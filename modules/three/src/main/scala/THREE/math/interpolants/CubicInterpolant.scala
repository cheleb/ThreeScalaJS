package THREE

import THREE.Interpolant
import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.typedarray.TypedArray

/**
 * Cubic interpolant.
 *
 * The cubic interpolant uses a cubic Hermite spline for interpolation. This
 * provides a smooth interpolation between adjacent values.
 */
@js.native
@JSImport("three", "CubicInterpolant")
class CubicInterpolant(
  parameterPositions: TypedArray[?, ?],
  sampleValues: TypedArray[?, ?],
  sampleSize: Int,
  resultBuffer: js.UndefOr[TypedArray[?, ?]] = js.undefined
) extends Interpolant(parameterPositions, sampleValues, sampleSize, resultBuffer) {

  /**
   * Implements a cubic Hermite spline interpolation.
   */
  override protected def interpolate_(i1: Int, t0: Double, t: Double, t1: Double): TypedArray[?, ?] = js.native

  /**
   * Called when the interpolation interval has changed.
   */
  override protected def intervalChanged_(i1: Int, t0: Double, t1: Double): Unit = js.native
}
