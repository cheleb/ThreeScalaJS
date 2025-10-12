package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * The EffectComposer is a post-processing pipeline that allows you to apply
 * multiple post-processing effects to a scene.
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/EffectComposer.js", "EffectComposer")
class EffectComposer(renderer: WebGLRenderer, renderTarget: js.UndefOr[WebGLRenderTarget] = js.undefined)
    extends js.Object {

  var writeBuffer: WebGLRenderTarget = js.native
  var readBuffer: WebGLRenderTarget  = js.native

  def addPass(pass: EffectPass): Unit                   = js.native
  def removePass(pass: EffectPass): Unit                = js.native
  def insertPass(pass: EffectPass, index: Double): Unit = js.native

  def render(deltaTime: Double = 0): Unit          = js.native
  def setSize(width: Double, height: Double): Unit = js.native

  def reset(renderTarget: js.UndefOr[WebGLRenderTarget] = js.undefined): Unit = js.native
  def dispose(): Unit                                                         = js.native

  def getSize(target: Vector2): Vector2       = js.native
  def setPixelRatio(pixelRatio: Double): Unit = js.native
}

object EffectComposer {

  def apply(renderer: WebGLRenderer, renderTarget: js.UndefOr[WebGLRenderTarget] = js.undefined): EffectComposer =
    new EffectComposer(renderer, renderTarget)
}
