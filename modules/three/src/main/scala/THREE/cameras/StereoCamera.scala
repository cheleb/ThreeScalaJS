package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A special type of camera that uses two perspective cameras with stereoscopic
 * projection. Can be used for rendering stereo effects like 3D Anaglyph or
 * Parallax Barrier.
 */
@js.native
@JSImport("three", "StereoCamera")
class StereoCamera extends js.Object {

  /**
   * The type property is used for detecting the object type in context of
   * serialization/deserialization.
   */
  val `type`: String = js.native

  /**
   * The aspect.
   */
  var aspect: Double = js.native

  /**
   * The eye separation which represents the distance between the left and right
   * camera.
   */
  var eyeSep: Double = js.native

  /**
   * The camera representing the left eye. This is added to layer 1 so objects
   * to be rendered by the left camera must also be added to this layer.
   */
  val cameraL: PerspectiveCamera = js.native

  /**
   * The camera representing the right eye. This is added to layer 2 so objects
   * to be rendered by the right camera must also be added to this layer.
   */
  val cameraR: PerspectiveCamera = js.native

  /**
   * Updates the stereo camera based on the given perspective camera.
   */
  def update(camera: PerspectiveCamera): Unit = js.native
}
