package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Base class for all objects in the THREE scene graph.
 */
@js.native
@JSImport("three", "Object3D")
class Object3D extends js.Object {

  val id: Int        = js.native
  val uuid: String   = js.native
  var name: String   = js.native
  val `type`: String = js.native

  var parent: js.UndefOr[Object3D] = js.native
  val children: js.Array[Object3D] = js.native

  var position: Vector3      = js.native
  var rotation: Euler        = js.native
  var quaternion: Quaternion = js.native
  var scale: Vector3         = js.native

  var matrix: Matrix4      = js.native
  var matrixWorld: Matrix4 = js.native

  var matrixAutoUpdate: Boolean       = js.native
  var matrixWorldNeedsUpdate: Boolean = js.native

  var layers: js.Object = js.native
  var visible: Boolean  = js.native

  var castShadow: Boolean    = js.native
  var receiveShadow: Boolean = js.native

  var frustumCulled: Boolean = js.native
  var renderOrder: Double    = js.native

  var userData: js.Object = js.native

  def add(obj: Object3D*): this.type   = js.native
  def remove(ob: Object3D*): this.type = js.native

  def attach(obj: Object3D): this.type = js.native

  @JSName("clone")
  def jsClone(recursive: Boolean = true): this.type                = js.native
  def copy(source: Object3D, recursive: Boolean = true): this.type = js.native

  def applyMatrix4(matrix: Matrix4): Unit       = js.native
  def applyQuaternion(q: Quaternion): this.type = js.native

  def setRotationFromAxisAngle(axis: Vector3, angle: Double): Unit = js.native
  def setRotationFromEuler(euler: Euler): Unit                     = js.native
  def setRotationFromMatrix(m: Matrix4): Unit                      = js.native
  def setRotationFromQuaternion(q: Quaternion): Unit               = js.native

  def rotateOnAxis(axis: Vector3, angle: Double): this.type      = js.native
  def rotateOnWorldAxis(axis: Vector3, angle: Double): this.type = js.native
  def rotateX(angle: Double): this.type                          = js.native
  def rotateY(angle: Double): this.type                          = js.native
  def rotateZ(angle: Double): this.type                          = js.native

  def translateOnAxis(axis: Vector3, distance: Double): this.type = js.native
  def translateX(distance: Double): this.type                     = js.native
  def translateY(distance: Double): this.type                     = js.native
  def translateZ(distance: Double): this.type                     = js.native

  def localToWorld(vector: Vector3): Vector3 = js.native
  def worldToLocal(vector: Vector3): Vector3 = js.native

  def lookAt(x: js.Any, y: js.UndefOr[Double] = js.undefined, z: js.UndefOr[Double] = js.undefined): Unit = js.native

  def traverse(callback: js.Function1[Object3D, Unit]): Unit          = js.native
  def traverseVisible(callback: js.Function1[Object3D, Unit]): Unit   = js.native
  def traverseAncestors(callback: js.Function1[Object3D, Unit]): Unit = js.native

  def updateMatrix(): Unit                                                    = js.native
  def updateMatrixWorld(force: Boolean = false): Unit                         = js.native
  def updateWorldMatrix(updateParent: Boolean, updateChildren: Boolean): Unit = js.native

  def getObjectById(id: Int): js.UndefOr[Object3D]                           = js.native
  def getObjectByName(name: String): js.UndefOr[Object3D]                    = js.native
  def getObjectByProperty(name: String, value: js.Any): js.UndefOr[Object3D] = js.native

  def getWorldPosition(target: Vector3): Vector3         = js.native
  def getWorldQuaternion(target: Quaternion): Quaternion = js.native
  def getWorldScale(target: Vector3): Vector3            = js.native
  def getWorldDirection(target: Vector3): Vector3        = js.native

  def raycast(raycaster: js.Object, intersects: js.Array[js.Object]): Unit = js.native

  def clear(): this.type = js.native
}

@js.native
@JSImport("three", "Object3D")
object Object3D extends js.Object {
  val DefaultUp: js.Array[Double]      = js.native
  val DefaultMatrixAutoUpdate: Boolean = js.native
}
