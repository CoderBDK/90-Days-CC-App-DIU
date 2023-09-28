package com.coding.challenge.kotlinprogramminglanguage

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Resource{
    val a = 90
    val b = 80
}

class Owner{
    val valResource by ResourceDelegate()
    val readOnlyResource: Resource by resourceDelegate()  // ReadWriteProperty as val
    var readWriteResource: Resource by resourceDelegate()
}

class ResourcesDelegate2{
    operator fun getValue(r: Owner, k: KProperty<*>): Resource{
        return Resource()
    }
}

class ResourceDelegate(private var resource: Resource = Resource()) {
    operator fun getValue(thisRef: Owner, property: KProperty<*>): Resource {
        return resource
    }
    operator fun setValue(thisRef: Owner, property: KProperty<*>, value: Any?) {
        if (value is Resource) {
            resource = value
        }
    }
}

fun resourceDelegate(resource: Resource = Resource()): ReadWriteProperty<Any?, Resource> =
    object : ReadWriteProperty<Any?, Resource> {
        var curValue = resource
        override fun getValue(thisRef: Any?, property: KProperty<*>): Resource = curValue
        override fun setValue(thisRef: Any?, property: KProperty<*>, value: Resource) {
            curValue = value
        }
    }

fun main() {
    val owner = Owner()
    println(owner.valResource.a)
    println(owner.readOnlyResource.a)
    println(owner.readWriteResource.a)
}