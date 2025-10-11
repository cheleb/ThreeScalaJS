package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for generating shape geometries.
 */
@js.native
@JSImport("three", "ShapeGeometry")
class ShapeGeometry(
  shapes: js.Any,
  curveSegments: Int = 12
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
