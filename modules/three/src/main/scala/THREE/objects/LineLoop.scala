package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A continuous line that connects back to the start.
 *
 * This is nearly the same as Line; the only difference is that it is rendered
 * using gl.LINE_LOOP instead of gl.LINE_STRIP, which draws a straight line to
 * the next vertex, and connects the last vertex back to the first.
 */
@js.native
@JSImport("three", "LineLoop")
class LineLoop extends Line {

  /**
   * This flag can be used for type testing.
   */
  val isLineLoop: Boolean = js.native
}

/**
 * Companion object for LineLoop class
 */
@js.native
@JSImport("three", "LineLoop")
object LineLoop extends js.Object
