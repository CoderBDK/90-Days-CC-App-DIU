package com.coding.challenge.kotlinprogramminglanguage


/**
 * In Kotlin, we can perform type checks to check the type of an object at runtime.
 * Type casts convert objects to a different type.
 *
 * @link { https://kotlinlang.org/docs/typecasts.html
 *
 */
fun main(){
    typesCheck()
   typesCast()
}
fun typesCheck() {
    // [is,!is] operators
    // Use the is operator or its negated form !is to perform a runtime
    // check that identifies whether an object conforms to a given type:

    var obj = "Casting"
    if (obj is String) {
        println(obj.length)
    }

    if (obj !is String) { // Same as !(obj is String)
        println("Not a String")
    } else {
        println(obj.length)
    }
    checkDemo(5555)

    // The compiler is smart enough to know that a cast is safe if a negative check leads to a return:
    var x = "Hello"
    if (x !is String) return

    println(x.length) // x is automatically cast to String

    var z: Any = 8

    typeCheck(z)
    z = "Hello"
    typeCheck(z)
    z = intArrayOf(0,1,2,3,4,5,6,7,8,9)
    typeCheck(z)
}
fun checkDemo(obj:Any){
    if (obj is String) {
        print(obj.length)
    }

    if (obj !is String) { // Same as !(obj is String)
        print("Not a String")
    } else {
        print(obj.length)
    }
}
fun typeCheck(z: Any) {
    when(z){
        is Int ->{
            println("Int")
        }
        is String ->{
            println("String")
        }
        else ->{
            println("Unknown Type")
        }
    }
}
fun typesCast() {
    // "Unsafe" cast operator
    // Usually, the cast operator throws an exception if the cast isn't possible.
    // Thus, it's called unsafe. The unsafe cast in Kotlin is done by the infix operator as.

    var y = "Hello"
    val x: String = y as String
    println(x) // it works

    // throws : java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
    // var y2 = 9
    // val x2 = y2 as String
    //println(x2)

    /*
       Note that null cannot be cast to String, as this type is not nullable.
       If y is null, the code above throws an exception. To make code like this
       correct for null values, use the nullable type on the right-hand side of the cast:
     */

    // java.lang.NullPointerException: null cannot be cast to non-null type kotlin.String
    // var ny: String? = null
    // val x3: String? = ny as String
    // println(x3)

    // its null pointer safe casting
     var ny: String? = null
     val x3: String? = ny as String?
     println(x3)

    println(x3)

    // "Safe" (nullable) cast operator
    // To avoid exceptions, use the safe cast operator as?, which returns null on failure.

    val xv: String? = ny as? String

    println(xv)



}


