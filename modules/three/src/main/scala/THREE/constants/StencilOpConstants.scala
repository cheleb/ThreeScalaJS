package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Sets the stencil buffer value to `0`.
 */
@js.native
@JSGlobal("THREE.ZeroStencilOp")
val ZeroStencilOp: Int = js.native

/**
 * Keeps the current value.
 */
@js.native
@JSGlobal("THREE.KeepStencilOp")
val KeepStencilOp: Int = js.native

/**
 * Sets the stencil buffer value to the specified reference value.
 */
@js.native
@JSGlobal("THREE.ReplaceStencilOp")
val ReplaceStencilOp: Int = js.native

/**
 * Increments the current stencil buffer value. Clamps to the maximum
 * representable unsigned value.
 */
@js.native
@JSGlobal("THREE.IncrementStencilOp")
val IncrementStencilOp: Int = js.native

/**
 * Decrements the current stencil buffer value. Clamps to `0`.
 */
@js.native
@JSGlobal("THREE.DecrementStencilOp")
val DecrementStencilOp: Int = js.native

/**
 * Increments the current stencil buffer value. Wraps stencil buffer value to
 * zero when incrementing the maximum representable unsigned value.
 */
@js.native
@JSGlobal("THREE.IncrementWrapStencilOp")
val IncrementWrapStencilOp: Int = js.native

/**
 * Decrements the current stencil buffer value. Wraps stencil buffer value to
 * the maximum representable unsigned value when decrementing a stencil buffer
 * value of `0`.
 */
@js.native
@JSGlobal("THREE.DecrementWrapStencilOp")
val DecrementWrapStencilOp: Int = js.native

/**
 * Inverts the current stencil buffer value bitwise.
 */
@js.native
@JSGlobal("THREE.InvertStencilOp")
val InvertStencilOp: Int = js.native
