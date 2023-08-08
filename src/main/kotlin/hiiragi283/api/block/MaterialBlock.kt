package hiiragi283.api.block

import hiiragi283.api.HiiragiBlock
import hiiragi283.api.ItemColorProvider
import hiiragi283.api.MaterialItemProvider
import hiiragi283.api.part.HiiragiPart
import hiiragi283.material.RagiMaterials
import hiiragi283.material.util.appendBefore
import net.minecraft.block.AbstractBlock.Properties
import net.minecraft.block.BlockState
import net.minecraft.client.renderer.color.IBlockColor
import net.minecraft.data.BlockModelDefinition
import net.minecraft.data.FinishedVariantBlockState
import net.minecraft.data.loot.BlockLootTables
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.IFormattableTextComponent
import net.minecraft.world.IBlockDisplayReader

fun createMaterialBlock(part: HiiragiPart, settings: Properties = part.shape.getBlockSettings()): HiiragiBlock {

    val (shape, material) = part

    return object : MaterialBlock(part, settings) {

        override fun asPart(): HiiragiPart = part

        override fun getColor(state: BlockState, world: IBlockDisplayReader?, pos: BlockPos?, tintIndex: Int): Int =
            material.color

        override fun getColor(stack: ItemStack, tintIndex: Int): Int = material.color

        override fun getName(): IFormattableTextComponent = part.getText()

        override fun initResourcePack() {

            RagiMaterials.RESOURCE_PACK.addBlockState(
                registryName,
                FinishedVariantBlockState.multiVariant(this, BlockModelDefinition())
            )

            RagiMaterials.RESOURCE_PACK.addLootTable(
                this.lootTable,
                BlockLootTables.createSingleItemTable(this)
            )

            RagiMaterials.RESOURCE_PACK.addModel(registryName?.appendBefore("block/"), part.shape.getModel(this))

            part.shape.registerRecipe(RagiMaterials.RESOURCE_PACK, this)

        }

    }

}

abstract class MaterialBlock(
    val part: HiiragiPart,
    settings: Properties = part.shape.getBlockSettings()
) : HiiragiBlock(part.getId(), settings), IBlockColor, ItemColorProvider, MaterialItemProvider