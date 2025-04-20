package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Creates a texture from a canvas element.
 */
@js.native
@JSImport("three", "CanvasTexture")
class CanvasTexture(
  canvas: js.Any,
  mapping: js.UndefOr[Int] = js.undefined,
  wrapS: js.UndefOr[Int] = js.undefined,
  wrapT: js.UndefOr[Int] = js.undefined,
  magFilter: js.UndefOr[Int] = js.undefined,
  minFilter: js.UndefOr[Int] = js.undefined,
  format: js.UndefOr[Int] = js.undefined,
  tpe: js.UndefOr[Int] = js.undefined,
  anisotropy: js.UndefOr[Int] = js.undefined
) extends Texture {

  /**
   * This flag can be used for type testing.
   */
  val isCanvasTexture: Boolean = js.native
}
