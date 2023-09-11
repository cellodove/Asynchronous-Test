import kotlinx.coroutines.*

fun main() = runBlocking{
    doOneTwoThree()
    println("runBlocking: ${Thread.currentThread().name}")
    println("5!")
}

suspend fun doOneTwoThree() = coroutineScope {
    val job = launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1000L)
        println("3!")
    }
    job.join()

    launch {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }

    repeat(1000) {
        launch {
            println("launch3: ${Thread.currentThread().name}")
            delay(500L)
            println("2!")
        }
    }
    println("4!")
}