package hiiragi283.api.capability.item

import net.minecraft.item.ItemStack
import net.minecraft.nbt.CompoundNBT
import net.minecraft.nbt.ListNBT
import net.minecraftforge.common.util.Constants
import net.minecraftforge.common.util.INBTSerializable
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.IItemHandlerModifiable

/**
 * RagiItemHandlerとスロットの番号を紐づけたPairの一覧を作ることで，複数のRagiItemHandlerをまとめて処理できる
 * Thanks to SkyTheory!
 */

class HiiragiItemHandlerWrapper(vararg itemHandlers: HiiragiItemHandler) : IItemHandler, IItemHandlerModifiable,
    INBTSerializable<CompoundNBT> {

    private val pairs: MutableList<Pair<HiiragiItemHandler, Int>> = mutableListOf()

    init {
        for (itemHandler in itemHandlers) {
            for (slot in 0 until itemHandler.slots) {
                pairs.add(itemHandler to slot)
            }
        }
    }

    //    Slot    //

    override fun getSlots(): Int = pairs.size

    override fun getStackInSlot(slot: Int): ItemStack {
        val pair = getSlotHandler(slot)
        return pair.first.getStackInSlot(pair.second)
    }

    override fun isItemValid(slot: Int, stack: ItemStack): Boolean = true

    override fun setStackInSlot(slot: Int, stack: ItemStack) {
        val pair = getSlotHandler(slot)
        pair.first.setStackInSlot(pair.second, stack)
    }

    override fun getSlotLimit(slot: Int): Int = 64

    fun getSlotHandler(slot: Int): Pair<HiiragiItemHandler, Int> = pairs[slot]

    //    Extraction    //

    //指定したスロットが搬出可能な場合のみアイテムを取り出すメソッド
    override fun extractItem(slot: Int, amount: Int, simulate: Boolean): ItemStack {
        return if (canExtract(slot)) {
            val pair = getSlotHandler(slot)
            pair.first.extractItem(pair.second, amount, simulate)
        } else ItemStack.EMPTY
    }

    //アイテムを取り出せるか判定するメソッド
    fun canExtract(slot: Int): Boolean = getSlotHandler(slot).first.getIOType().canOutput

    //    Insertion    //

    //指定したスロットが搬入可能な場合のみアイテムを入れるメソッド
    override fun insertItem(slot: Int, stack: ItemStack, simulate: Boolean): ItemStack {
        return if (canInsert(slot)) {
            val pair = getSlotHandler(slot)
            pair.first.insertItem(pair.second, stack, simulate)
        } else stack
    }

    //アイテムを入れられるか判定するメソッド
    fun canInsert(slot: Int): Boolean = getSlotHandler(slot).first.getIOType().canInput

    //    INBTSerializable    //

    override fun serializeNBT(): CompoundNBT {
        val nbtTagList = ListNBT()
        for (i in pairs.indices) {
            val pair = getSlotHandler(i)
            val stack = pair.first.getStackInSlot(pair.second)
            if (!stack.isEmpty) CompoundNBT().also {
                it.putInt("Slot", i)
                //it.put(stack.serializeNBT())
                nbtTagList.add(it)
            }
        }
        return CompoundNBT().also { it.put("Items", nbtTagList) }
    }

    override fun deserializeNBT(nbt: CompoundNBT) {
        val tagList = nbt.getList("Items", Constants.NBT.TAG_COMPOUND)
        for (i in 0 until tagList.size) {
            val tag: CompoundNBT = tagList[i] as CompoundNBT
            val slot = tag.getInt("Slot")
            if (slot >= 0 && slot < pairs.size) {
                val pair = getSlotHandler(slot)
                pair.first.setStackInSlot(pair.second, ItemStack.of(tag))
            }
        }
    }

    //    Custom    //

    fun isEmpty(): Boolean {
        var result = 0
        for (slot in 0 until slots) {
            val stack = getStackInSlot(slot)
            if (stack.isEmpty) result++
        }
        return result == slots
    }

    fun clear(): Unit = clear(0 until slots)

    fun clear(range: IntRange) {
        for (slot in range) {
            setStackInSlot(slot, ItemStack.EMPTY)
        }
    }
}