package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Parameters for BokehPass configuration
 */
trait BokehPassParameters extends js.Object {
  var focus: js.UndefOr[Double]    = js.undefined
  var aspect: js.UndefOr[Double]   = js.undefined
  var aperture: js.UndefOr[Double] = js.undefined
  var maxblur: js.UndefOr[Double]  = js.undefined
  var width: js.UndefOr[Double]    = js.undefined
  var height: js.UndefOr[Double]   = js.undefined
}

object BokehPassParameters {

  def apply(
    focusValue: js.UndefOr[Double] = js.undefined,
    aspectValue: js.UndefOr[Double] = js.undefined,
    apertureValue: js.UndefOr[Double] = js.undefined,
    maxblurValue: js.UndefOr[Double] = js.undefined,
    widthValue: js.UndefOr[Double] = js.undefined,
    heightValue: js.UndefOr[Double] = js.undefined
  ): BokehPassParameters =
    new BokehPassParameters {
      this.focus = focusValue
      this.aspect = aspectValue
      this.aperture = apertureValue
      this.maxblur = maxblurValue
      this.width = widthValue
      this.height = heightValue
    }
}
