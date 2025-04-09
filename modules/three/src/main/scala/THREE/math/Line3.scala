package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class representing a line in 3D space, defined by a start point and an end
 * point.
 */
@js.native
@JSImport("three", "Line3")
class Line3(
  var start: js.UndefOr[Vector3] = js.undefined,
  var end: js.UndefOr[Vector3] = js.undefined
) extends js.Object {

  /**
   * Sets the start and end points of this line.
   */
  def set(start: Vector3, end: Vector3): this.type = js.native

  /**
   * Creates a new Line3 with the same start and end points as this one.
   */
  @JSName("clone")
  def jsClone(): Line3 = js.native

  /**
   * Copies the start and end points from the given line.
   */
  def copy(line: Line3): this.type = js.native

  /**
   * Returns the center of the line segment.
   */
  def getCenter(target: Vector3): Vector3 = js.native

  /**
   * Gets the delta vector of this line (end point - start point).
   */
  def delta(target: Vector3): Vector3 = js.native

  /**
   * Calculates the squared distance from this line to the given point.
   */
  def distanceSq(): Double = js.native

  /**
   * Calculates the distance from this line to the given point.
   */
  def distance(): Double = js.native

  /**
   * Calculates the closest point on this line to the given point.
   */
  def closestPointToPoint(point: Vector3, clampToLine: Boolean, target: Vector3): Vector3 = js.native

  /**
   * Calculates the closest point on this line to the given line.
   */
  def closestPointToPointParameter(point: Vector3, clampToLine: Boolean): Double = js.native

  /**
   * Returns a point at a certain distance along the line from the start point.
   */
  def at(t: Double, target: Vector3): Vector3 = js.native

  /**
   * Applies the given matrix to this line's start and end points.
   */
  def applyMatrix4(matrix: Matrix4): this.type = js.native

  /**
   * Returns true if this line equals the given line.
   */
  def equals(line: Line3): Boolean = js.native
}
