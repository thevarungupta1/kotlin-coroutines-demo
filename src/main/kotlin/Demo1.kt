import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus


fun main(){
    GlobalScope.launch {
        delay(1000)
        print("World")
    }

    println("Hello")
    Thread.sleep(2000)
}

