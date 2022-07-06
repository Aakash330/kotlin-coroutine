package cooperative

import kotlinx.coroutines.*

fun main()= runBlocking {

    val job: Job = launch(Dispatchers.Default)
    {
        val job: Job = launch(Dispatchers.Default) {     // Thread T1: Creates a non-blocking coroutine
            for (i in 0..500) {
                if (!isActive) {
                    return@launch // break
                }
                print("thread name ${Thread.currentThread().name} task wich has done  $i.")


                Thread.sleep(1)
            }

        }
    }


    delay(100)  // Let's print a few values before we cancel
    job.cancelAndJoin()

    println("\nMain program ends: ${Thread.currentThread().name}")    // main thread

}
