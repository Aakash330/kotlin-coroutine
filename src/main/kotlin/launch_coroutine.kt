import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking{

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    val job: Job = launch {   // Thread: main
        //if i have 100 song to download

        for(i in 1..100) {

            println("download start  $i: ${Thread.currentThread().name}")     // Thread: main
            delay(10000)   // Coroutine is suspended but Thread: main is free (not blocked)
            println("download completed $i: ${Thread.currentThread().name}") // Thread: main
        }
    }//lunch closed here

    job.join()      // main thread: wait for coroutine to finish

    println("Main program ends: ${Thread.currentThread().name}")


}