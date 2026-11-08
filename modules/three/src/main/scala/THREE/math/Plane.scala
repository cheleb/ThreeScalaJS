package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * A class representing a plane in 3D space.
 */
@js.native
@JSImport("three", "Plane")
class Plane(var normal: js.UndefOr[Vector3] = js.undefined, constant: js.UndefOr[Double] = js.undefined)
    extends js.Object {

  val isPlane: Boolean = js.native

  def set(normal: Vector3, constant: Double): this.type                         = js.native
  def setComponents(x: Double, y: Double, z: Double, w: Double): this.type      = js.native
  def setFromNormalAndCoplanarPoint(normal: Vector3, point: Vector3): this.type = js.native
  def setFromCoplanarPoints(a: Vector3, b: Vector3, c: Vector3): this.type      = js.native

  @JSName("clone")
  def jsClone(): Plane              = js.native
  def copy(plane: Plane): this.type = js.native

  def normalize(): this.type = js.native
  def negate(): this.type    = js.native

  def distanceToPoint(point: Vector3): Double     = js.native
  def distanceToSphere(sphere: js.Object): Double = js.native

  def projectPoint(point: Vector3, target: Vector3): Vector3  = js.native
  def orthoPoint(point: Vector3, target: Vector3): Vector3    = js.native
  def intersectLine(line: js.Object, target: Vector3): js.Any = js.native
  def intersectsLine(line: js.Object): Boolean                = js.native
  def intersectsBox(box: Box3): Boolean                       = js.native
  def intersectsSphere(sphere: js.Object): Boolean            = js.native

  def coplanarPoint(target: Vector3): Vector3                                                              = js.native
  def applyMatrix4(matrix: js.Object, optionalNormalMatrix: js.UndefOr[Matrix3] = js.undefined): this.type = js.native
  def translate(offset: Vector3): this.type                                                                = js.native

  def equals(plane: Plane): Boolean = js.native

  /**
   * Returns a serialized structure (`{ normal, constant }`) of the plane.
   *
   * @since r186
   */
  def toJSON(): js.Object = js.native

  /**
   * Sets the plane properties from the given JSON.
   *
   * @since r186
   */
  def fromJSON(json: js.Object): this.type = js.native
}
