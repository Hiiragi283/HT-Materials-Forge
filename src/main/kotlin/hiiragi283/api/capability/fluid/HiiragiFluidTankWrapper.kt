package hiiragi283.api.capability.fluid

import net.minecraft.nbt.CompoundNBT
import net.minecraft.nbt.ListNBT
import net.minecraftforge.common.util.Constants
import net.minecraftforge.common.util.INBTSerializable
import net.minecraftforge.fluids.FluidStack
import net.minecraftforge.fluids.capability.IFluidHandler

abstract class HiiragiFluidTankWrapper(private vararg val tanks: HiiragiFluidTank) : IFluidHandler, INBTSerializable<CompoundNBT> {

    fun getFluid(index: Int): FluidStack = tanks[index].fluid

    fun getCapacity(index: Int): FluidStack = tanks[index].fluid

    //    IFluidHandler    //

    override fun fill(resource: FluidStack, action: IFluidHandler.FluidAction): Int {
        var result = 0
        for (tank in tanks) {
            //搬入可能なtankに対してのみ実行する
            if (tank.getIOType().canInput) {
                val result1 = tank.fill(resource, IFluidHandler.FluidAction.EXECUTE)
                if (result1 > 0) {
                    result = tank.fill(resource, IFluidHandler.FluidAction.SIMULATE)
                    break
                }
            }
        }
        return result
    }

    override fun drain(resource: FluidStack, action: IFluidHandler.FluidAction): FluidStack {
        for (tank in tanks) {
            //搬出可能なtankに対してのみ実行する
            if (tank.getIOType().canOutput) {
                return tank.drain(resource, IFluidHandler.FluidAction.EXECUTE)
            }
        }
        return FluidStack.EMPTY
    }

    //最初に登録したtankを返す
    override fun drain(maxDrain: Int, action: IFluidHandler.FluidAction): FluidStack = tanks[0].drain(maxDrain, action)

    //    INBTSerializable<NBTTagCompound>    //

    override fun serializeNBT(): CompoundNBT {
        val tagList = ListNBT()
        for (tank in tanks) {
            val stack = tank.fluid
            CompoundNBT().also { tag ->
                stack.writeToNBT(tag)
                tagList.add(tag)
            }
        }
        return CompoundNBT().also { it.put("Fluids", tagList) }
    }

    override fun deserializeNBT(nbt: CompoundNBT) {
        val tagList: ListNBT = nbt.getList("Fluids", Constants.NBT.TAG_COMPOUND)
        for (i in 0 until tagList.size) {
            val tag: CompoundNBT = tagList.getCompound(i)
            tanks[i].fluid = FluidStack.loadFluidStackFromNBT(tag)
        }
    }
}