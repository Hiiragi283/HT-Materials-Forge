package hiiragi283.api.material

object MaterialType {

    @JvmField
    val INTERNAL: Set<String> = setOf("bottles", "wildcard")

    @JvmField
    val SOLID: Set<String> = setOf(
        "dusts",
        "tiny_dusts"
    )

    @JvmField
    val GEM_4x: Set<String> = SOLID.toMutableSet().also {
        it.add("gems")
    }

    @JvmField
    val GEM_4xADVANCED: Set<String> = SOLID.toMutableSet().also {
        it.add("plates")
        it.add("rods")
    }

    @JvmField
    val GEM_9x: Set<String> = GEM_4x.toMutableSet().also {
        it.add("gems")
    }

    @JvmField
    val GEM_9xADVANCED: Set<String> = GEM_9x.toMutableSet().also {
        it.add("plates")
        it.add("rods")
    }

    @JvmField
    val METAL_COMMON: Set<String> = SOLID.toMutableSet().also {
        it.addAll(
            setOf(
                "ingots",
                "nuggets"
            )
        )
    }

    @JvmField
    val METAL_ADVANCED: Set<String> = METAL_COMMON.toMutableSet().also {
        it.addAll(
            setOf(
                "gears",
                "plates",
                "rods"
            )
        )
    }

    @JvmField
    val WOOD: Set<String> = SOLID.toMutableSet().also {
        it.addAll(
            setOf(
                "gears",
                "logs",
                "planks",
                "plates"
            )
        )
    }

}