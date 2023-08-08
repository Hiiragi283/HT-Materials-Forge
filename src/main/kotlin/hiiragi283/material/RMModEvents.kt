package hiiragi283.material

import hiiragi283.api.part.getParts
import hiiragi283.api.tileentity.HiiragiProvider
import hiiragi283.material.util.hiiragiRL
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.event.entity.player.ItemTooltipEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = RagiMaterials.MOD_ID)
object RMModEvents {

    private val keyInventory = hiiragiRL("inventory")
    private val keyTank = hiiragiRL("tank")
    private val keyEnergy = hiiragiRL("energy")

    @SubscribeEvent
    fun attachCapability(event: AttachCapabilitiesEvent<TileEntity>) {
        val tile: TileEntity = event.`object`
        if (tile is HiiragiProvider.Inventory) event.addCapability(keyInventory, tile.createInventory())
        if (tile is HiiragiProvider.Tank) event.addCapability(keyTank, tile.createTank())
        if (tile is HiiragiProvider.Energy) event.addCapability(keyEnergy, tile.createBattery())
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    fun onTooltip(event: ItemTooltipEvent) {

        event.itemStack.getParts().toSet().forEach { it.appendTooltip(event.toolTip) }

    }

}