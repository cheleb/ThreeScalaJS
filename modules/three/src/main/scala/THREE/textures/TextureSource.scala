package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Represents the data source of a texture. The main purpose of this class is to
 * decouple the data definition from the texture definition so the same data can
 * be used with multiple texture instances.
 *
 * Renamed from `Source` in r186.
 *
 * @since r186
 */
@js.native
@JSImport("three", "TextureSource")
class TextureSource(var data: js.Any = null) extends js.Object {

  val isTextureSource: Boolean = js.native

  val id: Int      = js.native
  var uuid: String = js.native

  /**
   * Whether the data are ready to be used or not.
   */
  var dataReady: Boolean = js.native

  /**
   * Starts at `0` and counts how many times `needsUpdate` is set to `true`.
   */
  var version: Int = js.native

  /**
   * When set to `true`, the data of this source are uploaded to the GPU again.
   */
  var needsUpdate: Boolean = js.native

  /**
   * Returns the dimensions of the source into the given target vector.
   */
  def getSize(target: Vector2 | Vector3): Vector2 | Vector3 = js.native

  def toJSON(meta: js.UndefOr[js.Object] = js.undefined): js.Object = js.native
}
