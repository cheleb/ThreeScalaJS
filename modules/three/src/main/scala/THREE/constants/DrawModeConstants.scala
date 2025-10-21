package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * For every three vertices draw a single triangle.
 */
@js.native
@JSImport("three", "TrianglesDrawMode")
object TrianglesDrawMode extends js.Object:
  override def toString(): String = js.native

/**
 * For each vertex draw a triangle from the last three vertices.
 */
@js.native
@JSImport("three", "TriangleStripDrawMode")
object TriangleStripDrawMode extends js.Object:
  override def toString(): String = js.native

/**
 * For each vertex draw a triangle from the first vertex and the last two
 * vertices.
 */
@js.native
@JSImport("three", "TriangleFanDrawMode")
object TriangleFanDrawMode extends js.Object:
  override def toString(): String = js.native
