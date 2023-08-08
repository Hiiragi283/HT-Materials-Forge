package hiiragi283.api.part

import hiiragi283.api.PartProvider
import hiiragi283.api.material.HiiragiMaterial
import hiiragi283.api.material.MaterialRegistry
import hiiragi283.api.shape.HiiragiShape
import hiiragi283.api.shape.ShapeRegistry
import hiiragi283.material.util.forgeRL
import net.minecraft.block.Block
import net.minecraft.client.resources.I18n
import net.minecraft.entity.Entity
import net.minecraft.fluid.Fluid
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.tags.BlockTags
import net.minecraft.tags.FluidTags
import net.minecraft.tags.ItemTags
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.StringTextComponent
import net.minecraft.util.text.TranslationTextComponent
import net.minecraft.world.Explosion
import net.minecraft.world.World
import net.minecraftforge.common.Tags
import kotlin.math.roundToInt

fun ItemStack.getParts(): List<HiiragiPart> = this.item.tags.map { HiiragiPart.fromPath(it.path) }

data class HiiragiPart(val shape: HiiragiShape, val material: HiiragiMaterial) : PartProvider {

    constructor(shape: String, material: String) : this(
        ShapeRegistry.getShape(shape),
        MaterialRegistry.getMaterial(material)
    )

    private val weight: Double =
        if (material.hasMolar() && shape.hasScale()) (material.molar * shape.scale * 10.0).roundToInt() / 10.0 else 0.0

    companion object {

        @JvmField
        val EMPTY = HiiragiPart(HiiragiShape.EMPTY, HiiragiMaterial.EMPTY)

        @JvmStatic
        fun fromPath(path: String): HiiragiPart {
            val list = path.split("/")
            return if (list.size != 2) EMPTY
            else HiiragiPart(ShapeRegistry.getShape(list[0]), MaterialRegistry.getMaterial(list[1]))
        }

    }

    override fun toString(): String = "${shape.name}:${material.name}"

    fun appendTooltip(tooltip: MutableList<ITextComponent>) {
        if (material.isEmpty()) return
        tooltip.add(StringTextComponent("§e=== Property ==="))
        tooltip.add(TranslationTextComponent("tips.ragi_materials.property.name", "§b${getName()}"))
        if (material.hasFormula())
            tooltip.add(TranslationTextComponent("tips.ragi_materials.property.formula", "§b${material.formula}"))
        if (weight > 0.0)
            tooltip.add(TranslationTextComponent("tips.ragi_materials.property.mol", "§b${weight}"))
        if (material.hasTempMelt())
            tooltip.add(TranslationTextComponent("tips.ragi_materials.property.melt", "§b${material.tempMelt}"))
        if (material.hasTempBoil())
            tooltip.add(TranslationTextComponent("tips.ragi_materials.property.boil", "§b${material.tempBoil}"))
        if (material.hasTempSubl())
            tooltip.add(TranslationTextComponent("tips.ragi_materials.property.subl", "§b${material.tempSubl}"))
    }

    fun doExplosion(world: World, entity: Entity) {
        if (!material.isActiveToWater) return
        world.explode(
            null,
            entity.x,
            entity.y,
            entity.z,
            shape.scale.toFloat(),
            Explosion.Mode.DESTROY
        )
    }

    fun isEmpty(): Boolean = this == EMPTY

    fun isValid(): Boolean = shape.isValid(material)

    fun getName(): String = I18n.get(shape.getTranslationKey(), material.getTranslatedName())

    fun getText(): TranslationTextComponent =
        TranslationTextComponent(shape.getTranslationKey(), material.getTranslatedName())

    fun replace(shape: HiiragiShape = this.shape, material: HiiragiMaterial = this.material): HiiragiPart =
        HiiragiPart(shape, material)

    //    ResourceLocation    //

    fun getId(): String = "${shape.name}_${material.name}"

    fun getForgeId(): String = "${shape.name}/${material.name}"

    //    Tag    //

    fun getBlockTag(): Tags.IOptionalNamedTag<Block> = BlockTags.createOptional(forgeRL(getForgeId()))

    fun getFluidTag(): Tags.IOptionalNamedTag<Fluid> = FluidTags.createOptional(forgeRL(getForgeId()))

    fun getItemTag(): Tags.IOptionalNamedTag<Item> = ItemTags.createOptional(forgeRL(getForgeId()))

    //    PartProvider    //

    override fun asPart(): HiiragiPart = this

}