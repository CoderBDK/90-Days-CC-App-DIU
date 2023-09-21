package com.coding.challenge.kotlinprogramminglanguage

interface MyInterface {
    fun bar()

    val prop: Int // abstract

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child : MyInterface{
    override val prop: Int = 29
    override val propertyWithImplementation: String
        get() = super.propertyWithImplementation
    override fun bar() {

    }

    override fun foo() {
        super.foo()
    }

}

interface Named {
    val name: String
}

interface Person5 : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}
class Position

data class Employee(
    // implementing 'name' is not required
    override val firstName: String,
    override val lastName: String,
    val position: Position
) : Person5

interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}
interface Parent{
    fun callParent()
    fun callParentByChild() : Parent
}
interface Child2 : Parent{
    override fun callParent() {
       println("${this.javaClass.simpleName } is calling the parent")
    }
    override fun callParentByChild(): Parent {
        println((this as Parent).javaClass.simpleName)
        return this
    }

}

class Child3 : Child2{

}
fun main(){
    Child().foo()
    Employee("a","b",Position()).lastName
    println()
    var child = Child3()
    child.callParent()
    child.callParentByChild()


}
