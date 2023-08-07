package hiiragi283.api.item

import hiiragi283.api.HiiragiItem
import hiiragi283.api.RMItemColorProvider
import hiiragi283.api.material.HiiragiMaterial
import hiiragi283.api.part.HiiragiPart
import hiiragi283.api.shape.HiiragiShape
import hiiragi283.material.RagiMaterials
import hiiragi283.material.util.append
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.text.TranslationTextComponent
import net.minecraftforge.fml.RegistryObject

open class MaterialItem(val part: HiiragiPart) : HiiragiItem(Properties()), RMItemColorProvider,
    MaterialItemConvertible {

    constructor(shape: HiiragiShape, material: HiiragiMaterial) : this(HiiragiPart(shape, material))

    override fun asPart(): HiiragiPart = part

    override fun getColor(stack: ItemStack, tintIndex: Int): Int = part.material.color

    override fun getName(stack: ItemStack): TranslationTextComponent = part.getText()

    override fun register(): RegistryObject<Item> {

        val item = super.register()

        RagiMaterials.RESOURCE_PACK.addModel(registryName?.append("item/"), part.shape.getModel())


        return item

    }

}