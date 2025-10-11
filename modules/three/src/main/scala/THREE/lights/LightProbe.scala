package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Light probes are used for image-based lighting (IBL) in Three.js. They
 * capture the lighting information from the environment and can be used to
 * illuminate objects with realistic lighting based on their surroundings.
 */
@js.native
@JSImport("three", "LightProbe")
class LightProbe() extends Object3D {

  /**
   * Read-only flag to check if a given object is of type LightProbe.
   */
  val isLightProbe: Boolean = js.native

  /**
   * The light probe's intensity.
   */
  var intensity: Double = js.native

  /**
   * The light probe's spherical harmonics coefficients.
   */
  var sh: js.Object = js.native

  /**
   * Copy the spherical harmonics coefficients from another light probe.
   */
  def copy(lightProbe: LightProbe): LightProbe = js.native

  /**
   * Convert the light probe to a JSON representation.
   */
  def toJSON(meta: js.Object): js.Object = js.native

  /**
   * Create a light probe from a JSON representation.
   */
  def fromJSON(json: js.Object): LightProbe = js.native
}

// Companion object for custom constructors
object LightProbe {

  def apply(
    sh: js.Object = null,
    intensity: Double = 1.0
  ): LightProbe = {
    val lightProbe = new LightProbe()
    lightProbe.sh = sh
    lightProbe.intensity = intensity
    lightProbe
  }

  /**
   * Create a LightProbe from a cube texture representing the environment.
   */
  def fromCubeTexture(cubeTexture: CubeTexture): LightProbe = {
    val lightProbe = new LightProbe()
    // In a real implementation, this would use Three.js's fromCubeTexture method
    // For now, we'll create a basic light probe
    lightProbe
  }
}
