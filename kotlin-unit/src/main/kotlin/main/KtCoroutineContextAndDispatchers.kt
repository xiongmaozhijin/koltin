package main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main(array: Array<String>) {
    Df2()
}

fun Df2() {
    val str = "1551075783329:"
    val split = str.split(":")
    println("length is ${split.size}")
    split.forEach {
        println(it)
    }
}

fun Df1() {
    runBlocking<Unit> {
        //sampleStart
        launch {
            // context of the parent, main runBlocking coroutine
            println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) {
            // not confined -- will work with main thread
            println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            // will get dispatched to DefaultDispatcher
            println("Default               : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(newSingleThreadContext("MyOwnThread")) {
            // will get its own new thread
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }
        //sampleEnd
    }
}
