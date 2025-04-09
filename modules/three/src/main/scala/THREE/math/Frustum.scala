package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * A class representing a frustum - the volume visible to a camera.
 *
 * A frustum is created by the intersection of six planes. The planes correspond
 * to the faces of a parallelepiped (a box).
 */
@js.native
@JSImport("three", "Frustum")
class Frustum(
  var planes: js.UndefOr[js.Array[Plane]] = js.undefined
) extends js.Object {

  /**
   * Sets the frustum from the passed planes. No plane order is implied.
   */
  def set(
    p0: Plane,
    p1: Plane,
    p2: Plane,
    p3: Plane,
    p4: Plane,
    p5: Plane
  ): this.type = js.native

  /**
   * Creates a new frustum with the same properties as this one.
   */
  @JSName("clone")
  def jsClone(): Frustum = js.native

  /**
   * Copies the properties of the passed frustum into this one.
   */
  def copy(frustum: Frustum): this.type = js.native

  /**
   * Sets the frustum planes from the projection matrix.
   */
  def setFromProjectionMatrix(m: Matrix4): this.type = js.native

  /**
   * Checks whether the frustum contains the point.
   */
  def intersectsPoint(point: Vector3): Boolean = js.native

  /**
   * Checks whether the frustum intersects the sphere.
   */
  def intersectsSphere(sphere: Sphere): Boolean = js.native

  /**
   * Checks whether the frustum intersects the box.
   */
  def intersectsBox(box: Box3): Boolean = js.native

  /**
   * Checks whether the frustum contains the object based on its bounding
   * sphere.
   */
  def containsPoint(point: Vector3): Boolean = js.native
}
