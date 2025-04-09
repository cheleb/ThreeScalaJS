package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.typedarray.TypedArray

/**
 * Creates a texture directly from raw data, width and height.
 */
@js.native
@JSImport("three", "DataTexture")
class DataTexture(
  data: TypedArray[?, ?],
  width: Int,
  height: Int,
  format: js.UndefOr[Int] = js.undefined,
  `type`: js.UndefOr[Int] = js.undefined,
  mapping: js.UndefOr[Int] = js.undefined,
  wrapS: js.UndefOr[Int] = js.undefined,
  wrapT: js.UndefOr[Int] = js.undefined,
  magFilter: js.UndefOr[Int] = js.undefined,
  minFilter: js.UndefOr[Int] = js.undefined,
  anisotropy: js.UndefOr[Int] = js.undefined,
  colorSpace: js.UndefOr[String] = js.undefined
) extends Texture {

  val isDataTexture: Boolean = js.native
}
