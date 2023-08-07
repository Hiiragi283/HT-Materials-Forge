package hiiragi283.material

import hiiragi283.material.util.hiiragiRL
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent.Register
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.InterModComms
import net.minecraftforge.fml.InterModComms.IMCMessage
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.event.lifecycle.*
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
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

    internal val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID)
    internal val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID)

    init {

        val eventBus: IEventBus = MOD_BUS

        BLOCKS.register(eventBus)
        ITEMS.register(eventBus)

        eventBus.addListener { event: FMLConstructModEvent -> construct(event) }
        eventBus.addListener { event: FMLCommonSetupEvent -> commonSetup(event) }
        eventBus.addListener { event: InterModEnqueueEvent -> enqueueIMC(event) }
        eventBus.addListener { event: InterModProcessEvent -> processIMC(event) }
        eventBus.addListener { event: FMLClientSetupEvent -> clientSetup(event) }
        eventBus.addListener { event: FMLLoadCompleteEvent -> complete(event) }

        eventBus.addListener { event: RRPEvent.BeforeVanilla -> event.addPack(RESOURCE_PACK) }

    }

    private fun construct(event: FMLConstructModEvent) {

    }

    //最初に呼ばれる
    private fun commonSetup(event: FMLCommonSetupEvent) {
        LOGGER.info("HELLO FROM PREINIT")
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName())
    }

    //Client側で次に呼ばれる
    private fun clientSetup(event: FMLClientSetupEvent) {
        LOGGER.info("Got game settings {}", event.minecraftSupplier.get().options)
    }

    //3番目に呼ばれる
    private fun enqueueIMC(event: InterModEnqueueEvent) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("ragi_materials", "helloworld") {
            LOGGER.info("Hello world from the MDK")
            "Hello world"
        }
    }

    //最後に呼ばれる
    private fun processIMC(event: InterModProcessEvent) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.imcStream.map { m: IMCMessage -> m.getMessageSupplier<Any>().get() }
            .collect(Collectors.toList()))
    }

    private fun complete(event: FMLLoadCompleteEvent) {

    }

    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
    object RegistryEvents {
        @SubscribeEvent
        fun onBlocksRegistry(blockRegistryEvent: Register<Block?>?) {
            LOGGER.info("HELLO from Register Block")
        }
    }

}