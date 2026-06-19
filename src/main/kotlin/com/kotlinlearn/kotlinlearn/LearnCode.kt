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
    println("The number is $result")

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
        println("Result: $result")
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
    val str = "Hello"
    val reversed = buildString {
        for (j in str.lastIndex downTo 0) {
            append(str[j])
        }
    }
    println(reversed)
}