package hiiragi283.api.tileentity

import hiiragi283.api.material.HiiragiMaterial
import hiiragi283.api.material.MaterialRegistry
import net.minecraft.block.BlockState
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.nbt.CompoundNBT
import net.minecraft.tileentity.TileEntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class MaterialTileEntity(type: TileEntityType<*>) : HiiragiTileEntity(type) {

    var material: HiiragiMaterial = HiiragiMaterial.EMPTY

    //    HiiragiTileEntity    //

    override fun load(state: BlockState, compound: CompoundNBT) {
        material = MaterialRegistry.getMaterial(compound.getString(TileKey.MATERIAL))
        super.load(state, compound)
    }

    override fun save(compound: CompoundNBT): CompoundNBT {
        compound.putString(TileKey.MATERIAL, material.name)
        return super.save(compound)
    }

    override fun onTilePlaced(
        world: World,
        pos: BlockPos,
        state: BlockState,
        placer: LivingEntity,
        stack: ItemStack
    ) {
        material = TODO()
    }

}