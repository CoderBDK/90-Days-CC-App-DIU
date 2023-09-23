package com.coding.challenge.kotlinprogramminglanguage

sealed interface Error

sealed class IOError: Error{

}

class FileReadError : IOError()
class DatabaseError : IOError()
object RuntimeError : Error

sealed class IOError2 {
    constructor() { /*...*/ } // protected by default
    private constructor(description: String): this() { /*...*/ } // private is OK
    // public constructor(code: Int): this() {} // Error: public and internal are not allowed
}

sealed interface Error2 // has implementations only in same package and module

sealed class IOError3(): Error // extended only in same package and module
open class CustomError(): Error // can be extended wherever it's visible



fun log(e: Error) = when(e) {
    is FileReadError -> { println("Error while reading file ${e.toString()}") }
    is DatabaseError -> { println("Error while reading from database ${e.toString()}") }
    is RuntimeError ->  { println("Runtime error") }
    // the `else` clause is not required because all the cases are covered
    else -> {
        println("Custom Error")
    }
}
fun main() {
    log(FileReadError())
    log(DatabaseError())
    log(RuntimeError)
    log(CustomError())
}
