package hiiragi283.api.tileentity

import hiiragi283.api.container.HiiragiContainer
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.container.Container
import net.minecraft.inventory.container.INamedContainerProvider
import net.minecraft.util.text.ITextComponent


interface HiiragiInteractionObject<T : HiiragiContainer<*>> : INamedContainerProvider {

    override fun createMenu(
        p_createMenu_1_: Int,
        inventory: PlayerInventory,
        player: PlayerEntity
    ): Container? {
        TODO("Not yet implemented")
    }

    override fun getDisplayName(): ITextComponent {
        TODO("Not yet implemented")
    }

}