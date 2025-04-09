package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A light that gets emitted in a specific direction. This light will behave as
 * though it is infinitely far away and the rays produced from it are all
 * parallel. The common use case for this is to simulate daylight; the sun is
 * far enough away that its position can be considered to be infinite.
 */
@js.native
@JSImport("three", "DirectionalLight")
class DirectionalLight(
  color: js.UndefOr[Int | String | Color] = js.undefined,
  intensity: js.UndefOr[Double] = js.undefined
) extends Light {

  /**
   * Target position for this light.
   */
  var target: Object3D = js.native

  /**
   * Shadow camera frustum far plane.
   */
  var shadow: js.Object = js.native

}

/**
 * Companion object for DirectionalLight with factory method
 */
@js.native
@JSImport("three", "DirectionalLight")
object DirectionalLight extends js.Object
