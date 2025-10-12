package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Unreal Bloom pass that creates realistic bloom effect with threshold and
 * intensity controls
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/UnrealBloomPass.js", "UnrealBloomPass")
class UnrealBloomPass(resolution: Vector2, strength: Double, radius: Double, threshold: Double) extends EffectPass {

  def setStrength(strength: Double): Unit      = js.native
  def setRadius(radius: Double): Unit          = js.native
  def setThreshold(threshold: Double): Unit    = js.native
  def setResolution(resolution: Vector2): Unit = js.native
  override def dispose(): Unit                 = js.native
}

object UnrealBloomPass {

  def apply(resolution: Vector2, strength: Double, radius: Double, threshold: Double): UnrealBloomPass =
    new UnrealBloomPass(resolution, strength, radius, threshold)
}
