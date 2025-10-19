package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A helper object to visualize an instance of {@link Plane}.
 *
 * @example
 *   ```scala
 *   val plane  = new Plane(new Vector3(1, 1, 0.2), 3)
 *   val helper = new PlaneHelper(plane, 1, 0xffff00)
 *   scene.add(helper)
 *   ```
 */
@js.native
@JSImport("three", "PlaneHelper")
class PlaneHelper(
  /** The plane to be visualized. */
  var plane: Plane,
  /** The side length of plane helper. Default is 1. */
  var size: Double = js.native,
  /** The helper's color. Default is 0xffff00. */
  var color: Double | Color | String = js.native
) extends Line {

  /**
   * This flag can be used for type testing.
   */
  val isPlaneHelper: Boolean = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * Updates the helper to match the position and direction of the plane being
   * visualized.
   */
  override def updateMatrixWorld(force: Boolean = false): Unit = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Companion object for PlaneHelper class
 */
@js.native
@JSImport("three", "PlaneHelper")
object PlaneHelper extends js.Object
