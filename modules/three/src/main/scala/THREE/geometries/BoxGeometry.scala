package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for generating rectangular cuboid geometries.
 */
@js.native
@JSImport("three", "BoxGeometry")
class BoxGeometry(
  width: Double = 1,
  height: Double = 1,
  depth: Double = 1,
  widthSegments: Int = 1,
  heightSegments: Int = 1,
  depthSegments: Int = 1
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
