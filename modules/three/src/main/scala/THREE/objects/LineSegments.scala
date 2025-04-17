package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A series of lines drawn between pairs of vertices.
 *
 * This is nearly the same as Line; the only difference is that it is rendered
 * using gl.LINES instead of gl.LINE_STRIP.
 */
@js.native
@JSImport("three", "LineSegments")
class LineSegments extends Line {

  /**
   * This flag can be used for type testing.
   */
  val isLineSegments: Boolean = js.native
}

/**
 * Companion object for LineSegments class
 */
@js.native
@JSImport("three", "LineSegments")
object LineSegments extends js.Object
