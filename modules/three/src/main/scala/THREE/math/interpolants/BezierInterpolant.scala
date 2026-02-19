package THREE

import THREE.Interpolant
import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.typedarray.TypedArray

/**
 * Bezier interpolant using cubic Bezier curves with 2D control points.
 *
 * This interpolant supports the COLLADA/Maya style of Bezier animation where
 * each keyframe has explicit in/out tangent control points specified as 2D
 * coordinates (time, value).
 *
 * The tangent data must be provided via the `settings` object:
 *   - `settings.inTangents`: Float32Array with [time, value] pairs per keyframe
 *     per component
 *   - `settings.outTangents`: Float32Array with [time, value] pairs per
 *     keyframe per component
 *
 * For a track with N keyframes and stride S:
 *   - Each tangent array has N * S * 2 values
 *   - Layout: [k0_c0_time, k0_c0_value, k0_c1_time, k0_c1_value, ...,
 *     k0_cS_time, k0_cS_value, k1_c0_time, k1_c0_value, ...]
 *
 * If no tangent data is provided, falls back to linear interpolation.
 */
@js.native
@JSImport("three", "BezierInterpolant")
class BezierInterpolant(
  parameterPositions: TypedArray[?, ?],
  sampleValues: TypedArray[?, ?],
  sampleSize: Int,
  resultBuffer: js.UndefOr[TypedArray[?, ?]] = js.undefined
) extends Interpolant(parameterPositions, sampleValues, sampleSize, resultBuffer) {

  /**
   * Implements cubic Bezier interpolation with 2D control points.
   *
   * Uses Newton-Raphson iteration to solve for the Bezier parameter from the
   * time domain, then evaluates the value domain Bezier curve.
   */
  override protected def interpolate_(i1: Int, t0: Double, t: Double, t1: Double): TypedArray[?, ?] = js.native
}
