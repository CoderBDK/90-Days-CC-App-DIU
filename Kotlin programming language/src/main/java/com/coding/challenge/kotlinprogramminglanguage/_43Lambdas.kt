package com.coding.challenge.kotlinprogramminglanguage

fun <T, R> Collection<T>.fold(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

fun <T,R> String.go(t: T,r: ()->R): T{
    r()
    return t
}

class IntTransformer: (Int) -> Int {
    override operator fun invoke(x: Int): Int = TODO()
}
//typealias ClickHandler = (Button, ClickEvent) -> Unit
fun main() {
    val items = listOf(1, 2, 3, 4, 5)

// Lambdas are code blocks enclosed in curly braces.
    items.fold(0) {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    }

// Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:") { acc, i -> "$acc $i" }

// Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)

    var hello = "World!"
    println(hello.go(hello){
        print("Hello, ")
    })
    val a = { i: Int -> i + 1
    println(i)
    } // The inferred type is (Int) -> Int
    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
    val twoParameters: (String, Int) -> String = repeatFun // OK

    fun runTransformation(f: (String, Int) -> String): String {
        return f("hello", 3)
    }
    val result = runTransformation(repeatFun) // OK

    println("result = $result")

    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3)) // extension-like call


}