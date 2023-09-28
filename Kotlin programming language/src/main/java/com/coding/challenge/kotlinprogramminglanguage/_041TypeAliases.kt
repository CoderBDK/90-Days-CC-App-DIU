package com.coding.challenge.kotlinprogramminglanguage

import java.io.File


class Network {
    class Node
}

typealias NodeSet = Set<Network.Node>



typealias FileTable<K> = MutableMap<K, MutableList<File>>

typealias MyHandler = (Int, String, Any) -> Unit

typealias Predicate<T> = (T) -> Boolean

typealias U16BIT = UByte
fun main() {
    var node: NodeSet = HashSet<Network.Node>()
    var fileTable = HashMap<String,MutableList<File>>()
    var predictBool: Predicate<Boolean> ={
        false
    }
    var b:U16BIT = 134u
    println(node)
    println(b)
}
