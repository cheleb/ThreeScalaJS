package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Never pass.
 */
@js.native
@JSImport("three", "NeverCompare")
val NeverCompare: Int = js.native

/**
 * Pass if the incoming value is less than the texture value.
 */
@js.native
@JSImport("three", "LessCompare")
val LessCompare: Int = js.native

/**
 * Pass if the incoming value equals the texture value.
 */
@js.native
@JSImport("three", "EqualCompare")
val EqualCompare: Int = js.native

/**
 * Pass if the incoming value is less than or equal to the texture value.
 */
@js.native
@JSImport("three", "LessEqualCompare")
val LessEqualCompare: Int = js.native

/**
 * Pass if the incoming value is greater than the texture value.
 */
@js.native
@JSImport("three", "GreaterCompare")
val GreaterCompare: Int = js.native

/**
 * Pass if the incoming value is not equal to the texture value.
 */
@js.native
@JSImport("three", "NotEqualCompare")
val NotEqualCompare: Int = js.native

/**
 * Pass if the incoming value is greater than or equal to the texture value.
 */
@js.native
@JSImport("three", "GreaterEqualCompare")
val GreaterEqualCompare: Int = js.native

/**
 * Always pass.
 */
@js.native
@JSImport("three", "AlwaysCompare")
val AlwaysCompare: Int = js.native
