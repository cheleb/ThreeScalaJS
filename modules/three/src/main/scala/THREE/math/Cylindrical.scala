package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * A class representing cylindrical coordinates.
 *
 * Cylindrical coordinates represent a position in 3D space using a distance
 * from the origin (radius), an angle from the X axis on the XZ plane (theta),
 * and a height above the XZ plane (y).
 */
@js.native
@JSImport("three", "Cylindrical")
class Cylindrical(
  var radius: js.UndefOr[Double] = js.undefined,
  var theta: js.UndefOr[Double] = js.undefined,
  var y: js.UndefOr[Double] = js.undefined
) extends js.Object {

  /**
   * Sets values of this cylindrical's coordinates.
   */
  def set(radius: Double, theta: Double, y: Double): this.type = js.native

  /**
   * Creates a new cylindrical with the same radius, theta, and y values as this
   * one.
   */
  @JSName("clone")
  def jsClone(): Cylindrical = js.native

  /**
   * Copies values of radius, theta, and y properties from the given
   * cylindrical.
   */
  def copy(other: Cylindrical): this.type = js.native

  /**
   * Sets values of this cylindrical's coordinates from a Vector3.
   */
  def setFromVector3(vector3: Vector3): this.type = js.native

  /**
   * Sets values of this cylindrical's coordinates from a Cartesian vector.
   */
  def setFromCartesianCoords(x: Double, y: Double, z: Double): this.type = js.native
}
