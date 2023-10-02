package com.coding.challenge.kotlinprogramminglanguage
interface IndexedContainer {
    operator fun get(index: Int)
}
class OrdersList: IndexedContainer {
    override fun get(index: Int) { /*...*/ }
}
data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

val point = Point(10, 20)

data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}
fun main() {
    println(point)  // prints "Point(x=-10, y=-20)"
    val a = 8
    val b = 5
    println(a + b)
    println(a.plus(b))
    println(a.unaryMinus())

    println(a.minus(b))
    println(true.not())
    println(!true)
    println(a.inc())
    println(a.dec())
    println(a.rem(2))
    println(a.rangeTo(100))
    println("Hello" in "hello")
    println("Hello".contains("Hello"))

    val array = arrayOf(
        0,1,2,3,4,5,6,7,8,9
    )

    println(array[0])
    println(array.get(0))

    println(array)

  // println(a.plusAssign(3))
    println(a.compareTo(b))
    println(a.compareTo(b) > 100)
}
