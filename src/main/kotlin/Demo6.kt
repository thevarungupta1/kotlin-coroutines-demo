import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import kotlinx.coroutines.runBlocking

/**
 * Jobs
 * a .launch() call return a job
 * allows us to manipulate the coroutine lifecycle
 * live in the hierarchy of the other jobs both are parent and children
 *
 * can access lifecycle variables and methods
 *
 * - cancel()
 * - join()
 * if a job is cancelled, all its parent and children will be cancelled too
 * **/

fun main() {
    runBlocking {
        val job1 = launch {
            println("job1 launched")
            val job2 = launch {
                println("job2 launched")
                delay(3000L)
                println("job2 is finishing")
            }
            job2.invokeOnCompletion { println("job2 completed") }

            val job3 = launch {
                println("job3 launched")
                delay(3000L)
                println("job3 is finishing")
            }
            job3.invokeOnCompletion { println("job3 completed") }
        }

        job1.invokeOnCompletion { println("job1 completed") }

        delay(500L)
        println("job1 will be cancelled")
       job1.cancel()
    }
}