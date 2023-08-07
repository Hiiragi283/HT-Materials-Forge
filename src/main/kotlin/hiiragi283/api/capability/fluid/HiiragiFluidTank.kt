package hiiragi283.api.capability.fluid

import hiiragi283.api.capability.CapabilityIO
import hiiragi283.api.capability.IOType
import net.minecraft.nbt.CompoundNBT
import net.minecraftforge.common.util.INBTSerializable
import net.minecraftforge.fluids.FluidStack
import net.minecraftforge.fluids.capability.templates.FluidTank

open class HiiragiFluidTank(cap: Int) : FluidTank(cap), CapabilityIO<HiiragiFluidTank>, INBTSerializable<CompoundNBT> {

    //    ICapabilityIO    //

    override var ioType: IOType = IOType.INPUT

    override fun getIOType(): IOType = ioType

    override fun setIOType(type: IOType): HiiragiFluidTank = also { ioType = type }

    //    INBTSerializable    //

    override fun serializeNBT() = CompoundNBT().also { fluid.writeToNBT(it) }

    override fun deserializeNBT(tag: CompoundNBT?) {
        fluid = FluidStack.loadFluidStackFromNBT(tag ?: CompoundNBT())
    }

}