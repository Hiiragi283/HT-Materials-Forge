package hiiragi283.api.shape

import hiiragi283.api.MaterialItemProvider
import hiiragi283.api.material.HiiragiMaterial
import hiiragi283.material.util.hiiragiRL
import hiiragi283.material.util.itemModelLayered
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Blocks
import net.minecraft.util.ResourceLocation
import pers.solid.brrp.v1.api.RuntimeResourcePack
import pers.solid.brrp.v1.model.ModelJsonBuilder
import java.util.function.BiConsumer
import java.util.function.Function

fun shapeOf(
    name: String,
    scale: Double,
    blockSettings: AbstractBlock.Properties = AbstractBlock.Properties.copy(Blocks.AIR),
    model: Function<MaterialItemProvider, ModelJsonBuilder> = Function { itemModelLayered(ResourceLocation("item/iron_ingot")) },
    recipes: BiConsumer<RuntimeResourcePack, MaterialItemProvider> = BiConsumer { pack, item -> },
    state: ResourceLocation = hiiragiRL("block/block_metal")
): HiiragiShape = object : HiiragiShape(name, scale) {

    override fun getBlockSettings(): AbstractBlock.Properties = blockSettings

    override fun getState(): ResourceLocation = state

    override fun getModel(item: MaterialItemProvider): ModelJsonBuilder = model.apply(item)

    override fun registerRecipe(resourcePack: RuntimeResourcePack, item: MaterialItemProvider) {
        recipes.accept(resourcePack, item)
    }

}

abstract class HiiragiShape internal constructor(
    val name: String,
    val scale: Double
) {

    abstract fun getBlockSettings(): AbstractBlock.Properties

    abstract fun getState(): ResourceLocation

    abstract fun getModel(item: MaterialItemProvider): ModelJsonBuilder

    abstract fun registerRecipe(resourcePack: RuntimeResourcePack, item: MaterialItemProvider)

    companion object {
        @JvmField
        val EMPTY = shapeOf("empty", 0.0)

        @JvmField
        val WILDCARD = shapeOf("wildcard", 0.0)
    }

    override fun toString(): String = "Part:$name"

    fun getTranslationKey(): String = "shape.$name"

    fun hasScale(): Boolean = scale > 0.0

    fun isEmpty(): Boolean = this.name == "empty"

    fun isValid(material: HiiragiMaterial): Boolean = name in material.validShapes

}