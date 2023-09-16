package com.coding.challenge.kotlinprogramminglanguage


/**
 * Here is the complete list of bitwise operations:
 * shl(bits) – signed shift left
 * shr(bits) – signed shift right
 * ushr(bits) – unsigned shift right
 * and(bits) – bitwise AND
 * or(bits) – bitwise OR
 * xor(bits) – bitwise XOR
 * inv() – bitwise inversion
 */
fun main(){
    //Bitwise operations
    //Kotlin provides a set of bitwise operations on integer numbers. They operate on the binary level directly with bits of the numbers' representation. Bitwise operations are represented by functions that can be called in infix form. They can be applied only to Int and Long:

    val boa = (1 shl 2) and 0x000FF000
    println(boa)

    // 0100 >> 1 = 010 shr
    // 0100 << 1 = 0100 shl

    // right side add a 0 bit
    var bshl = 0b1010 shl 1
    println("$bshl << signed shift left ${Integer.toBinaryString(bshl)}")

    // right side to remove a bit signed or unsigned value
    var bshr = 0b010 shr 1

    println("$bshr >> signed shift right ${Integer.toBinaryString(bshr)}")
    // right side to remove a bit only unsigned value
    var bushr = 0b10 ushr 1
    println("$bshr >>> unsigned shift right ${Integer.toBinaryString(bushr)}")

    val band = 0b10 and 0b11 // Output : 10
    println("$band and => ${Integer.toBinaryString(band)}")

    val bor = 0b10 or 0b11 // Output : 11
    println("$bor or => ${Integer.toBinaryString(bor)}")

    val bxor = 0b110 xor 0b011 // Output : 101
    println("$bxor xor => ${Integer.toBinaryString(bxor)}")

    var binv = (13).inv() // Output : -14
    println("$binv inv => ${Integer.toBinaryString(binv)}")

    binv = (-13).inv() // Output : 12
    println("$binv inv => ${Integer.toBinaryString(binv)}")

}