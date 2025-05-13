package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * This light globally illuminates all objects in the scene equally. It cannot
 * be used to cast shadows as it does not have a direction.
 *
 * ```scala
 * val light = new AmbientLight(0x404040) // soft white light
 * scene.add(light)
 * ```
 */
@js.native
@JSImport("three", "AmbientLight")
class AmbientLight(
  color: Int | String | Color = 0xffffff,
  intensity: Double = 1.0
) extends Light {

  /**
   * Read-only flag to check if a given object is of type AmbientLight.
   */
  val isAmbientLight: Boolean = js.native
}

/**
 * Companion object for AmbientLight with factory method
 */
@js.native
@JSImport("three", "AmbientLight")
object AmbientLight extends js.Object
