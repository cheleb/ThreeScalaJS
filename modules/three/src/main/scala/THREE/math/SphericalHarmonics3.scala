package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class for storing spherical harmonics.
 *
 * Spherical harmonics are an extension of Spherical coordinates to the sphere,
 * and are particularly useful for representing some types of directional data.
 */
@js.native
@JSImport("three", "SphericalHarmonics3")
class SphericalHarmonics3 extends js.Object {

  /**
   * Spherical harmonics coefficients.
   */
  var coefficients: js.Array[Vector3] = js.native

  /**
   * Whether this instance has been set up.
   */
  val isSphericalHarmonics3: Boolean = js.native

  def set(coefficients: js.Array[Vector3]): this.type = js.native

  def zero(): this.type = js.native

  def add(sh: SphericalHarmonics3): this.type = js.native

  def addScaledSH(sh: SphericalHarmonics3, scale: Double): this.type = js.native

  def scale(scale: Double): this.type = js.native

  def lerp(sh: SphericalHarmonics3, alpha: Double): this.type = js.native

  def equals(sh: SphericalHarmonics3): Boolean = js.native

  @JSName("clone")
  def jsClone(): SphericalHarmonics3 = js.native

  def copy(sh: SphericalHarmonics3): this.type = js.native

  def fromArray(array: js.Array[Double], offset: Int = 0): this.type = js.native

  def toArray(array: js.Array[Double] = js.Array(), offset: Int = 0): js.Array[Double] = js.native

  def getAt(normal: Vector3, target: Vector3): Vector3 = js.native

  def getIrradianceAt(normal: Vector3, target: Vector3): Vector3 = js.native
}

@js.native
@JSImport("three", "SphericalHarmonics3")
object SphericalHarmonics3 extends js.Object {

  def getBasisAt(normal: Vector3, shBasis: js.Array[Double]): Unit = js.native
}
