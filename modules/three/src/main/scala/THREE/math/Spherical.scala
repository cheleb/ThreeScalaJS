package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class for spherical coordinates.
 *
 * Spherical coordinates represent a position in 3D space using a distance from
 * origin (radius), an angle from the y (polar) axis, and an angle around the y
 * axis (equator).
 */
@js.native
@JSImport("three", "Spherical")
class Spherical(
  var radius: js.UndefOr[Double] = js.undefined,
  var phi: js.UndefOr[Double] = js.undefined,
  var theta: js.UndefOr[Double] = js.undefined
) extends js.Object {

  def set(radius: Double, phi: Double, theta: Double): this.type = js.native

  @JSName("clone")
  def jsClone(): Spherical = js.native

  def copy(other: Spherical): this.type = js.native

  def makeSafe(): this.type = js.native

  def setFromVector3(v: Vector3): this.type = js.native

  def setFromCartesianCoords(x: Double, y: Double, z: Double): this.type = js.native
}
