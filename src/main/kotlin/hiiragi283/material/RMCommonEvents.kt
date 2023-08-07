package hiiragi283.material

import hiiragi283.api.event.MaterialRegistryEvent
import hiiragi283.api.material.MaterialCommon
import hiiragi283.api.material.MaterialElements
import hiiragi283.api.tileentity.HiiragiProvider
import hiiragi283.material.util.hiiragiRL
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = RagiMaterials.MOD_ID)
object RMCommonEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun registerMaterial(event: MaterialRegistryEvent) {
        val registry = event.registry
        MaterialElements.register()
        RagiMaterials.LOGGER.info("Elemental Materials registered!")

        MaterialCommon.register()
        RagiMaterials.LOGGER.info("Common Materials registered!")

        //RMResourceHandler.load()
        RagiMaterials.LOGGER.info("Materials from data packs loaded!")
    }

    @SubscribeEvent
    fun registerBlock(event: RegistryEvent.Register<Block>) {

    }

    @SubscribeEvent
    fun registerItem(event: RegistryEvent.Register<Item>) {

    }

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

}