package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material for drawing points.
 */
@js.native
@JSImport("three", "PointsMaterial")
class PointsMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isPointsMaterial: Boolean = js.native

  /**
   * Sets the color of the points.
   */
  var color: Color = js.native

  /**
   * Defines the size of the points in pixels.
   */
  var size: Double = js.native

  /**
   * Whether the size is attenuated by the camera depth.
   */
  var sizeAttenuation: Boolean = js.native

  /**
   * Sets the color map of the points.
   */
  var map: js.UndefOr[Texture] = js.native

  /**
   * Sets the alpha map of the points.
   */
  var alphaMap: js.UndefOr[Texture] = js.native
}

/**
 * Companion object for PointsMaterial with factory method.
 */
@js.native
@JSImport("three", "PointsMaterial")
object PointsMaterial extends js.Object
