package com.coding.challenge.kotlinprogramminglanguage

import kotlinx.coroutines.*

fun main(){
    println("Coroutines run")
    runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            delay(500L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello") // main coroutine continues while a previous one is delayed
    }

    runBlocking {
        launch {
            delay(200)
            doWorld()
        }
        print("Hello, ")
        // scope builder
        doWorldScopeBuilder()
        doWorldScopeBuilderAndConcurrency()

        val job = launch { // launch a new coroutine and keep a reference to its Job
            delay(1000L)
            println("World!")
        }
        println("Hello")
        job.join() // wait until child coroutine completes
        println("Done")

        var counter = 0
        repeat(5) { // launch a of repeated coroutines
            launch {
                delay(500L)
                println(counter++)
            }
        }
    }

    println("All Done")

}

// this is suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}

suspend fun doWorldScopeBuilder() = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}
// Concurrently executes both sections
suspend fun doWorldScopeBuilderAndConcurrency() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}