package com.coding.challenge.kotlinprogramminglanguage


interface EngineInterface{
    fun on()
    fun off()
}
fun  EngineInterface(engineOn: () -> Unit, engineOff: () -> Unit): EngineInterface = object : EngineInterface{
    override fun on() = engineOn()
    override fun off() = engineOff()
}

fun main() {

    var engine1 = object : EngineInterface{
        override fun on() {
            println("Engine1 on")
        }
        override fun off() {
            println("Engine1 off")
        }
    }
    engine1.on()
    engine1.off()

    var engine2 =  EngineInterface(
        {
            println("Engine2 on")
        },{
            println("Engine2 off")
        }
    )
    engine2.on()
    engine2.off()
}