import kotlinx.coroutines.*

// scope
/**
 * Scope - provides lifecycle methods for coroutines
 * allow us to start and stop coroutines
 *
 * GlobalScope.launch{} - the scope of the coroutine is the lifecycle of the entire application
 *
 * runBlocking - create a scope and runs a coroutine in a blocking way
 *
 * coroutineScope{} - create a new scope, does not complete until all children coroutines complete
 *
 * **/

suspend fun main(){
    println("program execution will now block")
    runBlocking {
        launch {
            delay(1000L)
            println("task from runBlocking")
        }
    }

    GlobalScope.launch {
        delay(500L)
        println("task from GlobalScope")
    }

    coroutineScope {
        launch {
            delay(1500L)
            println("Task for coroutineScope")
        }
    }
    println("program execution will now continue")
}