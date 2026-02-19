package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Linear interpolation mode.
 * @defaultValue
 *   2100
 */
@js.native
@JSImport("three", "InterpolateLinear")
object InterpolateLinear extends js.Object:
  override def toString(): String = js.native

/**
 * Smooth interpolation mode.
 * @defaultValue
 *   2101
 */
@js.native
@JSImport("three", "InterpolateSmooth")
object InterpolateSmooth extends js.Object:
  override def toString(): String = js.native

/**
 * Discrete interpolation mode.
 * @defaultValue
 *   2102
 */
@js.native
@JSImport("three", "InterpolateDiscrete")
object InterpolateDiscrete extends js.Object:
  override def toString(): String = js.native

/**
 * Bezier interpolation mode.
 * @defaultValue
 *   2303
 */
@js.native
@JSImport("three", "InterpolateBezier")
object InterpolateBezier extends js.Object:
  override def toString(): String = js.native
