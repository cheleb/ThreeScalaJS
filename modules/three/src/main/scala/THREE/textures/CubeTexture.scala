package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * Represents a texture comprising six images - one for each side of a cube.
 */
@js.native
@JSImport("three", "CubeTexture")
class CubeTexture(
  var images: js.UndefOr[js.Array[js.Any]] = js.undefined,
  mapping: js.UndefOr[Int] = js.undefined,
  wrapS: js.UndefOr[Int] = js.undefined,
  wrapT: js.UndefOr[Int] = js.undefined,
  magFilter: js.UndefOr[Int] = js.undefined,
  minFilter: js.UndefOr[Int] = js.undefined,
  format: js.UndefOr[Int] = js.undefined,
  `type`: js.UndefOr[Int] = js.undefined,
  anisotropy: js.UndefOr[Int] = js.undefined,
  colorSpace: js.UndefOr[String] = js.undefined
) extends Texture(js.Array(), mapping, wrapS, wrapT, magFilter, minFilter, format, `type`, anisotropy, colorSpace) {

  val isCubeTexture: Boolean = js.native

}
