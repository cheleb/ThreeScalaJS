package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A ray that emits from an origin in a certain direction.
 */
@js.native
@JSImport("three", "Ray")
class Ray(
  var origin: js.UndefOr[Vector3] = js.undefined,
  var direction: js.UndefOr[Vector3] = js.undefined
) extends js.Object {

  def set(origin: Vector3, direction: Vector3): this.type = js.native

  @JSName("clone")
  def jsClone(): Ray = js.native

  def copy(ray: Ray): this.type = js.native

  def at(t: Double, target: Vector3): Vector3 = js.native

  def lookAt(v: Vector3): this.type = js.native

  def recast(t: Double): this.type = js.native

  def closestPointToPoint(point: Vector3, target: Vector3): Vector3 = js.native

  def distanceToPoint(point: Vector3): Double = js.native

  def distanceSqToPoint(point: Vector3): Double = js.native

  def distanceSqToSegment(
    v0: Vector3,
    v1: Vector3,
    optionalPointOnRay: js.UndefOr[Vector3] = js.undefined,
    optionalPointOnSegment: js.UndefOr[Vector3] = js.undefined
  ): Double = js.native

  def intersectSphere(sphere: Sphere, target: Vector3): js.UndefOr[Vector3] = js.native

  def intersectsSphere(sphere: Sphere): Boolean = js.native

  def distanceToPlane(plane: Plane): Double = js.native

  def intersectPlane(plane: Plane, target: Vector3): js.UndefOr[Vector3] = js.native

  def intersectsPlane(plane: Plane): Boolean = js.native

  def intersectBox(box: Box3, target: Vector3): js.UndefOr[Vector3] = js.native

  def intersectsBox(box: Box3): Boolean = js.native

  def intersectTriangle(
    a: Vector3,
    b: Vector3,
    c: Vector3,
    backfaceCulling: Boolean,
    target: Vector3
  ): js.UndefOr[Vector3] = js.native

  def applyMatrix4(matrix4: Matrix4): this.type = js.native

  def equals(ray: Ray): Boolean = js.native
}
