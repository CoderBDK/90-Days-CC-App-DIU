//@file:JvmName("_051Annotations")
package com.coding.challenge.kotlinprogramminglanguage

import org.jetbrains.annotations.VisibleForTesting
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
    AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.EXPRESSION, AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy

annotation class Special(val why: String)

annotation class ReplaceWithAnn(val expression: String)

annotation class DeprecatedAnn(
    val message: String,
    val replaceWith: ReplaceWithAnn = ReplaceWithAnn(""))
annotation class Ann(val arg2: KClass<out Any>)


@Fancy
@Special("example")
@DeprecatedAnn("This function is deprecated, use === instead", ReplaceWithAnn("this === other"))
@Ann(Int::class)
class FooFancy {
    @set:[Fancy VisibleForTesting]
    lateinit var collaborator: DeprecatedAnn
    @Fancy fun baz(@Fancy foo: Int): Int {
        return (@Fancy 1)
    }
}
annotation class InfoMarker(val info: String)
fun processInfo(marker: InfoMarker): Unit = TODO()
annotation class Suspendable
annotation class Anno()
class ExampleAnno(@field:Anno val foo: Int,    // annotate Java field
              @get:Anno val bar: Int,      // annotate Java getter
              @param:Anno val quux: Int)   // annotate Java constructor parameter


fun main() {

   var fooFancy = FooFancy()
    fooFancy.baz(3)
    val f = @Suspendable {
        println(0)
        5
    }
    f()

    ExampleAnno(0,0,0)
}