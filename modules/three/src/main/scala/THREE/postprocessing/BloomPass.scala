package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Bloom pass that adds a bloom/glow effect to bright areas
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/BloomPass.js", "BloomPass")
class BloomPass(strength: Double = 1, kernelSize: Double = 25, sigma: Double = 4, resolution: Double = 256)
    extends EffectPass {

  def setStrength(strength: Double): Unit     = js.native
  def setKernelSize(kernelSize: Double): Unit = js.native
  def setSigma(sigma: Double): Unit           = js.native
  def setResolution(resolution: Double): Unit = js.native
}

object BloomPass {

  def apply(strength: Double = 1, kernelSize: Double = 25, sigma: Double = 4, resolution: Double = 256): BloomPass =
    new BloomPass(strength, kernelSize, sigma, resolution)
}
