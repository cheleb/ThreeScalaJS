package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A helper object to assist with visualizing a Skeleton.
 *
 * @example
 *   ```scala
 *   val helper = new SkeletonHelper(skinnedMesh)
 *   scene.add(helper)
 *   ```
 */
@js.native
@JSImport("three", "SkeletonHelper")
class SkeletonHelper(
  /**
   * Usually an instance of SkinnedMesh. However, any 3D object can be used if
   * it represents a hierarchy of bones.
   */
  var `object`: Object3D = js.native
) extends LineSegments {

  /**
   * This flag can be used for type testing.
   */
  val isSkeletonHelper: Boolean = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * The object being visualized.
   */
  val root: Object3D = js.native

  /**
   * The list of bones that the helper visualizes.
   */
  val bones: js.Array[Bone] = js.native

  /**
   * Defines the colors of the helper.
   *
   * @param color1
   *   The first line color for each bone.
   * @param color2
   *   The second line color for each bone.
   * @return
   *   A reference to this helper.
   */
  def setColors(color1: Color, color2: Color): SkeletonHelper = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Companion object for SkeletonHelper class
 */
@js.native
@JSImport("three", "SkeletonHelper")
object SkeletonHelper extends js.Object
