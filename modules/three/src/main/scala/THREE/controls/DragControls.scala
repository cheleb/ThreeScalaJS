package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * This class can be used to provide a drag'n'drop interaction.
 */
@js.native
@JSImport("three/addons/controls/DragControls.js", "DragControls")
class DragControls(objects: js.Array[Object3D], camera: Camera, domElement: dom.Element = null) extends js.Object {

  /**
   * Whether children of draggable objects can be dragged independently from
   * their parent.
   */
  var recursive: Boolean = js.native

  /**
   * This option only works if the `objects` array contains a single draggable
   * group object. If set to `true`, the controls does not transform individual
   * objects but the entire group.
   */
  var transformGroup: Boolean = js.native

  /**
   * The speed at which the object will rotate when dragged in `rotate` mode.
   */
  var rotateSpeed: Double = js.native

  /**
   * The raycaster used for detecting 3D objects.
   */
  var raycaster: Raycaster = js.native

  /**
   * Dispose of the controls.
   */
  def dispose(): Unit = js.native

  /**
   * Connect the controls to the DOM element.
   */
  def connect(element: dom.Element): Unit = js.native

  /**
   * Disconnect the controls from the DOM element.
   */
  def disconnect(): Unit = js.native

  /**
   * Update the controls.
   */
  def update(): Unit = js.native
}

object DragControls {
  def apply(objects: js.Array[Object3D], camera: Camera, domElement: dom.Element = null): DragControls =
    new DragControls(objects, camera, domElement)
}
