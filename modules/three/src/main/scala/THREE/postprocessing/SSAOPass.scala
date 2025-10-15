package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * SSAO (Screen Space Ambient Occlusion) pass for realistic ambient occlusion
 * effects
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/SSAOPass.js", "SSAOPass")
class SSAOPass(scene: Scene, camera: Camera, width: Double = 512, height: Double = 512, kernelSize: Double = 32)
    extends EffectPass {

  var kernelRadius: Double = js.native
  var minDistance: Double  = js.native
  var maxDistance: Double  = js.native
  var output: Double       = js.native

  override def dispose(): Unit = js.native

  override def setSize(width: Double, height: Double): Unit = js.native
}

object SSAOPass {

  def apply(
    scene: Scene,
    camera: Camera,
    width: Double = 512,
    height: Double = 512,
    kernelSize: Double = 32
  ): SSAOPass =
    new SSAOPass(scene, camera, width, height, kernelSize)

}
