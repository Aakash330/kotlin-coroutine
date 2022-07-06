import kotlinx.coroutines.*

fun main() = runBlocking {


    println("Main program starts: ${Thread.currentThread().name}")  // main thread

        val job=GlobalScope.launch {    // Thread: T1
        for (i in 1..20) {
            println("Fake work starts: ${Thread.currentThread().name}")     // Thread: T1
            mySuspendFunc(2000)   // Coroutine is suspended but Thread: T1 is free (not blocked)
            println("Fake work finished: ${Thread.currentThread().name}") // Either T1 or some other thread.
        }
         //
    }

    mySuspendFunc(2000)  // main thread: wait for coroutine to finish (practically not a right way to wait)
      job.join()
    println("Main program ends: ${Thread.currentThread().name}")
}

suspend fun mySuspendFunc(time: Long) {
    // code..
    delay(time)
}