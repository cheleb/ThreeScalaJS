package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Multiplies all colors by `0`.
 */
@js.native
@JSImport("three", "ZeroFactor")
object ZeroFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by `1`.
 */
@js.native
@JSImport("three", "OneFactor")
object OneFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by the source colors.
 */
@js.native
@JSImport("three", "SrcColorFactor")
object SrcColorFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by `1` minus each source color.
 */
@js.native
@JSImport("three", "OneMinusSrcColorFactor")
object OneMinusSrcColorFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by the source alpha value.
 */
@js.native
@JSImport("three", "SrcAlphaFactor")
object SrcAlphaFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by 1 minus the source alpha value.
 */
@js.native
@JSImport("three", "OneMinusSrcAlphaFactor")
object OneMinusSrcAlphaFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by the destination alpha value.
 */
@js.native
@JSImport("three", "DstAlphaFactor")
object DstAlphaFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by `1` minus the destination alpha value.
 */
@js.native
@JSImport("three", "OneMinusDstAlphaFactor")
object OneMinusDstAlphaFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by the destination color.
 */
@js.native
@JSImport("three", "DstColorFactor")
object DstColorFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by `1` minus each destination color.
 */
@js.native
@JSImport("three", "OneMinusDstColorFactor")
object OneMinusDstColorFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies the RGB colors by the smaller of either the source alpha value or
 * the value of `1` minus the destination alpha value. The alpha value is
 * multiplied by `1`.
 */
@js.native
@JSImport("three", "SrcAlphaSaturateFactor")
object SrcAlphaSaturateFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by a constant color.
 */
@js.native
@JSImport("three", "ConstantColorFactor")
object ConstantColorFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by `1` minus a constant color.
 */
@js.native
@JSImport("three", "OneMinusConstantColorFactor")
object OneMinusConstantColorFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by a constant alpha value.
 */
@js.native
@JSImport("three", "ConstantAlphaFactor")
object ConstantAlphaFactor extends js.Object:
  override def toString(): String = js.native

/**
 * Multiplies all colors by 1 minus a constant alpha value.
 */
@js.native
@JSImport("three", "OneMinusConstantAlphaFactor")
object OneMinusConstantAlphaFactor extends js.Object:
  override def toString(): String = js.native
