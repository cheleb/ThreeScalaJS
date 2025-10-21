package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Never pass.
 */
@js.native
@JSImport("three", "NeverCompare")
object NeverCompare extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value is less than the texture value.
 */
@js.native
@JSImport("three", "LessCompare")
object LessCompare extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value equals the texture value.
 */
@js.native
@JSImport("three", "EqualCompare")
object EqualCompare extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value is less than or equal to the texture value.
 */
@js.native
@JSImport("three", "LessEqualCompare")
object LessEqualCompare extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value is greater than the texture value.
 */
@js.native
@JSImport("three", "GreaterCompare")
object GreaterCompare extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value is not equal to the texture value.
 */
@js.native
@JSImport("three", "NotEqualCompare")
object NotEqualCompare extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value is greater than or equal to the texture value.
 */
@js.native
@JSImport("three", "GreaterEqualCompare")
object GreaterEqualCompare extends js.Object:
  override def toString(): String = js.native

/**
 * Always pass.
 */
@js.native
@JSImport("three", "AlwaysCompare")
object AlwaysCompare extends js.Object:
  override def toString(): String = js.native
