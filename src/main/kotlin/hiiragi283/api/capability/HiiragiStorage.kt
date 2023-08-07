package hiiragi283.api.capability

import net.minecraft.nbt.INBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.Capability.IStorage
import net.minecraftforge.common.util.INBTSerializable

/**
 * Thanks to SkyTheory!
 * Source: https://github.com/SkyTheory/SkyTheoryLib/blob/1.12.2/java/skytheory/lib/capability/DataStorage.java
 */

class HiiragiStorage<T : Any> : IStorage<T> {

    override fun writeNBT(capability: Capability<T>, instance: T, side: Direction): INBT? {
        return if (instance is INBTSerializable<*>) instance.serializeNBT() else null
    }

    @Suppress("UNCHECKED_CAST")
    override fun readNBT(capability: Capability<T>, instance: T, side: Direction, nbt: INBT) {
        if (instance is INBTSerializable<*>) {
            try {
                (instance as INBTSerializable<INBT>).deserializeNBT(nbt)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}