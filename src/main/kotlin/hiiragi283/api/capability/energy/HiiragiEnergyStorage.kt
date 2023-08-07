package hiiragi283.api.capability.energy

import net.minecraft.nbt.CompoundNBT
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.Direction
import net.minecraftforge.common.util.INBTSerializable
import net.minecraftforge.common.util.LazyOptional
import net.minecraftforge.energy.CapabilityEnergy
import net.minecraftforge.energy.IEnergyStorage

class HiiragiEnergyStorage(
    private val capacity: Int,
    private val maxIn: Int = capacity,
    private val maxOut: Int = capacity,
    private var stored: Int = 0
) : IEnergyStorage, INBTSerializable<CompoundNBT> {

    //    IEnergyStorage    //

    override fun receiveEnergy(maxReceive: Int, simulate: Boolean): Int {
        if (!canReceive()) return 0
        val energyReceived = (capacity - energyStored).coerceAtMost(maxIn.coerceAtMost(maxReceive))
        if (!simulate) energyStored += energyReceived
        return energyReceived
    }

    fun receiveEnergyFrom(storageFrom: LazyOptional<IEnergyStorage>, simulate: Boolean) {
        storageFrom.map {
            if (it.canExtract() && this.canReceive()) {
                receiveEnergy(it.extractEnergy(getFreeCapacity(), simulate), simulate)
            }
        }
    }

    fun receiveEnergyFrom(tileFrom: TileEntity, facingFrom: Direction?, simulate: Boolean) {
        receiveEnergyFrom(tileFrom.getCapability(CapabilityEnergy.ENERGY, facingFrom), simulate)
    }

    override fun extractEnergy(maxExtract: Int, simulate: Boolean): Int {
        if (!canExtract()) return 0
        val energyExtracted = stored.coerceAtMost(maxOut.coerceAtMost(maxExtract))
        if (!simulate) stored -= energyExtracted
        return energyExtracted
    }

    fun extractEnergyTo(storageTo: LazyOptional<IEnergyStorage>, simulate: Boolean) {
        storageTo.map {
            if (it.canReceive() && this.canExtract()) {
                extractEnergy(it.receiveEnergy(capacity, simulate), simulate)
            }
        }

    }

    fun extractEnergyTo(tileTo: TileEntity, facingTo: Direction?, simulate: Boolean) {
        extractEnergyTo(tileTo.getCapability(CapabilityEnergy.ENERGY, facingTo), simulate)
    }

    override fun getEnergyStored(): Int = stored

    fun setEnergyStored(energy: Int) {
        stored = energy.coerceAtMost(capacity)
    }

    override fun getMaxEnergyStored(): Int = capacity

    override fun canExtract(): Boolean = maxOut > 0 && stored in 1..capacity

    override fun canReceive(): Boolean = maxIn > 0 && stored in 0 until capacity

    fun getFreeCapacity(): Int = capacity - energyStored

    //    INBTSerializable    //

    private val keyEnergy = "energy"

    override fun serializeNBT(): CompoundNBT {
        val tag = CompoundNBT()
        tag.putInt(keyEnergy, stored)
        return tag
    }

    override fun deserializeNBT(tag: CompoundNBT?) {
        stored = if (tag !== null && tag.contains(keyEnergy)) tag.getInt(keyEnergy) else 0
    }
}