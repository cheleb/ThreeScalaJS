package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * The GridHelper is an object to define grids. Grids are two-dimensional arrays
 * of lines.
 *
 * @example
 *   ```scala
 *   val gridHelper = new GridHelper(10, 10)
 *   scene.add(gridHelper)
 *   ```
 */
@js.native
@JSImport("three", "GridHelper")
class GridHelper(
  /** The size of the grid. Default is 10. */
  var size: Double = js.native,
  /** The number of divisions across the grid. Default is 10. */
  var divisions: Double = js.native,
  /** The color of the center line. Default is 0x444444. */
  var color1: Double | Color | String = js.native,
  /** The color of the lines of the grid. Default is 0x888888. */
  var color2: Double | Color | String = js.native
) extends LineSegments {

  /**
   * This flag can be used for type testing.
   */
  val isGridHelper: Boolean = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Companion object for GridHelper class
 */
@js.native
@JSImport("three", "GridHelper")
object GridHelper extends js.Object
