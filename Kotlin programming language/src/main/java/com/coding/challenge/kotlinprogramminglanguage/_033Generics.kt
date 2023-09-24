package com.coding.challenge.kotlinprogramminglanguage

// Classes in Kotlin can have type parameters, just like in Java:

class Box<T> (t: T){
    var value = t
}
interface Source<out T>{
    fun nextT(): T
}
fun demo(strs: Source<String>){
    val objects: Source<String> = strs
}
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}



fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, you can assign x to a variable of type Comparable<Double>
    val y: Comparable<Double> = x // OK!

}

class Foo<out T,in V,K>(a: T, b: V,c: K){
    var nK = c
    // invariant out
    // var outT = a
    // invariant in
    //var inT:V = b

    fun <V> get(a: V) : V{
        return a
    }

}
class Foo2<out T: Foo<Int,Int,Int>, in V: Foo<Int,Int,Int>>{
    fun <Int,String> g(){

    }
}
fun <T> singletonList() : List<T>{
   return arrayListOf()
}
fun <T> T.basicToString(): String { // extension function
  return ""
}
fun <T> copyWhenGreater(list: List<T>, threshold: T):
        List<String> where T : CharSequence, T : Comparable<T>
{
    return list.filter { it > threshold }.map { it.toString() }
}

inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
    if (first !is A || second !is B) return null
    return first as A to second as B
}
inline fun <reified B> callHello(){

}

val somePair: Pair<Any?, Any?> = "items" to listOf(1, 2, 3)


val stringToSomething = somePair.asPairOf<String, Any>()
val stringToInt = somePair.asPairOf<String, Int>()
val stringToList = somePair.asPairOf<String, List<*>>()
val stringToStringList = somePair.asPairOf<String, List<String>>() // Compiles but breaks type safety!
// Expand the sample for more details

abstract class SomeClass<T> {
    abstract fun execute() : T
}

class SomeImplementation : SomeClass<String>() {
    override fun execute(): String = "Test"
}

class OtherImplementation : SomeClass<Int>() {
    override fun execute(): Int = 42
}

object Runner {
    inline fun <reified S: SomeClass<T>, T> run() : T {
        return S::class.java.getDeclaredConstructor().newInstance().execute()
    }
}

fun main() {
    var box: Box<Int> = Box<Int>(100)
    println(box.value)

    var boxB = Box(1000000) // parameter can be inferred, omit the type arguments


    var foo = Foo<Int,Int,Int>(1,2,4)
    foo.get<Int>(100000)

    val l = singletonList<Int>()
    // not enough info to infer type T variable
   // val lf = singletonList()

    //copyWhenGreater<Int>(l,8)
    println(somePair)
    println(stringToInt)
    println(stringToSomething)
    println(stringToList)
    println(stringToStringList)

    val s = Runner.run<SomeImplementation, _>()
   println(s == "Test")

    // T is inferred as Int because OtherImplementation derives from SomeClass<Int>
    val n = Runner.run<OtherImplementation, _>()
    println(n == 2)

}
