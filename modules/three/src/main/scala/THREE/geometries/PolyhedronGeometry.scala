package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class for generating a polyhedron geometry.
 */
@js.native
@JSImport("three", "PolyhedronGeometry")
class PolyhedronGeometry(
  vertices: js.Array[Double] = js.Array(),
  indices: js.Array[Double] = js.Array(),
  radius: Double = 1,
  detail: Int = 0
) extends BufferGeometry {

  /**
   * An object with parameters that were used to generate the geometry.
   */
  val parameters: js.Object = js.native
}

/**
 * Companion object for PolyhedronGeometry with factory method.
 */
@js.native
@JSImport("three", "PolyhedronGeometry")
object PolyhedronGeometry extends js.Object
