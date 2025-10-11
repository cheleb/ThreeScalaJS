package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * This class works just like ShaderMaterial, except that definitions of
 * built-in uniforms and attributes are not automatically prepended to the GLSL
 * shader code.
 */
@js.native
@JSImport("three", "RawShaderMaterial")
class RawShaderMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends ShaderMaterial {

  /**
   * This flag can be used for type testing.
   */
  val isRawShaderMaterial: Boolean = js.native
}

// Manual customization of the constructor
object RawShaderMaterial:

  def apply(
    uniforms: js.Object = js.Dynamic.literal(),
    vertexShader: String = "",
    fragmentShader: String = "",
    defines: js.Object = js.Dynamic.literal(),
    wireframe: Boolean = false,
    fog: Boolean = false,
    lights: Boolean = false,
    clipping: Boolean = false
  ) =
    new RawShaderMaterial(
      js.Dynamic.literal(
        uniforms = uniforms,
        vertexShader = vertexShader,
        fragmentShader = fragmentShader,
        defines = defines,
        wireframe = wireframe,
        fog = fog,
        lights = lights,
        clipping = clipping
      )
    )
