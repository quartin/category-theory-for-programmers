package challenges

import java.util.HashMap
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

// 1. HOF memoize
fun <A, B> memoize(f1: (A) -> B): (A) -> B {
    val cache: HashMap<A, B> = hashMapOf()
    return { a: A -> cache.getOrPut(a, {f1(a)}) }
}

@ExperimentalTime
fun main() {
    val x: List<Int> = 1.until(50000000).toList()
    val t: List<Int> = 2.until(50000000).toList()
    val memoizedSum: (List<Int>) -> Int = memoize { it.sum() }

    println("Sum same list 6 times")
    repeat(6) { println(measureTime { memoizedSum(x) }) }
    println("Sum slightly different list")
    println(measureTime { memoizedSum(t) })
}
