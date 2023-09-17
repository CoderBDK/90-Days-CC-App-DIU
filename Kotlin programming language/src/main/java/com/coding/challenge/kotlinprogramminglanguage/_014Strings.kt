package com.coding.challenge.kotlinprogramminglanguage

/**
 * Strings in Kotlin are represented by the type String.
 * Generally, a string value is a sequence of characters
 * in double quotes (")
 *
 * Kotlin has two types of string literals:
 * -Escaped strings
 * -Multiline strings
 */
fun main(){
    val str = "abcd 123"
    // Elements of a string are characters that you can access
    // via the indexing operation: s[i]. We can iterate over these characters with a for loop:
    for (c in str) {
        println(c)
    }
    var newStr = "abc"
    println(newStr)
    newStr = "88888"
    println(newStr)
    // Strings are immutable. Once we initialize a string, we can't change
    // its value or assign a new value to it.
    // All operations that transform strings return their results in a new String object,
    // leaving the original string unchanged
    val immutableString = "123"
   // immutableString = "abc"

    println(str.uppercase()) // Create and print a new String object
    println(str) // The original string remains the same

    // To concatenate strings, use the + operator.
    // This also works for concatenating strings with values of other types,
    // as long as the first element in the expression is a string:
    val s = "abc" + 1 + "234"
    println(s + "def")

    // Escaped string
    val v = "Hello, world!\n"
    // Multiline strings
    // Multiline strings can contain newlines and arbitrary text.
    // It is delimited by a triple quote ("""), contains no escaping and
    // can contain newlines and any other characters:

    val text = """
    for (c in "foo")
        print(c)
    """

    println("Escaped strings :$v")
    println("Multiline strings : $text")

    val text2 = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(text2)

    val text3 = """
        a b c e f
        g h i j k
        l m n o p
    """.trimIndent()

    println(text3)

    // String templates
    val i = 10
    println("i = $i") // Prints "i = 10"
    val s2 = "abc"
    println("$s2.length is ${s2.length}") // Prints "abc.length is 3"

    // We can use templates both in multiline and escaped strings.
    // To insert the dollar sign $ in a multiline string (which doesn't support backslash escaping)
    // before any symbol, which is allowed as a beginning of an identifier, use the following syntax:
    val price = """
    ${'$'}_9.99 \n 
    """.trim()
    println(price)

}