package hiiragi283.api.shape

import hiiragi283.api.item.MaterialItemConvertible
import hiiragi283.api.material.HiiragiMaterial
import hiiragi283.material.util.hiiragiRL
import hiiragi283.material.util.itemModelLayered
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Blocks
import net.minecraft.util.ResourceLocation
import pers.solid.brrp.v1.model.ModelJsonBuilder
import pers.solid.brrp.v1.util.RecipeJsonFactory
import java.util.function.Function

fun shapeOf(
    name: String,
    scale: Double,
    blockSettings: AbstractBlock.Properties = AbstractBlock.Properties.copy(Blocks.AIR),
    model: ModelJsonBuilder = itemModelLayered(hiiragiRL("item/ingot")),
    recipes: Function<MaterialItemConvertible, Map<ResourceLocation, RecipeJsonFactory>> = Function { mapOf() },
    state: ResourceLocation = hiiragiRL("block/block_metal"),
    type: ShapeType = ShapeType.ITEM
): HiiragiShape = object : HiiragiShape(name, scale) {

    override fun getBlockSettings(): AbstractBlock.Properties = blockSettings

    override fun getModel(): ModelJsonBuilder = model

    override fun getRecipe(output: MaterialItemConvertible): Map<ResourceLocation, RecipeJsonFactory> =
        recipes.apply(output)

    override fun getState(): ResourceLocation = state

    override fun getType(): ShapeType = type

}

abstract class HiiragiShape internal constructor(
    val name: String,
    val scale: Double
) {

    abstract fun getBlockSettings(): AbstractBlock.Properties

    abstract fun getModel(): ModelJsonBuilder

    abstract fun getRecipe(output: MaterialItemConvertible): Map<ResourceLocation, RecipeJsonFactory>

    abstract fun getState(): ResourceLocation

    abstract fun getType(): ShapeType

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