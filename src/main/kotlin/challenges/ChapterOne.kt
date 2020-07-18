package challenges

// 1. identity function
fun <T> identity(a: T): T = a

// 2. composition function
fun <A, B, C> compose(f1: (A) -> B, f2: (B) -> C): (A) -> C = { a: A -> f2(f1(a)) }

// 3. composition function respects identity
fun <A, B> composeWithIdentity(f1: (A) -> B): (A) -> B = compose(f1, { i: B -> identity(i) })

fun main() {
    val x: List<Int> = listOf(1, 2)

    println(identity(x))

    val sumAndThenPower: (List<Int>) -> Int = compose({ l: List<Int> -> l.sum() }, { i: Int -> i * i })
    println(sumAndThenPower(x))

    val sumWithIdentity: (List<Int>) -> Int = composeWithIdentity { l: List<Int> -> l.sum() }
    println(sumWithIdentity(x))
}
