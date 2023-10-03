package com.coding.challenge.kotlinprogramminglanguage

import java.util.Date

class AB { // implicit label @A
    inner class B { // implicit label @B
        fun Int.foo() { // implicit label @foo
            val a = this@AB // A's this
            val b = this@B // B's this

            val c = this // foo()'s receiver, an Int
            val c1 = this@foo // foo()'s receiver, an Int

            val funLit = lambda@ fun String.() {
                val d = this // funLit's receiver, a String
            }

            val funLit2 = { s: String ->
                // foo()'s receiver, since enclosing lambda expression
                // doesn't have any receiver
                val d1 = this
            }
        }
    }
}

fun main(){
   var d = fun String.(){
       println("Hello")
   }
   println(d("dd"))


    ABC().invokePrintLine() // Member function
    ABC().invokePrintLine(omitThis = true) // Top-level function

    callFRC {
        receiveMe()
    }
    callFRC2 {
        println("Hello")
        println("World")
        FRC()// return to receiver
    }
    callFRC3 {

    }

}
fun goBack():Int{
   return -1
}
fun printLine() { println("Top-level function") }

class ABC {
    fun printLine() { println("Member function") }

    fun invokePrintLine(omitThis: Boolean = false)  {
        if (omitThis) printLine()
        else this.printLine()
    }
}

class FRC{
    fun receiveMe(){
        println("Receive me")
    }
}

// receiver
fun callFRC(init: FRC.()->Unit) {
    var frc = FRC() // create the receiver object
    return frc.init() // pass the receiver object to the lambda
}

fun callFRC2(init: ()-> FRC){
    init().receiveMe()
}
fun callFRC3(init: ()-> Unit){
    init()
}

