package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * This light gets emitted from a single point in one direction, along a cone
 * that increases in size the further from the light it gets.
 */
@js.native
@JSImport("three", "SpotLight")
class SpotLight(
  color: Int | String | Color = 0xffffff,
  intensity: Double = 1.0
) extends Light(color, intensity) {

  /**
   * This flag can be used for type testing.
   */
  val isSpotLight: Boolean = js.native

  /**
   * The spot light points from its position to the target's position.
   */
  var target: Object3D = js.native

  /**
   * Maximum range of the light. 0 means no limit.
   */
  var distance: Double = js.native

  /**
   * Maximum angle of light dispersion from its direction.
   */
  var angle: Double = js.native

  /**
   * Percent of the spotlight cone that is attenuated due to penumbra.
   */
  var penumbra: Double = js.native

  /**
   * The amount the light dims along the distance of the light.
   */
  var decay: Double = js.native

  /**
   * A texture used to modulate the color of the light.
   */
  var map: js.Object = js.native

  /**
   * The light's shadow configuration.
   */
  var shadow: SpotLightShadow = js.native

  /**
   * The light's power in lumens.
   */
  var power: Double = js.native
}

// Manual customization of the constructor
object SpotLight:

  def apply(
    color: Int | String | Color = 0xffffff,
    intensity: Double = 1.0,
    distance: Double = 0.0,
    angle: Double = scala.math.Pi / 3,
    penumbra: Double = 0.0,
    decay: Double = 2.0
  ) = {
    val light = new SpotLight(color, intensity)
    light.distance = distance
    light.angle = angle
    light.penumbra = penumbra
    light.decay = decay
    light
  }
