package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Helper object to assist with visualizing a {@link DirectionalLight}'s effect
 * on the scene. This consists of plane and a line representing the light's
 * position and direction.
 *
 * @example
 *   ```scala
 *   val light = new DirectionalLight(0xffffff)
 *   scene.add(light)
 *
 *   val helper = new DirectionalLightHelper(light, 5)
 *   scene.add(helper)
 *   ```
 */
@js.native
@JSImport("three", "DirectionalLightHelper")
class DirectionalLightHelper(
  /** The light to be visualized. */
  var light: DirectionalLight = js.native,
  /** The dimensions of the plane. Default is 1. */
  size: Double = 1.0,
  /**
   * The helper's color. If not set, the helper will take the color of the
   * light.
   */
  color: Int | String | Color = js.native
) extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isDirectionalLightHelper: Boolean = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * Contains the line showing the location of the directional light.
   */
  val lightPlane: Line = js.native

  /**
   * Represents the target line of the directional light.
   */
  val targetLine: Line = js.native

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
 * Companion object for DirectionalLightHelper class
 */
@js.native
@JSImport("three", "DirectionalLightHelper")
object DirectionalLightHelper extends js.Object
