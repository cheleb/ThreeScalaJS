package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class for generating text as a single geometry. It is constructed by
 * providing a string of text, and a set of parameters consisting of a loaded
 * font and extrude settings.
 */
@js.native
@JSImport("three", "TextGeometry")
class TextGeometry(
  text: String,
  parameters: js.Object = js.Dynamic.literal()
) extends js.Object {

  val geometryType: String = js.native
}
