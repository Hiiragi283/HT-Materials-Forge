package hiiragi283.api.block

import hiiragi283.api.HiiragiBlock
import hiiragi283.api.RMItemColorProvider
import hiiragi283.api.item.MaterialItemConvertible
import hiiragi283.api.part.HiiragiPart
import hiiragi283.material.RagiMaterials
import hiiragi283.material.util.append
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.client.renderer.color.IBlockColor
import net.minecraft.data.BlockModelDefinition
import net.minecraft.data.FinishedVariantBlockState
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.IFormattableTextComponent
import net.minecraft.world.IBlockDisplayReader
import net.minecraftforge.fml.RegistryObject

abstract class MaterialBlock(
    val part: HiiragiPart,
    settings: Properties = part.shape.getBlockSettings()
) : HiiragiBlock(settings), IBlockColor, RMItemColorProvider, MaterialItemConvertible {

    override fun asPart(): HiiragiPart = part

    override fun getColor(state: BlockState, world: IBlockDisplayReader?, pos: BlockPos?, tintIndex: Int): Int =
        part.material.color

    override fun getColor(stack: ItemStack, tintIndex: Int): Int = part.material.color

    override fun getName(): IFormattableTextComponent = part.getText()

    override fun register(): RegistryObject<Block> {

        val block = super.register()

        RagiMaterials.RESOURCE_PACK.addBlockState(
            registryName,
            FinishedVariantBlockState.multiVariant(this, BlockModelDefinition())
        )

        RagiMaterials.RESOURCE_PACK.addModel(registryName?.append("item/"), part.shape.getModel())

        return block
    }

}