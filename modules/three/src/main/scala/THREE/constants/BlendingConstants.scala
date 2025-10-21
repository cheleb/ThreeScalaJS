package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * No blending is performed which effectively disables alpha transparency.
 */
@js.native
@JSImport("three", "NoBlending")
object NoBlending extends js.Object:
  override def toString(): String = js.native

/**
 * The default blending.
 */
@js.native
@JSImport("three", "NormalBlending")
object NormalBlending extends js.Object:
  override def toString(): String = js.native

/**
 * Represents additive blending.
 */
@js.native
@JSImport("three", "AdditiveBlending")
object AdditiveBlending extends js.Object:
  override def toString(): String = js.native

/**
 * Represents subtractive blending.
 */
@js.native
@JSImport("three", "SubtractiveBlending")
object SubtractiveBlending extends js.Object:
  override def toString(): String = js.native

/**
 * Represents multiply blending.
 */
@js.native
@JSImport("three", "MultiplyBlending")
object MultiplyBlending extends js.Object:
  override def toString(): String = js.native

/**
 * Represents custom blending.
 */
@js.native
@JSImport("three", "CustomBlending")
object CustomBlending extends js.Object:
  override def toString(): String = js.native

/**
 * A `source + destination` blending equation.
 */
@js.native
@JSImport("three", "AddEquation")
object AddEquation extends js.Object:
  override def toString(): String = js.native

/**
 * A `source - destination` blending equation.
 */
@js.native
@JSImport("three", "SubtractEquation")
object SubtractEquation extends js.Object:
  override def toString(): String = js.native

/**
 * A `destination - source` blending equation.
 */
@js.native
@JSImport("three", "ReverseSubtractEquation")
object ReverseSubtractEquation extends js.Object:
  override def toString(): String = js.native

/**
 * A blend equation that uses the minimum of source and destination.
 */
@js.native
@JSImport("three", "MinEquation")
object MinEquation extends js.Object:
  override def toString(): String = js.native

/**
 * A blend equation that uses the maximum of source and destination.
 */
@js.native
@JSImport("three", "MaxEquation")
object MaxEquation extends js.Object:
  override def toString(): String = js.native
