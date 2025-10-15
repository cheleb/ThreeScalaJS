package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Output shader for tone mapping and color space conversion
 */
@js.native
@JSImport("three/examples/jsm/shaders/OutputShader.js", "OutputShader")
object OutputShader extends js.Object {

  /** Shader name */
  val name: String = js.native

  /** Shader uniforms */
  val uniforms: js.Object = js.native

  /** Vertex shader GLSL code */
  val vertexShader: String = js.native

  /** Fragment shader GLSL code */
  val fragmentShader: String = js.native
}
