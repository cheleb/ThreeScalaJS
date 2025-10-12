package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * WebGL render target for off-screen rendering
 */
@js.native
@JSImport("three", "WebGLRenderTarget")
class WebGLRenderTarget(width: Double = 0, height: Double = 0) extends js.Object {

  def setSize(width: Double, height: Double): Unit = js.native
  def dispose(): Unit                              = js.native
}

object WebGLRenderTarget {

  def apply(width: Double = 0, height: Double = 0): WebGLRenderTarget =
    new WebGLRenderTarget(width, height)
}
