package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Output pass for tone mapping and color space conversion
 *
 * This pass is responsible for including tone mapping and color space
 * conversion into your pass chain. In most cases, this pass should be included
 * at the end of each pass chain. If a pass requires sRGB input (e.g. like
 * FXAA), the pass must follow `OutputPass` in the pass chain.
 *
 * The tone mapping and color space settings are extracted from the renderer.
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/OutputPass.js", "OutputPass")
class OutputPass() extends EffectPass {

  /** The pass uniforms */
  var uniforms: js.Object = js.native

  /** The pass material */
  var material: RawShaderMaterial = js.native

  override def dispose(): Unit = js.native
}

object OutputPass {

  def apply(): OutputPass =
    new OutputPass()
}
