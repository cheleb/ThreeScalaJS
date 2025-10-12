package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Shader pass that applies a custom shader to a texture
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/ShaderPass.js", "ShaderPass")
class ShaderPass(shader: js.Object, textureID: js.UndefOr[String] = js.undefined) extends EffectPass {

  var uniforms: js.Object = js.native

  def setUniforms(uniforms: js.Object): Unit = js.native
}

object ShaderPass {

  def apply(shader: js.Object, textureID: js.UndefOr[String] = js.undefined): ShaderPass =
    new ShaderPass(shader, textureID)
}
