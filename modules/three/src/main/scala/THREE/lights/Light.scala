package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Abstract base class for lights.
 */
@js.native
@JSImport("three", "Light")
class Light(
  var color: js.UndefOr[Int | String | Color] = js.undefined,
  var intensity: js.UndefOr[Double] = js.undefined
) extends Object3D {

  /**
   * Read-only flag to check if a given object is of type Light.
   */
  val isLight: Boolean = js.native

}
