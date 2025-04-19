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
 * Companion object for PointsMaterial with factory methods.
 */
object PointsMaterial:

  /**
   * Create a PointsMaterial with specified parameters.
   *
   * @param color
   *   Color of the points. Default is 0xffffff (white).
   * @param size
   *   Size of the points in pixels. Default is 1.0.
   * @param sizeAttenuation
   *   Whether the size is attenuated by the camera depth. Default is true.
   * @param map
   *   The texture map. Default is null.
   * @param alphaMap
   *   The alpha map. Default is null.
   * @param fog
   *   Whether the material is affected by fog. Default is true.
   * @return
   *   A new PointsMaterial instance.
   */
  def apply(
    color: Int | String | Color = 0xffffff,
    size: Double = 1.0,
    sizeAttenuation: Boolean = true,
    map: Texture,
    alphaMap: js.UndefOr[Texture] = js.undefined,
    fog: Boolean = false
  ): PointsMaterial = {
    val params = js.Dynamic.literal(
      color = color.asInstanceOf[js.Any],
      size = size,
      sizeAttenuation = sizeAttenuation,
      map = map,
      alphaMap = alphaMap,
      fog = fog
    )

    new PointsMaterial(params)

  }
