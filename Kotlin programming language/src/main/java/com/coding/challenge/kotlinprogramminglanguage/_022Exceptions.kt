package com.coding.challenge.kotlinprogramminglanguage

/**
 * Exception classes
 * All exception classes in Kotlin inherit the Throwable class.
 * Every exception has a message, a stack trace, and an optional cause.
 *
 * To throw an exception object, use the throw expression:
 */
fun main(){
    // throw Exception("Hi There!")
    //throw Exception("Hello, World!") // output: Exception in thread "main" java.lang.Exception: Hello, World!

   // To catch an exception, use the try...catch expression:

    try {
        // some code
    } catch (e: Exception) {
        // handler
    } finally {
        // optional finally block
    }

    var input = "1d"
    val a: Int? = try { input.toInt() } catch (e: NumberFormatException) { null }

    println(a) // output is null
    input = "199"
    val b: Int? = try { input.toInt() } catch (e: NumberFormatException) { null }

    println(b) // output is 199

    var person:String? = null
    val s = person ?: throw IllegalArgumentException("Name required")
    println(s)
    var n = person?: fail("Name required")
}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}