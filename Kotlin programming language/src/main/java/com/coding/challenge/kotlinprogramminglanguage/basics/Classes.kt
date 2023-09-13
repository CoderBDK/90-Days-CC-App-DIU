package com.coding.challenge.kotlinprogramminglanguage.basics
//To define a class use the class keyword

// class Shape {
// }

//open class
open class Shape

// Properties of a class can be listed in its declaration or body.
// Two properties of this Rectangle class
// Inheritance between classes is declared by a colon (:)
// Classes are final by default; to make a class inheritable, mark it as open
// Inherit the Shape class
class Rectangle(var width: Double, var height: Double) : Shape(){
    var perimeter = (width + height) * 2
}


fun main(){
    // The default constructor with parameters listed in the class
    // declaration is available automatically.
    var rectangle  = Rectangle(4.0, 5.0)
    println("The perimeter is ${rectangle.perimeter}")

    var rectangle2: Rectangle = Rectangle(7.0, 5.0)
    println("The perimeter of rectangle2 is ${rectangle2.perimeter}")

}