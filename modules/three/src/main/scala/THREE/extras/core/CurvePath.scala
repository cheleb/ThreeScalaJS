package THREE.extras.core

import THREE.{Vector2, Vector3}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * A base class extending {@link Curve}. `CurvePath` is simply an array of
 * connected curves, but retains the API of a curve.
 *
 * @augments
 *   Curve
 */
@js.native
@JSImport("three", "CurvePath")
class CurvePath extends Curve {

  /**
   * An array of curves defining the path.
   *
   * @type
   *   {Array<Curve>}
   */
  var curves: js.Array[Curve] = js.native

  /**
   * Whether the path should automatically be closed by a line curve.
   *
   * @type
   *   {boolean}
   * @default
   *   false
   */
  var autoClose: Boolean = js.native

  /**
   * Adds a curve to this curve path.
   *
   * @param {Curve}
   *   curve - The curve to add.
   */
  def add(curve: Curve): Unit = js.native

  /**
   * Adds a line curve to close the path.
   *
   * @return
   *   {CurvePath} A reference to this curve path.
   */
  def closePath(): CurvePath = js.native

  /**
   * This method returns a vector in 2D or 3D space (depending on the curve
   * definitions) for the given interpolation factor.
   *
   * @param {number}
   *   t - A interpolation factor representing a position on the curve. Must be
   *   in the range `[0,1]`.
   * @param {(Vector2|Vector3)}
   *   [optionalTarget] - The optional target vector the result is written to.
   * @return
   *   {?(Vector2|Vector3)} The position on the curve. It can be a 2D or 3D
   *   vector depending on the curve definition.
   */
  override def getPoint(t: Double, optionalTarget: js.UndefOr[Vector2 | Vector3] = js.undefined): Vector2 | Vector3 =
    js.native

  override def getLength(): Double = js.native

  /**
   * Returns list of cumulative curve lengths of the defined curves.
   *
   * @return
   *   {Array<number>} The curve lengths.
   */
  def getCurveLengths(): js.Array[Double] = js.native

  override def getSpacedPoints(divisions: Double = 40): js.Array[Vector2 | Vector3] = js.native

  override def getPoints(divisions: Double = 12): js.Array[Vector2 | Vector3] = js.native

  override def copy(source: Curve): CurvePath = js.native

  override def toJSON(): js.Object = js.native

  override def fromJSON(json: js.Object): CurvePath = js.native

}
