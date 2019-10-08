package typeclass

trait HasTypeClass[A]

object HasTypeClass {
  implicit def typeClassInstance[A]: HasTypeClass[A] =
    new HasTypeClass[A] {}
}
