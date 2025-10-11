package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for generating cylinder geometries.
 */
@js.native
@JSImport("three", "CylinderGeometry")
class CylinderGeometry(
  radiusTop: Double = 1,
  radiusBottom: Double = 1,
  height: Double = 1,
  radialSegments: Int = 32,
  heightSegments: Int = 1,
  openEnded: Boolean = false,
  thetaStart: Double = 0,
  thetaLength: Double = Math.PI * 2
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
