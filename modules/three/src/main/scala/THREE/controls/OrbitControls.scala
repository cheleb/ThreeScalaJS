package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * Orbit controls allow the camera to orbit around a target.
 */
@js.native
@JSImport("three/addons/controls/OrbitControls.js", "OrbitControls")
class OrbitControls(camera: Camera, domElement: dom.Element) extends js.Object {

  /**
   * The current position of the camera.
   */
  var position0: Vector3 = js.native

  /**
   * The point that the camera orbits around.
   */
  var target: Vector3 = js.native

  /**
   * The camera zoom.
   */
  var zoom0: Double = js.native

  /**
   * Whether to enable damping (inertia).
   */
  var enableDamping: Boolean = js.native

  /**
   * The damping inertia factor.
   */
  var dampingFactor: Double = js.native

  /**
   * Whether to enable zooming.
   */
  var enableZoom: Boolean = js.native

  /**
   * The speed of zooming.
   */
  var zoomSpeed: Double = js.native

  /**
   * Whether to enable rotation.
   */
  var enableRotate: Boolean = js.native

  /**
   * The speed of rotation.
   */
  var rotateSpeed: Double = js.native

  /**
   * Whether to enable panning.
   */
  var enablePan: Boolean = js.native

  /**
   * The speed of panning.
   */
  var panSpeed: Double = js.native

  /**
   * Whether to automatically rotate around the target.
   */
  var autoRotate: Boolean = js.native

  /**
   * The speed of auto rotation.
   */
  var autoRotateSpeed: Double = js.native

  /**
   * Minimum distance from target when zooming.
   */
  var minDistance: Double = js.native

  /**
   * Maximum distance from target when zooming.
   */
  var maxDistance: Double = js.native

  /**
   * Sets the focus of the camera to the target.
   */
  def update(): Boolean = js.native

  /**
   * Reset camera to initial position.
   */
  def reset(): Unit = js.native

  /**
   * Dispose of the controls.
   */
  def dispose(): Unit = js.native

  /**
   * Save the current state of the controls.
   */
  def saveState(): Unit = js.native
}
