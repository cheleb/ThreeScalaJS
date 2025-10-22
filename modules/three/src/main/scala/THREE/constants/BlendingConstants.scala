package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * No blending is performed which effectively disables alpha transparency.
 */
@js.native
@JSImport("three", "NoBlending")
val NoBlending: Int = js.native

/**
 * The default blending.
 */
@js.native
@JSImport("three", "NormalBlending")
val NormalBlending: Int = js.native

/**
 * Represents additive blending.
 */
@js.native
@JSImport("three", "AdditiveBlending")
val AdditiveBlending: Int = js.native

/**
 * Represents subtractive blending.
 */
@js.native
@JSImport("three", "SubtractiveBlending")
val SubtractiveBlending: Int = js.native

/**
 * Represents multiply blending.
 */
@js.native
@JSImport("three", "MultiplyBlending")
val MultiplyBlending: Int = js.native

/**
 * Represents custom blending.
 */
@js.native
@JSImport("three", "CustomBlending")
val CustomBlending: Int = js.native

/**
 * A `source + destination` blending equation.
 */
@js.native
@JSImport("three", "AddEquation")
val AddEquation: Int = js.native

/**
 * A `source - destination` blending equation.
 */
@js.native
@JSImport("three", "SubtractEquation")
val SubtractEquation: Int = js.native

/**
 * A `destination - source` blending equation.
 */
@js.native
@JSImport("three", "ReverseSubtractEquation")
val ReverseSubtractEquation: Int = js.native

/**
 * A blend equation that uses the minimum of source and destination.
 */
@js.native
@JSImport("three", "MinEquation")
val MinEquation: Int = js.native

/**
 * A blend equation that uses the maximum of source and destination.
 */
@js.native
@JSImport("three", "MaxEquation")
val MaxEquation: Int = js.native
