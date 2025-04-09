package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|
import scala.scalajs.js.typedarray.Float32Array

/**
 * A special version of Mesh with instanced rendering support. Use this if you
 * have to render a large number of objects with the same geometry and material.
 */
@js.native
@JSImport("three", "InstancedMesh")
class InstancedMesh(
  geometry: js.UndefOr[BufferGeometry] = js.undefined,
  material: js.UndefOr[Material | js.Array[Material]] = js.undefined,
  val count: js.UndefOr[Int] = js.undefined
) extends Mesh(geometry, material) {

  /**
   * This flag can be used for type testing.
   */
  val isInstancedMesh: Boolean = js.native

  /**
   * Default is false.
   */
  var instanceMatrix: js.Object = js.native

  /**
   * Default is null.
   */
  var instanceColor: js.UndefOr[js.Object] = js.native

  /**
   * Sets the position, quaternion and scale for the instances' matrix
   * transformation.
   */
  def setMatrixAt(index: Int, matrix: Matrix4): Unit = js.native

  /**
   * Gets the position, quaternion and scale for the instances' matrix
   * transformation.
   */
  def getMatrixAt(index: Int, matrix: Matrix4): Unit = js.native

  /**
   * Sets the color for the instance at the specified index.
   */
  def setColorAt(index: Int, color: Color): Unit = js.native

  /**
   * Gets the color for the instance at the specified index.
   */
  def getColorAt(index: Int, color: Color): Unit = js.native

  /**
   * Disposes of this instance of InstancedMesh.
   */
  def dispose(): Unit = js.native
}
