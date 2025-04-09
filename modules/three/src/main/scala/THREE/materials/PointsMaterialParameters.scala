package THREE

import scala.scalajs.js

/**
 * Parameters for PointsMaterial.
 */
object PointsMaterialParameters {

  /**
   * Creates a new PointsMaterial parameters object.
   */
  def apply(): Builder = new Builder(js.Object().asInstanceOf[js.Dynamic])

  class Builder(val params: js.Dynamic) extends AnyVal {

    /**
     * Sets the color of the points.
     */
    def setColor(color: Int): Builder = {
      params.color = color
      this
    }

    /**
     * Sets the color of the points using a Color object.
     */
    def setColor(color: Color): Builder = {
      params.color = color
      this
    }

    /**
     * Sets the size of the points in pixels.
     */
    def setSize(size: Double): Builder = {
      params.size = size
      this
    }

    /**
     * Sets whether the size is attenuated by the camera depth.
     */
    def setSizeAttenuation(sizeAttenuation: Boolean): Builder = {
      params.sizeAttenuation = sizeAttenuation
      this
    }

    /**
     * Sets the color map of the points.
     */
    def setMap(map: Texture): Builder = {
      params.map = map
      this
    }

    /**
     * Sets the alpha map of the points.
     */
    def setAlphaMap(alphaMap: Texture): Builder = {
      params.alphaMap = alphaMap
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
