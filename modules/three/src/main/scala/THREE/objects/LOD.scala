package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|

/**
 * A component for providing a basic Level of Detail (LOD) mechanism.
 *
 * Every LOD level is associated with an object, and rendering can be switched
 * between them at the distances specified. Typically you would create, say,
 * three meshes, one for far away (low detail), one for mid range (medium
 * detail) and one for close up (high detail).
 *
 * Example:
 * ```scala sc:nocompile
 * val lod      = new LOD()
 * val material = MeshBasicMaterial(color = 0xffff00)
 *
 * // Create spheres with 3 levels of detail and create new LOD levels for them
 * for (i <- 0 until 3) {
 *   val geometry = IcosahedronGeometry(10, 3 - i)
 *   val mesh     = Mesh(geometry, material)
 *   lod.addLevel(mesh, i * 75)
 * }
 *
 * scene.add(lod)
 * ```
 */
@js.native
@JSImport("three", "LOD")
class LOD extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isLOD: Boolean = js.native

  /**
   * This array holds the LOD levels. Each level contains object, distance, and
   * hysteresis properties.
   */
  val levels: js.Array[LODLevel] = js.native

  /**
   * Whether the LOD object is updated automatically by the renderer per frame
   * or not. If set to false, you have to call update in the render loop by
   * yourself.
   */
  var autoUpdate: Boolean = js.native

  /**
   * Adds a mesh that will display at a certain distance and greater. Typically
   * the further away the distance, the lower the detail on the mesh.
   *
   * @param object
   *   The 3D object to display at this level
   * @param distance
   *   The distance at which to display this level of detail (default: 0)
   * @param hysteresis
   *   Threshold used to avoid flickering at LOD boundaries, as a fraction of
   *   distance (default: 0)
   * @return
   *   A reference to this instance
   */
  def addLevel(`object`: Object3D, distance: Double = 0, hysteresis: Double = 0): LOD = js.native

  /**
   * Removes an existing level, based on the distance from the camera. Returns
   * true when the level has been removed. Otherwise false.
   *
   * @param distance
   *   Distance of the level to remove
   * @return
   *   Whether the level has been removed or not
   */
  def removeLevel(distance: Double): Boolean = js.native

  /**
   * Returns the currently active LOD level index.
   *
   * @return
   *   The current active LOD level index
   */
  def getCurrentLevel(): Int = js.native

  /**
   * Returns a reference to the first 3D object that is greater than the given
   * distance.
   *
   * @param distance
   *   The LOD distance
   * @return
   *   The found 3D object, null if no 3D object has been found
   */
  def getObjectForDistance(distance: Double): Object3D | Null = js.native

  /**
   * Updates the LOD by computing which LOD level should be visible according to
   * the current distance of the given camera.
   *
   * @param camera
   *   The camera the scene is rendered with
   */
  def update(camera: Camera): Unit = js.native
}

/**
 * Represents a single LOD level with its object, distance, and hysteresis
 * settings.
 */
@js.native
trait LODLevel extends js.Object {
  val `object`: Object3D = js.native
  val distance: Double   = js.native
  val hysteresis: Double = js.native
}

/**
 * Companion object for LOD with factory method.
 */
@js.native
@JSImport("three", "LOD")
object LOD extends js.Object
