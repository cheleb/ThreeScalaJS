package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class for generating a dodecahedron geometry. A dodecahedron is a
 * polyhedron with twelve pentagonal faces.
 */
@js.native
@JSImport("three", "DodecahedronGeometry")
class DodecahedronGeometry(
  radius: js.UndefOr[Double] = js.undefined,
  detail: js.UndefOr[Int] = js.undefined
) extends PolyhedronGeometry

/**
 * Companion object for DodecahedronGeometry with factory method.
 */
@js.native
@JSImport("three", "DodecahedronGeometry")
object DodecahedronGeometry extends js.Object
