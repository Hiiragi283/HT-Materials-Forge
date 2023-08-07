package hiiragi283.api.block

import hiiragi283.api.item.MaterialBlockItem
import hiiragi283.api.material.HiiragiMaterial
import hiiragi283.api.part.HiiragiPart
import hiiragi283.material.RagiMaterials
import net.minecraft.block.Block
import net.minecraftforge.fml.RegistryObject

fun registerMaterialStorageBlocks(material: HiiragiMaterial) {

    val list: MutableList<HiiragiPart> = mutableListOf()
    when {
        //material.isMetal() -> list.add(HiiragiPart(ShapeRegistry.BLOCK_METAL, material))
        //material.isGem() -> list.add(HiiragiPart(ShapeRegistry.BLOCK_GEM, material))
        else -> {
            RagiMaterials.LOGGER.warn("$material cannot create storage blocks!")
            return
        }
    }

    //list.map(::MaterialStorageBlock).forEach { it.register() }

}

class MaterialStorageBlock(part: HiiragiPart) : MaterialBlock(part) {

    override fun register(): RegistryObject<Block> {

        /*RMResourcePack.addBlockTag(part.getTagKey(Registry.BLOCK_KEY)) {
            this.add(getIdentifier())
        }

        RMResourcePack.addItemTag(part.getTagKey(Registry.ITEM_KEY)) {
            this.add(getIdentifier())
        }*/

        MaterialBlockItem(this).register()

        return super.register()
    }

}