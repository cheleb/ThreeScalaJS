package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|

/**
 * A mesh that has a Skeleton that can then be used to animate the vertices of
 * the geometry with skinning/skeleton animation.
 *
 * Next to a valid skeleton, the skinned mesh requires skin indices and weights
 * as buffer attributes in its geometry. These attribute define which bones
 * affect a single vertex to a certain extend.
 *
 * Typically skinned meshes are not created manually but loaders like GLTFLoader
 * or FBXLoader import respective models.
 */
@js.native
@JSImport("three", "SkinnedMesh")
class SkinnedMesh(
  geo: js.UndefOr[BufferGeometry] = js.undefined,
  mat: js.UndefOr[Material | js.Array[Material]] = js.undefined
) extends Mesh(geo, mat) {

  /**
   * This flag can be used for type testing.
   */
  val isSkinnedMesh: Boolean = js.native

  /**
   * The type of this object.
   */
  override val `type`: String = js.native

  /**
   * `AttachedBindMode` means the skinned mesh shares the same world space as
   * the skeleton. This is not true when using `DetachedBindMode` which is
   * useful when sharing a skeleton across multiple skinned meshes.
   */
  var bindMode: String = js.native

  /**
   * The base matrix that is used for the bound bone transforms.
   */
  var bindMatrix: Matrix4 = js.native

  /**
   * The base matrix that is used for resetting the bound bone transforms.
   */
  var bindMatrixInverse: Matrix4 = js.native

  /**
   * The skeleton of this skinned mesh.
   */
  var skeleton: js.UndefOr[Skeleton] = js.native

  /**
   * The bounding box of the skinned mesh. Can be computed via
   * computeBoundingBox.
   */
  var boundingBox: js.UndefOr[Box3] = js.native

  /**
   * The bounding sphere of the skinned mesh. Can be computed via
   * computeBoundingSphere.
   */
  var boundingSphere: js.UndefOr[Sphere] = js.native

  /**
   * Computes the bounding box of the skinned mesh, and updates boundingBox. The
   * bounding box is not automatically computed by the engine; this method must
   * be called by your app. If the skinned mesh is animated, the bounding box
   * should be recomputed per frame in order to reflect the current animation
   * state.
   */
  def computeBoundingBox(): Unit = js.native

  /**
   * Computes the bounding sphere of the skinned mesh, and updates
   * boundingSphere. The bounding sphere is automatically computed by the engine
   * once when it is needed, e.g., for ray casting and view frustum culling. If
   * the skinned mesh is animated, the bounding sphere should be recomputed per
   * frame in order to reflect the current animation state.
   */
  def computeBoundingSphere(): Unit = js.native

  /**
   * This method sets the skinned mesh in the rest pose.
   */
  def pose(): Unit = js.native

  /**
   * Normalizes the skin weights which are defined as a buffer attribute in the
   * skinned mesh's geometry.
   */
  def normalizeSkinWeights(): Unit = js.native

  /**
   * Binds the given skeleton to the skinned mesh.
   *
   * @param skeleton
   *   The skeleton to bind
   * @param bindMatrix
   *   The bind matrix. If no bind matrix is provided, the skinned mesh's world
   *   matrix will be used instead
   */
  def bind(skeleton: Skeleton, bindMatrix: js.UndefOr[Matrix4] = js.undefined): Unit = js.native

  /**
   * Applies the bone transform associated with the given index to the given
   * vertex position. Returns the updated vector.
   *
   * @param index
   *   The vertex index
   * @param target
   *   The target object that is used to store the method's result
   * @return
   *   The updated vertex position
   */
  def applyBoneTransform(index: Int, target: Vector3): Vector3 = js.native
}

/**
 * Companion object for SkinnedMesh with factory method.
 */
@js.native
@JSImport("three", "SkinnedMesh")
object SkinnedMesh extends js.Object
