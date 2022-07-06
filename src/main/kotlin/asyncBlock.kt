import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {

    val daeffer:Deferred<Int> = async {


        for(i in 1..10) {

            println("download start  $i: ${Thread.currentThread().name}")     // Thread: main
            delay(4000)   // Coroutine is suspended but Thread: main is free (not blocked)
            println("download completed $i: ${Thread.currentThread().name}") // Thread: main
        }
        20

    }

   val number:Int=daeffer.await()
    println("defferend return value $number")
    println("main thread excuted ${Thread.currentThread().name}")

}