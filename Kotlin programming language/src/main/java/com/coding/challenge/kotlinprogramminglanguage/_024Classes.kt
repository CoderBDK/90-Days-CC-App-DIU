package com.coding.challenge.kotlinprogramminglanguage

// Classes in Kotlin are declared using the keyword class:
/**
 * A class in Kotlin has a primary constructor and possibly one or more secondary constructors.
 * The primary constructor is declared in the class header,
 * and it goes after the class name and optional type parameters.
 */
class Person constructor(firstName: String){

}
// If the primary constructor does not have any annotations or visibility modifiers,
// the constructor keyword can be omitted:
class Person2(firstName: String){

}

class Empty

class InitOrderDemo(name: String){
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }
    val secondProperty = "Second property: ${name.length}".also(::println)
    init {
        println("Second initializer block that prints ${name.length}")
    }
}

/**
 * Primary constructor parameters can be used in the initializer blocks.
 * They can also be used in property initializers declared in the class body:
 */
class Customer(name: String){
    var customerName = name.uppercase()
}
class Person3(
    val firstName: String = "Enter your name",
    val lastName: String,
    val age: Int = 0,
    ){


}
class Customer2 public constructor(name: String){

}

// A class can also declare secondary constructors, which are prefixed with constructor:
class Pet{

    constructor(person: Person){

    }
}
class Person4(name: String){
    constructor(name: String,lastName: String):this(name){

    }
}
// the code in all initializer blocks and property initializers is executed
// before the body of the secondary constructor.
class Constructors {
    init {
        println("Init block 1")
    }

    constructor(i: Int) {
        println("Constructor $i")
    }
    init {
        println("Init block 2")
    }
}

abstract class Polygon{
    abstract fun draw()
}
class Rectangle : Polygon(){
    override fun draw() {

    }

}

open class Polygon2{
    open fun draw(){

    }
}
abstract class WildShape : Polygon2(){
    abstract override fun draw()
}
fun main(){
    Person("MD. ABDULLAH")
    InitOrderDemo("Name")
    Customer("Name")
    Person3("first_name","last_name",0)
    Person4("first_name","last_name",)
    Constructors(1)

    // cannot create an instance of an abstract class
    // Polygon().draw()
    var polygon: Polygon = Rectangle()
    // var wildShape = WildShape() // need to implement
}