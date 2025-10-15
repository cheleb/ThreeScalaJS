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
    sceneValue: js.UndefOr[Scene] = js.undefined,
    cameraValue: js.UndefOr[Camera] = js.undefined,
    widthValue: js.UndefOr[Double] = js.undefined,
    heightValue: js.UndefOr[Double] = js.undefined,
    kernelSizeValue: js.UndefOr[Double] = js.undefined,
    kernelRadiusValue: js.UndefOr[Double] = js.undefined,
    minDistanceValue: js.UndefOr[Double] = js.undefined,
    maxDistanceValue: js.UndefOr[Double] = js.undefined,
    outputValue: js.UndefOr[Double] = js.undefined
  ): SSAOPassParameters =
    new SSAOPassParameters {
      this.scene = sceneValue
      this.camera = cameraValue
      this.width = widthValue
      this.height = heightValue
      this.kernelSize = kernelSizeValue
      this.kernelRadius = kernelRadiusValue
      this.minDistance = minDistanceValue
      this.maxDistance = maxDistanceValue
      this.output = outputValue
    }
}
