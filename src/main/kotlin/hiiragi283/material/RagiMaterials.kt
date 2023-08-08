package hiiragi283.material

import hiiragi283.api.item.MaterialItem
import hiiragi283.material.util.hiiragiRL
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.client.event.ColorHandlerEvent
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import pers.solid.brrp.v1.api.RuntimeResourcePack
import pers.solid.brrp.v1.forge.RRPEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(RagiMaterials.MOD_ID)
object RagiMaterials {

    const val MOD_ID = "ragi_materials"
    const val MOD_NAME = "RagiMaterials"

    val LOGGER: Logger = LogManager.getLogger(MOD_NAME)

    internal val RESOURCE_PACK: RuntimeResourcePack = RuntimeResourcePack.create(hiiragiRL("runtime"))

    init {

        LOGGER.info("RagiMaterials is initialized!")

        RMInitializer.initShapes()
        RMInitializer.initMaterials()

        MOD_BUS.run {
            this.addListener { event: FMLCommonSetupEvent -> commonSetup(event) }
            this.addListener { event: FMLClientSetupEvent -> clientSetup(event) }
            this.addListener { event: ColorHandlerEvent.Block -> registerBlockColor(event) }
            this.addListener { event: ColorHandlerEvent.Item -> registerItemColor(event) }
            this.addListener { event: ModelRegistryEvent -> registerModel(event) }
        }

    }

    private fun commonSetup(event: FMLCommonSetupEvent) {
        LOGGER.info("Common Setup")
        RMInitializer.initResourcePack()
        MOD_BUS.addListener { eventRRP: RRPEvent.BeforeVanilla -> eventRRP.addPack(RESOURCE_PACK) }
    }

    private fun clientSetup(event: FMLClientSetupEvent) {
        LOGGER.info("Client Setup")
    }

    @OnlyIn(Dist.CLIENT)
    fun registerBlockColor(event: ColorHandlerEvent.Block) {

    }

    @OnlyIn(Dist.CLIENT)
    fun registerItemColor(event: ColorHandlerEvent.Item) {
        event.itemColors.register(
            { stack, tintIndex ->
                val item = stack.item
                if (item is MaterialItem) item.getColor(stack, tintIndex) else -1
            },
            *RMItems.MATERIAL_ITEMS.toTypedArray()
        )
    }

    @OnlyIn(Dist.CLIENT)
    fun registerModel(event: ModelRegistryEvent) {

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID)
    object RegistryEvents {

        @SubscribeEvent(priority = EventPriority.LOWEST)
        fun registerBlock(event: RegistryEvent.Register<Block>) {
            RMBlocks.register(event.registry)
        }

        @SubscribeEvent(priority = EventPriority.LOWEST)
        fun registerItem(event: RegistryEvent.Register<Item>) {
            RMItems.register(event.registry)
        }

    }

}