package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|

/**
 * Base class for all geometries.
 */
@js.native
@JSImport("three", "BufferGeometry")
class BufferGeometry extends js.Object {

  val id: Int        = js.native
  val uuid: String   = js.native
  val name: String   = js.native
  val `type`: String = js.native

  val index: js.UndefOr[js.Object]  = js.native
  val attributes: js.Object         = js.native
  val morphAttributes: js.Object    = js.native
  var morphTargetsRelative: Boolean = js.native

  val groups: js.Array[js.Object] = js.native
  val boundingBox: Box3           = js.native
  val boundingSphere: Sphere      = js.native

  val drawRange: js.Object = js.native
  val userData: js.Object  = js.native

  def getIndex(): js.Any                 = js.native
  def setIndex(index: js.Any): this.type = js.native

  def getAttribute(name: String): js.Any                          = js.native
  def setAttribute(name: String, attribute: js.Object): this.type = js.native
  def deleteAttribute(name: String): this.type                    = js.native

  def hasAttribute(name: String): Boolean = js.native

  def addGroup(start: Int, count: Int, materialIndex: js.UndefOr[Int] = js.undefined): Unit = js.native
  def clearGroups(): Unit                                                                   = js.native

  def setDrawRange(start: Int, count: Int): Unit = js.native

  def applyMatrix4(matrix: Matrix4): this.type              = js.native
  def applyQuaternion(q: Quaternion): this.type             = js.native
  def rotateX(angle: Double): this.type                     = js.native
  def rotateY(angle: Double): this.type                     = js.native
  def rotateZ(angle: Double): this.type                     = js.native
  def translate(x: Double, y: Double, z: Double): this.type = js.native
  def scale(x: Double, y: Double, z: Double): this.type     = js.native
  def lookAt(vector: Vector3): this.type                    = js.native

  def center(): this.type    = js.native
  def normalize(): this.type = js.native

  def computeBoundingBox(): Unit    = js.native
  def computeBoundingSphere(): Unit = js.native
  def computeTangents(): Unit       = js.native

  def dispose(): Unit = js.native

  @JSName("clone")
  def jsClone(): BufferGeometry               = js.native
  def copy(source: BufferGeometry): this.type = js.native

  def toNonIndexed(): BufferGeometry = js.native
  def toJSON(): js.Object            = js.native

  def setFromPoints(points: js.Array[Vector2] | js.Array[Vector3]): this.type = js.native
}
