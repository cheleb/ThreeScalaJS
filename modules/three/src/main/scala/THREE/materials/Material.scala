package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Abstract base class for materials.
 */
@js.native
@JSImport("three", "Material")
class Material extends js.Object {

  val id: Int        = js.native
  val uuid: String   = js.native
  var name: String   = js.native
  val `type`: String = js.native

  var opacity: Double      = js.native
  var transparent: Boolean = js.native

  var blending: Int         = js.native
  var side: Int             = js.native
  var vertexColors: Boolean = js.native

  var depthTest: Boolean  = js.native
  var depthWrite: Boolean = js.native

  var stencilWrite: Boolean = js.native

  var precision: js.UndefOr[String] = js.native
  var polygonOffset: Boolean        = js.native
  var polygonOffsetFactor: Double   = js.native
  var polygonOffsetUnits: Double    = js.native

  var alphaTest: Double        = js.native
  var alphaToCoverage: Boolean = js.native

  var premultipliedAlpha: Boolean = js.native

  var visible: Boolean    = js.native
  var toneMapped: Boolean = js.native

  var userData: js.Object = js.native

  var version: Int = js.native

  @JSName("clone")
  def jsClone(): this.type                = js.native
  def copy(material: Material): this.type = js.native

  def dispose(): Unit = js.native

  def onBeforeCompile(shader: js.Object): Unit = js.native
  def customProgramCacheKey(): String          = js.native

  def setValues(values: js.Object): Unit = js.native
}
