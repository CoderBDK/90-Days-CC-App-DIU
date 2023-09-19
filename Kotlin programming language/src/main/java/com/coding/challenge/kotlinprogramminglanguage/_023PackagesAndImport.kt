package com.coding.challenge.kotlinprogramminglanguage

// import either a single name:
// all the accessible contents of a scope: package, class, object, and so on:
// If there is a name clash, you can disambiguate by using as keyword to locally rename the clashing entity:
import java.lang.Math as MyMath
fun main(){
   var r = MyMath.pow(2.0,2.0)
    println(r)
}