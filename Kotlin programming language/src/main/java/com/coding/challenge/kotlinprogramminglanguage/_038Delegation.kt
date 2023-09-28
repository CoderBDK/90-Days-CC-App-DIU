package com.coding.challenge.kotlinprogramminglanguage

interface BaseDelegation{
    var message: String
    fun print()
}
class BaseDelegationImpl(val x: Int) : BaseDelegation{
    override var message: String = "Base Impl"
    override fun print() {
       println(x)
    }
}

class DerivedDelegation(b: BaseDelegation): BaseDelegation by b{
    override var message: String = "Derived"
    override fun print() {
        println("Derived -> $message")
    }
}

fun main() {
    val b = BaseDelegationImpl(199)
    val derived = DerivedDelegation(b)
    derived.print()
    println(derived.message)
}