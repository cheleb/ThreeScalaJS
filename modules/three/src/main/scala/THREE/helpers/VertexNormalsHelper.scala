package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Visualizes an object's vertex normals.
 *
 * Requires that normals have been specified in the geometry as a buffer
 * attribute or have been calculated using BufferGeometry#computeVertexNormals.
 *
 * @example
 *   ```scala
 *   val geometry = new BoxGeometry(10, 10, 10, 2, 2, 2)
 *   val material = new MeshStandardMaterial()
 *   val mesh     = new Mesh(geometry, material)
 *   scene.add(mesh)
 *
 *   val helper = new VertexNormalsHelper(mesh, 1, 0xff0000)
 *   scene.add(helper)
 *   ```
 */
@js.native
@JSImport("three/addons/helpers/VertexNormalsHelper.js", "VertexNormalsHelper")
class VertexNormalsHelper(
  /** The object for which to visualize vertex normals. */
  var `object`: Object3D = js.native,
  /** The helper's size. Default is 1. */
  var size: Double = js.native,
  /** The helper's color. Default is 0xff0000. */
  var color: Double | Color | String = js.native
) extends LineSegments {

  /**
   * The object for which to visualize vertex normals.
   */
  @JSName("object")
  val objectProperty: Object3D = js.native

  /**
   * The helper's size.
   */
  val sizeProperty: Double = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * This flag can be used for type testing.
   */
  val isVertexNormalsHelper: Boolean = js.native

  /**
   * Updates the vertex normals preview based on the object's world transform.
   */
  def update(): Unit = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Companion object for VertexNormalsHelper class
 */
@js.native
@JSImport("three/addons/helpers/VertexNormalsHelper.js", "VertexNormalsHelper")
object VertexNormalsHelper extends js.Object
