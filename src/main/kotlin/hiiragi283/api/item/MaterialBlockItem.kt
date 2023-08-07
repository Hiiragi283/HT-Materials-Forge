package hiiragi283.api.item

import hiiragi283.api.HiiragiBlockItem
import hiiragi283.api.RMItemColorProvider
import hiiragi283.api.block.MaterialBlock
import hiiragi283.api.part.HiiragiPart
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.text.IFormattableTextComponent
import net.minecraftforge.fml.RegistryObject

open class MaterialBlockItem(
    val block: MaterialBlock
) : HiiragiBlockItem(block, Properties()), RMItemColorProvider, MaterialItemConvertible {

    override fun asPart(): HiiragiPart = block.part

    override fun getName(stack: ItemStack): IFormattableTextComponent = block.getName()

    override fun getColor(stack: ItemStack, tintIndex: Int): Int = block.getColor(stack, tintIndex)

    override fun register(): RegistryObject<Item> {

        val item = super.register()

        //block.part.getRecipe(this as MaterialItemConvertible).forEach(RagiMaterials.RESOURCE_PACK::addRecipe)

        return item
    }

}