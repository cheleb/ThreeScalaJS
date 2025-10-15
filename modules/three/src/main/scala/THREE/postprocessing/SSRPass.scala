package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * SSR (Screen Space Reflections) pass for realistic reflections
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/SSRPass.js", "SSRPass")
class SSRPass(parameters: SSRPassParameters) extends EffectPass {

  var width: Double           = js.native
  var height: Double          = js.native
  var maxDistance: Double     = js.native
  var resolutionScale: Double = js.native

  override def dispose(): Unit = js.native
}

object SSRPass {

  def apply(parameters: SSRPassParameters): SSRPass =
    new SSRPass(parameters)

  def apply(
    renderer: WebGLRenderer,
    scene: Scene,
    camera: Camera,
    width: Double = 512,
    height: Double = 512,
    selects: js.Object = null,
    bouncing: Boolean = false,
    groundReflector: js.Object = null
  ): SSRPass = {
    val parameters = SSRPassParameters(
      rendererValue = renderer,
      sceneValue = scene,
      cameraValue = camera,
      widthValue = width,
      heightValue = height,
      selectsValue = selects,
      bouncingValue = bouncing,
      groundReflectorValue = groundReflector
    )
    new SSRPass(parameters)
  }
}
