package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A helper object to visualize an instance of {@link Box3}.
 *
 * @example
 *   ```scala
 *   val box = new Box3()
 *   box.setFromCenterAndSize(new Vector3(1, 1, 1), new Vector3(2, 1, 3))
 *
 *   val helper = new Box3Helper(box, 0xffff00)
 *   scene.add(helper)
 *   ```
 */
@js.native
@JSImport("three", "Box3Helper")
class Box3Helper(
  /** The box to visualize. */
  var box: Box3 = js.native,
  /** The box's color. Default is 0xffff00. */
  var color: Double | Color | String = js.native
) extends LineSegments {

  /**
   * This flag can be used for type testing.
   */
  val isBox3Helper: Boolean = js.native

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
 * Companion object for Box3Helper class
 */
@js.native
@JSImport("three", "Box3Helper")
object Box3Helper extends js.Object
