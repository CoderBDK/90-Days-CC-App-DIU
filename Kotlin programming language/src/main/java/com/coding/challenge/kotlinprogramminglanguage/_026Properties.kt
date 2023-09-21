package com.coding.challenge.kotlinprogramminglanguage

//declaring properties
class Address{
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"
}
fun copyAddress(address: Address): Address {
    val result = Address() // there's no 'new' keyword in Kotlin
    result.name = address.name // accessors are called
    result.street = address.street
    // ...
    return result
}

class Rectangle6(val width: Int, val height: Int) {
     val area: Int // property type is optional since it can be inferred from the getter's return type
        get() = this.width * this.height

    var stringRepresentation: String
        get() = this.toString()
        set(value) {
          "dfdf"
        }

}



class Properties{

    var a = ""
        set(value){"dfdf"}
    val PI = 3.14

    var counter = 10 // the initializer assigns the backing field directly
        set(value) {
            if (value >= 0)
                field = value + 1000
            // counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
        }

    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap() // Type parameters are inferred
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }

    lateinit var lateInitVar: Properties
        public get
}

const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
@Deprecated(SUBSYSTEM_DEPRECATED) fun foo() {

}

fun main(){
    Address().name = "a0"
    // it cannot be set but only get
    //Rectangle6(10,10).area  = 1000
    var rectangle = Rectangle6(45,45)
    rectangle.stringRepresentation = "dfkjdlf"
   println(rectangle.stringRepresentation)

    var properties = Properties()
    properties.a = "adfdf"
    println(properties.a)
    println(properties.counter)
    // deprecated
    foo()

   // if(properties::lateInitVar.isInitialized){ }
}