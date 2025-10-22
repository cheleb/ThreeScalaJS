package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom
import org.scalajs.dom.WebGLRenderingContext

/**
 * The WebGL renderer displays your scenes using WebGL.
 */
@js.native
@JSImport("three", "WebGLRenderer")
class WebGLRenderer(parameters: js.UndefOr[js.Object] = js.undefined) extends js.Object {

  var domElement: dom.html.Canvas = js.native

  var autoClear: Boolean        = js.native
  var autoClearColor: Boolean   = js.native
  var autoClearDepth: Boolean   = js.native
  var autoClearStencil: Boolean = js.native

  var outputColorSpace: String = js.native

  var toneMapping: Int            = js.native
  var toneMappingExposure: Double = js.native

  var shadowMap: js.Object = js.native

  def getSize(target: Vector2): Vector2                                         = js.native
  def setSize(width: Double, height: Double, updateStyle: Boolean = true): Unit = js.native
  def getPixelRatio(): Double                                                   = js.native
  def setPixelRatio(value: Double): Unit                                        = js.native

  def getDrawingBufferSize(target: Vector2): Vector2                          = js.native
  def setDrawingBufferSize(width: Int, height: Int, pixelRatio: Double): Unit = js.native

  def setClearColor(color: Color | Int | String, alpha: Double = 1): Unit = js.native
  def getClearColor(): Color                                              = js.native
  def getClearAlpha(): Double                                             = js.native

  def clear(color: Boolean = true, depth: Boolean = true, stencil: Boolean = true): Unit = js.native
  def clearColor(): Unit                                                                 = js.native
  def clearDepth(): Unit                                                                 = js.native
  def clearStencil(): Unit                                                               = js.native

  def dispose(): Unit = js.native

  def render(scene: Object3D, camera: Camera): Unit        = js.native
  def setAnimationLoop(callback: js.Function0[Unit]): Unit = js.native

  def copyFramebufferToTexture(texture: FramebufferTexture, position: Vector2 = null, level: Int = 0): Unit = js.native

  def info: js.Object = js.native
}

object WebGLRenderer {

  def apply(
    canvas: js.UndefOr[dom.html.Canvas] = js.undefined,
    context: js.UndefOr[WebGLRenderingContext] = js.undefined,
    depth: Boolean = true,
    stencil: Boolean = false,
    alpha: Boolean = false,
    antialias: Boolean = false,
    premultipliedAlpha: Boolean = true,
    preserveDrawingBuffer: Boolean = false,
    powerPreference: String = "default",
    failIfMajorPerformanceCaveat: Boolean = false,
    reverseDepthBuffer: Boolean = false
  ): WebGLRenderer = new WebGLRenderer(
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
  )
}
