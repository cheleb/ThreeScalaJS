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
  radius: Double = 1,
  detail: Int = 0
) extends PolyhedronGeometry

/**
 * Companion object for DodecahedronGeometry with factory method.
 */
@js.native
@JSImport("three", "DodecahedronGeometry")
object DodecahedronGeometry extends js.Object
