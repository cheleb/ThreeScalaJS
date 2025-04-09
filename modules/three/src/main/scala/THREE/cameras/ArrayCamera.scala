package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Array of cameras used for multi-viewport rendering.
 */
@js.native
@JSImport("three", "ArrayCamera")
class ArrayCamera(
  var cameras: js.UndefOr[js.Array[PerspectiveCamera]] = js.undefined
) extends PerspectiveCamera {}
