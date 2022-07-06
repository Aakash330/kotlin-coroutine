package withTimeoutOrNull_coroutine_builder

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking {

    // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    /*this funtion return null if it will not finish their work given time if
     it will finish the wrok given time then return "I am done" message

     */
    val result: String? = withTimeoutOrNull(2000) {
        for (i in 0..5) {
            print("$i.")
            delay(500)
        }

        "I am done"
    }

    print("Result: $result")

    println("\nMain program ends: ${Thread.currentThread().name}")    // main thread
}