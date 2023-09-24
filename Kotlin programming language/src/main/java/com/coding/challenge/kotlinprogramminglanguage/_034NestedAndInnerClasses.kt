package com.coding.challenge.kotlinprogramminglanguage

// Doc https://kotlinlang.org/docs/nested-classes.html
class Outer2 {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

val demo = Outer2.Nested().foo() // == 2
interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OuterClass {
    class InnerClass
    interface InnerInterface
}

/**
 * A nested class marked as inner can access the members of its outer class.
 * Inner classes carry a reference to an object of an outer class:
 */
class Outer3 {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}

val demo2 = Outer3().Inner().foo() // == 1




class Home{
    lateinit var window : Window
    lateinit var door : Door
    constructor(){

    }
    interface IWindow{
        fun open()
        fun close()
    }
    class Window : IWindow{
        override fun open() {
            println("Window open")
        }

        override fun close() {
            println("Window close")
        }

    }
    interface IDoor{
        fun open(){
            println("Open door")
        }
        fun close(){
            println("Close door")
        }
        fun locked()
        fun unlocked()

    }
    open class Door : IDoor{
        override fun locked() {
            println("Door locked")
        }

        override fun unlocked() {
           println("Door unlocked")
        }

    }

    class Door2 : Door() {
        override fun locked() {
            super.locked()
        }

        override fun unlocked() {
            super.unlocked()
        }

        override fun open() {
            super.open()
        }

        override fun close() {
            super.close()
        }
    }
}
fun main() {
    var home = Home()
    home.door = Home.Door()
    var door = home.door
    door.close()
    door.locked()
    door.unlocked()
    door.open()

    home.window = Home.Window()
    home.window.close()
    home.window.open()

    home.door = Home.Door2()
    home.door.close()
    home.door.open()


}