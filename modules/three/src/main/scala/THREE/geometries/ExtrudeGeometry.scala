package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Creates extruded geometry from a path shape.
 */
@js.native
@JSImport("three", "ExtrudeGeometry")
class ExtrudeGeometry(
  shapes: js.Any, // Shape or Array[Shape]
  options: js.Object = js.Dynamic.literal()
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
