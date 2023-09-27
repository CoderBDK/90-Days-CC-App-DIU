package com.coding.challenge.kotlinprogramminglanguage

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class Direction{
    NORTH, SOUTH, WEST, EAST
}
enum class ColorRGB(var rgb:Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}
inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

fun main() {
    println(Direction.EAST)
    println(Direction.WEST)
    for (dir in Direction.values()){
        println(dir)
    }
    println(ColorRGB.BLUE.ordinal) // 2

  println("Apply ${  IntArithmetics.PLUS.apply(20,1)}")

    // RED, GREEN, BLUE
    printAllValues<ColorRGB>()
}

