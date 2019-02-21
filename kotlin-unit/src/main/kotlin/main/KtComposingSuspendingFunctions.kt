package main

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(array: Array<String>) {
    Cf3()
}

fun Cf3() {
    runBlocking<Unit> {
        //sampleStart
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
            val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
            // some computation
            one.start() // start the first one
            two.start() // start the second one
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
        //sampleEnd
    }

}

fun Cf2() {
    runBlocking {
        val time = measureTimeMillis {
            val one = async { doSomethingUsefulOne() }
            val two = async { doSomethingUsefulTwo() }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }
}

fun Cf1() {
    runBlocking {
        println("begin...")
        val time = measureTimeMillis {
            val one = doSomethingUsefulOne()
            val two = doSomethingUsefulTwo()
            println("The answer is ${one + two}")
        }

        println("Completed in $time ms")
    }
}


suspend fun doSomethingUsefulOne(): Int {
    delay(3500L)
    return 1
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(3500L)
    return 4
}

