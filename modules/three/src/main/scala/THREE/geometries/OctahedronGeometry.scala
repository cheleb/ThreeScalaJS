package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class for generating an octahedron geometry. An octahedron is a polyhedron
 * with eight triangular faces.
 */
@js.native
@JSImport("three", "OctahedronGeometry")
class OctahedronGeometry(
  radius: Double = 1,
  detail: Int = 0
) extends PolyhedronGeometry {}

/**
 * Companion object for OctahedronGeometry with factory method.
 */
@js.native
@JSImport("three", "OctahedronGeometry")
object OctahedronGeometry extends js.Object
