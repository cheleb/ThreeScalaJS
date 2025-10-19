package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * This helps with visualizing what a camera contains in its frustum. It
 * visualizes the frustum of a camera using line segments.
 *
 * Based on frustum visualization in lightgl.js shadowmap example.
 *
 * CameraHelper must be a child of the scene.
 *
 * @example
 *   ```scala
 *   val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
 *   val helper = new CameraHelper(camera)
 *   scene.add(helper)
 *   ```
 */
@js.native
@JSImport("three", "CameraHelper")
class CameraHelper(
  /** The camera to visualize. */
  var camera: Camera = js.native
) extends LineSegments {

  /**
   * This flag can be used for type testing.
   */
  val isCameraHelper: Boolean = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * This contains the points used to visualize the camera.
   */
  val pointMap: js.Object = js.native

  /**
   * Defines the colors of the helper.
   *
   * @param frustum
   *   The frustum line color.
   * @param cone
   *   The cone line color.
   * @param up
   *   The up line color.
   * @param target
   *   The target line color.
   * @param cross
   *   The cross line color.
   * @return
   *   A reference to this helper.
   */
  def setColors(frustum: Color, cone: Color, up: Color, target: Color, cross: Color): CameraHelper = js.native

  /**
   * Updates the helper based on the projection matrix of the camera.
   */
  def update(): Unit = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Companion object for CameraHelper class
 */
@js.native
@JSImport("three", "CameraHelper")
object CameraHelper extends js.Object
