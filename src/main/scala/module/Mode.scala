package module

sealed abstract class Mode(val value: String)

case object Failure extends Mode("failure")
case object Bind extends Mode("bind")
case object Inherit extends Mode("inherit")

object Mode {
  val modeMap: Map[String, Mode] = Seq(Failure, Bind, Inherit).map { x =>
    x.value -> x
  }.toMap
}