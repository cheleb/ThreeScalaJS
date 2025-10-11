package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * LensFlareElement represents a single element in a lens flare effect. Each
 * element can have its own texture, size, distance from the light source, and
 * color.
 */
@js.native
@JSImport("three/addons/objects/Lensflare.js", "LensflareElement")
class LensflareElement(
  var texture: js.UndefOr[Texture] = js.undefined,
  var size: js.UndefOr[Double] = js.undefined,
  var distance: js.UndefOr[Double] = js.undefined,
  var color: js.UndefOr[Color] = js.undefined
) extends js.Object
