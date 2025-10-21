package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Sets the stencil buffer value to `0`.
 */
@js.native
@JSImport("three", "ZeroStencilOp")
object ZeroStencilOp extends js.Object:
  override def toString(): String = js.native

/**
 * Keeps the current value.
 */
@js.native
@JSImport("three", "KeepStencilOp")
object KeepStencilOp extends js.Object:
  override def toString(): String = js.native

/**
 * Sets the stencil buffer value to the specified reference value.
 */
@js.native
@JSImport("three", "ReplaceStencilOp")
object ReplaceStencilOp extends js.Object:
  override def toString(): String = js.native

/**
 * Increments the current stencil buffer value. Clamps to the maximum
 * representable unsigned value.
 */
@js.native
@JSImport("three", "IncrementStencilOp")
object IncrementStencilOp extends js.Object:
  override def toString(): String = js.native

/**
 * Decrements the current stencil buffer value. Clamps to `0`.
 */
@js.native
@JSImport("three", "DecrementStencilOp")
object DecrementStencilOp extends js.Object:
  override def toString(): String = js.native

/**
 * Increments the current stencil buffer value. Wraps stencil buffer value to
 * zero when incrementing the maximum representable unsigned value.
 */
@js.native
@JSImport("three", "IncrementWrapStencilOp")
object IncrementWrapStencilOp extends js.Object:
  override def toString(): String = js.native

/**
 * Decrements the current stencil buffer value. Wraps stencil buffer value to
 * the maximum representable unsigned value when decrementing a stencil buffer
 * value of `0`.
 */
@js.native
@JSImport("three", "DecrementWrapStencilOp")
object DecrementWrapStencilOp extends js.Object:
  override def toString(): String = js.native

/**
 * Inverts the current stencil buffer value bitwise.
 */
@js.native
@JSImport("three", "InvertStencilOp")
object InvertStencilOp extends js.Object:
  override def toString(): String = js.native
