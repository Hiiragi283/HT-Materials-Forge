package hiiragi283.api.item

import hiiragi283.api.ColoredItemProvider
import hiiragi283.api.HiiragiItem
import hiiragi283.api.MaterialItemProvider
import hiiragi283.api.material.HiiragiMaterial
import hiiragi283.api.part.HiiragiPart
import hiiragi283.api.shape.HiiragiShape
import hiiragi283.material.RagiMaterials
import hiiragi283.material.util.appendBefore
import net.minecraft.item.ItemStack
import net.minecraft.util.text.TranslationTextComponent
import pers.solid.brrp.v1.tag.IdentifiedTagBuilder

fun createMaterialItem(part: HiiragiPart): MaterialItem {

    val (shape: HiiragiShape, material: HiiragiMaterial) = part

    return object : MaterialItem(part.getId()) {

        override fun asPart(): HiiragiPart = part

        override fun getColor(stack: ItemStack, tintIndex: Int): Int = material.color

        override fun getName(stack: ItemStack): TranslationTextComponent = part.getText()

        override fun initResourcePack() {

            RagiMaterials.RESOURCE_PACK.addModel(
                registryName?.appendBefore("item/"),
                shape.getModel(this)
            )

            shape.registerRecipe(RagiMaterials.RESOURCE_PACK, this)

            RagiMaterials.RESOURCE_PACK.addTag(IdentifiedTagBuilder.createItem(part.getItemTag()).add(this))

        }

    }

}

abstract class MaterialItem(id: String) : HiiragiItem(id), ColoredItemProvider, MaterialItemProvider