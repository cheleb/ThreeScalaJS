package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * Creates a texture from a canvas element.
 */
@js.native
@JSImport("three", "CanvasTexture")
class CanvasTexture(
  canvas: dom.html.Canvas,
  mapping: js.UndefOr[Int] = js.undefined,
  wrapS: js.UndefOr[Int] = js.undefined,
  wrapT: js.UndefOr[Int] = js.undefined,
  magFilter: js.UndefOr[Int] = js.undefined,
  minFilter: js.UndefOr[Int] = js.undefined,
  format: js.UndefOr[Int] = js.undefined,
  `type`: js.UndefOr[Int] = js.undefined,
  anisotropy: js.UndefOr[Int] = js.undefined
) extends Texture {

  val isCanvasTexture: Boolean = js.native
}
