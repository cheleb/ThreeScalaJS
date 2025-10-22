package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Discards the red, green and blue components and reads just the alpha
 * component.
 */
@js.native
@JSImport("three", "AlphaFormat")
val AlphaFormat: Int = js.native

/**
 * Discards the alpha component and reads the red, green and blue component.
 */
@js.native
@JSImport("three", "RGBFormat")
val RGBFormat: Int = js.native

/**
 * Reads the red, green, blue and alpha components.
 */
@js.native
@JSImport("three", "RGBAFormat")
val RGBAFormat: Int = js.native

/**
 * Reads each element as a single depth value, converts it to floating point,
 * and clamps to the range `[0,1]`.
 */
@js.native
@JSImport("three", "DepthFormat")
val DepthFormat: Int = js.native

/**
 * Reads each element is a pair of depth and stencil values. The depth component
 * of the pair is interpreted as in `DepthFormat`. The stencil component is
 * interpreted based on the depth + stencil internal format.
 */
@js.native
@JSImport("three", "DepthStencilFormat")
val DepthStencilFormat: Int = js.native

/**
 * Discards the green, blue and alpha components and reads just the red
 * component.
 */
@js.native
@JSImport("three", "RedFormat")
val RedFormat: Int = js.native

/**
 * Discards the green, blue and alpha components and reads just the red
 * component. The texels are read as integers instead of floating point.
 */
@js.native
@JSImport("three", "RedIntegerFormat")
val RedIntegerFormat: Int = js.native

/**
 * Discards the alpha, and blue components and reads the red, and green
 * components.
 */
@js.native
@JSImport("three", "RGFormat")
val RGFormat: Int = js.native

/**
 * Discards the alpha, and blue components and reads the red, and green
 * components. The texels are read as integers instead of floating point.
 */
@js.native
@JSImport("three", "RGIntegerFormat")
val RGIntegerFormat: Int = js.native

/**
 * Discards the alpha component and reads the red, green and blue component. The
 * texels are read as integers instead of floating point.
 */
@js.native
@JSImport("three", "RGBIntegerFormat")
val RGBIntegerFormat: Int = js.native

/**
 * Reads the red, green, blue and alpha components. The texels are read as
 * integers instead of floating point.
 */
@js.native
@JSImport("three", "RGBAIntegerFormat")
val RGBAIntegerFormat: Int = js.native
