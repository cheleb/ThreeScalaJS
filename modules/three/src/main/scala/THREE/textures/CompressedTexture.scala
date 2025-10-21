package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Creates a texture based on data in compressed form.
 *
 * These textures are usually loaded with CompressedTextureLoader.
 */
@js.native
@JSImport("three", "CompressedTexture")
class CompressedTexture(
  mipmaps: js.Array[js.Object],
  width: Int,
  height: Int,
  format: js.UndefOr[Int] = js.undefined,
  tpe: js.UndefOr[Int] = js.undefined,
  mapping: js.UndefOr[Int] = js.undefined,
  wrapS: js.UndefOr[Int] = js.undefined,
  wrapT: js.UndefOr[Int] = js.undefined,
  magFilter: js.UndefOr[Int] = js.undefined,
  minFilter: js.UndefOr[Int] = js.undefined,
  anisotropy: js.UndefOr[Int] = js.undefined,
  colorSpace: js.UndefOr[String] = js.undefined
) extends Texture(null, mapping, wrapS, wrapT, magFilter, minFilter, format, tpe, anisotropy, colorSpace) {

  /**
   * This flag can be used for type testing.
   */
  val isCompressedTexture: Boolean = js.native
}
