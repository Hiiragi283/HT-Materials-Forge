package hiiragi283.material.util

import com.mojang.blaze3d.platform.GlStateManager
import java.awt.Color

object HiiragiColor {

    //Minecraftのカラーコードと同じ色
    @JvmStatic
    val BLACK by lazy { Color(0x00, 0x00, 0x00) }

    @JvmStatic
    val DARK_BLUE by lazy { Color(0x00, 0x00, 0xAA) }

    @JvmStatic
    val DARK_GREEN by lazy { Color(0x00, 0xAA, 0x00) }

    @JvmStatic
    val DARK_AQUA by lazy { Color(0x00, 0xAA, 0xAA) }

    @JvmStatic
    val DARK_RED by lazy { Color(0xAA, 0x00, 0x00) }

    @JvmStatic
    val DARK_PURPLE by lazy { Color(0xAA, 0x00, 0xAA) }

    @JvmStatic
    val GOLD by lazy { Color(0xFF, 0xAA, 0x00) }

    @JvmStatic
    val GRAY by lazy { Color(0xAA, 0xAA, 0xAA) }

    @JvmStatic
    val DARK_GRAY by lazy { Color(0x55, 0x55, 0x55) }

    @JvmStatic
    val BLUE by lazy { Color(0x55, 0x55, 0xFF) }

    @JvmStatic
    val GREEN by lazy { Color(0x55, 0xFF, 0x55) }

    @JvmStatic
    val AQUA by lazy { Color(0x55, 0xFF, 0xFF) }

    @JvmStatic
    val RED by lazy { Color(0xFF, 0x55, 0x55) }

    @JvmStatic
    val LIGHT_PURPLE by lazy { Color(0xFF, 0x55, 0xFF) }

    @JvmStatic
    val YELLOW by lazy { Color(0xFF, 0xFF, 0x55) }

    @JvmStatic
    val WHITE by lazy { Color(0xFF, 0xFF, 0xFF) }

    //複数の色を混合するメソッド
    fun mixColor(colors: Collection<Color>): Color {
        var redAve = 0
        var greenAve = 0
        var blueAve = 0
        colors.forEach {
            redAve += it.red
            greenAve += it.green
            blueAve += it.blue
        }
        return Color(redAve / colors.size, greenAve / colors.size, blueAve / colors.size)
    }

    //可変長配列用
    fun mixColor(vararg colors: Color): Color = mixColor(colors.toList())

    //複数の色を比率を指定して混合するメソッド
    fun mixColor(colors: Map<Color, Int>): Color {
        var redSum = 0
        var greenSum = 0
        var blueSum = 0
        var weightSum = 0
        colors.forEach {
            val color = it.key
            val weight = it.value
            //RGB値にweightをかけた値を加算していく
            redSum += color.red * weight
            greenSum += color.green * weight
            blueSum += color.blue * weight
            weightSum += weight
        }
        return if (weightSum != 0) Color(
            redSum / weightSum,
            greenSum / weightSum,
            blueSum / weightSum
        ) else WHITE
    }

    //List用
    fun mixColor(colors: List<Pair<Color, Int>>): Color = mixColor(colors.toMap())

    //可変長配列用
    fun mixColor(vararg colors: Pair<Color, Int>): Color = mixColor(colors.toMap())

    //混合色から元の色を取得するメソッド
    fun getColorDif(colorMixed: Color, colorBase1: Color): Color {
        //colorMixedとcolorBase1の各RGB値の差分を計算
        val red2 = colorMixed.red * 2 - colorBase1.red
        val green2 = colorMixed.green * 2 - colorBase1.green
        val blue2 = colorMixed.blue * 2 - colorBase1.blue
        //混成前の色を返す
        return Color(red2, green2, blue2)
    }

    fun setGLColor(color: Int) {
        val red = (color shr 16 and 255) / 255.0f
        val green = (color shr 8 and 255) / 255.0f
        val blue = (color and 255) / 255.0f
        GlStateManager._blendColor(red, green, blue, 1.0f)
    }

    fun setGLColor(color: Color) {
        setGLColor(color.rgb)
    }

}