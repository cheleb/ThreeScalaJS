package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * An axis object to visualize the 3 axes in a simple way. The X axis is red.
 * The Y axis is green. The Z axis is blue.
 *
 * @example
 *   ```scala
 *   val axesHelper = new AxesHelper(5)
 *   scene.add(axesHelper)
 *   ```
 */
@js.native
@JSImport("three", "AxesHelper")
class AxesHelper(
  /** Size of the lines representing the axes. Default is 1. */
  var size: Double = js.native
) extends LineSegments {

  /**
   * This flag can be used for type testing.
   */
  val isAxesHelper: Boolean = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * Defines the colors of the axes helper.
   *
   * @param xAxisColor
   *   The color for the x axis.
   * @param yAxisColor
   *   The color for the y axis.
   * @param zAxisColor
   *   The color for the z axis.
   * @return
   *   A reference to this axes helper.
   */
  def setColors(xAxisColor: Color, yAxisColor: Color, zAxisColor: Color): this.type = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Companion object for AxesHelper class
 */
@js.native
@JSImport("three", "AxesHelper")
object AxesHelper extends js.Object
