package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Will never return true.
 */
@js.native
@JSImport("three", "NeverStencilFunc")
object NeverStencilFunc extends js.Object:
  override def toString(): String = js.native

/**
 * Will return true if the stencil reference value is less than the current
 * stencil value.
 */
@js.native
@JSImport("three", "LessStencilFunc")
object LessStencilFunc extends js.Object:
  override def toString(): String = js.native

/**
 * Will return true if the stencil reference value is equal to the current
 * stencil value.
 */
@js.native
@JSImport("three", "EqualStencilFunc")
object EqualStencilFunc extends js.Object:
  override def toString(): String = js.native

/**
 * Will return true if the stencil reference value is less than or equal to the
 * current stencil value.
 */
@js.native
@JSImport("three", "LessEqualStencilFunc")
object LessEqualStencilFunc extends js.Object:
  override def toString(): String = js.native

/**
 * Will return true if the stencil reference value is greater than the current
 * stencil value.
 */
@js.native
@JSImport("three", "GreaterStencilFunc")
object GreaterStencilFunc extends js.Object:
  override def toString(): String = js.native

/**
 * Will return true if the stencil reference value is not equal to the current
 * stencil value.
 */
@js.native
@JSImport("three", "NotEqualStencilFunc")
object NotEqualStencilFunc extends js.Object:
  override def toString(): String = js.native

/**
 * Will return true if the stencil reference value is greater than or equal to
 * the current stencil value.
 */
@js.native
@JSImport("three", "GreaterEqualStencilFunc")
object GreaterEqualStencilFunc extends js.Object:
  override def toString(): String = js.native

/**
 * Will always return true.
 */
@js.native
@JSImport("three", "AlwaysStencilFunc")
object AlwaysStencilFunc extends js.Object:
  override def toString(): String = js.native
