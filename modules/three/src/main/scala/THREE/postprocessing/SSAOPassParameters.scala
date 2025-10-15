package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Parameters for SSAOPass configuration
 */
trait SSAOPassParameters extends js.Object {
  var scene: js.UndefOr[Scene]         = js.undefined
  var camera: js.UndefOr[Camera]       = js.undefined
  var width: js.UndefOr[Double]        = js.undefined
  var height: js.UndefOr[Double]       = js.undefined
  var kernelSize: js.UndefOr[Double]   = js.undefined
  var kernelRadius: js.UndefOr[Double] = js.undefined
  var minDistance: js.UndefOr[Double]  = js.undefined
  var maxDistance: js.UndefOr[Double]  = js.undefined
  var output: js.UndefOr[Double]       = js.undefined
}

object SSAOPassParameters {

  def apply(
    pscene: js.UndefOr[Scene] = js.undefined,
    pcamera: js.UndefOr[Camera] = js.undefined,
    pwidth: js.UndefOr[Double] = js.undefined,
    pheight: js.UndefOr[Double] = js.undefined,
    pkernelSize: js.UndefOr[Double] = js.undefined,
    pkernelRadius: js.UndefOr[Double] = js.undefined,
    pminDistance: js.UndefOr[Double] = js.undefined,
    pmaxDistance: js.UndefOr[Double] = js.undefined,
    poutput: js.UndefOr[Double] = js.undefined
  ): SSAOPassParameters =
    new SSAOPassParameters {
      this.scene = pscene
      this.camera = pcamera
      this.width = pwidth
      this.height = pheight
      this.kernelSize = pkernelSize
      this.kernelRadius = pkernelRadius
      this.minDistance = pminDistance
      this.maxDistance = pmaxDistance
      this.output = poutput
    }
}
