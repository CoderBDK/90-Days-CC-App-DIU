package com.coding.challenge.kotlinprogramminglanguage

import kotlin.math.sqrt

fun sqrt(i: Int): Int {
    return sqrt(i.toDouble()).toInt()
}

fun main() {
    val n = 100
    val primes = Array(n) { 0 }
    // println(primes.contentToString())
    for (i in 2 until n) {
        if (primes[i] == 0) {
            for (j in 2 until sqrt(i)) {
                if (i % j == 0) {
                    primes[i] = 1
                }
            }
        }
    }

    for (i in 2 until n) {
        if (primes[i] == 0) {
            println("$i -> prime")
        }
    }
}