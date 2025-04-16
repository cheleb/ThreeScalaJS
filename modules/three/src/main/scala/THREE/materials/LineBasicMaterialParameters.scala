package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Parameters for LineBasicMaterial.
 */
class LineBasicMaterialParameters private () extends js.Object {
  var color: js.UndefOr[Color | String | Int] = js.undefined
  var fog: js.UndefOr[Boolean]                = js.undefined
  var linewidth: js.UndefOr[Double]           = js.undefined
  var linecap: js.UndefOr[String]             = js.undefined
  var linejoin: js.UndefOr[String]            = js.undefined
}

object LineBasicMaterialParameters {

  /**
   * Create new LineBasicMaterialParameters with builder pattern.
   */
  def apply(): Builder = new Builder(new LineBasicMaterialParameters())

  class Builder(val params: LineBasicMaterialParameters) {

    /**
     * Sets the color of the line.
     */
    def setColor(color: Color | String | Int): Builder = {
      params.color = color
      this
    }

    /**
     * Whether the material is affected by fog.
     */
    def setFog(fog: Boolean): Builder = {
      params.fog = fog
      this
    }

    /**
     * Sets the line width. Default is 1. Due to limitations of the OpenGL Core
     * Profile with the WebGL renderer on most platforms, line width will always
     * be 1 regardless of the set value.
     */
    def setLinewidth(linewidth: Double): Builder = {
      params.linewidth = linewidth
      this
    }

    /**
     * Define appearance of line ends. Default is 'butt'. Available values are
     * 'butt', 'round' and 'square'.
     */
    def setLinecap(linecap: String): Builder = {
      params.linecap = linecap
      this
    }

    /**
     * Define appearance of line joints. Default is 'round'. Available values
     * are 'round', 'bevel' and 'miter'.
     */
    def setLinejoin(linejoin: String): Builder = {
      params.linejoin = linejoin
      this
    }

    /**
     * Converts the builder to a JavaScript object.
     */
    def build(): js.Object = params.asInstanceOf[js.Object]

    /**
     * Implicitly converts the builder to a JavaScript object.
     */
    implicit def toJsObject: js.Object = build()
  }
}
