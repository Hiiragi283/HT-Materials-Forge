package hiiragi283.api.material

import hiiragi283.api.item.HiiragiToolMaterial
import hiiragi283.material.util.HiiragiColor
import net.minecraft.item.ItemTier


/**
 * @author MrKono
 * @author turtton
 */
object MaterialElements {

    //    1st Period    //

    @JvmField
    val HYDROGEN = materialOf("hydrogen") {
        color = HiiragiColor.BLUE.rgb
        formula = "H"
        molar = 1.0
        tempBoil = 20
        tempMelt = 14
    }

    @JvmField
    val HELIUM = materialOf("helium") {
        color = HiiragiColor.YELLOW.rgb
        formula = "He"
        molar = 4.0
        tempBoil = 3
        tempMelt = 1
    }

    //    2nd Period    //

    @JvmField
    val LITHIUM = materialOf("lithium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Li"
        isActiveToWater = true
        molar = 6.9
        tempBoil = 1560
        tempMelt = 454
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val BERYLLIUM = materialOf("beryllium") {
        color = HiiragiColor.DARK_GREEN.rgb
        crystalType = CrystalType.METAL
        formula = "Be"
        isActiveToWater = true
        molar = 9.0
        tempBoil = 2742
        tempMelt = 1560
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val BORON = materialOf("boron") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "B"
        molar = 10.8
        tempBoil = 4200
        tempMelt = 2349
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val CARBON = materialOf("carbon") {
        color = HiiragiColor.mixColor(HiiragiColor.BLACK, HiiragiColor.DARK_GRAY).rgb
        formula = "C"
        molar = 12.0
        //tempBoil = 4300
        //tempMelt = 4000
        tempSubl = 3915
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val NITROGEN = materialOf("nitrogen") {
        color = HiiragiColor.AQUA.rgb
        formula = "N"
        molar = 14.0
        tempBoil = 77
        tempMelt = 63
    }

    @JvmField
    val OXYGEN = materialOf("oxygen") {
        formula = "O"
        molar = 16.0
        tempBoil = 90
        tempMelt = 54
    }

    @JvmField
    val FLUORINE = materialOf("fluorine") {
        color = HiiragiColor.GREEN.rgb
        formula = "F"
        molar = 19.0
        tempBoil = 85
        tempMelt = 54
    }

    @JvmField
    val NEON = materialOf("neon") {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        formula = "Ne"
        molar = 20.2
        tempBoil = 27
        tempMelt = 25
    }

    //    3rd Period    //

    @JvmField
    val SODIUM = materialOf("sodium") {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_BLUE to 1, HiiragiColor.BLUE to 4).rgb
        crystalType = CrystalType.METAL
        formula = "Na"
        isActiveToWater = true
        molar = 23.0
        tempBoil = 1156
        tempMelt = 371
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val MAGNESIUM = materialOf("magnesium") {
        color = HiiragiColor.mixColor(HiiragiColor.LIGHT_PURPLE, HiiragiColor.WHITE).rgb
        crystalType = CrystalType.METAL
        formula = "Mg"
        isActiveToWater = true
        molar = 24.3
        tempBoil = 1363
        tempMelt = 923
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ALUMINIUM = materialOf("aluminium") {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.WHITE to 5).rgb
        crystalType = CrystalType.METAL
        formula = "Al"
        molar = 27.0
        tempBoil = 2792
        tempMelt = 933
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val SILICON = materialOf("silicon") {
        color = HiiragiColor.mixColor(HiiragiColor.BLACK to 2, HiiragiColor.GRAY to 1, HiiragiColor.BLUE to 1).rgb
        crystalType = CrystalType.METAL
        formula = "Si"
        molar = 28.1
        tempBoil = 3538
        tempMelt = 1687
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PHOSPHORUS = materialOf("phosphorus") {
        color = HiiragiColor.YELLOW.rgb
        formula = "P"
        hasOre = true
        molar = 31.0
        tempBoil = 550
        tempMelt = 317
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val SULFUR = materialOf("sulfur") {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD, HiiragiColor.YELLOW).rgb
        formula = "S"
        hasOre = true
        molar = 32.1
        tempBoil = 718
        tempMelt = 388
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val CHLORINE = materialOf("chlorine") {
        color = HiiragiColor.YELLOW.rgb
        formula = "Cl"
        molar = 35.5
        tempBoil = 239
        tempMelt = 171
    }

    @JvmField
    val ARGON = materialOf("argon") {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        formula = "Ar"
        molar = 40.0
        tempBoil = 87
        tempMelt = 84
    }

    //    4th Period    //

    @JvmField
    val POTASSIUM = materialOf("potassium") {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_BLUE to 2, HiiragiColor.BLUE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "K"
        isActiveToWater = true
        molar = 39.1
        tempBoil = 1032
        tempMelt = 337
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val CALCIUM = materialOf("calcium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ca"
        isActiveToWater = true
        molar = 40.1
        tempBoil = 1757
        tempMelt = 1115
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val SCANDIUM = materialOf("scandium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Sc"
        molar = 45.0
        tempBoil = 3109
        tempMelt = 1814
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TITANIUM = materialOf("titanium") {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD to 1, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        formula = "Ti"
        molar = 47.9
        tempBoil = 3560
        tempMelt = 1941
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val VANADIUM = materialOf("vanadium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "V"
        molar = 50.9
        tempBoil = 3680
        tempMelt = 2183
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val CHROMIUM = materialOf("chromium") {
        color = HiiragiColor.GREEN.rgb
        crystalType = CrystalType.METAL
        formula = "Cr"
        molar = 52.0
        tempBoil = 2944
        tempMelt = 2180
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val MANGANESE = materialOf("manganese") {
        color = HiiragiColor.mixColor(HiiragiColor.RED, HiiragiColor.WHITE).rgb
        crystalType = CrystalType.METAL
        formula = "Mn"
        molar = 54.9
        tempBoil = 2334
        tempMelt = 1519
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val IRON = materialOf("iron") {
        color = HiiragiColor.mixColor(HiiragiColor.GRAY to 1, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        formula = "Fe"
        hasOre = true
        molar = 55.8
        tempBoil = 3134
        tempMelt = 1811
        toolProperty = HiiragiToolMaterial.copy(ItemTier.IRON)
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val COBALT = materialOf("cobalt") {
        color = HiiragiColor.BLUE.rgb
        crystalType = CrystalType.METAL
        formula = "Co"
        hasOre = true
        molar = 58.9
        tempBoil = 3200
        tempMelt = 1768
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val NICKEL = materialOf("nickel") {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD, HiiragiColor.WHITE).rgb
        crystalType = CrystalType.METAL
        formula = "Ni"
        hasOre = true
        molar = 58.7
        tempBoil = 3186
        tempMelt = 1728
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val COPPER = materialOf("copper") {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD, HiiragiColor.RED).rgb
        crystalType = CrystalType.METAL
        formula = "Cu"
        hasOre = true
        molar = 63.5
        tempBoil = 2835
        tempMelt = 1358
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val ZINC = materialOf("zinc") {
        color = HiiragiColor.mixColor(HiiragiColor.GREEN to 1, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        formula = "Zn"
        hasOre = true
        molar = 65.4
        tempBoil = 1180
        tempMelt = 693
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val GALLIUM = materialOf("gallium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ga"
        molar = 69.7
        tempBoil = 2673
        tempMelt = 303
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val GERMANIUM = materialOf("germanium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ge"
        molar = 72.6
        tempBoil = 3106
        tempMelt = 1211
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ARSENIC = materialOf("arsenic") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "As"
        molar = 74.9
        //tempBoil = 887
        //tempMelt = 1090
        tempSubl = 887
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val SELENIUM = materialOf("selenium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Se"
        molar = 74.9
        tempBoil = 958
        tempMelt = 453
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val BROMINE = materialOf("bromine") {
        color = HiiragiColor.GOLD.rgb
        formula = "Br"
        molar = 79.9
        tempBoil = 332
        tempMelt = 267
    }

    @JvmField
    val KRYPTON = materialOf("krypton") {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        formula = "Kr"
        molar = 83.8
        tempBoil = 120
        tempMelt = 116
    }

    //    5th Period    //

    @JvmField
    val RUBIDIUM = materialOf("rubidium") {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_BLUE to 3, HiiragiColor.BLUE to 2).rgb
        crystalType = CrystalType.METAL
        formula = "Rb"
        isActiveToWater = true
        molar = 85.5
        tempBoil = 961
        tempMelt = 312
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val STRONTIUM = materialOf("strontium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Sr"
        isActiveToWater = true
        molar = 87.6
        tempBoil = 1655
        tempMelt = 1050
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val YTTRIUM = materialOf("yttrium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Y"
        molar = 88.9
        tempBoil = 3609
        tempMelt = 1799
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ZIRCONIUM = materialOf("zirconium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Zr"
        molar = 91.2
        tempBoil = 4682
        tempMelt = 2128
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val NIOBIUM = materialOf("niobium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Nb"
        molar = 92.9
        tempBoil = 5017
        tempMelt = 2750
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val MOLYBDENUM = materialOf("molybdenum") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Mo"
        molar = 96.0
        tempBoil = 4912
        tempMelt = 2896
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TECHNETIUM = materialOf("technetium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Tc"
        //molar = 97.0/98.0/99.0
        tempBoil = 4538
        tempMelt = 2430
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val RUTHENIUM = materialOf("ruthenium") {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.LIGHT_PURPLE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Ru"
        molar = 101.1
        tempBoil = 4423
        tempMelt = 2607
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val RHODIUM = materialOf("rhodium") {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.RED to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Rh"
        molar = 102.9
        tempBoil = 3968
        tempMelt = 2237
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PALLADIUM = materialOf("palladium") {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.YELLOW to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Pd"
        molar = 106.4
        tempBoil = 3236
        tempMelt = 1828
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val SILVER = materialOf("silver") {
        color = HiiragiColor.mixColor(HiiragiColor.AQUA to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Ag"
        hasOre = true
        molar = 107.9
        tempBoil = 2435
        tempMelt = 1235
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val CADMIUM = materialOf("cadmium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Cd"
        molar = 112.4
        tempBoil = 1040
        tempMelt = 594
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val INDIUM = materialOf("indium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "In"
        molar = 114.8
        tempBoil = 2345
        tempMelt = 430
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TIN = materialOf("tin") {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.AQUA to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Sn"
        hasOre = true
        molar = 118.7
        tempBoil = 2875
        tempMelt = 505
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val ANTIMONY = materialOf("antimony") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Sb"
        molar = 121.8
        tempBoil = 1860
        tempMelt = 904
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TELLURIUM = materialOf("tellurium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Te"
        molar = 127.6
        tempBoil = 1261
        tempMelt = 723
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val IODINE = materialOf("iodine") {
        color = HiiragiColor.DARK_PURPLE.rgb
        formula = "I"
        molar = 126.9
        tempBoil = 457
        tempMelt = 387
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val XENON = materialOf("xenon") {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        formula = "Xe"
        molar = 131.3
        tempBoil = 165
        tempMelt = 161
    }

    //    6th Period    //

    @JvmField
    val CAESIUM = materialOf("caesium") {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_BLUE to 4, HiiragiColor.BLUE to 1).rgb
        crystalType = CrystalType.METAL
        formula = "Cs"
        isActiveToWater = true
        molar = 132.9
        tempBoil = 944
        tempMelt = 302
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val BARIUM = materialOf("barium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ba"
        isActiveToWater = true
        molar = 137.3
        tempBoil = 2170
        tempMelt = 1000
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    //    Lanthanides Start    //

    @JvmField
    val LANTHANUM = materialOf("lanthanum") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "La"
        molar = 138.9
        tempBoil = 3737
        tempMelt = 1193
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val CERIUM = materialOf("cerium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ce"
        molar = 140.1
        tempBoil = 3716
        tempMelt = 1068
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PRASEODYMIUM = materialOf("praseodymium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Pr"
        molar = 140.9
        tempBoil = 3793
        tempMelt = 1208
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val NEODYMIUM = materialOf("neodymium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Nd"
        molar = 144.2
        tempBoil = 3347
        tempMelt = 1297
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PROMETHIUM = materialOf("promethium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Pm"
        //molar = 145.0
        tempBoil = 3237
        tempMelt = 1315
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val SAMARIUM = materialOf("samarium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Sm"
        molar = 150.4
        tempBoil = 2067
        tempMelt = 1345
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val EUROPIUM = materialOf("europium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Eu"
        molar = 152.0
        tempBoil = 1802
        tempMelt = 1099
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val GADOLINIUM = materialOf("gadolinium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Gd"
        molar = 157.3
        tempBoil = 3546
        tempMelt = 1585
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TERBIUM = materialOf("terbium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Tb"
        molar = 158.9
        tempBoil = 3503
        tempMelt = 1629
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val DYSPROSIUM = materialOf("dysprosium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Dy"
        molar = 157.3
        tempBoil = 2840
        tempMelt = 1680
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val HOLMIUM = materialOf("holmium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ho"
        molar = 164.9
        tempBoil = 2993
        tempMelt = 1734
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ERBIUM = materialOf("erbium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Er"
        molar = 167.3
        tempBoil = 3141
        tempMelt = 1802
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val THULIUM = materialOf("thulium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Tm"
        molar = 168.9
        tempBoil = 2223
        tempMelt = 1818
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val YTTERBIUM = materialOf("ytterbium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Yb"
        molar = 173.0
        tempBoil = 1469
        tempMelt = 1097
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val LUTETIUM = materialOf("lutetium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Lu"
        molar = 175.0
        tempBoil = 3675
        tempMelt = 1925
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    //    Lanthanides End    //

    @JvmField
    val HAFNIUM = materialOf("hafnium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Hf"
        molar = 178.5
        tempBoil = 4876
        tempMelt = 2506
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TANTALUM = materialOf("tantalum") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ta"
        molar = 180.9
        tempBoil = 5731
        tempMelt = 3290
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TUNGSTEN = materialOf("tungsten") {
        color = HiiragiColor.mixColor(HiiragiColor.BLACK to 2, HiiragiColor.DARK_GRAY to 1).rgb
        crystalType = CrystalType.METAL
        formula = "W"
        hasOre = true
        molar = 183.8
        tempBoil = 5828
        tempMelt = 3695
        toolProperty = HiiragiToolMaterial.copy(ItemTier.DIAMOND)
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val RHENIUM = materialOf("rhenium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Re"
        molar = 186.2
        tempBoil = 5869
        tempMelt = 3459
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val OSMIUM = materialOf("osmium") {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Os"
        molar = 190.2
        tempBoil = 5285
        tempMelt = 3306
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val IRIDIUM = materialOf("iridium") {
        color = HiiragiColor.mixColor(HiiragiColor.AQUA to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Ir"
        molar = 192.2
        tempBoil = 4701
        tempMelt = 2719
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val PLATINUM = materialOf("platinum") {
        color = HiiragiColor.mixColor(HiiragiColor.GREEN to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Pt"
        molar = 195.1
        tempBoil = 4098
        tempMelt = 2041
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val GOLD = materialOf("gold") {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD, HiiragiColor.YELLOW).rgb
        crystalType = CrystalType.METAL
        formula = "Au"
        hasOre = true
        molar = 197.0
        tempBoil = 3129
        tempMelt = 1337
        toolProperty = HiiragiToolMaterial.copy(ItemTier.GOLD)
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val MERCURY = materialOf("mercury") {
        formula = "Hg"
        molar = 200.6
        tempBoil = 670
        tempMelt = 234
    }

    @JvmField
    val THALLIUM = materialOf("thallium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Tl"
        molar = 204.4
        tempBoil = 1749
        tempMelt = 577
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val LEAD = materialOf("lead") {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_BLUE, HiiragiColor.DARK_GRAY, HiiragiColor.WHITE).rgb
        crystalType = CrystalType.METAL
        formula = "Pb"
        hasOre = true
        molar = 207.2
        tempBoil = 2022
        tempMelt = 601
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val BISMUTH = materialOf("bismuth") {
        color = HiiragiColor.AQUA.rgb
        crystalType = CrystalType.METAL
        formula = "Bi"
        hasOre = true
        molar = 209.0
        tempBoil = 1837
        tempMelt = 545
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val POLONIUM = materialOf("polonium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Po"
        //molar = 209.0/210.0
        tempBoil = 1235
        tempMelt = 527
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ASTATINE = materialOf("astatine") {
        color = HiiragiColor.BLACK.rgb
        formula = "At"
        //molar = 210.0
        tempBoil = 610
        tempMelt = 575
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val RADON = materialOf("radon") {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        formula = "Rn"
        //molar = 222.0
        tempBoil = 211
        tempMelt = 202
    }

    //    7th Period    //

    @JvmField
    val FRANCIUM = materialOf("francium") {
        color = HiiragiColor.DARK_BLUE.rgb
        formula = "Fr"
        isActiveToWater = true
        //molar = 223.0
        tempBoil = 890
        tempMelt = 281
    }

    @JvmField
    val RADIUM = materialOf("radium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ra"
        isActiveToWater = true
        //molar = 226.0
        tempBoil = 2010
        tempMelt = 973
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    //    Actinides Start    //

    @JvmField
    val ACTINIUM = materialOf("actinium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ac"
        //molar = 227.0
        tempBoil = 3471
        tempMelt = 1323
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val THORIUM = materialOf("thorium") {
        color = HiiragiColor.mixColor(HiiragiColor.BLACK to 2, HiiragiColor.DARK_GREEN to 1, HiiragiColor.GRAY to 1).rgb
        crystalType = CrystalType.METAL
        formula = "Th"
        hasOre = true
        molar = 232.0
        tempBoil = 5061
        tempMelt = 2115
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PROTACTINIUM = materialOf("protactinium") {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Pa"
        molar = 231.0
        tempBoil = 4300
        tempMelt = 1841
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val URANIUM = materialOf("uranium") {
        color = HiiragiColor.GREEN.rgb
        crystalType = CrystalType.METAL
        formula = "U"
        hasOre = true
        molar = 238.0
        tempBoil = 4404
        tempMelt = 1405
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val NEPTUNIUM = materialOf("neptunium") {
        color = HiiragiColor.BLUE.rgb
        crystalType = CrystalType.METAL
        formula = "Np"
        //molar = 237.0
        tempBoil = 4273
        tempMelt = 917
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PLUTONIUM = materialOf("plutonium") {
        color = HiiragiColor.RED.rgb
        crystalType = CrystalType.METAL
        formula = "Pu"
        molar = 244.1
        tempBoil = 3501
        tempMelt = 913
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val AMERICIUM = materialOf("americium") {
        crystalType = CrystalType.METAL
        formula = "Am"
        //molar = 243.0
        tempBoil = 1880
        tempMelt = 1449
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val CURIUM = materialOf("curium") {
        crystalType = CrystalType.METAL
        formula = "Cm"
        //molar = 247.0
        tempBoil = 3383
        tempMelt = 1613
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val BERKELIUM = materialOf("berkelium") {
        crystalType = CrystalType.METAL
        formula = "Bk"
        //molar = 247.0
        tempBoil = 2900
        tempMelt = 1259
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val CALIFORNIUM = materialOf("californium") {
        crystalType = CrystalType.METAL
        formula = "Cf"
        //molar = 251.0/252.0
        tempBoil = 1743
        tempMelt = 1173
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val EINSTEINIUM = materialOf("einsteinium") {
        crystalType = CrystalType.METAL
        formula = "Es"
        //molar = 252.0
        tempBoil = 1269
        tempMelt = 1133
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val FERMIUM = materialOf("fermium") {
        crystalType = CrystalType.METAL
        formula = "Fm"
        //molar = 257.0
        //tempBoil =
        //tempMelt = 1125/1800
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val MENDELEVIUM = materialOf("mendelevium") {
        crystalType = CrystalType.METAL
        formula = "Md"
        //molar = 258.0
        //tempBoil =
        //tempMelt = 1100
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val NOBELIUM = materialOf("nobelium") {
        crystalType = CrystalType.METAL
        formula = "No"
        //molar = 259.0
        //tempBoil =
        //tempMelt = 1100
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val LAWRENCIUM = materialOf("lawrencium") {
        crystalType = CrystalType.METAL
        formula = "Lr"
        //molar = 262.0/266.0
        //tempBoil =
        //tempMelt = 1900
        validShapes.addAll(MaterialType.SOLID)
    }

    //    Actinides End    //

    @JvmField
    val RUTHERFORDIUM = materialOf("rutherfordium") {
        crystalType = CrystalType.METAL
        formula = "Lr"
        //molar = 261.1/267.0
        //tempBoil = 5800
        //tempMelt = 2400
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val DUBNIUM = materialOf("dubnium") {
        crystalType = CrystalType.METAL
        formula = "Db"
        //molar = 265.0/268.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val SEABORGIUM = materialOf("seaborgium") {
        crystalType = CrystalType.METAL
        formula = "Sg"
        //molar = 269.0/271.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val BOHRIUM = materialOf("bohrium") {
        crystalType = CrystalType.METAL
        formula = "Bh"
        //molar = 270.0/272.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val HASSIUM = materialOf("hassium") {
        crystalType = CrystalType.METAL
        formula = "Hs"
        //molar = 269.0/277.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val MEITNERIUM = materialOf("meitnerium") {
        crystalType = CrystalType.METAL
        formula = "Mt"
        //molar = 276.0/278.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val DARMSTADTIUM = materialOf("darmstadtium") {
        crystalType = CrystalType.METAL
        formula = "Ds"
        //molar = 281.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val ROENTGENIUM = materialOf("roentgenium") {
        crystalType = CrystalType.METAL
        formula = "Rg"
        //molar = 280.0/281.0/282.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val COPERNICIUM = materialOf("copernicium") {
        crystalType = CrystalType.METAL
        formula = "Cn"
        //molar = 285.0
        //tempBoil = 340
        //tempMelt = 283
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val NIHONIUM = materialOf("nihonium") {
        crystalType = CrystalType.METAL
        formula = "Nh"
        //molar = 278.0/286.0
        //tempBoil = 1400
        //tempMelt = 700
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val FLEROVIUM = materialOf("flerovium") {
        crystalType = CrystalType.METAL
        formula = "Fl"
        //molar = 289.0
        //tempBoil =
        //tempMelt = 284
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val MOSCOVIUM = materialOf("moscovium") {
        crystalType = CrystalType.METAL
        formula = "Mc"
        //molar = 289.0/290.0
        //tempBoil = 1400
        //tempMelt = 700
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val LIVERMORIUM = materialOf("livermorium") {
        crystalType = CrystalType.METAL
        formula = "Lv"
        //molar = 293.0
        //tempBoil = 1100
        //tempMelt = 700
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val TENNESSINE = materialOf("tennessine") {
        crystalType = CrystalType.METAL
        formula = "Ts"
        //molar = 293.0/294.0
        //tempBoil = 883
        //tempMelt = 700
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val OGANESSON = materialOf("oganesson") {
        crystalType = CrystalType.METAL
        formula = "Og"
        //molar = 294.0
        //tempBoil = 450
        //tempMelt = 352
        validShapes.addAll(MaterialType.SOLID)
    }

    //    Isotope    //

    @JvmField
    val DEUTERIUM = isotopeOf("deuterium", HYDROGEN) {
        formula = "D"
        molar = 2.0
    }

    @JvmField
    val TRITIUM = isotopeOf("tritium", HYDROGEN) {
        formula = "T"
        molar = 3.0
    }

    @JvmField
    val URANIUM235 = isotopeOf("uranium235", URANIUM) {
        formula = "U235"
        molar = 235.0
    }

    fun register() {
        // --1st Period--
        MaterialRegistry.registerMaterial(HYDROGEN)
        MaterialRegistry.registerMaterial(HELIUM)
        // --2nd Period--
        MaterialRegistry.registerMaterial(LITHIUM)
        MaterialRegistry.registerMaterial(BERYLLIUM)
        MaterialRegistry.registerMaterial(BORON)
        MaterialRegistry.registerMaterial(CARBON)
        MaterialRegistry.registerMaterial(NITROGEN)
        MaterialRegistry.registerMaterial(OXYGEN)
        MaterialRegistry.registerMaterial(FLUORINE)
        MaterialRegistry.registerMaterial(NEON)
        // --3rd Period--
        MaterialRegistry.registerMaterial(SODIUM)
        MaterialRegistry.registerMaterial(MAGNESIUM)
        MaterialRegistry.registerMaterial(ALUMINIUM)
        MaterialRegistry.registerMaterial(SILICON)
        MaterialRegistry.registerMaterial(PHOSPHORUS)
        MaterialRegistry.registerMaterial(SULFUR)
        MaterialRegistry.registerMaterial(CHLORINE)
        MaterialRegistry.registerMaterial(ARGON)
        // --4th Period--
        MaterialRegistry.registerMaterial(POTASSIUM)
        MaterialRegistry.registerMaterial(CALCIUM)
        MaterialRegistry.registerMaterial(SCANDIUM)
        MaterialRegistry.registerMaterial(TITANIUM)
        MaterialRegistry.registerMaterial(VANADIUM)
        MaterialRegistry.registerMaterial(CHROMIUM)
        MaterialRegistry.registerMaterial(MANGANESE)
        MaterialRegistry.registerMaterial(IRON)
        MaterialRegistry.registerMaterial(COBALT)
        MaterialRegistry.registerMaterial(NICKEL)
        MaterialRegistry.registerMaterial(COPPER)
        MaterialRegistry.registerMaterial(ZINC)
        MaterialRegistry.registerMaterial(GALLIUM)
        MaterialRegistry.registerMaterial(GERMANIUM)
        MaterialRegistry.registerMaterial(ARSENIC)
        MaterialRegistry.registerMaterial(SELENIUM)
        MaterialRegistry.registerMaterial(BROMINE)
        MaterialRegistry.registerMaterial(KRYPTON)
        // --5th Period--
        MaterialRegistry.registerMaterial(RUBIDIUM)
        MaterialRegistry.registerMaterial(STRONTIUM)
        MaterialRegistry.registerMaterial(YTTRIUM)
        MaterialRegistry.registerMaterial(ZIRCONIUM)
        MaterialRegistry.registerMaterial(NIOBIUM)
        MaterialRegistry.registerMaterial(MOLYBDENUM)
        MaterialRegistry.registerMaterial(TECHNETIUM)
        MaterialRegistry.registerMaterial(RUTHENIUM)
        MaterialRegistry.registerMaterial(RHODIUM)
        MaterialRegistry.registerMaterial(PALLADIUM)
        MaterialRegistry.registerMaterial(SILVER)
        MaterialRegistry.registerMaterial(CADMIUM)
        MaterialRegistry.registerMaterial(INDIUM)
        MaterialRegistry.registerMaterial(TIN)
        MaterialRegistry.registerMaterial(ANTIMONY)
        MaterialRegistry.registerMaterial(TELLURIUM)
        MaterialRegistry.registerMaterial(IODINE)
        MaterialRegistry.registerMaterial(XENON)
        // --6th Period--
        MaterialRegistry.registerMaterial(CAESIUM)
        MaterialRegistry.registerMaterial(BARIUM)
        // --Lanthanides--
        //if (RMConfig.enableLanthanides) {
        MaterialRegistry.registerMaterial(LANTHANUM)
        MaterialRegistry.registerMaterial(CERIUM)
        MaterialRegistry.registerMaterial(PRASEODYMIUM)
        MaterialRegistry.registerMaterial(NEODYMIUM)
        MaterialRegistry.registerMaterial(PROMETHIUM)
        MaterialRegistry.registerMaterial(SAMARIUM)
        MaterialRegistry.registerMaterial(EUROPIUM)
        MaterialRegistry.registerMaterial(GADOLINIUM)
        MaterialRegistry.registerMaterial(TERBIUM)
        MaterialRegistry.registerMaterial(DYSPROSIUM)
        MaterialRegistry.registerMaterial(HOLMIUM)
        MaterialRegistry.registerMaterial(ERBIUM)
        MaterialRegistry.registerMaterial(THULIUM)
        MaterialRegistry.registerMaterial(YTTERBIUM)
        MaterialRegistry.registerMaterial(LUTETIUM)
        //}
        MaterialRegistry.registerMaterial(HAFNIUM)
        MaterialRegistry.registerMaterial(TANTALUM)
        MaterialRegistry.registerMaterial(TUNGSTEN)
        MaterialRegistry.registerMaterial(RHENIUM)
        MaterialRegistry.registerMaterial(OSMIUM)
        MaterialRegistry.registerMaterial(IRIDIUM)
        MaterialRegistry.registerMaterial(PLATINUM)
        MaterialRegistry.registerMaterial(GOLD)
        MaterialRegistry.registerMaterial(MERCURY)
        MaterialRegistry.registerMaterial(THALLIUM)
        MaterialRegistry.registerMaterial(LEAD)
        MaterialRegistry.registerMaterial(BISMUTH)
        MaterialRegistry.registerMaterial(POLONIUM)
        MaterialRegistry.registerMaterial(ASTATINE)
        MaterialRegistry.registerMaterial(RADON)
        // --7th Period--
        MaterialRegistry.registerMaterial(FRANCIUM)
        MaterialRegistry.registerMaterial(RADIUM)
        // --Actinides Start--
        MaterialRegistry.registerMaterial(ACTINIUM)
        MaterialRegistry.registerMaterial(THORIUM)
        MaterialRegistry.registerMaterial(PROTACTINIUM)
        MaterialRegistry.registerMaterial(URANIUM)
        MaterialRegistry.registerMaterial(NEPTUNIUM)
        MaterialRegistry.registerMaterial(PLUTONIUM)
        //if (RMConfig.enableTransuraniumElement) {
        MaterialRegistry.registerMaterial(AMERICIUM)
        MaterialRegistry.registerMaterial(CURIUM)
        MaterialRegistry.registerMaterial(BERKELIUM)
        MaterialRegistry.registerMaterial(CALIFORNIUM)
        MaterialRegistry.registerMaterial(EINSTEINIUM)
        MaterialRegistry.registerMaterial(FERMIUM)
        MaterialRegistry.registerMaterial(MENDELEVIUM)
        MaterialRegistry.registerMaterial(NOBELIUM)
        MaterialRegistry.registerMaterial(LAWRENCIUM)
        // --Actinides End--
        MaterialRegistry.registerMaterial(RUTHERFORDIUM)
        MaterialRegistry.registerMaterial(DUBNIUM)
        MaterialRegistry.registerMaterial(SEABORGIUM)
        MaterialRegistry.registerMaterial(BOHRIUM)
        MaterialRegistry.registerMaterial(HASSIUM)
        MaterialRegistry.registerMaterial(MEITNERIUM)
        MaterialRegistry.registerMaterial(DARMSTADTIUM)
        MaterialRegistry.registerMaterial(ROENTGENIUM)
        MaterialRegistry.registerMaterial(COPERNICIUM)
        MaterialRegistry.registerMaterial(NIHONIUM)
        MaterialRegistry.registerMaterial(FLEROVIUM)
        MaterialRegistry.registerMaterial(MOSCOVIUM)
        MaterialRegistry.registerMaterial(LIVERMORIUM)
        MaterialRegistry.registerMaterial(TENNESSINE)
        MaterialRegistry.registerMaterial(OGANESSON)
        //}
        // --Isotope--
        MaterialRegistry.registerMaterial(DEUTERIUM)
        MaterialRegistry.registerMaterial(TRITIUM)
        MaterialRegistry.registerMaterial(URANIUM235)
    }
}