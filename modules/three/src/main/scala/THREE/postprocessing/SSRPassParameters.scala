package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Parameters for SSRPass configuration
 */
trait SSRPassParameters extends js.Object {
  var renderer: js.UndefOr[WebGLRenderer]    = js.undefined
  var scene: js.UndefOr[Scene]               = js.undefined
  var camera: js.UndefOr[Camera]             = js.undefined
  var width: js.UndefOr[Double]              = js.undefined
  var height: js.UndefOr[Double]             = js.undefined
  var selects: js.UndefOr[js.Object]         = js.undefined
  var bouncing: js.UndefOr[Boolean]          = js.undefined
  var groundReflector: js.UndefOr[js.Object] = js.undefined
}

object SSRPassParameters {

  def apply(
    rendererValue: js.UndefOr[WebGLRenderer] = js.undefined,
    sceneValue: js.UndefOr[Scene] = js.undefined,
    cameraValue: js.UndefOr[Camera] = js.undefined,
    widthValue: js.UndefOr[Double] = js.undefined,
    heightValue: js.UndefOr[Double] = js.undefined,
    selectsValue: js.UndefOr[js.Object] = js.undefined,
    bouncingValue: js.UndefOr[Boolean] = js.undefined,
    groundReflectorValue: js.UndefOr[js.Object] = js.undefined
  ): SSRPassParameters =
    new SSRPassParameters {
      this.renderer = rendererValue
      this.scene = sceneValue
      this.camera = cameraValue
      this.width = widthValue
      this.height = heightValue
      this.selects = selectsValue
      this.bouncing = bouncingValue
      this.groundReflector = groundReflectorValue
    }
}
