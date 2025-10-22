package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Creates 6 cameras that render to a WebGLCubeRenderTarget.
 */
@js.native
@JSImport("three", "CubeCamera")
class CubeCamera(
  near: Double,
  far: Double,
  renderTarget: WebGLCubeRenderTarget
) extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isCubeCamera: Boolean = js.native

  /**
   * Updates the render target cube with the camera views.
   */
  def update(renderer: WebGLRenderer, scene: Scene): Unit = js.native
}
