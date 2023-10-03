package com.coding.challenge.kotlinprogramminglanguage

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

   }
    println(d)


    ABC().invokePrintLine() // Member function
    ABC().invokePrintLine(omitThis = true) // Top-level function

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
