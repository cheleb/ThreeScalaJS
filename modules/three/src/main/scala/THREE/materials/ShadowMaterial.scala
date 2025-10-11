package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * This material can receive shadows, but otherwise is completely transparent.
 */
@js.native
@JSImport("three", "ShadowMaterial")
class ShadowMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isShadowMaterial: Boolean = js.native

  /**
   * Color of the material.
   */
  var color: Color = js.native

  /**
   * Whether the material is affected by fog or not.
   */
  var fog: Boolean = js.native
}

// Manual customization of the constructor
object ShadowMaterial:

  def apply(
    color: Int = 0x000000,
    transparent: Boolean = true,
    fog: Boolean = true
  ) =
    new ShadowMaterial(
      js.Dynamic.literal(
        color = color,
        transparent = transparent,
        fog = fog
      )
    )
