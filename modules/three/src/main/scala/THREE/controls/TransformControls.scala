package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * This class can be used to transform objects in 3D space by adapting a similar
 * interaction model of DCC tools like Blender. Unlike other controls, it is not
 * intended to transform the scene's camera.
 *
 * `TransformControls` expects that its attached 3D object is part of the scene
 * graph.
 */
@js.native
@JSImport("three/addons/controls/TransformControls.js", "TransformControls")
class TransformControls(camera: Camera, domElement: dom.Element = null) extends js.Object {

  /**
   * The current transformation axis.
   */
  var axis: String = js.native

  /**
   * The current transformation mode.
   */
  var mode: String = js.native

  /**
   * By default, 3D objects are continuously translated. If you set this
   * property to a numeric value (world units), you can define in which steps
   * the 3D object should be translated.
   */
  var translationSnap: js.UndefOr[Double] = js.native

  /**
   * By default, 3D objects are continuously rotated. If you set this property
   * to a numeric value (radians), you can define in which steps the 3D object
   * should be rotated.
   */
  var rotationSnap: js.UndefOr[Double] = js.native

  /**
   * By default, 3D objects are continuously scaled. If you set this property to
   * a numeric value, you can define in which steps the 3D object should be
   * scaled.
   */
  var scaleSnap: js.UndefOr[Double] = js.native

  /**
   * Defines in which coordinate space transformations should be performed.
   */
  var space: String = js.native

  /**
   * The size of the helper UI (axes/planes).
   */
  var size: Double = js.native

  /**
   * Whether dragging is currently performed or not.
   */
  var dragging: Boolean = js.native

  /**
   * Whether the x-axis helper should be visible or not.
   */
  var showX: Boolean = js.native

  /**
   * Whether the y-axis helper should be visible or not.
   */
  var showY: Boolean = js.native

  /**
   * Whether the z-axis helper should be visible or not.
   */
  var showZ: Boolean = js.native

  /**
   * The minimum allowed X position during translation.
   */
  var minX: Double = js.native

  /**
   * The maximum allowed X position during translation.
   */
  var maxX: Double = js.native

  /**
   * The minimum allowed y position during translation.
   */
  var minY: Double = js.native

  /**
   * The maximum allowed Y position during translation.
   */
  var maxY: Double = js.native

  /**
   * The minimum allowed z position during translation.
   */
  var minZ: Double = js.native

  /**
   * The maximum allowed Z position during translation.
   */
  var maxZ: Double = js.native

  /**
   * Returns the visual representation of the controls. Add the helper to your
   * scene to visually transform the attached 3D object.
   */
  def getHelper(): TransformControlsRoot = js.native

  /**
   * Sets the 3D object that should be transformed and ensures the controls UI
   * is visible.
   */
  def attach(`object`: Object3D): TransformControls = js.native

  /**
   * Removes the current 3D object from the controls and makes the helper UI
   * invisible.
   */
  def detach(): TransformControls = js.native

  /**
   * Resets the object's position, rotation and scale to when the current
   * transform began.
   */
  def reset(): Unit = js.native

  /**
   * Returns the raycaster that is used for user interaction. This object is
   * shared between all instances of `TransformControls`.
   */
  def getRaycaster(): Raycaster = js.native

  /**
   * Returns the transformation mode.
   */
  def getMode(): String = js.native

  /**
   * Sets the given transformation mode.
   */
  def setMode(mode: String): Unit = js.native

  /**
   * Sets the translation snap.
   */
  def setTranslationSnap(translationSnap: js.UndefOr[Double]): Unit = js.native

  /**
   * Sets the rotation snap.
   */
  def setRotationSnap(rotationSnap: js.UndefOr[Double]): Unit = js.native

  /**
   * Sets the scale snap.
   */
  def setScaleSnap(scaleSnap: js.UndefOr[Double]): Unit = js.native

  /**
   * Sets the size of the helper UI.
   */
  def setSize(size: Double): Unit = js.native

  /**
   * Sets the coordinate space in which transformations are applied.
   */
  def setSpace(space: String): Unit = js.native

  /**
   * Sets the colors of the control's gizmo.
   */
  def setColors(xAxis: js.Any, yAxis: js.Any, zAxis: js.Any, active: js.Any): Unit = js.native

  /**
   * Dispose of the controls.
   */
  def dispose(): Unit = js.native
}

/**
 * The visual representation of the TransformControls.
 */
@js.native
@JSImport("three/addons/controls/TransformControls.js", "TransformControlsRoot")
class TransformControlsRoot extends Object3D {
  var controls: TransformControls = js.native
}

/**
 * The gizmo component of the TransformControls.
 */
@js.native
@JSImport("three/addons/controls/TransformControls.js", "TransformControlsGizmo")
class TransformControlsGizmo extends Object3D

/**
 * The plane component of the TransformControls.
 */
@js.native
@JSImport("three/addons/controls/TransformControls.js", "TransformControlsPlane")
class TransformControlsPlane extends Mesh

object TransformControls {
  def apply(camera: Camera, domElement: dom.Element = null): TransformControls =
    new TransformControls(camera, domElement)
}
