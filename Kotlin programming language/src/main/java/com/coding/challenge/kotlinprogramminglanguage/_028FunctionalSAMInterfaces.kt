package com.coding.challenge.kotlinprogramminglanguage

/**
 * An interface with only one abstract method is called a functional interface,
 * or a Single Abstract Method (SAM) interface.
 * The functional interface can have several non-abstract members but only one abstract member.
 */
fun interface KRunnable{
    fun invoke()
}


interface Printer{
    fun print()
    fun copy()
}
fun Printer(block:() ->Unit,blockCopy: () -> Unit): Printer = object : Printer{
    override fun print() = block()
    override fun copy() = blockCopy()
}
@Deprecated(message = "Don't use this", level = DeprecationLevel.WARNING)
fun Printer(blocker:() ->Unit):Printer = object : Printer{
    override fun print() {
       blocker()
    }

    override fun copy() {

    }

}
typealias TypeAlias = (i: Int,j: Int)->Boolean
val isTypeAlias:TypeAlias ={ i: Int, j: Int ->
    i !=j
}

fun main() {
   var kRunnable = KRunnable {
        println("Invoke method called")
    }
    kRunnable.invoke()

    // If we don't use a SAM conversion, we will need to write code like this:

    var oKRunnable = object : KRunnable{
        override fun invoke() {

        }

    }

    var printer = Printer({
        println("Print")
    },{
        println("Copy")
    })
    printer.print()
    printer.copy()

    var printer2 = Printer {
        println("Blocker")
    }
    printer2.print()

    println(isTypeAlias(1,21))


}
