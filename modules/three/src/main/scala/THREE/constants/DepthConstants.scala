package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Never pass.
 */
@js.native
@JSImport("three", "NeverDepth")
object NeverDepth extends js.Object:
  override def toString(): String = js.native

/**
 * Always pass.
 */
@js.native
@JSImport("three", "AlwaysDepth")
object AlwaysDepth extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value is less than the depth buffer value.
 */
@js.native
@JSImport("three", "LessDepth")
object LessDepth extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value is less than or equal to the depth buffer value.
 */
@js.native
@JSImport("three", "LessEqualDepth")
object LessEqualDepth extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value equals the depth buffer value.
 */
@js.native
@JSImport("three", "EqualDepth")
object EqualDepth extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value is greater than or equal to the depth buffer
 * value.
 */
@js.native
@JSImport("three", "GreaterEqualDepth")
object GreaterEqualDepth extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value is greater than the depth buffer value.
 */
@js.native
@JSImport("three", "GreaterDepth")
object GreaterDepth extends js.Object:
  override def toString(): String = js.native

/**
 * Pass if the incoming value is not equal to the depth buffer value.
 */
@js.native
@JSImport("three", "NotEqualDepth")
object NotEqualDepth extends js.Object:
  override def toString(): String = js.native
