package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Materials for sprites.
 */
@js.native
@JSImport("three", "SpriteMaterial")
class SpriteMaterial(parameters: js.UndefOr[js.Any] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isSpriteMaterial: Boolean = js.native

  /**
   * The texture map. Default is null.
   */
  var map: js.UndefOr[Texture] = js.native

  /**
   * Alpha map is a grayscale texture that controls the opacity across the
   * surface. Default is null.
   */
  var alphaMap: js.UndefOr[Texture] = js.native

  /**
   * The material's color. Default is white (0xffffff).
   */
  var color: Color = js.native

  /**
   * Whether the material is affected by fog. Default is true.
   */
  var fog: Boolean = js.native

  /**
   * Whether the size of the sprite is attenuated by the camera depth.
   * (Perspective camera only.) Default is true.
   */
  var sizeAttenuation: Boolean = js.native

  /**
   * Whether the material is affected by lights. Default is false.
   */
  var lights: Boolean = js.native

}
