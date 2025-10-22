package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import THREE.Texture

/**
 * A cube render target used in context of WebGLRenderer for cube map rendering.
 * This is useful for creating dynamic cube maps for reflections, environment
 * mapping, etc.
 */
@js.native
@JSImport("three", "WebGLCubeRenderTarget")
class WebGLCubeRenderTarget(
  size: Double = 1,
  options: js.UndefOr[WebGLRenderTargetOptions] = js.undefined
) extends WebGLRenderTarget {

  /**
   * This flag can be used for type testing.
   */
  val isWebGLCubeRenderTarget: Boolean = js.native

  /**
   * Converts the given equirectangular texture to a cube map.
   *
   * @param renderer
   *   The renderer.
   * @param texture
   *   The equirectangular texture.
   * @return
   *   A reference to this cube render target.
   */
  def fromEquirectangularTexture(renderer: WebGLRenderer, texture: Texture): WebGLCubeRenderTarget = js.native

  /**
   * Clears this cube render target.
   *
   * @param renderer
   *   The renderer.
   * @param color
   *   Whether the color buffer should be cleared or not.
   * @param depth
   *   Whether the depth buffer should be cleared or not.
   * @param stencil
   *   Whether the stencil buffer should be cleared or not.
   */
  def clear(renderer: WebGLRenderer, color: Boolean = true, depth: Boolean = true, stencil: Boolean = true): Unit =
    js.native
}

object WebGLCubeRenderTarget {

  def apply(
    size: Double = 1,
    options: js.UndefOr[WebGLRenderTargetOptions] = js.undefined
  ): WebGLCubeRenderTarget = {
    val opts = options.getOrElse(new js.Object().asInstanceOf[WebGLRenderTargetOptions])
    new WebGLCubeRenderTarget(size, opts)
  }

  def apply(size: Double): WebGLCubeRenderTarget =
    apply(size, js.undefined)
}
