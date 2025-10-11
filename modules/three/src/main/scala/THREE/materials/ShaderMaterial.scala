package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material rendered with custom shaders. A shader is a small program written
 * in GLSL that runs on the GPU. You may want to use a custom shader if you need
 * to implement an effect not included with any of the built-in materials.
 */
@js.native
@JSImport("three", "ShaderMaterial")
class ShaderMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isShaderMaterial: Boolean = js.native

  /**
   * Defines custom constants using #define directives within the GLSL code for
   * both the vertex shader and the fragment shader; each key/value pair yields
   * another directive.
   */
  var defines: js.Object = js.native

  /**
   * An object specifying the uniforms to be passed to the shader code; keys are
   * uniform names, values are definitions of the form { value: 1.0 } where
   * value is the value of the uniform.
   */
  var uniforms: js.Object = js.native

  /**
   * An array holding uniforms groups for configuring UBOs.
   */
  var uniformsGroups: js.Array[js.Object] = js.native

  /**
   * Vertex shader GLSL code. This is the actual code for the shader.
   */
  var vertexShader: String = js.native

  /**
   * Fragment shader GLSL code. This is the actual code for the shader.
   */
  var fragmentShader: String = js.native

  /**
   * Controls line thickness for lines.
   */
  var linewidth: Double = js.native

  /**
   * Renders the geometry as a wireframe.
   */
  var wireframe: Boolean = js.native

  /**
   * Controls the thickness of the wireframe.
   */
  var wireframeLinewidth: Double = js.native

  /**
   * Defines whether the material color is affected by global fog settings; true
   * to pass fog uniforms to the shader.
   */
  var fog: Boolean = js.native

  /**
   * Defines whether this material uses lighting; true to pass uniform data
   * related to lighting to this shader.
   */
  var lights: Boolean = js.native

  /**
   * Defines whether this material supports clipping; true to let the renderer
   * pass the clippingPlanes uniform.
   */
  var clipping: Boolean = js.native

  /**
   * This object allows to enable certain WebGL 2 extensions.
   */
  var extensions: js.Object = js.native

  /**
   * When the rendered geometry doesn't include these attributes but the
   * material does, these default values will be passed to the shaders.
   */
  var defaultAttributeValues: js.Object = js.native

  /**
   * If set, this calls gl.bindAttribLocation to bind a generic vertex index to
   * an attribute variable.
   */
  var index0AttributeName: js.UndefOr[String] = js.native

  /**
   * Can be used to force a uniform update while changing uniforms in
   * onBeforeRender.
   */
  var uniformsNeedUpdate: Boolean = js.native

  /**
   * Defines the GLSL version of custom shader code.
   */
  var glslVersion: js.Object = js.native
}

// Manual customization of the constructor
object ShaderMaterial:

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
    new ShaderMaterial(
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
