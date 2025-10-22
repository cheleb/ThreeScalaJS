package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * For every three vertices draw a single triangle.
 */
@js.native
@JSGlobal("THREE.TrianglesDrawMode")
val TrianglesDrawMode: Int = js.native

/**
 * For each vertex draw a triangle from the last three vertices.
 */
@js.native
@JSGlobal("THREE.TriangleStripDrawMode")
val TriangleStripDrawMode: Int = js.native

/**
 * For each vertex draw a triangle from the first vertex and the last two
 * vertices.
 */
@js.native
@JSGlobal("THREE.TriangleFanDrawMode")
val TriangleFanDrawMode: Int = js.native
