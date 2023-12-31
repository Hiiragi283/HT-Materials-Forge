@file:JvmName("MaterialBuilders")

package hiiragi283.api.material

import hiiragi283.material.util.HiiragiColor
import java.awt.Color
import kotlin.math.roundToInt

//    Material    //

fun materialOf(name: String, init: HiiragiMaterial.() -> Unit = {}): HiiragiMaterial {
    val material = HiiragiMaterial(name)
    material.init()
    return material
}

//    Isotope    //

fun isotopeOf(
    name: String,
    parent: HiiragiMaterial,
    init: HiiragiMaterial.() -> Unit
): HiiragiMaterial {
    val isotope = HiiragiMaterial(name).also {
        it.color = parent.color
        it.crystalType = parent.crystalType
        it.tempBoil = parent.tempBoil
        it.tempMelt = parent.tempMelt
        it.tempSubl = parent.tempSubl
        //it.validShapes.addAll(parent.validShapes)
    }
    isotope.init()
    return isotope
}

//    Compound    //

fun compoundOf(
    name: String,
    components: Map<HiiragiMaterial, Int>,
    init: HiiragiMaterial.() -> Unit = {}
): HiiragiMaterial {
    val compound = HiiragiMaterial(name)
    initCompound(compound, components)
    compound.init()
    return compound
}

private fun initCompound(material: HiiragiMaterial, components: Map<HiiragiMaterial, Int>) {
    initColor(material, components)
    initFormula(material, components)
    initMolar(material, components)
}

//色を自動で生成
private fun initColor(material: HiiragiMaterial, components: Map<HiiragiMaterial, Int>) {
    material.color = HiiragiColor.mixColor(components.map { Color(it.key.color) to it.value }).rgb
}

private fun initCrystalType(material: HiiragiMaterial) {
    //固相を持たない場合は強制的にNONE
    if (!material.isSolid()) material.crystalType = CrystalType.NONE
}

//化学式を自動で生成
private fun initFormula(material: HiiragiMaterial, components: Map<HiiragiMaterial, Int>) {
    val builder = StringBuilder()
    for ((material1, weight) in components) {
        //化学式を持たない場合はパス
        if (!material1.hasFormula()) continue
        builder.append(material1.formula)
        //値が1の場合はパス
        if (weight == 1) continue
        //化学式の下付き数字の桁数調整
        val subscript1 = '\u2080' + (weight % 10)
        val subscript10 = '\u2080' + (weight / 10)
        //2桁目が0でない場合，下付き数字を2桁にする
        builder.append(
            StringBuilder().also {
                if (subscript10 != '\u2080') it.append(subscript10)
                it.append(subscript1)
            }
        )
    }
    material.formula = builder.toString()
}

//分子量を自動で生成
private fun initMolar(material: HiiragiMaterial, components: Map<HiiragiMaterial, Int>) {
    var molar = 0.0
    components
        .filter { it.key.hasMolar() }
        .forEach { molar += it.key.molar * it.value }
    molar = (molar * 10.0).roundToInt() / 10.0 //小数点1桁まで
    material.molar = molar
}

//    Alloy    //

fun alloyOf(
    name: String,
    components: Map<HiiragiMaterial, Int>,
    init: HiiragiMaterial.() -> Unit = {}
): HiiragiMaterial {
    val alloy = HiiragiMaterial(name)
    initCompound(alloy, components)
    initAlloy(alloy, components)
    alloy.init()
    return alloy
}

private fun initAlloy(material: HiiragiMaterial, components: Map<HiiragiMaterial, Int>) {
    initTempBoil(material, components)
    initTempMelt(material, components)
    initTempSubl(material, components)
}

//沸点を自動で生成
private fun initTempBoil(material: HiiragiMaterial, components: Map<HiiragiMaterial, Int>) {
    var boil = 0
    components
        .filter { it.key.hasTempBoil() }
        .forEach { boil += it.key.tempBoil * it.value }
    material.tempBoil = boil
}

//融点を自動で生成
private fun initTempMelt(material: HiiragiMaterial, components: Map<HiiragiMaterial, Int>) {
    var melt = 0
    components
        .filter { it.key.hasTempMelt() }
        .forEach { melt += it.key.tempMelt * it.value }
    material.tempMelt = melt
}

//昇華点を自動で生成
private fun initTempSubl(material: HiiragiMaterial, components: Map<HiiragiMaterial, Int>) {
    var subl = 0
    components
        .filter { it.key.hasTempSubl() }
        .forEach { subl += it.key.tempSubl * it.value }
    material.tempSubl = subl
}

//    Mixture    //

fun mixtureOf(
    name: String,
    components: List<HiiragiMaterial>,
    init: HiiragiMaterial.() -> Unit = {}
): HiiragiMaterial {
    val mixture = HiiragiMaterial(name)
    initMixture(mixture, components)
    mixture.init()
    return mixture
}

private fun initMixture(material: HiiragiMaterial, components: List<HiiragiMaterial>) {
    initFormula(material, components)
    material.molar = -1.0 //Invalidate molar
}

private fun initFormula(material: HiiragiMaterial, components: List<HiiragiMaterial>) {
    val builder = StringBuilder()
    components
        .map { "${it.formula}, " }
        .forEach { builder.append(it) }
    builder.setLength(builder.length - 2) //末尾の", "を取り除く
    material.formula = builder.toString()
}

//    Formula String    //

fun formulaOf(formula: String): HiiragiMaterial = HiiragiMaterial.EMPTY.copy(formula = formula)

//    Hydrate    //

fun hydrateOf(
    name: String,
    parent: HiiragiMaterial,
    amountWater: Int,
    init: HiiragiMaterial.() -> Unit = {}
): HiiragiMaterial {
    val hydrate = HiiragiMaterial(name)
    initHydrate(hydrate, parent, amountWater)
    hydrate.init()
    return hydrate
}

fun initHydrate(material: HiiragiMaterial, parent: HiiragiMaterial, amountWater: Int) {
    initFormula(material, parent, amountWater)
    material.molar = parent.molar + amountWater * HiiragiMaterial.EMPTY.molar
}

fun initFormula(material: HiiragiMaterial, parent: HiiragiMaterial, amountWater: Int) {
    val builder = StringBuilder(parent.formula)
    builder.append("・")
    builder.append(amountWater)
    builder.append(HiiragiMaterial.EMPTY.formula)
    material.formula = builder.toString()
}

//    Polymer    //

fun polymerOf(
    name: String,
    monomar: Map<HiiragiMaterial, Int>,
    init: HiiragiMaterial.() -> Unit = {}
): HiiragiMaterial {
    val polymer = HiiragiMaterial(name)
    initCompound(polymer, monomar)
    polymer.formula = "(${polymer.formula})n"
    polymer.molar = -1.0 //Invalidate molar
    polymer.init()
    return polymer
}