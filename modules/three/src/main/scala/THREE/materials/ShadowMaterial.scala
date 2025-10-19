package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * This material can receive shadows, but otherwise is completely transparent.
 */
@js.native
@JSImport("three", "ShadowMaterial")
class ShadowMaterial(parameters: js.Object = js.Object()) extends Material {

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

  /**
   * Copies the values of the given material instance to this instance.
   */
  override def copy(material: Material): this.type = js.native

  def this() = this(js.Object())
}

/**
 * Companion object for ShadowMaterial with factory method
 */
@js.native
@JSImport("three", "ShadowMaterial")
object ShadowMaterial extends js.Object
