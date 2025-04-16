package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Abstract base class for lights.
 */
@js.native
@JSImport("three", "Light")
class Light(
  var color: Int | String | Color = 0xfffff,
  var intensity: Double = 1.0
) extends Object3D {

  /**
   * Read-only flag to check if a given object is of type Light.
   */
  val isLight: Boolean = js.native

}
