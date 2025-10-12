package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Dot screen pass that creates halftone/dot pattern effects
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/DotScreenPass.js", "DotScreenPass")
class DotScreenPass(center: Vector2, angle: Double, scale: Double) extends EffectPass {

  def setCenter(center: Vector2): Unit = js.native
  def setAngle(angle: Double): Unit    = js.native
  def setScale(scale: Double): Unit    = js.native
}

object DotScreenPass {

  def apply(center: Vector2, angle: Double, scale: Double): DotScreenPass =
    new DotScreenPass(center, angle, scale)
}
