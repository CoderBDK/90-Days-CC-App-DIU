package com.coding.challenge.kotlinprogramminglanguage


// -------------------------------Explicit number conversions-----------------------------
// Due to different representations, smaller types are not subtypes of bigger ones.
// If they were, we would have troubles of the following sort:

/**
 * # All number types support conversions to other types:
 * toByte(): Byte
 * toShort(): Short
 * toInt(): Int
 * toLong(): Long
 * toFloat(): Float
 * toDouble(): Double
 */
fun main() {

    // Hypothetical code, does not actually compile:
    // val a: Int? = 1 // A boxed Int (java.lang.Integer)
    // val b: Long? = a // Implicit conversion yields a boxed Long (java.lang.Long)
    // print(b == a) // Surprise! This prints "false" as Long's equals() checks whether the other is Long as well


    // So equality would have been lost silently, not to mention identity.

    // As a consequence, smaller types are NOT implicitly converted to bigger types.
    // This means that assigning a value of type Byte to an Int variable requires an explicit conversion:

    val b: Byte = 1 // OK, literals are checked statically
    // val i: Int = b // ERROR
    val i1: Int = b.toInt()

    var c : Byte = i1.toByte()
    println(c)

    // In many cases, there is no need for explicit conversions because the
    // type is inferred from the context, and arithmetical operations are
    // overloaded for appropriate conversions, for example:

    val l = 1L + 3 // Long + Int => Long
    val d = 100.0 + 100f // Double + Float => Double
    val bt = 100
    val i = bt + 1000 // Byte + Int => Int

    println(l)
    println(d)
    println(i)

    println((10000).toFloat())


}
