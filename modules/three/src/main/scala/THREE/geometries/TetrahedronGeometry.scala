package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class for generating a tetrahedron geometry. A tetrahedron is a polyhedron
 * with four triangular faces.
 */
@js.native
@JSImport("three", "TetrahedronGeometry")
class TetrahedronGeometry(
  radius: Double = 1,
  detail: Int = 0
) extends PolyhedronGeometry

/**
 * Companion object for TetrahedronGeometry with factory method.
 */
@js.native
@JSImport("three", "TetrahedronGeometry")
object TetrahedronGeometry extends js.Object
