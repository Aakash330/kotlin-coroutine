package coroutineScope

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    println("runBlocking: $this")

    launch {
        println("launch: $this")

        launch(coroutineContext) {
            println("child launch: $this")
        }
    }

    async {
        println("async: $this")
    }

    println("... some other code...")
}