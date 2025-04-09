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
  val renderTarget: js.Object
) extends js.Object {

  /**
   * The parent Object3D containing the 6 perspective cameras.
   */
  val parent: Object3D = js.native

  /**
   * Updates the render target cube with the camera views.
   */
  def update(renderer: WebGLRenderer, scene: Scene): Unit = js.native
}
