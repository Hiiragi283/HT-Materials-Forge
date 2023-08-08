package hiiragi283.api.tileentity

import hiiragi283.api.capability.energy.HiiragiEnergyStorage
import hiiragi283.api.capability.fluid.HiiragiFluidTankWrapper
import hiiragi283.api.capability.item.HiiragiItemHandlerWrapper
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.client.renderer.texture.ITickable
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.nbt.CompoundNBT
import net.minecraft.network.NetworkManager
import net.minecraft.network.play.server.SUpdateTileEntityPacket
import net.minecraft.tileentity.TileEntity
import net.minecraft.tileentity.TileEntityType
import net.minecraft.util.Direction
import net.minecraft.util.Hand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

abstract class HiiragiTileEntity(type: TileEntityType<*>) : TileEntity(type) {

    open lateinit var inventory: HiiragiItemHandlerWrapper
    open lateinit var tank: HiiragiFluidTankWrapper
    open lateinit var energy: HiiragiEnergyStorage

    //    General    //

    override fun getBlockState(): BlockState = level?.getBlockState(blockPos) ?: Blocks.AIR.defaultBlockState()

    //    NBT tag    //

    override fun getUpdateTag(): CompoundNBT = save(CompoundNBT()) //オーバーライドしないと正常に更新されない

    //    Packet    //

    override fun getUpdatePacket(): SUpdateTileEntityPacket =
        SUpdateTileEntityPacket(blockPos, 0, updateTag) //NBTタグの情報を送る

    override fun onDataPacket(net: NetworkManager, pkt: SUpdateTileEntityPacket) {
        load(blockState, pkt.tag) //受け取ったパケットのNBTタグを書き込む
    }

    /**
     * Thanks to defeatedcrow!
     * Source: https://github.com/defeatedcrow/FluidTankTutorialMod/blob/master/src/main/java/defeatedcrow/tutorial/ibc/base/TileIBC.java#L93
     */

    fun shouldRefresh(world: World, pos: BlockPos, oldState: BlockState, newState: BlockState): Boolean =
        oldState.block != newState.block //更新の前後でBlockが変化する場合のみtrue

    //    CommonEvent    //

    open fun onTileActivated(
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        facing: Direction
    ): Boolean = false

    open fun onTilePlaced(
        world: World,
        pos: BlockPos,
        state: BlockState,
        placer: LivingEntity,
        stack: ItemStack
    ) {
    }

    fun readNBTFromStack(stack: ItemStack) {
        //ItemStackに保存されたNBTタグを取得し，nullでない場合
        stack.getOrCreateTagElement("BlockEntityTag")?.let {
            //TileEntityからNBTタグを取得
            val tagTile = updateTag
            //tagTileにtagStackを合併
            tagTile.merge(it)
            //座標を修正する
            tagTile.putInt("x", blockPos.x)
            tagTile.putInt("y", blockPos.y)
            tagTile.putInt("z", blockPos.z)
            //座標が異なる場合
            if (tagTile != updateTag.copy()) {
                save(tagTile)
                setChanged()
            }
        }
    }

    open fun onTileRemoved(world: World, pos: BlockPos, state: BlockState) {}

    abstract class Tickable(private val maxCount: Int, type: TileEntityType<*>) : HiiragiTileEntity(type), ITickable {

        var countdown = 0

        //    ITickable    //

        override fun tick() {
            onUpdateTick()
            if (countdown >= maxCount) {
                onUpdate()
                if (level !== null && level!!.isClientSide) {
                    onUpdateServer()
                } else {
                    onUpdateClient()
                }
                countdown = 0
            } else countdown++
        }

        //1tickごとにサーバー側とクライアント側で同時に実行するメソッド
        open fun onUpdateTick() {}

        //20tickごとにサーバー側とクライアント側で同時に実行するメソッド
        open fun onUpdate() {}

        //20tickごとにサーバー側で実行するメソッド
        open fun onUpdateServer() {}

        //20tickごとにクライアント側で実行するメソッド
        open fun onUpdateClient() {}

    }

}