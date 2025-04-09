package THREE

import THREE.Interpolant
import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.typedarray.TypedArray

/**
 * Discrete interpolant.
 *
 * The discrete interpolant returns the sample at the position closest to the
 * parameter.
 */
@js.native
@JSImport("three", "DiscreteInterpolant")
class DiscreteInterpolant(
  parameterPositions: TypedArray[?, ?],
  sampleValues: TypedArray[?, ?],
  sampleSize: Int,
  resultBuffer: js.UndefOr[TypedArray[?, ?]] = js.undefined
) extends Interpolant(parameterPositions, sampleValues, sampleSize, resultBuffer) {

  /**
   * Implements discrete interpolation. Returns the nearest sample value.
   */
  override protected def interpolate_(i1: Int, t0: Double, t: Double, t1: Double): TypedArray[?, ?] = js.native
}
