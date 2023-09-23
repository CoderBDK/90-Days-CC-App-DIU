package com.coding.challenge.kotlinprogramminglanguage

/**
 * Data classes in Kotlin are classes whose main purpose is to hold data.
 * Data classes come automatically with additional member functions that
 * allow you to print an instance to readable output, compare instances,
 * instances, and more. Data classes are marked with data:
 */

data class User(val name: String, val age: Int){
}
// data class User2(name: String) // primary constructor must only have val/var parameter
//properties declared in the class body
data class User2(val name: String = "", val age: Int = 0)
data class Person6(val name: String) {
    var age: Int = 0
}

fun main() {
    val person1 = Person6("John")
    val person2 = Person6("John")
    person1.age = 10
    person2.age = 20

    println("person1 == person2: ${person1 == person2}")
// person1 == person2: true

    println("person1 with age ${person1.age}: ${person1}")
// person1 with age 10: Person(name=John)

    println("person2 with age ${person2.age}: ${person2}")
// person2 with age 20: Person(name=John)

    val jane = User("Jane", 35)


    // copying object
    var user2 = jane.copy(age = 3)
    println("${user2.name}, ${user2.age}")

    //destructing declarations

    val (name, age) = jane
    println("$name, $age years of age")
    // Jane, 35 years of age

    val (userName,userAge) = jane
    println("$userName, $userAge")

}