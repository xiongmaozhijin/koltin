package main

import kotlinx.coroutines.*

fun main(array: Array<String>) {
    f5()
}

fun f5() {
    runBlocking {
        GlobalScope.launch {
            repeat(1_000) {
                println("I'm sleeping $it")
                delay(500)
            }
        }

        println("below GlobalScope.")
    }
}

fun f4() {
    runBlocking {
        repeat(100_000) {
            launch {
                delay(1_000L)
                println(".$it")
            }
        }

        delay(10_000L)
    }
}

fun f3() {
    runBlocking {
        launch {
            dof3Work()
        }

        println("below launch.")

        coroutineScope {
            launch {
                delay(3_000L)
                println("coroutineScope.Launch")
            }

            delay(9_000L)
            println("coroutineScope.")
        }

        println("below Coroutine scope is oover")
    }
}

private suspend fun dof3Work() {
    delay(1000L)
    println("dof3Work(). Task from runBlocking. launch")
}

fun f2() {
    runBlocking {
        launch {
            delay(1_000L)
            println("World!")
        }
        println("f2() Hello, ")
    }
}

private fun f1() {
    GlobalScope.launch {
        delay(1_000L)
        println("World!")
    }
    println("Hello, ")
    Thread.sleep(2_000L)
}