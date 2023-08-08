package hiiragi283.material

import hiiragi283.api.item.MaterialItem
import hiiragi283.api.material.MaterialRegistry
import hiiragi283.material.item.RespawnBookItem
import net.minecraft.item.Item
import net.minecraftforge.registries.IForgeRegistry

object RMItems {

    @JvmField
    val RESPAWN_BOOK = RespawnBookItem

    @JvmField
    val MATERIAL_ITEMS: MutableList<MaterialItem> = mutableListOf()

    fun initResourcePack() {
        RESPAWN_BOOK.initResourcePack()

        MaterialRegistry.getMaterials()
            .flatMap { it.createItems() }
            .forEach { MATERIAL_ITEMS.add(it) }

        MATERIAL_ITEMS.forEach { it.initResourcePack() }
    }

    fun register(registry: IForgeRegistry<Item>) {
        registry.register(RESPAWN_BOOK)
        MATERIAL_ITEMS.forEach { registry.register(it) }
    }

}