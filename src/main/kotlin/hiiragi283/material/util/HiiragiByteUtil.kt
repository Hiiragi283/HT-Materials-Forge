package hiiragi283.material.util

import io.netty.buffer.ByteBuf
import net.minecraft.util.math.BlockPos

//    Reader    //

fun ByteBuf.readBlockPos(): BlockPos = BlockPos(this.readInt(), this.readInt(), this.readInt())

//    Writer    //

fun ByteBuf.writeBlockPos(pos: BlockPos) = also {
    it.writeInt(pos.x)
    it.writeInt(pos.y)
    it.writeInt(pos.z)
}