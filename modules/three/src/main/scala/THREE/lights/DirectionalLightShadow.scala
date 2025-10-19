package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Represents the shadow configuration of directional lights.
 */
@js.native
@JSImport("three", "DirectionalLightShadow")
class DirectionalLightShadow() extends LightShadow(new OrthographicCamera(-5, 5, 5, -5, 0.5, 500)) {

  /**
   * This flag can be used for type testing.
   */
  val isDirectionalLightShadow: Boolean = js.native
}

/**
 * Companion object for DirectionalLightShadow with factory method
 */
@js.native
@JSImport("three", "DirectionalLightShadow")
object DirectionalLightShadow extends js.Object
