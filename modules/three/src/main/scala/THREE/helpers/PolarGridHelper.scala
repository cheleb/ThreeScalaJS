package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * This helper is an object to define polar grids. Grids are two-dimensional
 * arrays of lines.
 *
 * @example
 *   ```scala
 *   val radius    = 10
 *   val sectors   = 16
 *   val rings     = 8
 *   val divisions = 64
 *
 *   val helper = new PolarGridHelper(radius, sectors, rings, divisions)
 *   scene.add(helper)
 *   ```
 */
@js.native
@JSImport("three", "PolarGridHelper")
class PolarGridHelper(
  /** The radius of the polar grid. Default is 10. */
  var radius: Double = js.native,
  /** The number of sectors the grid will be divided into. Default is 16. */
  var sectors: Double = js.native,
  /** The number of rings. Default is 8. */
  var rings: Double = js.native,
  /** The number of line segments used for each circle. Default is 64. */
  var divisions: Double = js.native,
  /** The first color used for grid elements. Default is 0x444444. */
  var color1: Double | Color | String = js.native,
  /** The second color used for grid elements. Default is 0x888888. */
  var color2: Double | Color | String = js.native
) extends LineSegments {

  /**
   * This flag can be used for type testing.
   */
  val isPolarGridHelper: Boolean = js.native

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
 * Companion object for PolarGridHelper class
 */
@js.native
@JSImport("three", "PolarGridHelper")
object PolarGridHelper extends js.Object
