package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Array of cameras used for multi-viewport rendering.
 */
@js.native
@JSImport("three", "ArrayCamera")
class ArrayCamera(
  var cameras: js.Array[PerspectiveCamera] = js.Array()
) extends PerspectiveCamera {}
