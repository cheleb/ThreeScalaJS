package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * This class is an alternative implementation of {@link FlyControls}.
 */
@js.native
@JSImport("three/addons/controls/FirstPersonControls.js", "FirstPersonControls")
class FirstPersonControls(camera: Camera, domElement: js.UndefOr[dom.Element] = js.undefined) extends js.Object {

  /**
   * The movement speed.
   */
  var movementSpeed: Double = js.native

  /**
   * The look around speed.
   */
  var lookSpeed: Double = js.native

  /**
   * Whether it's possible to vertically look around or not.
   */
  var lookVertical: Boolean = js.native

  /**
   * Whether the camera is automatically moved forward or not.
   */
  var autoForward: Boolean = js.native

  /**
   * Whether it's possible to look around or not.
   */
  var activeLook: Boolean = js.native

  /**
   * Whether or not the camera's height influences the forward movement speed.
   * Use the properties `heightCoef`, `heightMin` and `heightMax` for
   * configuration.
   */
  var heightSpeed: Boolean = js.native

  /**
   * Determines how much faster the camera moves when it's y-component is near
   * `heightMax`.
   */
  var heightCoef: Double = js.native

  /**
   * Lower camera height limit used for movement speed adjustment.
   */
  var heightMin: Double = js.native

  /**
   * Upper camera height limit used for movement speed adjustment.
   */
  var heightMax: Double = js.native

  /**
   * Whether or not looking around is vertically constrained by `verticalMin`
   * and `verticalMax`.
   */
  var constrainVertical: Boolean = js.native

  /**
   * How far you can vertically look around, lower limit. Range is `0` to
   * `Math.PI` in radians.
   */
  var verticalMin: Double = js.native

  /**
   * How far you can vertically look around, upper limit. Range is `0` to
   * `Math.PI` in radians.
   */
  var verticalMax: Double = js.native

  /**
   * Whether the mouse is pressed down or not.
   */
  val mouseDragOn: Boolean = js.native

  /**
   * Must be called if the application window is resized.
   */
  def handleResize(): Unit = js.native

  /**
   * Rotates the camera towards the defined target position.
   */
  def lookAt(
    x: Double | Vector3,
    y: js.UndefOr[Double] = js.undefined,
    z: js.UndefOr[Double] = js.undefined
  ): FirstPersonControls = js.native

  /**
   * Update the controls. Call this method every frame.
   */
  def update(delta: Double): Unit = js.native

  /**
   * Dispose of the controls.
   */
  def dispose(): Unit = js.native
}
