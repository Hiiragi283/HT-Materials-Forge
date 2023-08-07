package hiiragi283.api.block

import hiiragi283.api.item.MaterialBlockItem
import hiiragi283.api.material.HiiragiMaterial
import hiiragi283.api.part.HiiragiPart
import hiiragi283.api.shape.HiiragiShapes
import hiiragi283.material.RagiMaterials
import net.minecraft.block.Block
import net.minecraftforge.fml.RegistryObject

fun registerMaterialOreBlocks(material: HiiragiMaterial) {

    if (!material.hasOre) {
        RagiMaterials.LOGGER.warn("$material cannot create ores!")
        return
    }

    val list: List<HiiragiPart> = listOf(
        HiiragiPart(HiiragiShapes.ORE_STONE, material),
        HiiragiPart(HiiragiShapes.ORE_NETHER, material),
        HiiragiPart(HiiragiShapes.ORE_END, material)
    )

    list.map(::MaterialOreBlock).forEach { it.register() }

}

class MaterialOreBlock(part: HiiragiPart) : MaterialBlock(part) {

    override fun register(): RegistryObject<Block> {
        MaterialBlockItem(this).register()
        return super.register()
    }

}