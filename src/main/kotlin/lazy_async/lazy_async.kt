package lazy_async

import kotlinx.coroutines.*

fun main() = runBlocking {


    // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    //CoroutineStart.LAZY-it means coroutine only start when its need even coroutine is cancelled
    /*
    Async coroutine builder takes coroutine context and start as a parameter
     where by using start
    parameter it is possible to define when to start the coroutines execution
    when CoroutineStart.LAZY is passed to start parameter it means that
    start the execution of coroutines only when either start or await method is called.
     */
    val msgOne: Deferred<String> = async(start = CoroutineStart.LAZY) {
        getMessageOne()
    }
    val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) {
        getMessageTwo()
    }

   msgOne.start()
   msgTwo.start()
  //  println("the entire nessage : ${msgOne} "+msgTwo)
 println("The entire message is: ${msgOne.await() + msgTwo.await()}")

    println("Main program ends: ${Thread.currentThread().name}")    // main thread
}

suspend fun getMessageOne(): String {
    delay(1000L)    // pretend to do some work
    println("After working in getMessageOne()")
    return "Hello "
}

suspend fun getMessageTwo(): String {
    delay(1000L)    // pretend to do some work
    println("After working in getMessageTwo()")
    return "World!"
}


