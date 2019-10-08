package impl

import dependency.Dependency
import entity.Entity
import javax.inject.Inject

class InjectTypeToResolveInstance @Inject() (
  dependency: Dependency
) extends NeedToBeInjectedImpl[Entity](dependency)
