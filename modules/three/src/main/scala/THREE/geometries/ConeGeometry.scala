package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for generating cone geometries.
 */
@js.native
@JSImport("three", "ConeGeometry")
class ConeGeometry(
  radius: Double = 1,
  height: Double = 1,
  radialSegments: Int = 32,
  heightSegments: Int = 1,
  openEnded: Boolean = false,
  thetaStart: Double = 0,
  thetaLength: Double = Math.PI * 2
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
