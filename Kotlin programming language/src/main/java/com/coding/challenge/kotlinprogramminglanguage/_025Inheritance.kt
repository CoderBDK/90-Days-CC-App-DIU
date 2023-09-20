package com.coding.challenge.kotlinprogramminglanguage

/**
 * By default, Kotlin classes are final – they can't be inherited.
 * To make a class inheritable, mark it with the open keyword:
 */
open class Base (p: Int){ // Class is open for inheritance

}

class Derived(p: Int): Base(p){
}

/**
 * If the derived class has a primary constructor, the base class
 * can (and must) be initialized in that primary constructor according to its parameters.
 *
 * If the derived class has no primary constructor, then each secondary constructor has to initialize
 * the base type using the super keyword or it has to delegate to another constructor which does.
 * Note that in this case different secondary constructors can call different constructors of the base type:
 */
open class Engine{
    constructor(p :Int)
}

class Car : Engine{
    constructor(p: Int):super(p){

    }
}

open class Shape{
    open val vertexCount: Int = 0
    open val indicesCount: Int = 0
    open fun draw(){}
    fun fill(){

    }
}

class Circle() : Shape(){

    override fun draw() {
        super.draw()
    }

}
open class Rectangle2 : Shape(){
    override val vertexCount: Int get() = super.vertexCount
    override val indicesCount: Int = 0

    final override fun draw() {
        super.draw()

    }
}

interface Shape2 {
    val vertexCount: Int
}

class Rectangle3(override val vertexCount: Int = 4) : Shape2 // Always has 4 vertices
{
    init {
        println(vertexCount)
    }
}

class Polygon3 : Shape2 {
    override var vertexCount: Int = 0  // Can be set to any number later
}

/**
 * @Doc https://kotlinlang.org/docs/inheritance.html#calling-the-superclass-implementation
 */
open class Base2(val name: String) {

    init { println("Initializing a base class") }

    open val size: Int =
        name.length.also { println("Initializing size in the base class: $it") }
}

class Derived2(
    name: String,
    val lastName: String,
) : Base2(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {

    init { println("Initializing a derived class") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
}


open class Rectangle4{
    open fun draw(){
        println("Drawing a rectangle")
    }
    val borderColor : String get() = "black"
}
class FilledRectangle : Rectangle4() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
    val fillPathColor: String get() = super.borderColor


    inner class Filler {
        fun fill() { println("Filling") }
        fun drawAndFill() {
            println("Draw filled 1")
            super@FilledRectangle.draw() // Calls Rectangle's implementation of draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // Uses Rectangle's implementation of borderColor's get()
        }
        fun drawAndFill2() {
            println("Draw filled 2")
            this@FilledRectangle.draw() // Calls Rectangle's implementation of draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // Uses Rectangle's implementation of borderColor's get()
        }
        /*
        inner class FillerInner{
            fun fill(){
                this@FilledRectangle.draw()
                super@FilledRectangle.draw()
            }
        }
        */
    }
}

open class Rectangle5 {
    open fun draw() { println("drawing rectangle") }
}

interface Polygon4 {
    fun draw() {
        println("drawing polygon")
    } // interface members are 'open' by default
    fun fill(){
        println("fill polygon")
    }
}

class Square() : Rectangle5(), Polygon4 {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Rectangle5>.draw() // call to Rectangle.draw()
        super<Polygon4>.draw() // call to Polygon.draw()
    }
    override fun fill(){
        super<Polygon4>.draw()
        super.fill()
    }
}
fun main(){
    Rectangle3(6)
    /*
    1: Initializing a base class
    2: Initializing size in the base class: 1
    3: Initializing a derived class
    4: Initializing size in the derived class: 2
     */
    Derived2("a","b")

    val filledRectangle = FilledRectangle()

    // It's fine to inherit from both Rectangle and Polygon, but both of them have
    // their implementations of draw(), so we need to override draw() in Square
    // and provide a separate implementation for it to eliminate the ambiguity.
    // @Doc https://kotlinlang.org/docs/inheritance.html#overriding-rules
    var filled = filledRectangle.Filler()
    filled.drawAndFill()
    filled.drawAndFill2()

    println("------------")
    // 1: drawing rectangle
    // 2: drawing polygon
    // 3: drawing polygon
    // 4: fill polygon
    var square = Square()
    square.draw()
    square.fill()

}
