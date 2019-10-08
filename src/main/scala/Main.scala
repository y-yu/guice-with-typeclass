import com.google.inject.{Guice, Key}
import impl.NeedToBeInjected
import module.Module

object Main {
  def main(args: Array[String]): Unit = {
    val injector = Guice.createInjector(new Module(args(0)))

    injector
      .getInstance(
        Key.get(classOf[NeedToBeInjected])
      )
  }
}
