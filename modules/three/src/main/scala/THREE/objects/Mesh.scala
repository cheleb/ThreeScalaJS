package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|

/**
 * Class representing triangular polygon mesh based objects.
 *
 * Example:
 * ```scala sc:nocompile
 * val geometry = new BoxGeometry(1, 1, 1)
 * val material = new MeshBasicMaterial(js.Dynamic.literal(color = 0xffff00))
 * val mesh     = new Mesh(geometry, material)
 * scene.add(mesh)
 * ```
 */
@js.native
@JSImport("three", "Mesh")
class Mesh(
  var geometry: js.UndefOr[BufferGeometry] = js.undefined,
  var material: js.UndefOr[Material | js.Array[Material]] = js.undefined
) extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isMesh: Boolean = js.native

  /**
   * A dictionary representing the morph targets in the geometry. The key is the
   * morph targets name, the value its attribute index. This member is undefined
   * by default and only set when morph targets are detected in the geometry.
   */
  var morphTargetDictionary: js.UndefOr[js.Dictionary[Int]] = js.native

  /**
   * An array of weights typically in the range [0,1] that specify how much of
   * the morph is applied. This member is undefined by default and only set when
   * morph targets are detected in the geometry.
   */
  var morphTargetInfluences: js.UndefOr[js.Array[Double]] = js.native

  /**
   * Sets the values of morphTargetDictionary and morphTargetInfluences to make
   * sure existing morph targets can influence this 3D object.
   */
  def updateMorphTargets(): Unit = js.native

  /**
   * Returns the local-space position of the vertex at the given index, taking
   * into account the current animation state of both morph targets and
   * skinning.
   *
   * @param index
   *   The vertex index
   * @param target
   *   The target object that is used to store the method's result
   * @return
   *   The vertex position in local space
   */
  def getVertexPosition(index: Int, target: Vector3): Vector3 = js.native
}
