package hiiragi283.api

import hiiragi283.material.RagiMaterials
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolItem
import net.minecraft.util.IItemProvider
import net.minecraftforge.common.extensions.IForgeItem
import net.minecraftforge.registries.IForgeRegistryEntry

internal interface HiiragiEntry<T : IForgeRegistryEntry<T>> : IItemProvider {

    fun getObject(): T

    fun initResourcePack()

    interface BLOCK : HiiragiEntry<Block> {

        override fun getObject(): Block = this as Block

    }

    interface ITEM : HiiragiEntry<Item> {

        override fun getObject(): Item = this as Item

        interface TOOL : ITEM, IForgeItem {

            override fun getContainerItem(itemStack: ItemStack): ItemStack =
                if ((this is ToolItem) && (itemStack.damageValue < this.tier.uses)) itemStack.copy()
                    .also { it.damageValue += 1 } else ItemStack.EMPTY

        }

    }

}

//    Block    //

abstract class HiiragiBlock(id: String, settings: Properties) : Block(settings), HiiragiEntry.BLOCK {

    init {
        setRegistryName(RagiMaterials.MOD_ID, id)
    }

}

//    Item    //

open class HiiragiBlockItem(block: Block, settings: Properties = Properties()) :
    BlockItem(block, settings), HiiragiEntry.ITEM {

    init {
        registryName = block.registryName
    }

    override fun initResourcePack() {
    }

}

abstract class HiiragiItem(id: String, settings: Properties = Properties()) : Item(settings), HiiragiEntry.ITEM {

    init {
        setRegistryName(RagiMaterials.MOD_ID, id)
    }

}