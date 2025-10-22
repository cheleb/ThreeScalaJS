package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom
import org.scalajs.dom

/**
 * The WebGL2 renderer displays your scenes using WebGL 2.0. It extends
 * WebGLRenderer with WebGL 2.0 specific features.
 */
@js.native
@JSImport("three", "WebGLRenderer")
class WebGL2Renderer(parameters: js.Object) extends WebGLRenderer {

  // WebGL 2.0 specific properties and methods can be added here
  // For now, it's the same as WebGLRenderer but with WebGL 2.0 context

  var capabilities: js.Object = js.native // WebGL 2.0 capabilities

}

object WebGL2Renderer {

  def apply(
    canvas: js.UndefOr[dom.html.Canvas] = js.undefined,
    context: js.UndefOr[js.Any] = js.undefined,
    depth: Boolean = true,
    stencil: Boolean = false,
    alpha: Boolean = false,
    antialias: Boolean = false,
    premultipliedAlpha: Boolean = true,
    preserveDrawingBuffer: Boolean = false,
    powerPreference: String = "default",
    failIfMajorPerformanceCaveat: Boolean = false,
    reverseDepthBuffer: Boolean = false
  ): WebGL2Renderer = new WebGLRenderer(
    js.Dynamic.literal(
      "canvas"                       -> canvas,
      "context"                      -> context,
      "depth"                        -> depth,
      "stencil"                      -> stencil,
      "alpha"                        -> alpha,
      "antialias"                    -> antialias,
      "premultipliedAlpha"           -> premultipliedAlpha,
      "preserveDrawingBuffer"        -> preserveDrawingBuffer,
      "powerPreference"              -> powerPreference,
      "failIfMajorPerformanceCaveat" -> failIfMajorPerformanceCaveat,
      "reverseDepthBuffer"           -> reverseDepthBuffer
    )
  ).asInstanceOf[WebGL2Renderer]
}
