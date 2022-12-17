import kotlinx.coroutines.*
import java.lang.Thread.currentThread

@OptIn(DelicateCoroutinesApi::class)
private val pool = newSingleThreadContext("CoroutinePool")


suspend fun doNothingSpecial(host: String) {
  while (true) {
    println(currentThread().name + ": " + host)
    delay(100)
  }
}

suspend fun main() = coroutineScope {
  for (h in listOf("farpost", "drom", "vl", "avito", "something else")) {
    launch(pool) {
      doNothingSpecial(h)
    }
  }
}
