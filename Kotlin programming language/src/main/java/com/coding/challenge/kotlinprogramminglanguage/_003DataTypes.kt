package com.coding.challenge.kotlinprogramminglanguage
/**
 * Integers - [Byte, Short, Int, Long]
 * Unsigned integers - [UByte, UShort, UInt, ULong]
 * Floating-point numbers - [Float, Double]
 * Booleans - [Boolean]
 * Characters - [Char]
 * Strings - [String]
 * For more information on basic types and their properties :
 * @link https://kotlinlang.org/docs/basic-types.html
 */

/**
 * @Integers
 * MIN_VALUE : -(pow(2,size of(bits)) / 2)
 * MAX_VALUE : (pow(2,size of(bits)) / 2) - 1
 * Type     Size(bits)          MIN_VALUE                                   MAX_VALUE
 * BYTE         8                 -128                                         127
 * Short        16               -32768                                       32767
 * Int          32          -2,147,483,648 (-2e31)                     2,147,483,647 (231 - 1)
 * Long         64      -9,223,372,036,854,775,808 (-2e63)       9,223,372,036,854,775,807 (2e63 - 1)
 */
fun main(){

    var a = 100
    var b = 25
    var c = a + b
    println("Results : $c")

    val minValueByte :Byte = -128
    val maxValueByte :Byte = 127

    var dByte:Byte = 100
    //Compilation Error: The integer literal does not conform to the expected type Byte
    // dByte = 128
    //Compilation Error : Type mismatch: inferred type is Int but Byte was expected
    //dByte = -129

    //now we can store other data types
    var dShort :Short = 128
    dShort = -129
    //it is work fine because Short data types range [min = -32768, max = 32767]

    dShort = -32768 //ok
    //error
    //dShort = -32789
    //dShort = 32768
    //Again we can store this data which has a higher capacity data range than it

    var dInt:Int = 32768

    var dLong:Long = 100L

    println("Byte : $dByte")
    println("Short : $dShort")
    println("Int : $dInt")
    println("Long : $dLong")


}