package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A light source positioned directly above the scene, with color fading from
 * the sky color to the ground color.
 */
@js.native
@JSImport("three", "HemisphereLight")
class HemisphereLight(
  skyColor: Int | String | Color = 0xffffff,
  intensity: Double = 1.0
) extends Light(skyColor, intensity) {

  /**
   * This flag can be used for type testing.
   */
  val isHemisphereLight: Boolean = js.native

  /**
   * The light's ground color.
   */
  var groundColor: Color = js.native
}

// Manual customization of the constructor
object HemisphereLight:

  def apply(
    skyColor: Int | String | Color = 0xffffff,
    groundColor: Int | String | Color = 0xffffff,
    intensity: Double = 1.0
  ) = {
    val light = new HemisphereLight(skyColor, intensity)
    light.asInstanceOf[js.Dynamic].groundColor = groundColor.asInstanceOf[js.Any]
    light
  }
