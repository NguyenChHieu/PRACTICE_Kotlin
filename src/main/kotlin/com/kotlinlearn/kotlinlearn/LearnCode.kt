fun main(){
    println("Hello World")
    val x = 5
    val y: Float = 5.7f
    val z: Double = 5.1782
    val a: Boolean = true
    val b: String = "Hello Kotlin"
    var c = "changeable variable"
    c = "changed variable"
    // arithmetic operators
    println(x + y)
    // incre/decrement operators
    var i = 1
    val a1 = i++   // postfix: a == 1, i == 2
    val b1 = ++i   // prefix:  i becomes 3, b == 3
    // comparison operators
    // == != > < >= <=
    // string interpolation
    print("The value of x is $x and the value of y is $y\n")
    // logical operators
    // && || !
    // read input + parse to int
    println("Enter your number:")
    val num = readln().toInt()
    println("Ts is number $num!")
    // nullability: input.toIntOrNull() returns null if input is not a valid integer
    // use !! to assert non-null, or ? for safe calls
    // ?: for Elvis operator to provide default value if null
    // input.toIntOrNull()?.<func> to safely call function if not null
}