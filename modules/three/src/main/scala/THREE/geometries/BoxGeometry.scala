package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for generating rectangular cuboid geometries.
 */
@js.native
@JSImport("three", "BoxGeometry")
class BoxGeometry(
  width: js.UndefOr[Double] = js.undefined,
  height: js.UndefOr[Double] = js.undefined,
  depth: js.UndefOr[Double] = js.undefined,
  widthSegments: js.UndefOr[Int] = js.undefined,
  heightSegments: js.UndefOr[Int] = js.undefined,
  depthSegments: js.UndefOr[Int] = js.undefined
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
