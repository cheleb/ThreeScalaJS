package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * This class emits light uniformly across the face a rectangular plane. This
 * light type can be used to simulate light sources such as bright windows or
 * strip lighting.
 */
@js.native
@JSImport("three", "RectAreaLight")
class RectAreaLight(
  color: Int | String | Color = 0xffffff,
  intensity: Double = 1.0
) extends Light(color, intensity) {

  /**
   * This flag can be used for type testing.
   */
  val isRectAreaLight: Boolean = js.native

  /**
   * The width of the light.
   */
  var width: Double = js.native

  /**
   * The height of the light.
   */
  var height: Double = js.native

  /**
   * The light's power in lumens.
   */
  var power: Double = js.native
}

// Manual customization of the constructor
object RectAreaLight:

  def apply(
    color: Int | String | Color = 0xffffff,
    intensity: Double = 1.0,
    width: Double = 10.0,
    height: Double = 10.0
  ) = {
    val light = new RectAreaLight(color, intensity)
    light.width = width
    light.height = height
    light
  }
