package hiiragi283.material.item

import hiiragi283.api.HiiragiItem
import hiiragi283.material.RagiMaterials
import hiiragi283.material.util.appendBefore
import hiiragi283.material.util.playSoundHypixel
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Rarity
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.world.World
import pers.solid.brrp.v1.model.ModelJsonBuilder

object RespawnBookItem : HiiragiItem(
    "respawn_book",
    Properties()
        .tab(ItemGroup.TAB_MISC)
        .rarity(Rarity.EPIC)
) {

    override fun use(world: World, player: PlayerEntity, hand: Hand): ActionResult<ItemStack> {
        val info = world.levelData
        //playerをスポーン地点にテレポート
        player.teleportTo(
            info.xSpawn.toDouble() + 0.5,
            info.ySpawn.toDouble(),
            info.zSpawn.toDouble() + 0.5
        )
        //playerの視線をリセット
        player.setYHeadRot(0.0f)
        //SEを再生
        playSoundHypixel(world, player.blockPosition())
        return ActionResult.success(player.getItemInHand(hand))
    }

    //    HiiragiEntry    //

    override fun initResourcePack() {
        RagiMaterials.RESOURCE_PACK.addModel(
            registryName!!.appendBefore("item/"),
            ModelJsonBuilder.create("item/writable_book")
        )
    }

}