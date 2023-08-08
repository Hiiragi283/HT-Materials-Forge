package hiiragi283.api.shape

import hiiragi283.material.util.hiiragiRL
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Blocks
import pers.solid.brrp.v1.model.ModelJsonBuilder

object HiiragiShapes {

    private val dustFake = shapeOf("dusts", 1.0)
    private val ingotFake = shapeOf("ingots", 1.0)
    private val gemFake = shapeOf("gems", 1.0)

    //    Blocks   //

    @JvmField
    val BLOCK_METAL = shapeOf(
        "block_metal",
        9.0,
        blockSettings = AbstractBlock.Properties.copy(Blocks.IRON_BLOCK),
        model = { ModelJsonBuilder().parent(hiiragiRL("block/block_metal")) },
        state = hiiragiRL("block/block_metal")
    )

    @JvmField
    val BLOCK_GEM = shapeOf(
        "block_gem",
        9.0,
        blockSettings = AbstractBlock.Properties.copy(Blocks.GLASS),
        model = { ModelJsonBuilder().parent(hiiragiRL("block/block_gem")) },
        state = hiiragiRL("block/block_gem")
    )

    @JvmField
    val ORE_STONE = shapeOf(
        "ore_stone",
        1.0,
        blockSettings = AbstractBlock.Properties.copy(Blocks.STONE),
        model = { ModelJsonBuilder().parent(hiiragiRL("block/ore_stone")) },
        state = hiiragiRL("block/ore_stone")
    )

    @JvmField
    val ORE_NETHER = shapeOf(
        "ore_nether",
        1.0,
        blockSettings = AbstractBlock.Properties.copy(Blocks.NETHERRACK).strength(3.0f, 6.0f).noOcclusion(),
        model = { ModelJsonBuilder().parent(hiiragiRL("block/ore_nether")) },
        state = hiiragiRL("block/ore_nether")
    )

    @JvmField
    val ORE_END = shapeOf(
        "ore_end",
        1.0,
        blockSettings = AbstractBlock.Properties.copy(Blocks.END_STONE).strength(3.0f, 6.0f).noOcclusion(),
        model = { ModelJsonBuilder().parent(hiiragiRL("block/ore_end")) },
        state = hiiragiRL("block/ore_end")
    )

    //    Items    //

    @JvmField
    val DUST = shapeOf(
        "dusts",
        1.0,
        /*model = ModelUtil.createSimple(hiiragiRL("item/dust")),
        recipes = {
            mapOf(
                it.asPart().getId().append("_shaped") to ShapedRecipeJsonBuilder.create(it)
                    .get3x3('A')
                    .input('A', it.asPart().setShape(DUST_TINY).getTagKey(Registry.ITEM_KEY))
                    .criterionFromMaterial(DUST_TINY, it.asPart().material)
            )
        }*/
    )

    @JvmField
    val DUST_TINY = shapeOf(
        "dust_tiny",
        0.1,
        /*model = ModelUtil.createSimple(hiiragiRL("item/dust_tiny")),
        recipes = {
            mapOf(
                it.asPart().getId().append("_shapeless") to ShapelessRecipeJsonBuilder.create(it, 9)
                    .input(it.asPart().setShape(dustFake).getTagKey(Registry.ITEM_KEY))
                    .criterionFromMaterial(dustFake, it.asPart().material)
            )
        }*/
    )

    @JvmField
    val GEAR = shapeOf(
        "gears",
        4.0,
        /*model = ModelUtil.createSimple(hiiragiRL("item/gear")),
        recipes = {
            mapOf(
                it.asPart().getId().append("_shaped") to ShapedRecipeJsonBuilder.create(it)
                    .pattern(" A ")
                    .pattern("ABA")
                    .pattern(" A ")
                    .input('A', it.asPart().setShape(ingotFake).getTagKey(Registry.ITEM_KEY))
                    .input('B', RMTags.HAMMERS)
                    .criterionFromMaterial(ingotFake, it.asPart().material)
            )
        }*/
    )

    @JvmField
    val GEM = shapeOf(
        "gems",
        1.0,
        /*model = ModelUtil.createSimple("item/quartz"),
        recipes = {
            mapOf(
                it.asPart().getId().append("_shapeless") to ShapelessRecipeJsonBuilder.create(it, 9)
                    .input(it.asPart().setShape(BLOCK_GEM).getTagKey(Registry.ITEM_KEY))
                    .criterionFromMaterial(BLOCK_GEM, it.asPart().material)
            )
        }*/
    )

    @JvmField
    val INGOT = shapeOf(
        "ingots",
        1.0,
        /*recipes = {
            mapOf(
                it.asPart().getId().append("_shaped") to ShapedRecipeJsonBuilder.create(it)
                    .get3x3('A')
                    .input('A', it.asPart().setShape(NUGGET).getTagKey(Registry.ITEM_KEY))
                    .criterionFromMaterial(NUGGET, it.asPart().material),
                it.asPart().getId().append("_shapeless") to ShapelessRecipeJsonBuilder.create(it, 9)
                    .input(it.asPart().setShape(BLOCK_METAL).getTagKey(Registry.ITEM_KEY))
                    .criterionFromMaterial(BLOCK_METAL, it.asPart().material)
            )
        }*/
    )

    @JvmField
    val NUGGET = shapeOf(
        "nuggets",
        0.1,
        /*model = ModelUtil.createSimple("item/iron_nugget"),
        recipes = {
            mapOf(
                it.asPart().getId().append("_shapeless") to ShapelessRecipeJsonBuilder.create(it, 9)
                    .input(it.asPart().setShape(ingotFake).getTagKey(Registry.ITEM_KEY))
                    .criterionFromMaterial(ingotFake, it.asPart().material)
            )
        }*/
    )

    @JvmField
    val PLATE = shapeOf(
        "plates",
        1.0,
        /*model = ModelUtil.createSimple(hiiragiRL("item/plate")),
        recipes = {
            val material = it.asPart().material
            val base = if (material.isGem()) gemFake else ingotFake
            mapOf(
                it.asPart().getId().append("_shapeless") to ShapelessRecipeJsonBuilder.create(it)
                    .input(it.asPart().setShape(base).getTagKey(Registry.ITEM_KEY))
                    .input(RMTags.HAMMERS)
                    .criterionFromMaterial(base, material)
            )
        }*/
    )

    @JvmField
    val ROD = shapeOf(
        "rods",
        0.5,
        /*model = ModelUtil.createSimple(hiiragiRL("item/rod")),
        recipes = {
            val material = it.asPart().material
            val base = if (material.isGem()) gemFake else ingotFake
            mapOf(
                it.asPart().getId().append("_shaped") to ShapedRecipeJsonBuilder.create(it, 4)
                    .pattern("AB")
                    .pattern("A ")
                    .input('A', it.asPart().setShape(base).getTagKey(Registry.ITEM_KEY))
                    .input('B', RMTags.FILES)
                    .criterionFromMaterial(base, material)
            )
        }*/
    )

}