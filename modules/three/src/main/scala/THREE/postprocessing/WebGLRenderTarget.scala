package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import THREE.Texture

/**
 * WebGL render target for off-screen rendering
 */
@js.native
@JSImport("three", "WebGLRenderTarget")
class WebGLRenderTarget(
  options: js.UndefOr[WebGLRenderTargetOptions] = js.undefined
) extends js.Object {

  /**
   * The width of the render target
   */
  var width: Double = js.native

  /**
   * The height of the render target
   */
  var height: Double = js.native

  /**
   * The depth of the render target
   */
  var depth: Double = js.native

  /**
   * A rectangular area inside the render target's viewport. Fragments that are
   * outside the area will be discarded.
   */
  var scissor: Vector4 = js.native

  /**
   * Indicates whether the scissor test should be enabled when rendering into
   * this render target or not.
   */
  var scissorTest: Boolean = js.native

  /**
   * A rectangular area representing the render target's viewport.
   */
  var viewport: Vector4 = js.native

  /**
   * An array of textures. Each color attachment is represented as a separate
   * texture. Has at least a single entry for the default color attachment.
   */
  var textures: js.Array[Texture] = js.native

  /**
   * Whether to allocate a depth buffer or not.
   */
  var depthBuffer: Boolean = js.native

  /**
   * Whether to allocate a stencil buffer or not.
   */
  var stencilBuffer: Boolean = js.native

  /**
   * Whether to resolve the depth buffer or not.
   */
  var resolveDepthBuffer: Boolean = js.native

  /**
   * Whether to resolve the stencil buffer or not.
   */
  var resolveStencilBuffer: Boolean = js.native

  /**
   * The number of MSAA samples. A value of `0` disables MSAA.
   */
  var samples: Double = js.native

  /**
   * Whether this target is used for multiview rendering.
   */
  var multiview: Boolean = js.native

  /**
   * The texture representing the default color attachment.
   */
  var texture: Texture = js.native

  /**
   * Instead of saving the depth in a renderbuffer, a texture can be used
   * instead which is useful for further processing e.g. in context of
   * post-processing.
   */
  var depthTexture: js.UndefOr[DepthTexture] = js.native

  /**
   * This flag can be used for type testing.
   */
  val isWebGLRenderTarget: Boolean = js.native

  def setSize(width: Double, height: Double, depth: Double = 1): Unit = js.native
  def dispose(): Unit                                                 = js.native
  @JSName("clone")
  def jsClone(): WebGLRenderTarget                       = js.native
  def copy(source: WebGLRenderTarget): WebGLRenderTarget = js.native
}

trait WebGLRenderTargetOptions extends js.Object {
  var width: js.UndefOr[Double]                 = js.undefined
  var height: js.UndefOr[Double]                = js.undefined
  var generateMipmaps: js.UndefOr[Boolean]      = js.undefined
  var internalFormat: js.UndefOr[js.Any]        = js.undefined
  var minFilter: js.UndefOr[Double]             = js.undefined
  var magFilter: js.UndefOr[Double]             = js.undefined
  var format: js.UndefOr[Double]                = js.undefined
  var `type`: js.UndefOr[Double]                = js.undefined
  var anisotropy: js.UndefOr[Double]            = js.undefined
  var colorSpace: js.UndefOr[String]            = js.undefined
  var depthBuffer: js.UndefOr[Boolean]          = js.undefined
  var stencilBuffer: js.UndefOr[Boolean]        = js.undefined
  var resolveDepthBuffer: js.UndefOr[Boolean]   = js.undefined
  var resolveStencilBuffer: js.UndefOr[Boolean] = js.undefined
  var depthTexture: js.UndefOr[DepthTexture]    = js.undefined
  var samples: js.UndefOr[Double]               = js.undefined
  var count: js.UndefOr[Double]                 = js.undefined
  var depth: js.UndefOr[Double]                 = js.undefined
  var multiview: js.UndefOr[Boolean]            = js.undefined
}

object WebGLRenderTarget {

  def apply(
    width: Double = 512,
    height: Double = 512,
    options: js.UndefOr[WebGLRenderTargetOptions] = js.undefined
  ): WebGLRenderTarget = {
    val opts = options match {
      case _: Unit => new js.Object().asInstanceOf[WebGLRenderTargetOptions]
      case o       => o.asInstanceOf[WebGLRenderTargetOptions]
    }
    opts.width = width
    opts.height = height
    new WebGLRenderTarget(opts)
  }

  def apply(width: Double, height: Double): WebGLRenderTarget =
    apply(width, height, js.undefined)

  def apply(options: WebGLRenderTargetOptions): WebGLRenderTarget =
    new WebGLRenderTarget(options)
}

/**
 * WebGLMultipleRenderTargets provides multiple render targets functionality.
 * This is essentially a WebGLRenderTarget with count > 1 for multiple color
 * attachments.
 */
@js.native
@JSImport("three", "WebGLRenderTarget")
class WebGLMultipleRenderTargets(
  width: Double,
  height: Double,
  count: Double,
  options: js.UndefOr[WebGLRenderTargetOptions] = js.undefined
) extends WebGLRenderTarget {

  /**
   * This flag can be used for type testing.
   */
  val isWebGLMultipleRenderTargets: Boolean = js.native
}

object WebGLMultipleRenderTargets {

  def apply(
    width: Double,
    height: Double,
    count: Double,
    options: js.UndefOr[WebGLRenderTargetOptions] = js.undefined
  ): WebGLMultipleRenderTargets = {
    val opts = options.getOrElse(new js.Object().asInstanceOf[WebGLRenderTargetOptions])
    opts.count = count
    new WebGLMultipleRenderTargets(width, height, count, opts)
  }
}
