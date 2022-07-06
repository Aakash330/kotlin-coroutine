import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    /*this is run  on main thread it special use for testing
    *  it also calles top label builder */

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    GlobalScope.launch { // Thread: T1

            println("videos  download start : ${Thread.currentThread().name}")     // Thread: T1 and T2
            delay(1000)
        // Coroutine is suspended but Thread: T1 is free (not blocked)
            println("videos download completed: ${Thread.currentThread().name}") // Either T1 or some other thread.


    }
    //when download the start from lunch builder but main thread last line executed then downloading is stoped

    delay(2000)
    // main thread: wait for coroutine to finish (practically not a right way to wait)

    println("Main program ends: ${Thread.currentThread().name}")    // main thread


}


