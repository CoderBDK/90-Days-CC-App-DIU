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
    override operator fun invoke(x: Int): Int = 4
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

    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3)) // extension-like call

    var lamVar : (Int,Int)-> Int ={a,b-> a + b}

    println(lamVar(10,20))

    val intFunction: (Int) -> Int = IntTransformer()
    intFunction.invoke(44)
    val av = { i: Int -> i + 1 } // The inferred type is (Int) -> Int

    println(av)

    val repeatFun: String.(Int,Int) -> String = { times,t -> this.repeat(times) }
    val twoParameters: (String, Int,Int) -> String = repeatFun // OK

    fun runTransformation(f: (String, Int,Int) -> String): String {
        return f("hello", 3,6)
    }
    val result = runTransformation(repeatFun) // OK
    println(result)

    var gtoString: (Int)-> String = {value:Int->value.toString()}
    var toString : (Int)-> String = gtoString

    println(toString(4))
    //max(strings, { a, b -> a.length < b.length })
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val sum2 = { x: Int, y: Int -> x + y }
    val sum3: (Int, Int) -> Unit = { x, y -> x + y}
        val map = HashMap<String,String>()
        map.forEach { (_, value) -> println("$value!") }
    val sum4: Int.(Int) -> Int = { other -> plus(other) }

    html {       // lambda with receiver begins here
        body()   // calling a method on the receiver object
    }
    html5(){

        HTML()

    }

}
fun compare(a: String, b: String): Boolean = a.length < b.length
class HTML {
    fun title(){}
    fun head(){}
    fun body() {
        println("this is body function")
    }

}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()  // create the receiver object
    html.init()        // pass the receiver object to the lambda
    return html
}

fun html5(init: ()-> HTML): HTML{
    var html5 = HTML()
    return html5
}
