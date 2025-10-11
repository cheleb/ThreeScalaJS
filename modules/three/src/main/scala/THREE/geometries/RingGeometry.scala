package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for generating ring geometries.
 */
@js.native
@JSImport("three", "RingGeometry")
class RingGeometry(
  innerRadius: Double = 0.5,
  outerRadius: Double = 1,
  thetaSegments: Int = 32,
  phiSegments: Int = 1,
  thetaStart: Double = 0,
  thetaLength: Double = Math.PI * 2
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
