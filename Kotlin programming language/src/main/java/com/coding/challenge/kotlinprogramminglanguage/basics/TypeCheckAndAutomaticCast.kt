package com.coding.challenge.kotlinprogramminglanguage.basics

/**
 * The is operator checks if an expression is an instance of a type.
 * If an immutable local variable or property is checked for a specific type,
 * there's no need to cast it explicitly:
 * @link {https://kotlinlang.org/docs/basic-syntax.html#type-checks-and-automatic-casts}
 */
fun main(){
    println("Length : ${getStringLength1("Hello")}")
    println("It should be null : ${getStringLength1(0)}")

    println("It should be null : ${getStringLength2(0)}")
    println("It should be null : ${getStringLength2(100u)}")

    println("Length : ${getStringLength3("Hello")}")
    println("Length : ${getStringLength3("Hello, World!")}")

    var a:Any = "22"

    if( a is String && a=="22"){
        println("String value of a is $a")
    }

    a = 100
    if( a is Int && a==100){
        println("Integer value of a is $a")
    }
    if( a is Int && a=="100"){
        println("Integer value of a is $a")
    }else{
        println("Is not equals string!=int")
    }
}

// 1
fun getStringLength1(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

// 2
fun getStringLength2(obj: Any): Int? {
    if (obj !is String) return null

    // `obj` is automatically cast to `String` in this branch
    return obj.length
}
fun getStringLength3(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}