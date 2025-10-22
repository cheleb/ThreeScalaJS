package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * This class is similar to {@link OrbitControls}. However, it does not maintain
 * a constant camera `up` vector. That means if the camera orbits over the
 * "north" and "south" poles, it does not flip to stay "right side up".
 */
@js.native
@JSImport("three/addons/controls/TrackballControls.js", "TrackballControls")
class TrackballControls(camera: Camera, domElement: js.UndefOr[dom.Element] = js.undefined) extends js.Object {

  /**
   * The rotation speed.
   */
  var rotateSpeed: Double = js.native

  /**
   * The zoom speed.
   */
  var zoomSpeed: Double = js.native

  /**
   * The pan speed.
   */
  var panSpeed: Double = js.native

  /**
   * Whether rotation is disabled or not.
   */
  var noRotate: Boolean = js.native

  /**
   * Whether zooming is disabled or not.
   */
  var noZoom: Boolean = js.native

  /**
   * Whether panning is disabled or not.
   */
  var noPan: Boolean = js.native

  /**
   * Whether damping is disabled or not.
   */
  var staticMoving: Boolean = js.native

  /**
   * Defines the intensity of damping. Only considered if `staticMoving` is set
   * to `false`.
   */
  var dynamicDampingFactor: Double = js.native

  /**
   * How far you can dolly in (perspective camera only).
   */
  var minDistance: Double = js.native

  /**
   * How far you can dolly out (perspective camera only).
   */
  var maxDistance: Double = js.native

  /**
   * How far you can zoom in (orthographic camera only).
   */
  var minZoom: Double = js.native

  /**
   * How far you can zoom out (orthographic camera only).
   */
  var maxZoom: Double = js.native

  /**
   * This array holds keycodes for controlling interactions.
   */
  var keys: js.Array[String] = js.native

  /**
   * This object contains references to the mouse actions used by the controls.
   */
  var mouseButtons: js.Object = js.native

  /**
   * The focus point of the controls.
   */
  var target: Vector3 = js.native

  /**
   * Update the controls. Call this method every frame.
   */
  def update(): Unit = js.native

  /**
   * Resets the controls to its initial state.
   */
  def reset(): Unit = js.native

  /**
   * Must be called if the application window is resized.
   */
  def handleResize(): Unit = js.native

  /**
   * Dispose of the controls.
   */
  def dispose(): Unit = js.native
}
