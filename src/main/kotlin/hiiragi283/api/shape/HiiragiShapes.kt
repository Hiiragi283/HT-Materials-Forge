package hiiragi283.api.shape

import hiiragi283.material.util.append
import hiiragi283.material.util.hiiragiRL
import hiiragi283.material.util.itemModelLayered
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Blocks
import net.minecraft.data.ShapedRecipeBuilder
import net.minecraft.data.ShapelessRecipeBuilder
import net.minecraft.util.ResourceLocation
import pers.solid.brrp.v1.model.ModelJsonBuilder

object HiiragiShapes {

    private val dustFake = shapeOf("dusts", 1.0)
    private val ingotFake = shapeOf("ingots", 1.0)
    private val gemFake = shapeOf("gems", 1.0)

    //    Blocks   //

    @JvmField
    val STORAGE_BLOCKS = shapeOf(
        "storage_blocks",
        9.0,
        blockSettings = AbstractBlock.Properties.copy(Blocks.IRON_BLOCK),
        model = { ModelJsonBuilder().parent(hiiragiRL("block/block_metal")) },
        state = hiiragiRL("block/block_metal")
    )

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
    val DUSTS = shapeOf(
        "dusts",
        1.0,
        model = { itemModelLayered(hiiragiRL("item/dusts")) },
        recipes = { pack, provider ->
            pack.addRecipeAndAdvancement(
                hiiragiRL(provider.asPart().getId()).append("_shaped"),
                ShapedRecipeBuilder.shaped(provider)
                    .pattern("AAA")
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', provider.asPart().replace(TINY_DUSTS).getItemTag())
                ::save
            )
        }
    )

    @JvmField
    val TINY_DUSTS = shapeOf(
        "tiny_dusts",
        0.1,
        model = { itemModelLayered(hiiragiRL("item/tiny_dusts")) },
        recipes = { pack, provider ->
            pack.addRecipeAndAdvancement(
                hiiragiRL(provider.asPart().getId()).append("_shapeless"),
                ShapelessRecipeBuilder.shapeless(provider)
                    .requires(provider.asPart().replace(dustFake).getItemTag())
                ::save
            )
        }
    )

    @JvmField
    val GEAR = shapeOf(
        "gears",
        4.0,
        model = { itemModelLayered(hiiragiRL("item/gears")) },
        recipes = { pack, provider ->
            pack.addRecipeAndAdvancement(
                hiiragiRL(provider.asPart().getId()).append("_shaped"),
                ShapedRecipeBuilder.shaped(provider)
                    .pattern(" A ")
                    .pattern("A A")
                    .pattern(" A ")
                    .define('A', provider.asPart().replace(ingotFake).getItemTag())
                ::save
            )
        }
    )

    @JvmField
    val GEM = shapeOf(
        "gems",
        1.0,
        model = { itemModelLayered(ResourceLocation("item/quartz")) }
    )

    @JvmField
    val INGOT = shapeOf(
        "ingots",
        1.0,
        recipes = { pack, provider ->
            pack.addRecipeAndAdvancement(
                hiiragiRL(provider.asPart().getId()).append("_shaped"),
                ShapedRecipeBuilder.shaped(provider)
                    .pattern("AAA")
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', provider.asPart().replace(NUGGET).getItemTag())
                ::save
            )
        }
    )

    @JvmField
    val NUGGET = shapeOf(
        "nuggets",
        0.1,
        model = { itemModelLayered(ResourceLocation("item/iron_nugget")) },
        recipes = { pack, provider ->
            pack.addRecipeAndAdvancement(
                hiiragiRL(provider.asPart().getId()).append("_shapeless"),
                ShapelessRecipeBuilder.shapeless(provider)
                    .requires(provider.asPart().replace(ingotFake).getItemTag())
                ::save
            )
        }

    )

    @JvmField
    val PLATE = shapeOf(
        "plates",
        1.0,
        model = { itemModelLayered(hiiragiRL("item/plates")) }
    )

    @JvmField
    val ROD = shapeOf(
        "rods",
        0.5,
        model = { itemModelLayered(hiiragiRL("item/rods")) }
    )

}