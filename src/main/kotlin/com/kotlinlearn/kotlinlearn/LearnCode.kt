import kotlin.math.sqrt

fun main(){
//    println("Hello World")
    val x = 5
    val y: Float = 5.7f
    val z: Double = 5.1782
    val a: Boolean = true
    val b: String = "Hello Kotlin"
    var c = "changeable variable"
    c = "changed variable"
    // arithmetic operators
//    println(x + y)
    // incre/decrement operators
    var i = 1
    val a1 = i++   // postfix: a == 1, i == 2
    val b1 = ++i   // prefix:  i becomes 3, b == 3
    // comparison operators
    // == != > < >= <=
    // string interpolation
//    print("The value of x is $x and the value of y is $y\n")
    // logical operators
    // && || !
    // read input + parse to int
    println("Enter your number:")
    val num = readln().toInt()
//    println("Ts is number $num!")
    // nullability: input.toIntOrNull() returns null if input is not a valid integer
    // use !! to assert non-null, or ? for safe calls
    // ?: for Elvis operator to provide default value if null
    // input.toIntOrNull()?.<func> to safely call function if not null

    // if-else
    if (num > 0) {
        println("Positive number")
    } else if (num < 0) {
        println("Negative number")
    } else {
        println("Zero")
    }

    // can be treated as expression that returns value
    val result = if (num % 2 == 0) "Even" else "Odd"
//    println("The number is $result")

    // when expression (similar to switch-case). it would be <bool condition> -> <result>/action
    when {
        num > 0 -> println("Positive number")
        num < 0 -> println("Negative number")
        else -> println("Zero")
    }
    // pass parameter to when
    when (num) {
        0 -> println("Zero")
        in 1..10 -> println("Between 1 and 10")
        else -> println("Greater than 10 or negative")
    }
    // also returns value
    val size = when (num) {
        in 1..10 -> "Small"
        in 11..100 -> "Medium"
        else -> "Large"
    }

    // try catch either treat as wrapper or expression that returns value
    // we can throw exceptions too
    try {
        val result = 10 / num
//        println("Result: $result")
    } catch (e: ArithmeticException) {
        println("Cannot divide by zero")
    }

    val res1 = try {
        10 / num
    } catch (e: ArithmeticException) {
        -1
    }

    // arrays (many types like IntArray, Array<String>, etc.) - size is fixed, but elements can be changed
    // sth like arrayOf(1, 2, 3) + 4 would create a new array with 4 added at the end
//    val arr = arrayOf(1, 2, 3, 4, 5)
//    println("First element: ${arr[0]}")

    // lists (immutable List and mutable MutableList) - size can change for mutable, but not for immutable
    // listOf(1, 2, 3) + 4 would create a new list with 4 added at the end, but original list remains unchanged
    val list = mutableListOf(1, 2, 3)
    list.add(4)

    // loops
    // while loop
//    var count = 0
//    while (count < 5) {
//        // we can also use break to exit loop or continue to skip current iteration
//        // val number = readln().toIntOrNull() ?: continue  // skip if input is not a valid integer
//        // if (number == 0) break  // exit loop if input is zero
//        println("Count: $count")
//        count++
//    }

    // for loop
//    for (k in 1..5) {
//        println("k: $k")
//    }
//    for (k in 5 downTo 1) {
//        println("k: $k")
//    }
//    for (k in 1 until 5) {
//        println("k: $k")
//    }
//    for (k in list) {
//        println("k: $k")
//    }
//    for (i in <str>.lastIndex downTo 0) {
//        println("Character: ${<str>[i]}")
//    }
    // reverse a string using for loop
//    val str = "Hello"
//    val reversed = buildString {
//        for (j in str.lastIndex downTo 0) {
//            append(str[j])
//        }
//    }
//    println(reversed)

    // functions
    // fun <name>(<parameters>): <return type> { <body> }
    fun add(a: Int = 10, b: Int): Int {
        return a + b
    }

    // extension function - add new function to existing class without modifying it
    fun String.reversed(): String {
        val rev = buildString {
            for (j in this@reversed.lastIndex downTo 0) {
                append(this@reversed[j])
            }
        }
        return rev
    }
//    val str = "Kotlin"
//    println(str.reversed())

    // function overloading - same function name but different parameters
    fun Int.reversed(): Int {
        return this.toString().reversed().toInt()
    }
//    val testNum = 12345
//    println(testNum.reversed())

    // lambda expressions - anonymous functions that can be treated as values
    // filter a list using lambda
    val numbers = listOf(1, 2, 3, 4, 5)
    val evenNumbers = numbers.filter { it % 2 == 0 }

    // lambda func if written clearly
//    val lambda: (Char) -> Boolean = {
//        it.isLetter() || it.isDigit()
//    }
//    val lettersOnly = <str>.filter(lambda)

    // write a func that accept lambda as parameter
    fun String.myFilter(predicate: (Char) -> Boolean): String {
        return buildString {
            for (ch in this@myFilter) {
                if (predicate(ch)) {
                    append(ch)
                }
            }
        }
    }
    // change lambda to be an extension function
    fun String.MyFilter(predicate: Char.() -> Boolean): String {
        return buildString {
            for (ch in this@MyFilter) {
                if (ch.predicate()) {
                    append(ch)
                }
            }
        }
    }

    // it is the implicit single-parameter name the Kotlin compiler provides for a lambda
    // when you don't declare parameters explicitly. It's just a read-only local parameter
    // (no special runtime magic). If the lambda has >= 0 parameter, or you
    // need destructuring, you must declare parameters explicitly. For lambdas with a receiver
    // use this (receiver) instead of it.

    // this@<label> is used to refer to the receiver of the lambda when there are multiple receivers
    // in scope. It allows you to specify which receiver you want to access when there is ambiguity.
}

// class
// data class - automatically generates equals(), hashCode(), toString(), copy() based on props defined in primary const
// x = y.copy(prop1 = newValue) would create a new instance with prop1 changed but other props remain the same
// vararg - allows you to pass a variable number of arguments to a function. Inside the function, the vararg parameter
// is treated as an array of the specified type. You can use the spread operator (*) to pass an array as vararg
// arguments when calling the function.
data class Rectangle(val width: Double, val height: Double) {
    val diagonal: Double = sqrt(width * width + height * height)
    val area: Double = width * height
}

data class Circle(val radius: Double) {
    val area: Double = Math.PI * radius * radius
    val diameter: Double = 2 * Math.PI * radius
}

// interface
interface Shape {
    val area: Double
    val perimeter: Double
}

fun sumAreas(vararg shapes: Shape): Double {
    return shapes.sumOf { currentShape ->
        currentShape.area
    }
}

// implement interface by  <class> : <interface> { <implementations> }
// override func to provide specific implementation for the interface methods
class Square(val side: Double) : Shape {
    override val area: Double
        get() = side * side
    override val perimeter: Double
        get() = 4 * side
}

// abstract class - cannot be instantiated, can contain abstract methods that must be implemented by subclasses
abstract class Shape2 {
    abstract val area: Double
    abstract val perimeter: Double
}

// open class - can be inherited by other classes. By default, classes in Kotlin are final (cannot be inherited)
// open val/func: can be overridden by subclasses, but not required. If you want to require subclasses to override, use abstract instead of open.

// polymorphism
//fun printShapes(vararg shapes: Shape) {
//    for (shape in shapes) {
//        when (shape) {
//            is Square -> println("Square with area ${shape.area} and perimeter ${shape.perimeter}")
//            is Rectangle -> println("Rectangle with area ${shape.area} and diagonal ${shape.diagonal}")
//            is Circle -> println("Circle with area ${shape.area} and diameter ${shape.diameter}")
//             else -> println("Unknown shape")
//        }
//    }
//}

// sealed interface/class - restricts class hierarchy to a limited set of types. All subclasses must be defined in the
// same file. Useful for representing closed sets of types and enabling exhaustive when expressions without needing an else case.

// enum
enum class Country(val code: String) {
    USA("US"),
    CANADA("CA"),
    MEXICO("MX")
}

fun getCountryInfo(country: Country): String {
    return when (country) {
        Country.USA -> "United States of America"
        Country.CANADA -> "Canada"
        Country.MEXICO -> "Mexico"
    }
}

// singleton object - a class that has only one instance. Useful for utility classes or managing shared state. The
// object declaration creates a thread-safe singleton instance that can be accessed directly by its name without needing
// to instantiate it.
object MathUtils {
    fun square(x: Double): Double {
        return x * x
    }
    fun cube(x: Double): Double {
        return x * x * x
    }
}

// visibility modifiers
// public (default) - visible everywhere
// private - visible only within the class/file
// protected - visible within the class and its subclasses
// internal - visible within the same module (e.g., same Gradle project)