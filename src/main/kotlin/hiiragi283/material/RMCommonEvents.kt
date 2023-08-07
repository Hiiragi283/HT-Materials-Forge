package hiiragi283.material

import hiiragi283.api.event.MaterialRegistryEvent
import hiiragi283.api.material.MaterialCommon
import hiiragi283.api.material.MaterialElements
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = RagiMaterials.MOD_ID)
object RMCommonEvents {

    @SubscribeEvent
    fun registerMaterial(event: MaterialRegistryEvent) {
        val registry = event.registry
        MaterialElements.register()
        RagiMaterials.LOGGER.info("Elemental Materials registered!")

        MaterialCommon.register()
        RagiMaterials.LOGGER.info("Common Materials registered!")

        //RMResourceHandler.load()
        RagiMaterials.LOGGER.info("Materials from data packs loaded!")
    }

}