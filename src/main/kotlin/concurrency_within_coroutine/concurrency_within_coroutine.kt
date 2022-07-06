package concurrency_within_coroutine

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    val time = measureTimeMillis {
        val msgOne: Deferred<String> = async {
            // ..more code..
            getMessageOne()
        }
        val msgTwo: Deferred<String> = async {
            // ..more code..
            getMessageTwo()
        }
        println("The entire message is: ${msgOne.await() + msgTwo.await()}")
    }

    println("Completed in $time ms")
    println("Main program ends: ${Thread.currentThread().name}")    // main thread
}

suspend fun getMessageOne(): String {
    delay(10000L)
    // pretend to do some work
    println("getMessageone called")
    return "Hello "
}

suspend fun getMessageTwo(): String {
    delay(1000L)
    // pretend to do some work
    println("getMessagetwo called")

    return "World!"
}
