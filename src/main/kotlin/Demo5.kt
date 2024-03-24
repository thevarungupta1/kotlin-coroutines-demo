import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/***
 *
 * suspending functions
 * functions that can be run in a coroutine
 * make callbacks seamless
 *
 * ***/

var functionCalls = 0

fun main(){
    GlobalScope.launch { completeMessage() }
    GlobalScope.launch { improveMessage() }
    print("Hello, ")
    Thread.sleep(2000L)
    println("there have been $functionCalls calls so far")
}

suspend fun completeMessage(){
    delay(500L)
    println("World")
    functionCalls++
}

suspend fun improveMessage(){
    delay(1000L)
    println("suspend function are cool")
    functionCalls++
}