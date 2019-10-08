package impl

import dependency.Dependency
import javax.inject.Inject
import typeclass.HasTypeClass

trait NeedToBeInjected {}

class NeedToBeInjectedImpl[A: HasTypeClass] @Inject() (
  dependency: Dependency
) extends NeedToBeInjected { }
