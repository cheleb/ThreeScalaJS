package THREE

import THREE.Interpolant
import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.typedarray.TypedArray

/**
 * Linear interpolant.
 *
 * The linear interpolant performs a simple linear interpolation between two
 * adjacent values.
 */
@js.native
@JSImport("three", "LinearInterpolant")
class LinearInterpolant(
  parameterPositions: TypedArray[?, ?],
  sampleValues: TypedArray[?, ?],
  sampleSize: Int,
  resultBuffer: js.UndefOr[TypedArray[?, ?]] = js.undefined
) extends Interpolant(parameterPositions, sampleValues, sampleSize, resultBuffer) {

  /**
   * Implements linear interpolation.
   */
  override protected def interpolate_(i1: Int, t0: Double, t: Double, t1: Double): TypedArray[?, ?] = js.native
}
