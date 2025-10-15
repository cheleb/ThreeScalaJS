package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * SSAO (Screen Space Ambient Occlusion) pass for realistic ambient occlusion
 * effects
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/SSAOPass.js", "SSAOPass")
class SSAOPass(parameters: SSAOPassParameters) extends EffectPass {

  var width: Double        = js.native
  var height: Double       = js.native
  var kernelRadius: Double = js.native
  var minDistance: Double  = js.native
  var maxDistance: Double  = js.native
  var output: Double       = js.native

  override def dispose(): Unit = js.native

  override def setSize(width: Double, height: Double): Unit = js.native
}

object SSAOPass {

  def apply(parameters: SSAOPassParameters): SSAOPass =
    new SSAOPass(parameters)

  def apply(
    scene: Scene,
    camera: Camera,
    width: Double = 512,
    height: Double = 512,
    kernelSize: Double = 32
  ): SSAOPass = {
    val parameters = SSAOPassParameters(
      sceneValue = scene,
      cameraValue = camera,
      widthValue = width,
      heightValue = height,
      kernelSizeValue = kernelSize
    )
    new SSAOPass(parameters)
  }
}
