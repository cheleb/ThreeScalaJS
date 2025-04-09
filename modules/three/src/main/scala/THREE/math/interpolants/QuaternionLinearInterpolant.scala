package THREE

import THREE.Interpolant
import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.typedarray.TypedArray

/**
 * Quaternion Linear Interpolant.
 *
 * Interpolant for quaternions with spherical linear interpolation (SLERP). This
 * interpolation ensures proper rotation interpolation.
 */
@js.native
@JSImport("three", "QuaternionLinearInterpolant")
class QuaternionLinearInterpolant(
  parameterPositions: TypedArray[?, ?],
  sampleValues: TypedArray[?, ?],
  sampleSize: Int,
  resultBuffer: js.UndefOr[TypedArray[?, ?]] = js.undefined
) extends Interpolant(parameterPositions, sampleValues, sampleSize, resultBuffer) {

  /**
   * Implements spherical linear interpolation for quaternions.
   */
  override protected def interpolate_(i1: Int, t0: Double, t: Double, t1: Double): TypedArray[?, ?] = js.native
}
