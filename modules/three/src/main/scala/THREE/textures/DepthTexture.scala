package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|

/**
 * This class can be used to automatically save the depth information of a
 * rendering into a texture.
 */
@js.native
@JSImport("three", "DepthTexture")
class DepthTexture(
  width: Double,
  height: Double,
  tpe: js.UndefOr[Int] = js.undefined,
  mapping: js.UndefOr[Int] = js.undefined,
  wrapS: js.UndefOr[Int] = js.undefined,
  wrapT: js.UndefOr[Int] = js.undefined,
  magFilter: js.UndefOr[Int] = js.undefined,
  minFilter: js.UndefOr[Int] = js.undefined,
  anisotropy: js.UndefOr[Int] = js.undefined,
  format: js.UndefOr[Int] = js.undefined,
  depth: js.UndefOr[Int] = js.undefined
) extends Texture {

  /**
   * This flag can be used for type testing.
   */
  val isDepthTexture: Boolean = js.native

  /**
   * Code corresponding to the depth compare function.
   */
  var compareFunction: js.UndefOr[Int] = js.native

  @JSName("clone")
  override def jsClone(): DepthTexture = js.native

  override def copy(source: Texture): this.type   = js.native
  override def toJSON(meta: js.Object): js.Object = js.native
}
