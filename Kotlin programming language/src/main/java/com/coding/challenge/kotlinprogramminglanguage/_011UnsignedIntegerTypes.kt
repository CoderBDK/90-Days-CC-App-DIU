package com.coding.challenge.kotlinprogramminglanguage


/**
 * ---------------------------------Unsigned Integer Types----------------------------------------
 * In addition to integer types, Kotlin provides the following types for unsigned integer numbers:
 * UByte: an unsigned 8-bit integer, ranges from 0 to 255
 * UShort: an unsigned 16-bit integer, ranges from 0 to 65535
 * UInt: an unsigned 32-bit integer, ranges from 0 to 2^32 - 1
 * ULong: an unsigned 64-bit integer, ranges from 0 to 2^64 - 1
 */
fun main(){
    var uByte:UByte = 255u // UByte, expected type provided
    // Compilation error : Unresolved reference. None of the following
    // candidates is applicable because of receiver type mismatch
    // uByte = -0
    // uByte = -0u

    println("UByte expected type provided: $uByte")

    var uShort = 65535u
    println("UShort expected type provided: $uShort")

    var uInt:UInt = 4759384u


    //it's value have UInt 0 to range(UInt)
    var uApple = 100u // UInt: no expected type provided, constant fits in UInt
    var uV = 0xEEEEE_FFF_FFFFEEEU // ULong: no expected type provided, constant doesn't fit in UInt
    var uM = 10000000090000900009u
    var uFI = 1UL // ULong, even though no expected type provided and constant fits into UInt

    uFI += uM

    println("Unit : no expected type provided: $uApple")
    println("ULong: no expected type provided: $uV")
    println("ULong: no expected type provided: $uM")
    println("ULong, even though no expected type provided and constant fits into UInt: $uFI")

    // its worked
    var uA:UInt = 100u + 34u
    // Compilation error : None of the following functions can be called with the arguments supplied:
    //uA = 100 + 34u

    var uB:UInt = 1000u

    var uC = uA + uB

    println("Results: uA = $uA , uB = $uB , uC = $uC")

    //int to convert UInt
    var dF = (-100).toUInt()
    println("Int value => (-100) toUnit -> ($dF)")
    var uG = 10u
    uA = 10u
    uB = 5u
    (uA + uB + uG).also {
        uC = it
    }
    println("Final result UC = $uC")



}