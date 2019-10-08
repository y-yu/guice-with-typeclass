package module

import com.google.inject.{AbstractModule, TypeLiteral}
import dependency.Dependency
import entity.Entity
import impl.{InjectTypeToResolveInstance, NeedToBeInjected, NeedToBeInjectedImpl}
import typeclass.HasTypeClass

class Module(name: String) extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[Dependency])

    Mode.modeMap.getOrElse(name, Failure) match {
      case Failure =>
        bind(classOf[NeedToBeInjected])
          .to(new TypeLiteral[NeedToBeInjectedImpl[Entity]]() {})

      case Inherit =>
        bind(classOf[NeedToBeInjected])
          .to(classOf[InjectTypeToResolveInstance])

      case Bind =>
        bind(new TypeLiteral[HasTypeClass[Entity]]() {})
          .toInstance(implicitly[HasTypeClass[Entity]])
        bind(classOf[NeedToBeInjected])
          .to(new TypeLiteral[NeedToBeInjectedImpl[Entity]]() {})
    }
  }
}
