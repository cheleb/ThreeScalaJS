package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Render pass that renders a scene to a render target
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/RenderPass.js", "RenderPass")
class RenderPass(
  scene: Scene,
  camera: Camera,
  overrideMaterial: js.UndefOr[Material] = js.undefined,
  clearColor: js.UndefOr[Color] = js.undefined,
  clearAlpha: js.UndefOr[Double] = js.undefined
) extends EffectPass {

  var clear: Boolean      = js.native
  var clearDepth: Boolean = js.native

  def getClearColor(): Color                               = js.native
  def setClearColor(color: Color, alpha: Double = 1): Unit = js.native
  def getClearAlpha(): Double                              = js.native
  def setClearAlpha(alpha: Double): Unit                   = js.native
}

object RenderPass {

  def apply(
    scene: Scene,
    camera: Camera,
    overrideMaterial: js.UndefOr[Material] = js.undefined,
    clearColor: js.UndefOr[Color] = js.undefined,
    clearAlpha: js.UndefOr[Double] = js.undefined
  ): RenderPass =
    new RenderPass(scene, camera, overrideMaterial, clearColor, clearAlpha)
}
