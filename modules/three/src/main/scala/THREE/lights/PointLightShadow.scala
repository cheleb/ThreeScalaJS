package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Represents the shadow configuration of point lights.
 */
@js.native
@JSImport("three", "PointLightShadow")
class PointLightShadow() extends LightShadow(new PerspectiveCamera(90, 1, 0.5, 500)) {

  /**
   * This flag can be used for type testing.
   */
  val isPointLightShadow: Boolean = js.native

  /**
   * Update the matrices for the camera and shadow, used internally by the
   * renderer.
   */
  def updateMatrices(light: Light, viewportIndex: Double = 0): Unit = js.native
}

/**
 * Companion object for PointLightShadow with factory method
 */
@js.native
@JSImport("three", "PointLightShadow")
object PointLightShadow extends js.Object
