package hiiragi283.material.util

@FunctionalInterface
interface TriPredicate<T : Any?, U : Any?, V : Any?> {

    fun test(t: T, u: U, v: V): Boolean

}