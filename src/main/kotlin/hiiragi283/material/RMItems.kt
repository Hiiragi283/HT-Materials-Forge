package hiiragi283.material

import hiiragi283.material.item.RespawnBookItem
import net.minecraft.item.Item
import net.minecraftforge.registries.IForgeRegistry

object RMItems {

    @JvmField
    val RESPAWN_BOOK = RespawnBookItem

    fun register(registry: IForgeRegistry<Item>) {
        registry.register(RESPAWN_BOOK)
    }

    fun initResourcePack() {
        RESPAWN_BOOK.initResourcePack()
    }

}