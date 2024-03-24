import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Context - is a set of data that relates to the coroutine
 *
 * All coroutines have an associated context
 *
 * important elements of a context
 * - Dispatcher - which thread the coroutine is run on
 * - Job - handle on the coroutine lifecycle
 *
 *
 * **/

fun main(){
    runBlocking {
        launch(CoroutineName("myCoroutine")){
           println("this is run from ${coroutineContext[CoroutineName.Key]}")
        }
    }
}
