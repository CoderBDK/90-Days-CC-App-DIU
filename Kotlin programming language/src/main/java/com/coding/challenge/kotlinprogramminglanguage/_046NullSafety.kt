package com.coding.challenge.kotlinprogramminglanguage

fun main(){
    var a: String = "abc" // Regular initialization means non-nullable by default
    // a = null // compilation error

    var b: String? = "abc" // can be set to null
    b = null // ok
    var l = a.length
    if (b != null) {
        l = b.length
    }
    l = if (b != null) b.length else -1

    val b2: String? = "Kotlin"
    if (b2 != null && b2.length > 0) {
        print("String of length ${b2.length}")
    } else {
        print("Empty string")
    }

    val a3 = "Kotlin"
    val b3: String? = null
    println(b3?.length)
    println(a3?.length) // Unnecessary safe call

    val listWithNulls: List<String?> = listOf("Kotlin", null)
    for (item in listWithNulls) {
        item?.let { println(it) } // prints Kotlin and ignores null
    }

    // elvis operator
    val l2: Int = if (b != null) b.length else -1
    val l3 = b?.length ?: -1

    // not-null assertion operator (!!)
    val b5:String? = null
    // val l4 = b5!!.length // throw an NPE
    // println(l4)

    val aInt: Int? = a as? Int
    println("safe cast: $aInt")
    // val bInt: Int? = a as Int
    // println("ignore safe cast: $bInt") // throw an CCE

}