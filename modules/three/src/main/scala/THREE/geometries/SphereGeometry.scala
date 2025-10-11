package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for generating sphere geometries.
 */
@js.native
@JSImport("three", "SphereGeometry")
class SphereGeometry(
  radius: Double = 1,
  widthSegments: Int = 32,
  heightSegments: Int = 16,
  phiStart: Double = 0,
  phiLength: Double = Math.PI * 2,
  thetaStart: Double = 0,
  thetaLength: Double = Math.PI
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
