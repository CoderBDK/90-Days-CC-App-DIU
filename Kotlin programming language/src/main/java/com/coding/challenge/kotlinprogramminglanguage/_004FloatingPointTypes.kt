package com.coding.challenge.kotlinprogramminglanguage


/**
 * For real numbers, Kotlin provides floating-point types Float
 * and Double that adhere to the IEEE 754 standard. Float reflects
 * the IEEE 754 single precision, while Double reflects double precision.
 * These types differ in their size and provide storage for floating-point
 * numbers with different precision:
 *
 * Type         Size (bits)     Significant bits        Exponent bits           Decimal
 * Float            32              24                      8                    6-7
 * Double           64              53                      11                  15-16
 *
 * @Doc: link{@https://kotlinlang.org/docs/numbers.html#floating-point-types
 */
fun main() {
    // -----------------------------Floating-point types---------------------

    // Floating
    val pi = 3.14 // Double
    // val one: Double = 1 // Error: type mismatch
    val oneDouble = 1.0 // Double

    println(pi)
    println(oneDouble)

    var amount = 1000000.0

    var price = 10.0
    var quantity = 190

    var total = price * quantity

    println("Balance : ${amount - total}")

    println("Total amount: $total")

    // To explicitly specify the Float type for a value, add the
    // suffix f or F. If such a value contains more than 6-7 decimal
    // digits, it will be rounded:

    val e = 2.7182818284 // Double
    // Floating-point literal cannot be represented with the required precision
    val eFloat = 2.7182818284f // Float, actual value is 2.7182817


    println("Double type: $e")
    println("Float type: $eFloat")

}
