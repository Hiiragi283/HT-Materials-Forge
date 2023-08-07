@file:JvmName("HiiragiUtil")

package hiiragi283.material.util

import hiiragi283.material.RagiMaterials
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.client.Minecraft
import net.minecraft.client.entity.player.ClientPlayerEntity
import net.minecraft.client.world.ClientWorld
import net.minecraft.command.ICommandSource
import net.minecraft.data.StockModelShapes
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.item.ItemEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Rarity
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.util.SoundCategory
import net.minecraft.util.SoundEvent
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.vector.Vector3d
import net.minecraft.util.text.TranslationTextComponent
import net.minecraft.world.IBlockReader
import net.minecraft.world.World
import net.minecraftforge.common.IExtensibleEnum
import net.minecraftforge.fluids.FluidStack
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.IForgeRegistry
import net.minecraftforge.registries.IForgeRegistryModifiable
import pers.solid.brrp.v1.model.ModelJsonBuilder
import java.util.*
import java.util.function.BiPredicate

//    Drop    //

fun dropItemAtPlayer(player: PlayerEntity, stack: ItemStack, x: Double = 0.0, y: Double = 0.0, z: Double = 0.0) {
    val world = player.commandSenderWorld
    if (!world.isClientSide) {
        val posPlayer = player.position()
        dropItem(world, posPlayer, stack, x, y, z)
    }
}

fun dropInventoryItems(
    world: World,
    pos: Vector3d,
    inventory: IItemHandler,
    x: Double = 0.0,
    y: Double = 0.0,
    z: Double = 0.0
) {
    for (i in 0 until inventory.slots) {
        val stack = inventory.getStackInSlot(i)
        dropItem(world, pos, stack, x, y, z)
    }
}

fun dropItemFromTile(
    world: World,
    pos: Vector3d,
    stack: ItemStack,
    tile: TileEntity,
    x: Double = 0.0,
    y: Double = 0.0,
    z: Double = 0.0
) {
    stack.getOrCreateTagElement("BlockEntityTag").merge(tile.updateTag)
    dropItem(world, pos, stack, x, y, z)
}

fun dropItem(world: World, pos: Vector3d, stack: ItemStack, x: Double = 0.0, y: Double = 0.0, z: Double = 0.0) {
    if (!world.isClientSide && !stack.isEmpty) {
        val drop = ItemEntity(world, pos.x.toDouble() + 0.5f, pos.y.toDouble(), pos.z.toDouble() + 0.5f, stack)
        drop.setPickUpDelay(0) //即座に回収できるようにする
        drop.spawnAtLocation(stack, 0.0f) //ドロップアイテムをスポーン
    }
}

//    Enchantment    //

fun addEnchantment(enchantment: Enchantment, level: Int, stack: ItemStack) {
    val map = EnchantmentHelper.getEnchantments(stack)
    map[enchantment] = level
    EnchantmentHelper.setEnchantments(map, stack)
}

fun addEnchantments(vararg pairs: Pair<Enchantment, Int>, stack: ItemStack) {
    val map = EnchantmentHelper.getEnchantments(stack)
    for (pair in pairs) {
        map[pair.first] = pair.second
    }
    EnchantmentHelper.setEnchantments(map, stack)
}

fun hasEnchantment(enchantment: Enchantment, stack: ItemStack) =
    EnchantmentHelper.getItemEnchantmentLevel(enchantment, stack) > 0

//    FluidStack    //

//    ItemStack    //

fun getItemStack(location: String, amount: Int): ItemStack? {
    val block = getBlock(location)
    if (block !== null) return ItemStack(block, amount)
    val item = getItem(location)
    return if (item !== null) ItemStack(item, amount) else null
}

//ItemとMetadataのみで比較
fun ItemStack.isSameWithoutCount(other: ItemStack): Boolean = this.item == other.item

//Item, Count, Metadataで比較
fun ItemStack.isSame(other: ItemStack): Boolean = this.isSameWithoutCount(other) && this.count == other.count

//NBTタグも含めて比較
fun ItemStack.isSameWithNBT(other: ItemStack): Boolean = this.isSame(other) && this.tag == other.tag

//    Model    //

fun itemModelLayered(layer0: ResourceLocation, layer1: ResourceLocation? = null): ModelJsonBuilder =
    ModelJsonBuilder.create(StockModelShapes.FLAT_ITEM)
        .addTexture("layer0", layer0)
        .addTexture("layer1", layer1)

//    Ore Dictionary    //

//    Registry    //

fun getBlock(location: String): Block? = ForgeRegistries.BLOCKS.getValue(ResourceLocation(location))

fun getItem(location: String): Item? = ForgeRegistries.ITEMS.getValue(ResourceLocation(location))

fun removeRegistryEntry(registry: IForgeRegistry<*>, registryName: ResourceLocation): Boolean {
    return if (registry is IForgeRegistryModifiable<*>) {
        registry.remove(registryName)
        RagiMaterials.LOGGER.warn("The entry $registryName was removed from ${registry::class.java.name}!")
        true
    } else {
        RagiMaterials.LOGGER.warn("The registry ${registry::class.java.name} is not implementing IForgeRegistryModifiable!")
        false
    }
}

fun removeRegistryEntry(registry: IForgeRegistry<*>, registryName: String): Boolean =
    removeRegistryEntry(registry, ResourceLocation(registryName))

//    ResourceLocation    //

fun hiiragiRL(path: String): ResourceLocation = ResourceLocation(RagiMaterials.MOD_ID, path)

fun forgeRL(path: String): ResourceLocation = ResourceLocation("forge", path)

fun ItemStack.toLocation(split: String = ":"): ResourceLocation = this.item.registryName!!.append(split + this.count)

fun FluidStack.toLocation(addAmount: Boolean): ResourceLocation {
    val location = this.fluid.registryName!!
    if (addAmount) location.append(":" + this.amount)
    return location
}

//ResourceLocationの末尾に付け足す関数
fun ResourceLocation.append(path: String) = ResourceLocation(this.namespace, this.path + path)

//    Result    //

private val WORLD_CLIENT: ClientWorld? by lazy { Minecraft.getInstance().level }
private val PLAYER_CLIENT: ClientPlayerEntity? by lazy { Minecraft.getInstance().player }

fun printResult(block: Block, player: ICommandSource? = PLAYER_CLIENT, predicate: BiPredicate<Block, ICommandSource?>) {
    if (predicate.test(block, player)) succeeded(block, player) else failed(block, player)
}

fun printResult(
    world: IBlockReader? = WORLD_CLIENT,
    pos: BlockPos,
    player: ICommandSource? = PLAYER_CLIENT,
    predicate: TriPredicate<IBlockReader?, BlockPos, ICommandSource?>
) {
    if (predicate.test(world, pos, player)) succeeded(world, pos, player) else failed(world, pos, player)
}

fun printResult(
    tile: TileEntity,
    player: ICommandSource? = PLAYER_CLIENT,
    predicate: BiPredicate<TileEntity, ICommandSource?>
) {
    if (predicate.test(tile, player)) succeeded(tile, player) else failed(tile, player)
}

fun succeeded(block: Block, player: ICommandSource? = PLAYER_CLIENT) {
    player?.sendMessage(TranslationTextComponent("info.ragi_materials.succeeded", block.name), UUID.randomUUID())
}

fun succeeded(world: IBlockReader? = WORLD_CLIENT, pos: BlockPos, player: ICommandSource? = PLAYER_CLIENT) {
    succeeded(world?.getBlockState(pos)?.block ?: Blocks.AIR, player)
}

fun succeeded(tile: TileEntity, player: ICommandSource? = PLAYER_CLIENT) {
    succeeded(tile.level, tile.blockPos, player)
}

fun failed(block: Block, player: ICommandSource? = PLAYER_CLIENT) {
    player?.sendMessage(TranslationTextComponent("info.ragi_materials.failed", block.name), UUID.randomUUID())
}

fun failed(world: IBlockReader? = WORLD_CLIENT, pos: BlockPos, player: ICommandSource? = PLAYER_CLIENT) {
    failed(world?.getBlockState(pos)?.block ?: Blocks.AIR, player)
}

fun failed(tile: TileEntity, player: ICommandSource? = PLAYER_CLIENT) {
    failed(tile.level, tile.blockPos, player)
}

//    Sound    //

fun getSound(location: ResourceLocation): SoundEvent {
    return ForgeRegistries.SOUND_EVENTS.getValue(location)
        ?: ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation("ambient.cave"))!!
}

fun getSound(registryName: String): SoundEvent {
    return getSound(ResourceLocation(registryName))
}

fun playSound(
    world: World?,
    pos: BlockPos,
    soundEvent: SoundEvent,
    volume: Float = 1.0f,
    pitch: Float = 1.0f,
    soundCategory: SoundCategory = SoundCategory.MASTER,
    player: PlayerEntity? = null
) {
    world?.playSound(player, pos, soundEvent, soundCategory, volume, pitch)
}

fun playSound(
    tile: TileEntity,
    soundEvent: SoundEvent,
    volume: Float = 1.0f,
    pitch: Float = 1.0f,
    soundCategory: SoundCategory = SoundCategory.MASTER
) {
    playSound(tile.level, tile.blockPos, soundEvent, volume, pitch, soundCategory)
}

fun playSoundHypixel(world: World?, pos: BlockPos) {
    world?.playSound(null, pos, getSound("minecraft:entity.player.levelup"), SoundCategory.BLOCKS, 1.0f, 0.5f)
}

fun playSoundHypixel(tile: TileEntity) {
    playSoundHypixel(tile.level, tile.blockPos)
}

//    TileEntity    //

@Suppress("UNCHECKED_CAST")
fun <T : TileEntity> getTile(world: IBlockReader?, pos: BlockPos?): T? =
    pos?.let { world?.getBlockEntity(it) } as? T

//    Misc    //

fun executeCommand(sender: ICommandSource, command: String) {
    Minecraft.getInstance().singleplayerServer
}

fun getEnumRarity(name: String): IExtensibleEnum {
    return when (name) {
        "Uncommon" -> Rarity.UNCOMMON
        "Rare" -> Rarity.RARE
        "Epic" -> Rarity.EPIC
        else -> Rarity.COMMON
    }
}