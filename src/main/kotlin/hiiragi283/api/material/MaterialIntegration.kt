package hiiragi283.api.material

import hiiragi283.material.util.HiiragiColor

object MaterialIntegration {

    //    Thermal Series    //

    @JvmField
    val MITHRIL = materialOf("mithril") {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE, HiiragiColor.AQUA, HiiragiColor.WHITE).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val SIGNALUM = alloyOf(
        "signalum",
        mapOf(MaterialElements.COPPER to 4, MaterialElements.GOLD to 1, MaterialCommon.REDSTONE to 10)
    ) {
        color = 0xFF9E08
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val LUMIUM = alloyOf(
        "lumium",
        mapOf(MaterialElements.TIN to 4, MaterialElements.SILVER to 1, MaterialCommon.GLOWSTONE to 4)
    ) {
        color = 0xDFE58F
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val ENDERIUM = alloyOf(
        "enderium",

        mapOf(MaterialElements.LEAD to 4, MaterialElements.PLATINUM to 1, MaterialCommon.ENDER_PEARL to 4)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_GREEN to 1, HiiragiColor.BLUE to 1).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val PYROTHEUM = compoundOf(
        "pyrotheum",
        mapOf(HiiragiMaterial.UNKNOWN to 2, MaterialCommon.REDSTONE to 1, MaterialElements.SULFUR to 1)
    ) {
        color = HiiragiColor.YELLOW.rgb
    }

    @JvmField
    val CRYOTHEUM = compoundOf(
        "cryotheum",
        mapOf(HiiragiMaterial.UNKNOWN to 2, MaterialCommon.REDSTONE to 1, MaterialCommon.WATER.addBracket() to 1)
    ) {
        color = HiiragiColor.AQUA.rgb
    }

    @JvmField
    val AEROTHEUM = compoundOf(
        "aerotheum",
        mapOf(HiiragiMaterial.UNKNOWN to 2, MaterialCommon.REDSTONE to 1, MaterialCommon.NITER.addBracket() to 1)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.GREEN, HiiragiColor.YELLOW, HiiragiColor.WHITE).rgb
    }

    @JvmField
    val PETROTHEUM = compoundOf(
        "petrotheum",
        mapOf(HiiragiMaterial.UNKNOWN to 2, MaterialCommon.REDSTONE to 1, MaterialCommon.OBSIDIAN.addBracket() to 1)
    ) {
        color =
            HiiragiColor.mixColor(
                HiiragiColor.BLACK to 4,
                HiiragiColor.GRAY to 2,
                HiiragiColor.BLUE to 1,
                HiiragiColor.RED to 1
            ).rgb
    }

    //    Mekanism    //

    @JvmField
    val OBSIDIAN_REFINED = alloyOf(
        "refined_obsidian",
        mapOf(MaterialCommon.OBSIDIAN.addBracket() to 1, MaterialElements.OSMIUM to 1, MaterialCommon.DIAMOND to 1)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_RED to 2, HiiragiColor.BLUE to 5, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val GLOWSTONE_REFINED = alloyOf(
        "refined_glowstone",
        mapOf(MaterialCommon.GLOWSTONE to 1, MaterialElements.OSMIUM to 1)
    ) {
        color = HiiragiColor.YELLOW.rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    //    Ender IO    //

    @JvmField
    val ELECTRICAL_STEEL = mixtureOf(
        "electrical_steel",
        listOf(MaterialElements.IRON, MaterialElements.SILICON, MaterialElements.CARBON)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.GRAY to 1, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val ENERGETIC_ALLOY = alloyOf(
        "energetic_alloy",
        mapOf(MaterialElements.GOLD to 1, MaterialCommon.REDSTONE to 1, MaterialCommon.GLOWSTONE to 1)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD, HiiragiColor.RED).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val VIBRANT_ALLOY = alloyOf(
        "vibrant_alloy",
        mapOf(ENERGETIC_ALLOY.addBracket() to 1, MaterialCommon.ENDER_PEARL to 1)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.GREEN, HiiragiColor.YELLOW).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val REDSTONE_ALLOY = alloyOf(
        "redstone_alloy",
        mapOf(MaterialElements.SILICON to 1, MaterialCommon.REDSTONE to 1)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_RED, HiiragiColor.RED).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val CONDUCTIVE_IRON = alloyOf(
        "conductive_iron",
        mapOf(MaterialElements.IRON to 1, MaterialCommon.REDSTONE to 1)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.RED to 1, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val PULSATING_IRON = alloyOf(
        "pulsating_iron",
        mapOf(MaterialElements.IRON to 1, MaterialCommon.ENDER_PEARL to 1)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.GREEN to 1, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val DARK_STEEL = mixtureOf(
        "dark_steel",
        listOf(MaterialElements.IRON, MaterialElements.CARBON, MaterialCommon.OBSIDIAN)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.BLACK to 1, HiiragiColor.DARK_GRAY to 3).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val SOULARIUM = alloyOf(
        "soularium",
        mapOf(MaterialElements.GOLD to 1, MaterialCommon.SOUL_SAND.addBracket() to 1)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_GRAY to 5, HiiragiColor.GOLD to 1).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val END_STEEL = mixtureOf(
        "end_steel",
        listOf(DARK_STEEL, MaterialCommon.END_STONE, MaterialCommon.OBSIDIAN)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.YELLOW to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val IRON_ALLOY = mixtureOf(
        "construction_alloy",
        listOf(HiiragiMaterial.UNKNOWN, MaterialElements.IRON, HiiragiMaterial.UNKNOWN)
    ) {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE, HiiragiColor.GREEN, HiiragiColor.RED).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    //    Thaumcraft    //

    @JvmField
    val THAUMIUM = materialOf("thaumium") {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_RED to 2, HiiragiColor.BLUE to 5, HiiragiColor.WHITE to 4).rgb
        crystalType = CrystalType.METAL
        formula = "✡"
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val VOID_METAL = materialOf("void") {
        color = HiiragiColor.mixColor(HiiragiColor.BLACK to 4, HiiragiColor.DARK_PURPLE to 1, HiiragiColor.BLUE to 1).rgb
        crystalType = CrystalType.METAL
        formula = "Vm9pZA=="
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    //    Botania    //

    @JvmField
    val MANA = materialOf("mana") {
        formula = "☆"
    }

    @JvmField
    val MANASTEEL = mixtureOf("manasteel", listOf(MaterialElements.IRON, MANA)) {
        color = HiiragiColor.BLUE.rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val MANA_DIAMOND = mixtureOf("mana_diamond", listOf(MaterialCommon.DIAMOND, MANA)) {
        color = HiiragiColor.AQUA.rgb
        crystalType = CrystalType.DIAMOND
        validShapes.addAll(MaterialType.GEM_9xADVANCED)
    }

    @JvmField
    val TERRASTEEL = mixtureOf("terrasteel", listOf(MaterialElements.IRON, MANA)) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_GREEN, HiiragiColor.GREEN).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val ELEMENTIUM = mixtureOf("elven_elementium", listOf(MaterialElements.IRON, MANA)) {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val DRAGONSTONE = mixtureOf("elven_dragonstone", listOf(MaterialCommon.DIAMOND, MANA)) {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        crystalType = CrystalType.DIAMOND
        validShapes.addAll(MaterialType.GEM_9xADVANCED)
    }

    //    Embers    //

    @JvmField
    val DAWNSTONE = compoundOf("dawnstone", mapOf(MaterialElements.COPPER to 1, MaterialElements.GOLD to 1)) {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD to 2, HiiragiColor.RED to 1, HiiragiColor.YELLOW to 1).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    //    Project Red: Core    //

    @JvmField
    val ELECTROTINE = materialOf("electrotine") {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_AQUA, HiiragiColor.BLUE, HiiragiColor.AQUA).rgb
        formula = "Er"
        molar = 112.2
        tempBoil = 1201
        tempMelt = 1122
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val RED_ALLOY = alloyOf("red_alloy", mapOf(MaterialElements.IRON to 1, MaterialCommon.REDSTONE to 8)) {
        color = HiiragiColor.DARK_RED.rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ELECTROTINE_ALLOY = alloyOf("electrotine_alloy", mapOf(MaterialElements.IRON to 1, ELECTROTINE to 8)) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_AQUA, HiiragiColor.BLUE, HiiragiColor.AQUA).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    //    Tinker's Construct    //

    @JvmField
    val ARDITE = materialOf("ardite") {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_RED to 2, HiiragiColor.GOLD to 1).rgb
        crystalType = CrystalType.METAL
        formula = "Ad"
        molar = 116.0
        tempBoil = 5000
        tempMelt = 3000
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val MANYULLYN = alloyOf("manyullyn", mapOf(MaterialElements.COBALT to 1, ARDITE to 1)) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_RED to 2, HiiragiColor.BLUE to 5, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ALUMINIUM_BRASS =
        alloyOf("aluminium_brass", mapOf(MaterialElements.ALUMINIUM to 3, MaterialElements.COPPER to 1)) {
            color = HiiragiColor.mixColor(HiiragiColor.GOLD, HiiragiColor.YELLOW, HiiragiColor.WHITE).rgb
            crystalType = CrystalType.METAL
            validShapes.addAll(MaterialType.METAL_ADVANCED)
        }

}