package hiiragi283.material

import hiiragi283.material.util.hiiragiRL
import net.minecraftforge.fml.InterModComms
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.*
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import pers.solid.brrp.v1.api.RuntimeResourcePack
import pers.solid.brrp.v1.forge.RRPEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import java.util.stream.Collectors

@Mod(RagiMaterials.MOD_ID)
object RagiMaterials {

    const val MOD_ID = "ragi_materials"
    const val MOD_NAME = "RagiMaterials"

    val LOGGER: Logger = LogManager.getLogger(MOD_NAME)

    internal val RESOURCE_PACK: RuntimeResourcePack = RuntimeResourcePack.create(hiiragiRL("runtime"))

    init {

        RMInitializer.initShapes()
        RMInitializer.initMaterials()

        RMInitializer.initResourcePack()

        MOD_BUS.run {
            this.addListener { event: FMLCommonSetupEvent -> commonSetup(event) }
            this.addListener { event: InterModEnqueueEvent -> enqueueIMC(event) }
            this.addListener { event: InterModProcessEvent -> processIMC(event) }
            this.addListener { event: FMLClientSetupEvent -> clientSetup(event) }
            this.addListener { event: FMLLoadCompleteEvent -> complete(event) }
            this.addListener { event: RRPEvent.BeforeVanilla -> event.addPack(RESOURCE_PACK) }
        }

    }

    private fun commonSetup(event: FMLCommonSetupEvent) {
        LOGGER.info("Common Setup")
    }

    private fun clientSetup(event: FMLClientSetupEvent) {
        LOGGER.info("Client Setup")
    }

    private fun enqueueIMC(event: InterModEnqueueEvent) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("ragi_materials", "helloworld") {
            LOGGER.info("Hello world from the MDK")
            "Hello world"
        }
    }

    private fun processIMC(event: InterModProcessEvent) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info(
            "Got IMC {}",
            event.imcStream.map { it.getMessageSupplier<Any>().get() }.collect(Collectors.toList())
        )
    }

    private fun complete(event: FMLLoadCompleteEvent) {
        LOGGER.info("Completed")
    }

}