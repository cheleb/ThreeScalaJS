package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Creates meshes with axial symmetry like vases. The lathe rotates around the Y
 * axis.
 */
@js.native
@JSImport("three", "LatheGeometry")
class LatheGeometry(
  points: js.Array[Vector2] = js.Array(new Vector2(0, -0.5), new Vector2(0.5, 0), new Vector2(0, 0.5)),
  segments: Int = 12,
  phiStart: Double = 0,
  phiLength: Double = Math.PI * 2
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
