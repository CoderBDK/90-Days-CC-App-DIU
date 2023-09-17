package com.coding.challenge.kotlinprogramminglanguage

/**
 * Characters are represented by the type Char. Character literals go in single quotes: '1'.
 * Special characters start from an escaping backslash \. The following escape sequences are supported:
 * \t – tab
 * \b – backspace
 * \n – new line (LF)
 * \r – carriage return (CR)
 * \' – single quotation mark
 * \" – double quotation mark
 * \\ – backslash
 * \$ – dollar sign
 * To encode any other character, use the Unicode escape sequence syntax: '\uFF00'.
 */

fun main(){
    val aChar: Char = 'a'
    println(aChar)
    //println('\n') // Prints an extra newline character
   // println('\

    println("Hello World.!\b") // output : Hello World.
    println("Hello \t World!") // output : Hello    World
    println("Hello\nWorld") // a newline
    println("Welcome, Hello\rWorld") // remove before string output : World
    println("'Hello World!'")
    println("\'Hello, World!\'") // add single quotation
    println("\"Welcome to Coding, World!\"") // add double quotation
    println("\\At the begin, added a backlash")
    println("Amount balance : \$0.0")

    var a = 'A'
    var b: Char = 'B'

    println(String.format("%c%c",a,b))

    var digit = '9'
    var digitToInt = digit.digitToInt()
    println(digitToInt)

    //Java class
    println(Character.isDigit(digit))
}