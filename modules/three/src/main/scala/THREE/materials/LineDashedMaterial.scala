package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material for drawing wireframe-style geometries with dashed lines. Note:
 * You must call Line.computeLineDistances() when using LineDashedMaterial.
 */
@js.native
@JSImport("three", "LineDashedMaterial")
class LineDashedMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends LineBasicMaterial {

  /**
   * The size of the dash. This is both the gap with the stroke. Default is 3.
   */
  var dashSize: Double = js.native

  /**
   * The size of the gap. Default is 1.
   */
  var gapSize: Double = js.native

  /**
   * The scale of the dashed part of a line. Default is 1.
   */
  var scale: Double = js.native

  /**
   * This flag can be used for type testing.
   */
  val isLineDashedMaterial: Boolean = js.native
}

/**
 * Companion object for LineDashedMaterial with factory methods.
 */
object LineDashedMaterial {

  /**
   * Factory method to create a LineDashedMaterial with parameters.
   */
  def apply(parameters: js.Object): LineDashedMaterial = new LineDashedMaterial(parameters)

  /**
   * Factory method to create a LineDashedMaterial with default parameters.
   */
  def apply(): LineDashedMaterial = new LineDashedMaterial()

  /**
   * Factory method to create a LineDashedMaterial with common parameters.
   */
  def apply(color: Int, dashSize: Double = 3, gapSize: Double = 1, scale: Double = 1): LineDashedMaterial =
    new LineDashedMaterial(
      js.Dynamic.literal(
        color = color,
        dashSize = dashSize,
        gapSize = gapSize,
        scale = scale
      )
    )
}
