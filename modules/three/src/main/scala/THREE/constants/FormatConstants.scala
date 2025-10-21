package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Discards the red, green and blue components and reads just the alpha
 * component.
 */
@js.native
@JSImport("three", "AlphaFormat")
object AlphaFormat extends js.Object:
  override def toString(): String = js.native

/**
 * Discards the alpha component and reads the red, green and blue component.
 */
@js.native
@JSImport("three", "RGBFormat")
object RGBFormat extends js.Object:
  override def toString(): String = js.native

/**
 * Reads the red, green, blue and alpha components.
 */
@js.native
@JSImport("three", "RGBAFormat")
object RGBAFormat extends js.Object:
  override def toString(): String = js.native

/**
 * Reads each element as a single depth value, converts it to floating point,
 * and clamps to the range `[0,1]`.
 */
@js.native
@JSImport("three", "DepthFormat")
object DepthFormat extends js.Object:
  override def toString(): String = js.native

/**
 * Reads each element is a pair of depth and stencil values. The depth component
 * of the pair is interpreted as in `DepthFormat`. The stencil component is
 * interpreted based on the depth + stencil internal format.
 */
@js.native
@JSImport("three", "DepthStencilFormat")
object DepthStencilFormat extends js.Object:
  override def toString(): String = js.native

/**
 * Discards the green, blue and alpha components and reads just the red
 * component.
 */
@js.native
@JSImport("three", "RedFormat")
object RedFormat extends js.Object:
  override def toString(): String = js.native

/**
 * Discards the green, blue and alpha components and reads just the red
 * component. The texels are read as integers instead of floating point.
 */
@js.native
@JSImport("three", "RedIntegerFormat")
object RedIntegerFormat extends js.Object:
  override def toString(): String = js.native

/**
 * Discards the alpha, and blue components and reads the red, and green
 * components.
 */
@js.native
@JSImport("three", "RGFormat")
object RGFormat extends js.Object:
  override def toString(): String = js.native

/**
 * Discards the alpha, and blue components and reads the red, and green
 * components. The texels are read as integers instead of floating point.
 */
@js.native
@JSImport("three", "RGIntegerFormat")
object RGIntegerFormat extends js.Object:
  override def toString(): String = js.native

/**
 * Discards the alpha component and reads the red, green and blue component. The
 * texels are read as integers instead of floating point.
 */
@js.native
@JSImport("three", "RGBIntegerFormat")
object RGBIntegerFormat extends js.Object:
  override def toString(): String = js.native

/**
 * Reads the red, green, blue and alpha components. The texels are read as
 * integers instead of floating point.
 */
@js.native
@JSImport("three", "RGBAIntegerFormat")
object RGBAIntegerFormat extends js.Object:
  override def toString(): String = js.native
