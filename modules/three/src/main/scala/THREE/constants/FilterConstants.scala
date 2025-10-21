package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Returns the value of the texture element that is nearest (in Manhattan
 * distance) to the specified texture coordinates.
 */
@js.native
@JSImport("three", "NearestFilter")
object NearestFilter extends js.Object:
  override def toString(): String = js.native

/**
 * Chooses the mipmap that most closely matches the size of the pixel being
 * textured and uses the `NearestFilter` criterion (the texel nearest to the
 * center of the pixel) to produce a texture value.
 */
@js.native
@JSImport("three", "NearestMipmapNearestFilter")
object NearestMipmapNearestFilter extends js.Object:
  override def toString(): String = js.native

/**
 * Chooses the two mipmaps that most closely match the size of the pixel being
 * textured and uses the `NearestFilter` criterion to produce a texture value
 * from each mipmap. The final texture value is a weighted average of those two
 * values.
 */
@js.native
@JSImport("three", "NearestMipmapLinearFilter")
object NearestMipmapLinearFilter extends js.Object:
  override def toString(): String = js.native

/**
 * Returns the weighted average of the four texture elements that are closest to
 * the specified texture coordinates, and can include items wrapped or repeated
 * from other parts of a texture, depending on the values of `wrapS` and
 * `wrapT`, and on the exact mapping.
 */
@js.native
@JSImport("three", "LinearFilter")
object LinearFilter extends js.Object:
  override def toString(): String = js.native

/**
 * Chooses the mipmap that most closely matches the size of the pixel being
 * textured and uses the `LinearFilter` criterion (a weighted average of the
 * four texels that are closest to the center of the pixel) to produce a texture
 * value.
 */
@js.native
@JSImport("three", "LinearMipmapNearestFilter")
object LinearMipmapNearestFilter extends js.Object:
  override def toString(): String = js.native

/**
 * Chooses the two mipmaps that most closely match the size of the pixel being
 * textured and uses the `LinearFilter` criterion to produce a texture value
 * from each mipmap. The final texture value is a weighted average of those two
 * values.
 */
@js.native
@JSImport("three", "LinearMipmapLinearFilter")
object LinearMipmapLinearFilter extends js.Object:
  override def toString(): String = js.native
