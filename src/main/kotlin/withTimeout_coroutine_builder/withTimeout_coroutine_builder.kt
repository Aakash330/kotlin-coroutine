package withTimeout_coroutine_builder

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    withTimeout(1300) {
        try {
            for (i in 0..1000) {
                print("$i.")
                delay(500)
            }
        } catch (ex: TimeoutCancellationException) {
            println("time out ${ex.localizedMessage}")
            // .. code..
        } finally {
            println("finally all connection closed")

            // .. code..
        }
    }

    println("\nMain program ends: ${Thread.currentThread().name}")    // main thread

}