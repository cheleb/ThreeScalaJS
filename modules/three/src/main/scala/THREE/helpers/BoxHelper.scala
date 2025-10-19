package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Helper object to graphically show the world-axis-aligned bounding box around
 * an object. The actual bounding box is handled with {@link Box3}, this is just
 * a visual helper for debugging. It can be automatically resized with
 * {@link BoxHelper#update} when the object it's created from is transformed.
 * Note that the object must have a geometry for this to work, so it won't work
 * with sprites.
 *
 * @example
 *   ```scala
 *   val sphere = new SphereGeometry()
 *   val obj    = new Mesh(sphere, new MeshBasicMaterial(0xff0000))
 *   val box    = new BoxHelper(obj, 0xffff00)
 *   scene.add(box)
 *   ```
 */
@js.native
@JSImport("three", "BoxHelper")
class BoxHelper(
  /** The 3D object to show the world-axis-aligned bounding box. */
  var obj: Object3D = js.native,
  /** The box's color. Default is 0xffff00. */
  var color: Double | Color | String = js.native
) extends LineSegments {

  /**
   * This flag can be used for type testing.
   */
  val isBoxHelper: Boolean = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * Updates the helper's geometry to match the dimensions of the object,
   * including any children.
   */
  def update(): Unit = js.native

  /**
   * Updates the wireframe box for the passed object.
   *
   * @param obj
   *   The 3D object to create the helper for.
   * @return
   *   A reference to this instance.
   */
  def setFromObject(obj: Object3D): BoxHelper = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Companion object for BoxHelper class
 */
@js.native
@JSImport("three", "BoxHelper")
object BoxHelper extends js.Object
