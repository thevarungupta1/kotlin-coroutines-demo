import kotlinx.coroutines.*

/***
 * Dispatcher
 *
 * A dispatcher determines which thread or thread pol the coroutine runs on
 *
 * different dispatchers are available depending on the task specified
 *
 * Main - main thread update in UI driven application (eg Android)
 *          main dispatcher need to be define in gradle
 *
 * Default - useful for CPU intensive work
 *
 * IO - useful for network communication or reading / writing files
 *
 * Unconfined - starts the coroutine in the inherited dispatcher that called it
 *
 * NewSingleThreadContext("myThread") - forced creation of a new thread
 * ***/

fun main(){
    runBlocking {
//        launch(Dispatchers.Main){
//            println("main dispatcher, thread: ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined){
            println("unconfined1, thread: ${Thread.currentThread().name}")
            delay(100L)
            println("unconfined2, thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default){
            println("default, thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO){
            println("IO, thread: ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyThread")){
            println("newSingleThreadContext, thread: ${Thread.currentThread().name}")
        }

    }


}