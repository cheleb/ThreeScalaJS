package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * PointerLockControls is a perfect choice for first person 3D games. The
 * implementation of this class is based on the Pointer Lock API.
 */
@js.native
@JSImport("three/addons/controls/PointerLockControls.js", "PointerLockControls")
class PointerLockControls(camera: Camera, domElement: js.UndefOr[dom.HTMLElement] = js.undefined) extends js.Object {

  /**
   * Whether the controls are locked or not.
   */
  val isLocked: Boolean = js.native

  /**
   * Camera pitch, lower limit. Range is '[0, Math.PI]' in radians.
   */
  var minPolarAngle: Double = js.native

  /**
   * Camera pitch, upper limit. Range is '[0, Math.PI]' in radians.
   */
  var maxPolarAngle: Double = js.native

  /**
   * Multiplier for how much the pointer movement influences the camera
   * rotation.
   */
  var pointerSpeed: Double = js.native

  /**
   * Returns the look direction of the camera.
   *
   * @param v - The target vector that is used to store the method's result.
   * @return The normalized direction vector.
   */
  def getDirection(v: Vector3): Vector3 = js.native

  /**
   * Moves the camera forward parallel to the xz-plane. Assumes camera.up is y-up.
   *
   * @param distance - The signed distance.
   */
  def moveForward(distance: Double): Unit = js.native

  /**
   * Moves the camera sidewards parallel to the xz-plane.
   *
   * @param distance - The signed distance.
   */
  def moveRight(distance: Double): Unit = js.native

  /**
   * Activates the pointer lock.
   *
   * @param unadjustedMovement - Disables OS-level adjustment for mouse acceleration, and accesses raw mouse input instead.
   *                             Setting it to true will disable mouse acceleration.
   */
  def lock(unadjustedMovement: Boolean = false): Unit = js.native

  /**
   * Exits the pointer lock.
   */
  def unlock(): Unit = js.native

  /**
   * Dispose of the controls.
   */
  def dispose(): Unit = js.native

}
