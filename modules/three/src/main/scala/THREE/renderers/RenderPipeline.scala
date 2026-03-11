package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * RenderPipeline is the new name for PostProcessing since r183. It manages a
 * series of post-processing passes to be applied to a scene.
 *
 * @since r183
 */
@js.native
@JSImport("three/webgpu", "RenderPipeline")
class RenderPipeline(renderer: js.Object, outputNode: js.UndefOr[js.Object] = js.undefined) extends js.Object {

  /**
   * Renders the scene with all post-processing passes applied.
   */
  def render(): Unit = js.native

  /**
   * Sets the resolution scale for the render pipeline.
   */
  def setResolutionScale(scale: Double): Unit = js.native

  /**
   * Gets the resolution scale for the render pipeline.
   */
  def getResolutionScale(): Double = js.native
}

object RenderPipeline {
  def apply(renderer: js.Object, outputNode: js.UndefOr[js.Object] = js.undefined): RenderPipeline =
    new RenderPipeline(renderer, outputNode)
}
