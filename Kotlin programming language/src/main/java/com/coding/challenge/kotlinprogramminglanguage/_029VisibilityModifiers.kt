package com.coding.challenge.kotlinprogramminglanguage

/**
 * Classes, objects, interfaces, constructors, and functions, as well as properties and their setters,
 * can have visibility modifiers. Getters always have the same visibility as their properties.
 *
 * There are four visibility modifiers in Kotlin: private, protected, internal, and public.
 * The default visibility is public.
 * @Doc https://kotlinlang.org/docs/visibility-modifiers.html
 */

open class Outer {
    private val a = 1
    protected open val b = 2
    internal open val c = 3
    val d = 4  // public by default

    protected class Nested {
        public val e: Int = 5
        fun nested(){

        }
    }
}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible

    override val b = 5   // 'b' is protected
    override val c = 7   // 'c' is internal
}
class Unrelated(o: Outer) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
    init {

    }
}

fun main(){

}