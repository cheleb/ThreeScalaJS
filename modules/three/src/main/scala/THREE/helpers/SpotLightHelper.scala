package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Helper object to assist with visualizing a {@link SpotLight}'s effect on the
 * scene. This consists of a cone representing the light's position and
 * direction.
 *
 * @example
 *   ```scala
 *   val light = new SpotLight(0xffffff)
 *   light.position.set(10, 10, 10)
 *   scene.add(light)
 *
 *   val helper = new SpotLightHelper(light)
 *   scene.add(helper)
 *   ```
 */
@js.native
@JSImport("three", "SpotLightHelper")
class SpotLightHelper(
  /** The light to be visualized. */
  var light: SpotLight = js.native,
  /**
   * The helper's color. If not set, the helper will take the color of the
   * light.
   */
  color: Int | String | Color = js.native
) extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isSpotLightHelper: Boolean = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * Contains the cone showing the location and direction of the spot light.
   */
  val cone: LineSegments = js.native

  /**
   * Updates the helper to match the position and direction of the light being
   * visualized.
   */
  def update(): Unit = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Companion object for SpotLightHelper class
 */
@js.native
@JSImport("three", "SpotLightHelper")
object SpotLightHelper extends js.Object
