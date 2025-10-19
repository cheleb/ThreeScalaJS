package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Helper object to assist with visualizing a {@link PointLight}'s position in
 * the scene. This consists of a spherical wireframe mesh.
 *
 * @example
 *   ```scala
 *   val light = new PointLight(0xffffff, 1, 100)
 *   light.position.set(10, 10, 10)
 *   scene.add(light)
 *
 *   val helper = new PointLightHelper(light, 1)
 *   scene.add(helper)
 *   ```
 */
@js.native
@JSImport("three", "PointLightHelper")
class PointLightHelper(
  /** The light to be visualized. */
  var light: PointLight = js.native,
  /** The size of the sphere helper. Default is 1. */
  sphereSize: Double = 1.0,
  /**
   * The helper's color. If not set, the helper will take the color of the
   * light.
   */
  color: Int | String | Color = js.native
) extends Mesh {

  /**
   * This flag can be used for type testing.
   */
  val isPointLightHelper: Boolean = js.native

  /**
   * The type property of the helper.
   */
  override val `type`: String = js.native

  /**
   * Updates the helper to match the position of the light being visualized.
   */
  def update(): Unit = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Companion object for PointLightHelper class
 */
@js.native
@JSImport("three", "PointLightHelper")
object PointLightHelper extends js.Object
