package com.coding.challenge.kotlinprogramminglanguage

import kotlin.reflect.KClass
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

class MyClass2{
    val hello = "Hello, World"

}
fun isOdd(x: Int) = x % 2 != 0
fun isOdd(x: Int, y: Int) = x % 2 != 0
fun obv(a: Int,m: (Int,Int) -> Boolean): Boolean {
    return m(a,a)
}
fun main() {
    val c = MyClass2::class

    println(c.qualifiedName)
    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))

    println("obv: ${ obv (7,::isOdd)}")

    val predicate: (Int,Int) -> Boolean = ::isOdd

    println(predicate) //fun isOdd(kotlin.Int, kotlin.Int): kotlin.Boolean
    println(predicate(45,55)) // true

    fun length(s: String) = s.length

    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")

    println(strings.filter(oddLength))


    println(::x.get())
    println(::x.name)
    println(::x.isFinal)
    ::y.set(2)
    println(y)


    class A(val p: Int)
    val prop = A::p
    println(prop.get(A(1)))

    println(String::lastChar.get("abc"))

    println(A::p.javaGetter) // prints "public final int A.getP()"
    println(A::p.javaField)  // prints "private final int A.p"

    fun getKClass(o: Any): KClass<Any> = o.javaClass.kotlin

    println(getKClass(MyClass2()))


    class Foo{
        var name = "aaa"
    }

    fun function(factory: () -> Foo) {
        val x: Foo = factory()
        println(x.name)
    }

    function(::Foo)

    val numberRegex = "\\d+".toRegex()
    println(numberRegex.matches("2g9"))

    val isNumber = numberRegex::matches
    println(isNumber("29"))

    val strings2 = listOf("abc", "124", "a70")
    println(strings2.filter(numberRegex::matches))

    val prop2 = "abc"::length
    println(prop2.get())

    class Outer {
        inner class Inner{
            var a = 0
        }
    }

    val o = Outer()
    val boundInnerCtor = o::Inner

    println(boundInnerCtor)

}
val String.lastChar: Char
    get() = this[length - 1]

val x = 1
var y = 1
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}