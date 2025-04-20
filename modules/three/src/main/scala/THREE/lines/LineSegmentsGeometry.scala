package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A specialized geometry for drawing line segments.
 */
@js.native
@JSImport("three/examples/jsm/lines/LineSegmentsGeometry.js", "LineSegmentsGeometry")
class LineSegmentsGeometry extends BufferGeometry {

  /**
   * This flag can be used for type testing.
   */
  val isLineSegmentsGeometry: Boolean = js.native

  /**
   * Sets positions for the line segments. Expects an array of values with 6
   * entries per segment (3 per position).
   */
  def setPositions(array: js.Array[Double]): LineSegmentsGeometry = js.native

  /**
   * Sets colors for the line segments. Expects an array of values with 6
   * entries per segment (3 per position).
   */
  def setColors(array: js.Array[Double]): LineSegmentsGeometry = js.native

  /**
   * Creates a clone of this geometry.
   */
  def fromLine(line: js.Object): LineSegmentsGeometry = js.native

  /**
   * Creates a clone of this geometry.
   */
  override def clone(): LineSegmentsGeometry = js.native

}
