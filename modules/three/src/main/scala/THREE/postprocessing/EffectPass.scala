package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Base class for all post-processing passes
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/Pass.js", "Pass")
class EffectPass extends js.Object {

  var enabled: Boolean   = js.native
  var needsSwap: Boolean = js.native

  def render(
    renderer: WebGLRenderer,
    writeBuffer: js.Object,
    readBuffer: js.Object,
    deltaTime: Double,
    maskActive: Boolean = false
  ): Unit = js.native
  def setSize(width: Double, height: Double): Unit = js.native
  def dispose(): Unit                              = js.native
}

object EffectPass {

  def apply(): EffectPass = new EffectPass()
}
