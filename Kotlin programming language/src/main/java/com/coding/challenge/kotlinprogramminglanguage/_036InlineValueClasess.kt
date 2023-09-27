package com.coding.challenge.kotlinprogramminglanguage

@JvmInline
value class Password(private val s: String)
interface Printable {
    fun prettyPrint(): String
}

@JvmInline
value class Name(val s: String) : Printable {
    override fun prettyPrint(): String = "Let's $s!"
}

interface I

@JvmInline
value class Foo3(val i: Int) : I

fun asInline(f: Foo3) {
    println("as Inline $f")
}
fun <T> asGeneric(x: T) {
    println("as Generic $x")
}
fun asInterface(i: I) {
    println("as interface $i")
}
fun asNullable(i: Foo3?) {
    println("as nullable $i")
}

fun <T> id(x: T): T = x

@JvmInline
value class UserId<T>(val value: T)

fun compute(s: UserId<String>) {
    println(s)
} // compiler generates fun compute-<hashcode>(s: Any?)
@JvmInline
value class UInt1(val x: Int)

// Represented as 'public final void compute(int x)' on the JVM
fun compute(x: Int) { }

// Also represented as 'public final void compute(int x)' on the JVM!
fun compute(x: UInt1) {

}

@JvmInline
value class UInt2(val x: Int)
@JvmName("computeUInt")
fun compute(x: UInt2) { }

typealias NameTypeAlias = String

@JvmInline
value class NameInlineClass(val s: String)

fun acceptString(s: String) {}
fun acceptNameTypeAlias(n: NameTypeAlias) {}
fun acceptNameInlineClass(p: NameInlineClass) {}

fun main(){
    println(Password("3214acd"))
    val name = Name("Kotlin")
    println(name.prettyPrint()) // Still called as a static method

    val f = Foo3(42)

    asInline(f)    // unboxed: used as Foo itself
    asGeneric(f)   // boxed: used as generic type T
    asInterface(f) // boxed: used as type I
    asNullable(f)  // boxed: used as Foo?, which is different from Foo

    // below, 'f' first is boxed (while being passed to 'id') and then unboxed (when returned from 'id')
    // In the end, 'c' contains unboxed representation (just '42'), as 'f'
    val c = id(f)
    println(c)
    compute(1)
    compute(UInt1(12))


    val nameAlias: NameTypeAlias = ""
    val nameInlineClass: NameInlineClass = NameInlineClass("")
    val string: String = ""

    acceptString(nameAlias) // OK: pass alias instead of underlying type
    // acceptString(nameInlineClass) // Not OK: can't pass inline class instead of underlying type

    // And vice versa:
    acceptNameTypeAlias(string) // OK: pass underlying type instead of alias
    // acceptNameInlineClass(string) // Not OK: can't pass underlying type instead of inline class
    val my = MyInterfaceWrapper(object : MyInterface2 {
        override fun bar() {
            println("bar")
            // body
        }
    })
    println(my.foo()) // prints "foo"
}

interface MyInterface2 {
    fun bar()
    fun foo() = "foo"
}

@JvmInline
value class MyInterfaceWrapper(val myInterface: MyInterface2) : MyInterface2 by myInterface
