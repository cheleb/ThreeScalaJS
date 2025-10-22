package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * This class enables a navigation similar to fly modes in DCC tools like
 * Blender. You can arbitrarily transform the camera in 3D space without any
 * limitations (e.g. focus on a specific target).
 */
@js.native
@JSImport("three/addons/controls/FlyControls.js", "FlyControls")
class FlyControls(camera: Camera, domElement: js.UndefOr[dom.Element] = js.undefined) extends js.Object {

  /**
   * The movement speed.
   */
  var movementSpeed: Double = js.native

  /**
   * The rotation speed.
   */
  var rollSpeed: Double = js.native

  /**
   * If set to `true`, you can only look around by performing a drag
   * interaction.
   */
  var dragToLook: Boolean = js.native

  /**
   * If set to `true`, the camera automatically moves forward (and does not
   * stop) when initially translated.
   */
  var autoForward: Boolean = js.native

  /**
   * Update the controls. Call this method every frame.
   */
  def update(delta: Double): Unit = js.native

  /**
   * Dispose of the controls.
   */
  def dispose(): Unit = js.native
}
