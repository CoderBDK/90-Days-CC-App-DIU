package com.coding.challenge.kotlinprogramminglanguage

/**
 * There are the following kinds of literal constants for integral values:
 * Decimals: 123
 * Longs are tagged by a capital L: 123L
 * Hexadecimals: 0x0F
 * Binaries: 0b00001011
 *
 * Note : Octal literals are not supported in Kotlin
 *
 * Kotlin also supports a conventional notation for floating-point numbers:
 * Doubles by default: 123.5, 123.5e10
 * Floats are tagged by f or F: 123.5f
 */
fun main(){
    // We can use underscores to make number constants more readable:
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
    // val oct = 0b012
    println(oneMillion)
    println(creditCardNumber)
    println(socialSecurityNumber)
    println("HexBytes: $hexBytes")
    println("Bytes : $bytes")
}