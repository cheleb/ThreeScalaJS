package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for representing the armatures in three.js. The skeleton is defined by
 * a hierarchy of bones.
 *
 * Example:
 * ```scala sc:nocompile
 * val bones = js.Array[Bone]()
 *
 * val shoulder = new Bone()
 * val elbow    = new Bone()
 * val hand     = new Bone()
 *
 * shoulder.add(elbow)
 * elbow.add(hand)
 *
 * bones.push(shoulder, elbow, hand)
 *
 * shoulder.position.y = -5
 * elbow.position.y = 0
 * hand.position.y = 5
 *
 * val armSkeleton = new Skeleton(bones)
 * ```
 */
@js.native
@JSImport("three", "Skeleton")
class Skeleton(
  var bones: js.Array[Bone] = js.Array(),
  var boneInverses: js.Array[Matrix4] = js.Array()
) extends js.Object {

  /**
   * The UUID of this skeleton instance.
   */
  val uuid: String = js.native

  /**
   * An array of bone inverse matrices.
   */
  var boneMatrices: js.typedarray.Float32Array = js.native

  /**
   * A texture holding the bone data for use in the vertex shader.
   */
  var boneTexture: DataTexture = js.native

  /**
   * Initializes the skeleton. This method gets automatically called by the
   * constructor but depending on how the skeleton is created it might be
   * necessary to call this method manually.
   */
  def init(): Unit = js.native

  /**
   * Computes the bone inverse matrices. This method resets boneInverses and
   * fills it with new matrices.
   */
  def calculateInverses(): Unit = js.native

  /**
   * Resets the skeleton to the base pose.
   */
  def pose(): Unit = js.native

  /**
   * Updates the skeleton bone matrices.
   */
  def update(): Unit = js.native

  /**
   * Returns a new skeleton with copied values from this instance.
   */
  override def clone(): Skeleton = js.native

  /**
   * Computes a data texture for passing bone data to the vertex shader.
   */
  def computeBoneTexture(): Skeleton = js.native

  /**
   * Searches through the skeleton's bone array and returns the first with a
   * matching name.
   *
   * @param name
   *   The name of the bone
   * @return
   *   The found bone, undefined if no bone has been found
   */
  def getBoneByName(name: String): js.UndefOr[Bone] = js.native

  /**
   * Frees the GPU-related resources allocated by this instance.
   */
  def dispose(): Unit = js.native

  /**
   * Setups the skeleton by the given JSON and bones.
   *
   * @param json
   *   The skeleton as serialized JSON
   * @param bones
   *   An object map of bones
   * @return
   *   A reference of this instance
   */
  def fromJSON(json: js.Object, bones: js.Dictionary[Bone]): Skeleton = js.native

  /**
   * Serializes the skeleton into JSON.
   */
  def toJSON(): js.Object = js.native
}

/**
 * Companion object for Skeleton with factory method.
 */
@js.native
@JSImport("three", "Skeleton")
object Skeleton extends js.Object
