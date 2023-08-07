package hiiragi283.material

import hiiragi283.api.part.getParts
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.event.entity.player.ItemTooltipEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = RagiMaterials.MOD_ID, value = [Dist.CLIENT])
object RMClientEvents {

    @SubscribeEvent
    fun onTooltip(event: ItemTooltipEvent) {

        event.itemStack.getParts().toSet().forEach { it.appendTooltip(event.toolTip) }

    }

}