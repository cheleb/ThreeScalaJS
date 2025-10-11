package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for generating circle geometries.
 */
@js.native
@JSImport("three", "CircleGeometry")
class CircleGeometry(
  radius: Double = 1,
  segments: Int = 32,
  thetaStart: Double = 0,
  thetaLength: Double = Math.PI * 2
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
