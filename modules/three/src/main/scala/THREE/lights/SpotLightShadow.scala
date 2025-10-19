package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Represents the shadow configuration of spot lights.
 */
@js.native
@JSImport("three", "SpotLightShadow")
class SpotLightShadow() extends LightShadow(new PerspectiveCamera(50, 1, 0.5, 500)) {

  /**
   * This flag can be used for type testing.
   */
  val isSpotLightShadow: Boolean = js.native

  /**
   * Used to focus the shadow camera. The camera's field of view is set as a
   * percentage of the spotlight's field-of-view. Range is `[0, 1]`.
   */
  var focus: Double = js.native

  /**
   * Texture aspect ratio.
   */
  var aspect: Double = js.native

  /**
   * Update the matrices for the camera and shadow, used internally by the
   * renderer.
   */
  override def updateMatrices(light: Light): Unit = js.native

  /**
   * Copies the values of the given light shadow instance to this instance.
   */
  override def copy(source: LightShadow): SpotLightShadow = js.native
}

/**
 * Companion object for SpotLightShadow with factory method
 */
@js.native
@JSImport("three", "SpotLightShadow")
object SpotLightShadow extends js.Object
