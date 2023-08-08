package hiiragi283.api.item

import hiiragi283.api.ColoredItemProvider
import hiiragi283.api.HiiragiBlockItem
import hiiragi283.api.MaterialItemProvider
import hiiragi283.api.block.MaterialBlock
import hiiragi283.api.part.HiiragiPart
import net.minecraft.item.ItemStack
import net.minecraft.util.text.IFormattableTextComponent

fun createMaterialBlockItem(block: MaterialBlock): MaterialBlockItem {

    return object : MaterialBlockItem(block) {

        override fun asPart(): HiiragiPart = block.asPart()

        override fun getColor(stack: ItemStack, tintIndex: Int): Int = block.getColor(stack, tintIndex)

        override fun getName(stack: ItemStack): IFormattableTextComponent = block.name

    }

}

abstract class MaterialBlockItem(block: MaterialBlock) : HiiragiBlockItem(block), ColoredItemProvider,
    MaterialItemProvider