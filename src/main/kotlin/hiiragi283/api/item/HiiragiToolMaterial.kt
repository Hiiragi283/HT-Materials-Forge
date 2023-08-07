package hiiragi283.api.item

import kotlinx.serialization.Serializable
import net.minecraft.item.IItemTier
import net.minecraft.item.crafting.Ingredient

fun toolMaterialOf(init: HiiragiToolMaterial.() -> Unit = {}): HiiragiToolMaterial {
    val material = HiiragiToolMaterial()
    material.init()
    return material
}

@Serializable
class HiiragiToolMaterial(
    var toolDurability: Int = 0,
    var toolMiningSpeed: Float = 0.0f,
    var toolAttackDamage: Float = 0.0f,
    var toolMiningLevel: Int = 0,
    var toolEnchantability: Int = 0,
    var item: Pair<String, String> = "minecraft" to "air"
) : IItemTier {

    companion object {
        @JvmField
        val EMPTY = HiiragiToolMaterial()

        @JvmStatic
        fun copy(material: IItemTier): HiiragiToolMaterial {
            return toolMaterialOf {
                toolDurability = material.uses
                toolMiningSpeed = material.speed
                toolAttackDamage = material.attackDamageBonus
                toolMiningLevel = material.level
                toolEnchantability = material.enchantmentValue
            }
        }
    }

    override fun getUses(): Int = toolDurability

    override fun getSpeed(): Float = toolMiningSpeed

    override fun getAttackDamageBonus(): Float = toolAttackDamage

    override fun getLevel(): Int = toolMiningLevel

    override fun getEnchantmentValue(): Int = toolEnchantability

    override fun getRepairIngredient(): Ingredient = Ingredient.EMPTY

}