package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A series of lines drawn between pairs of vertices.
 *
 * This adds functionality beyond LineSegments, like arbitrary line width and
 * changing width to be in world units. Line2 extends this object, forming a
 * polyline instead of individual segments.
 */
@js.native
@JSImport("three/examples/jsm/lines/LineSegments2.js", "LineSegments2")
class LineSegments2(
  geometry: js.UndefOr[LineSegmentsGeometry] = js.undefined,
  material: js.UndefOr[LineMaterial] = js.undefined
) extends Mesh {

  /**
   * This flag can be used for type testing.
   */
  val isLineSegments2: Boolean = js.native

  /**
   * Computes an array of distance values which are necessary for rendering
   * dashed lines. For each vertex in the geometry, the method calculates the
   * cumulative length from the current point to the very beginning of the line.
   *
   * @return
   *   A reference to this instance.
   */
  def computeLineDistances(): LineSegments2 = js.native

  /**
   * Computes intersection points between a casted ray and this instance.
   *
   * @param raycaster
   *   \- The raycaster.
   * @param intersects
   *   \- The target array that holds the intersection points.
   */
  def raycast(raycaster: Raycaster, intersects: js.Array[js.Object]): Unit = js.native
}
