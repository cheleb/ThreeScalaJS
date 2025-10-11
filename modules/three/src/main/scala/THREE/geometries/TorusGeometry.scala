package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for generating torus geometries.
 */
@js.native
@JSImport("three", "TorusGeometry")
class TorusGeometry(
  radius: Double = 1,
  tube: Double = 0.4,
  radialSegments: Int = 32,
  tubularSegments: Int = 8,
  arc: Double = Math.PI * 2
) extends BufferGeometry {

  val parameters: js.Object = js.native
}
