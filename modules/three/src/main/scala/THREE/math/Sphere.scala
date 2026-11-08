package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * A class representing a sphere in 3D space.
 */
@js.native
@JSImport("three", "Sphere")
class Sphere(var center: js.UndefOr[Vector3] = js.undefined, var radius: js.UndefOr[Double] = js.undefined)
    extends js.Object {

  val isSphere: Boolean = js.native

  def set(center: Vector3, radius: Double): this.type                                                         = js.native
  def setFromPoints(points: js.Array[Vector3], optionalCenter: js.UndefOr[Vector3] = js.undefined): this.type =
    js.native

  @JSName("clone")
  def jsClone(): Sphere               = js.native
  def copy(sphere: Sphere): this.type = js.native

  def isEmpty(): Boolean     = js.native
  def makeEmpty(): this.type = js.native

  def containsPoint(point: Vector3): Boolean  = js.native
  def distanceToPoint(point: Vector3): Double = js.native

  def intersectsSphere(sphere: Sphere): Boolean = js.native
  def intersectsBox(box: Box3): Boolean         = js.native
  def intersectsPlane(plane: Plane): Boolean    = js.native

  def clampPoint(point: Vector3, target: Vector3): Vector3 = js.native
  def getBoundingBox(target: Box3): Box3                   = js.native

  def applyMatrix4(matrix: js.Object): this.type = js.native
  def translate(offset: Vector3): this.type      = js.native

  def equals(sphere: Sphere): Boolean = js.native
}
