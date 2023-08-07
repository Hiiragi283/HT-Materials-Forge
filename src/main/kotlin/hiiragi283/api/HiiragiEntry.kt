package hiiragi283.api

import hiiragi283.material.RagiMaterials
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolItem
import net.minecraft.util.IItemProvider
import net.minecraftforge.common.extensions.IForgeItem
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.IForgeRegistryEntry

internal interface HiiragiEntry<T : IForgeRegistryEntry<T>> : IItemProvider {

    val registry: DeferredRegister<T>

    fun getObject(): T

    fun register(): RegistryObject<T> = registry.register(getObject().registryName!!.path) { getObject() }

    interface BLOCK : HiiragiEntry<Block> {

        override val registry: DeferredRegister<Block>
            get() = RagiMaterials.BLOCKS

        override fun getObject(): Block = this as Block

    }

    interface ITEM : HiiragiEntry<Item> {

        override val registry: DeferredRegister<Item>
            get() = RagiMaterials.ITEMS

        override fun getObject(): Item = this as Item

        interface TOOL : ITEM, IForgeItem {

            override fun getContainerItem(itemStack: ItemStack): ItemStack =
                if ((this is ToolItem) && (itemStack.damageValue < this.tier.uses)) itemStack.copy()
                    .also { it.damageValue += 1 } else ItemStack.EMPTY

        }

    }

}

//    Block    //

abstract class HiiragiBlock(settings: Properties) : Block(settings), HiiragiEntry.BLOCK

//    Item    //

abstract class HiiragiBlockItem(block: Block, settings: Properties = Properties()) :
    BlockItem(block, settings), HiiragiEntry.ITEM

abstract class HiiragiItem(settings: Properties = Properties()) : Item(settings), HiiragiEntry.ITEM