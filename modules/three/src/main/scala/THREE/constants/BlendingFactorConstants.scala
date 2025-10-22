package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Multiplies all colors by `0`.
 */
@js.native
@JSImport("three", "ZeroFactor")
val ZeroFactor: Int = js.native

/**
 * Multiplies all colors by `1`.
 */
@js.native
@JSImport("three", "OneFactor")
val OneFactor: Int = js.native

/**
 * Multiplies all colors by the source colors.
 */
@js.native
@JSImport("three", "SrcColorFactor")
val SrcColorFactor: Int = js.native

/**
 * Multiplies all colors by `1` minus each source color.
 */
@js.native
@JSImport("three", "OneMinusSrcColorFactor")
val OneMinusSrcColorFactor: Int = js.native

/**
 * Multiplies all colors by the source alpha value.
 */
@js.native
@JSImport("three", "SrcAlphaFactor")
val SrcAlphaFactor: Int = js.native

/**
 * Multiplies all colors by 1 minus the source alpha value.
 */
@js.native
@JSImport("three", "OneMinusSrcAlphaFactor")
val OneMinusSrcAlphaFactor: Int = js.native

/**
 * Multiplies all colors by the destination alpha value.
 */
@js.native
@JSImport("three", "DstAlphaFactor")
val DstAlphaFactor: Int = js.native

/**
 * Multiplies all colors by `1` minus the destination alpha value.
 */
@js.native
@JSImport("three", "OneMinusDstAlphaFactor")
val OneMinusDstAlphaFactor: Int = js.native

/**
 * Multiplies all colors by the destination color.
 */
@js.native
@JSImport("three", "DstColorFactor")
val DstColorFactor: Int = js.native

/**
 * Multiplies all colors by `1` minus each destination color.
 */
@js.native
@JSImport("three", "OneMinusDstColorFactor")
val OneMinusDstColorFactor: Int = js.native

/**
 * Multiplies the RGB colors by the smaller of either the source alpha value or
 * the value of `1` minus the destination alpha value. The alpha value is
 * multiplied by `1`.
 */
@js.native
@JSImport("three", "SrcAlphaSaturateFactor")
val SrcAlphaSaturateFactor: Int = js.native

/**
 * Multiplies all colors by a constant color.
 */
@js.native
@JSImport("three", "ConstantColorFactor")
val ConstantColorFactor: Int = js.native

/**
 * Multiplies all colors by `1` minus a constant color.
 */
@js.native
@JSImport("three", "OneMinusConstantColorFactor")
val OneMinusConstantColorFactor: Int = js.native

/**
 * Multiplies all colors by a constant alpha value.
 */
@js.native
@JSImport("three", "ConstantAlphaFactor")
val ConstantAlphaFactor: Int = js.native

/**
 * Multiplies all colors by 1 minus a constant alpha value.
 */
@js.native
@JSImport("three", "OneMinusConstantAlphaFactor")
val OneMinusConstantAlphaFactor: Int = js.native
