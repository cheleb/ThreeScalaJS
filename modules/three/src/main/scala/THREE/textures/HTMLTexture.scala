package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Creates a texture from an HTML element.
 *
 * This is almost the same as the base texture class, except that it sets [[Texture#needsUpdate]]
 * to `true` immediately and listens for the parent canvas's paint events to trigger updates.
 *
 * @augments Texture
 */
@js.native
@JSImport("three", "HTMLTexture")
class HTMLTexture(
  element: js.UndefOr[js.Any] = js.undefined,
  mapping: js.UndefOr[Int] = js.undefined,
  wrapS: js.UndefOr[Int] = js.undefined,
  wrapT: js.UndefOr[Int] = js.undefined,
  magFilter: js.UndefOr[Int] = js.undefined,
  minFilter: js.UndefOr[Int] = js.undefined,
  format: js.UndefOr[Int] = js.undefined,
  `type`: js.UndefOr[Int] = js.undefined,
  anisotropy: js.UndefOr[Int] = js.undefined
) extends Texture(
  element,
  mapping,
  wrapS,
  wrapT,
  magFilter,
  minFilter,
  format,
  `type`,
  anisotropy
) {

  /**
   * This flag can be used for type testing.
   *
   * @type {boolean}
   * @readonly
   * @default true
   */
  val isHTMLTexture: Boolean = js.native

  /**
   * Releases the internal resources of the texture and removes the paint callback
   * from the parent element.
   */
  override def dispose(): Unit = js.native

}

object HTMLTexture {
  def apply(
    element: js.UndefOr[js.Any] = js.undefined,
    mapping: js.UndefOr[Int] = js.undefined,
    wrapS: js.UndefOr[Int] = js.undefined,
    wrapT: js.UndefOr[Int] = js.undefined,
    magFilter: js.UndefOr[Int] = js.undefined,
    minFilter: js.UndefOr[Int] = js.undefined,
    format: js.UndefOr[Int] = js.undefined,
    `type`: js.UndefOr[Int] = js.undefined,
    anisotropy: js.UndefOr[Int] = js.undefined
  ): HTMLTexture = new HTMLTexture(element, mapping, wrapS, wrapT, magFilter, minFilter, format, `type`, anisotropy)
}
