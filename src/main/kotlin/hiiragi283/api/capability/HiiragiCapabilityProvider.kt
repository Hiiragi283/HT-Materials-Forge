package hiiragi283.api.capability

import net.minecraft.nbt.CompoundNBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.ICapabilitySerializable
import net.minecraftforge.common.util.INBTSerializable

/**
 * Thanks to SkyTheory!
 * Source: https://github.com/SkyTheory/SkyTheoryLib/blob/1.12.2/java/skytheory/lib/capability/DataProvider.java
 */

@Suppress("UNCHECKED_CAST")
abstract class HiiragiCapabilityProvider<T : Any>(
    private val capability: Capability<T>,
    private val instance: T,
    private val serializer: INBTSerializable<CompoundNBT> = instance as INBTSerializable<CompoundNBT>
) : ICapabilitySerializable<CompoundNBT> {

    //    ICapability    //

    fun hasCapability(capability: Capability<*>, facing: Direction?): Boolean = capability == this.capability

    //    INBTSerializable<NBTTagCompound>    //

    override fun serializeNBT(): CompoundNBT = serializer.serializeNBT()

    override fun deserializeNBT(nbt: CompoundNBT) {
        serializer.deserializeNBT(nbt)
    }
}