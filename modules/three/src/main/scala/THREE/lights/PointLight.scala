package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A light that gets emitted from a single point in all directions. A common use
 * case for this is to replicate the light emitted from a bare lightbulb.
 */
@js.native
@JSImport("three", "PointLight")
class PointLight(
  color: Int | String | Color = 0xffffff,
  intensity: Double = 1.0
) extends Light(color, intensity) {

  /**
   * This flag can be used for type testing.
   */
  val isPointLight: Boolean = js.native

  /**
   * Maximum range of the light. 0 means no limit.
   */
  var distance: Double = js.native

  /**
   * The amount the light dims along the distance of the light.
   */
  var decay: Double = js.native

  /**
   * The light's shadow configuration.
   */
  var shadow: js.Object = js.native

  /**
   * The light's power in lumens.
   */
  var power: Double = js.native
}

// Manual customization of the constructor
object PointLight:

  def apply(
    color: Int | String | Color = 0xffffff,
    intensity: Double = 1.0,
    distance: Double = 0.0,
    decay: Double = 2.0
  ) = {
    val light = new PointLight(color, intensity)
    light.distance = distance
    light.decay = decay
    light
  }
