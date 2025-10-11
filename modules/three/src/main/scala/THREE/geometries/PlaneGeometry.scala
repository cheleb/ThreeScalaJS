package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for generating plane geometries.
 */
@js.native
@JSImport("three", "PlaneGeometry")
class PlaneGeometry(
  width: Double = 1,
  height: Double = 1,
  widthSegments: Int = 1,
  heightSegments: Int = 1
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
