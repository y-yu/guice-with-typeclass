import com.google.inject.{CreationException, Guice, Key}
import impl.NeedToBeInjected
import module.Module
import org.scalatest._

class MainSpec extends FlatSpec with DiagrammedAssertions {
  def getInstance(name: String): NeedToBeInjected = {
    val injector = Guice.createInjector(new Module(name))
    injector
      .getInstance(
        Key.get(classOf[NeedToBeInjected])
      )
  }

  "NeedToBeInjectedImpl" should "not be instantiated" in {
    intercept[CreationException] {
      getInstance("failure")
    }
  }

  "NeedToBeInjectedImpl" should "be instantiated if `HasTypeClass[Entity]` is bound explicitly" in {
    assert(getInstance("bind") != null)
  }

  "InjectTypeToResolveInstance" should "be instantiated because it's typeclass instance has been injected by Scala" in {
    assert(getInstance("inherit") != null)
  }
}
