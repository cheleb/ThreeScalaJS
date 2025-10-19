package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * An 3D arrow object for visualizing directions.
 *
 * @example
 *   ```scala
 *   val dir = new Vector3(1, 2, 0)
 *   dir.normalize()
 *   val origin = new Vector3(0, 0, 0)
 *   val length = 1.0
 *   val hex    = 0xffff00
 *
 *   val arrowHelper = new ArrowHelper(dir, origin, length, hex)
 *   scene.add(arrowHelper)
 *   ```
 */
@js.native
@JSImport("three", "ArrowHelper")
class ArrowHelper(
  /** The (normalized) direction vector. Default is (0, 0, 1). */
  var dir: Vector3 = js.native,
  /** Point at which the arrow starts. Default is (0, 0, 0). */
  var origin: Vector3 = js.native,
  /** Length of the arrow in world units. Default is 1. */
  var length: Double = js.native,
  /** Color of the arrow. Default is 0xffff00. */
  var color: Double | Color | String = js.native,
  /** The length of the head of the arrow. Default is length*0.2. */
  var headLength: Double = js.native,
  /** The width of the head of the arrow. Default is headLength*0.2. */
  var headWidth: Double = js.native
) extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isArrowHelper: Boolean = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * The line part of the arrow helper.
   */
  val line: Line = js.native

  /**
   * The cone part of the arrow helper.
   */
  val cone: Mesh = js.native

  /**
   * Sets the direction of the helper.
   *
   * @param dir
   *   The normalized direction vector.
   */
  def setDirection(dir: Vector3): Unit = js.native

  /**
   * Sets the length of the helper.
   *
   * @param length
   *   Length of the arrow in world units.
   * @param headLength
   *   The length of the head of the arrow. Default is length*0.2.
   * @param headWidth
   *   The width of the head of the arrow. Default is headLength*0.2.
   */
  def setLength(length: Double, headLength: Double = js.native, headWidth: Double = js.native): Unit = js.native

  /**
   * Sets the color of the helper.
   *
   * @param color
   *   The color to set.
   */
  def setColor(color: Double | Color | String): Unit = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Companion object for ArrowHelper class
 */
@js.native
@JSImport("three", "ArrowHelper")
object ArrowHelper extends js.Object
