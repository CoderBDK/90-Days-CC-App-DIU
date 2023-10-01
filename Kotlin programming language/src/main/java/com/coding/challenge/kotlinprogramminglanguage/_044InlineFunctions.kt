package com.coding.challenge.kotlinprogramminglanguage

import javax.swing.tree.TreeNode


// inline fun <T> lock(lock: Lock, body: () -> T): T { ... }
inline fun mul(a: Int, b: Int, result: (Int, Int) -> Unit){

}
inline fun f(crossinline body: () -> Unit) {
    val f = Runnable { body() }
    // ...
}

fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
    var p = parent
    while (p != null && !clazz.isInstance(p)) {
        p = p.parent
    }
    @Suppress("UNCHECKED_CAST")
    return p as T?
}

fun nFunc(a: Int){
    println(a)
}
inline fun inFunc(a: Int){
    println(a)
}
inline fun ninFunc(a: Int,noinline o: (Int)->Unit){
    o(a)
}

fun main() {
  var r = mul(1,4) {
      a:Int,b:Int ->
      println("$a , $b")

   }
    println(r)

    f {
        println("Runnable")
    }

    nFunc(5)
    inFunc(612)
    ninFunc(575) { a->
        println(a)
    }

}