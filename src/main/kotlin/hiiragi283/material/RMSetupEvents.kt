package hiiragi283.material

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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = RagiMaterials.MOD_ID)
object RMSetupEvents {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun registerBlock(event: RegistryEvent.Register<Block>) {
        RMBlocks.register(event.registry)
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun registerItem(event: RegistryEvent.Register<Item>) {
        RMItems.register(event.registry)
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    fun registerBlockColor(event: ColorHandlerEvent.Block) {

    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    fun registerItemColor(event: ColorHandlerEvent.Item) {

    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    fun registerModel(event: ModelRegistryEvent) {

    }


}