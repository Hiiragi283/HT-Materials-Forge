package hiiragi283.api.item

import hiiragi283.api.HiiragiBlockItem
import hiiragi283.api.HiiragiItem
import hiiragi283.api.ItemColorProvider
import hiiragi283.api.MaterialItemProvider
import hiiragi283.api.block.MaterialBlock
import hiiragi283.api.part.HiiragiPart
import hiiragi283.material.RagiMaterials
import hiiragi283.material.util.appendBefore
import net.minecraft.item.ItemStack
import net.minecraft.util.text.IFormattableTextComponent
import net.minecraft.util.text.TranslationTextComponent
import pers.solid.brrp.v1.tag.IdentifiedTagBuilder

fun createMaterialItem(part: HiiragiPart): HiiragiItem {

    val (shape, material) = part

    return object : HiiragiItem(part.getId()), ItemColorProvider, MaterialItemProvider {

        override fun asPart(): HiiragiPart = part

        override fun getColor(stack: ItemStack, tintIndex: Int): Int = material.color

        override fun getName(stack: ItemStack): TranslationTextComponent = part.getText()

        override fun initResourcePack() {

            RagiMaterials.RESOURCE_PACK.addModel(
                registryName?.appendBefore("item/"),
                shape.getModel(this)
            )

            RagiMaterials.RESOURCE_PACK.addTag(
                IdentifiedTagBuilder.createItem(part.getItemTag())
                    .add(this)
            )

        }

    }

}

fun createMaterialBlockItem(block: MaterialBlock): HiiragiBlockItem {

    return object : HiiragiBlockItem(block), ItemColorProvider, MaterialItemProvider {

        override fun asPart(): HiiragiPart = block.part

        override fun getColor(stack: ItemStack, tintIndex: Int): Int = block.getColor(stack, tintIndex)

        override fun getName(stack: ItemStack): IFormattableTextComponent = block.name

    }

}