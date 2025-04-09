package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class for generating an icosahedron geometry. An icosahedron is a regular
 * polyhedron with 20 equilateral triangular faces, 30 edges and 12 vertices.
 */
@js.native
@JSImport("three", "IcosahedronGeometry")
class IcosahedronGeometry(
  radius: js.UndefOr[Double] = js.undefined,
  detail: js.UndefOr[Int] = js.undefined
) extends BufferGeometry {

  /**
   * An object with parameters that were used to generate the geometry.
   */
  val parameters: js.Object = js.native
}

/**
 * Companion object for IcosahedronGeometry with factory method.
 */
@js.native
@JSImport("three", "IcosahedronGeometry")
object IcosahedronGeometry extends js.Object
