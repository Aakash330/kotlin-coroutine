import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {


    println("Main program starts: ${Thread.currentThread().name}")

    GlobalScope.launch {    // creates a background coroutine that runs on a background thread
        println("Fake work starts: ${Thread.currentThread().name}")
        Thread.sleep(1000)      // Pretend doing some work... may be file upload
        println("Fake work finished: ${Thread.currentThread().name}")

    }

    Thread.sleep(2000)
    println("Main program ends: ${Thread.currentThread().name}")
}
