package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * Base class for textures in THREE.js.
 */
@js.native
@JSImport("three", "Texture")
class Texture(
  var image: js.UndefOr[js.Any] = js.undefined,
  var mapping: js.UndefOr[Int] = js.undefined,
  var wrapS: js.UndefOr[Int] = js.undefined,
  var wrapT: js.UndefOr[Int] = js.undefined,
  var magFilter: js.UndefOr[Int] = js.undefined,
  var minFilter: js.UndefOr[Int] = js.undefined,
  var format: js.UndefOr[Int] = js.undefined,
  var `type`: js.UndefOr[Int] = js.undefined,
  var anisotropy: js.UndefOr[Int] = js.undefined,
  var colorSpace: js.UndefOr[String] = js.undefined
) extends js.Object {

  val id: Int      = js.native
  val uuid: String = js.native
  val name: String = js.native

  var offset: Vector2  = js.native
  var repeat: Vector2  = js.native
  var center: Vector2  = js.native
  var rotation: Double = js.native

  var matrixAutoUpdate: Boolean = js.native
  var matrix: Matrix3           = js.native

  var generateMipmaps: Boolean  = js.native
  var premultiplyAlpha: Boolean = js.native
  var flipY: Boolean            = js.native

  var version: Int         = js.native
  var needsUpdate: Boolean = js.native

  val isTexture: Boolean = js.native

  def updateMatrix(): Unit              = js.native
  def transformUv(uv: Vector2): Vector2 = js.native

  @JSName("clone")
  def jsClone(): Texture = js.native

  def copy(source: Texture): this.type   = js.native
  def toJSON(meta: js.Object): js.Object = js.native

  def dispose(): Unit = js.native
}
