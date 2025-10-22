package THREE.extras.core

import THREE.{Vector2, Vector3, Matrix4}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * An abstract base class for creating an analytic curve object that contains
 * methods for interpolation.
 *
 * @abstract
 */
@js.native
@JSImport("three", "Curve")
abstract class Curve extends js.Object {

  /**
   * The type property is used for detecting the object type in context of
   * serialization/deserialization.
   *
   * @type
   *   {string}
   * @readonly
   */
  val `type`: String = js.native

  /**
   * This value determines the amount of divisions when calculating the
   * cumulative segment lengths of a curve via {@link Curve#getLengths}. To
   * ensure precision when using methods like {@link Curve#getSpacedPoints}, it
   * is recommended to increase the value of this property if the curve is very
   * large.
   *
   * @type
   *   {number}
   * @default
   *   200
   */
  var arcLengthDivisions: Double = js.native

  /**
   * Must be set to `true` if the curve parameters have changed.
   *
   * @type
   *   {boolean}
   * @default
   *   false
   */
  var needsUpdate: Boolean = js.native

  /**
   * An internal cache that holds precomputed curve length values.
   *
   * @private
   * @type
   *   {?Array<number>}
   * @default
   *   null
   */
  var cacheArcLengths: js.Array[Double] = js.native

  /**
   * This method returns a vector in 2D or 3D space (depending on the curve
   * definition) for the given interpolation factor.
   *
   * @abstract
   * @param {number}
   *   t - A interpolation factor representing a position on the curve. Must be
   *   in the range `[0,1]`.
   * @param {(Vector2|Vector3)}
   *   [optionalTarget] - The optional target vector the result is written to.
   * @return
   *   {(Vector2|Vector3)} The position on the curve. It can be a 2D or 3D
   *   vector depending on the curve definition.
   */
  def getPoint(t: Double, optionalTarget: js.UndefOr[Vector2 | Vector3] = js.undefined): Vector2 | Vector3 = js.native

  /**
   * This method returns a vector in 2D or 3D space (depending on the curve
   * definition) for the given interpolation factor. Unlike
   * {@link Curve#getPoint}, this method honors the length of the curve which
   * equidistant samples.
   *
   * @param {number}
   *   u - A interpolation factor representing a position on the curve. Must be
   *   in the range `[0,1]`.
   * @param {(Vector2|Vector3)}
   *   [optionalTarget] - The optional target vector the result is written to.
   * @return
   *   {(Vector2|Vector3)} The position on the curve. It can be a 2D or 3D
   *   vector depending on the curve definition.
   */
  def getPointAt(u: Double, optionalTarget: js.UndefOr[Vector2 | Vector3] = js.undefined): Vector2 | Vector3 = js.native

  /**
   * This method samples the curve via {@link Curve#getPoint} and returns an
   * array of points representing the curve shape.
   *
   * @param {number}
   *   [divisions=5] - The number of divisions.
   * @return
   *   {Array<(Vector2|Vector3)>} An array holding the sampled curve values. The
   *   number of points is `divisions + 1`.
   */
  def getPoints(divisions: Double = 5): js.Array[Vector2 | Vector3] = js.native

  /**
   * This method samples the curve via {@link Curve#getPointAt} and returns an
   * array of points representing the curve shape. Unlike
   * {@link Curve#getPoints}, this method returns equi-spaced points across the
   * entire curve.
   *
   * @param {number}
   *   [divisions=5] - The number of divisions.
   * @return
   *   {Array<(Vector2|Vector3)>} An array holding the sampled curve values. The
   *   number of points is `divisions + 1`.
   */
  def getSpacedPoints(divisions: Double = 5): js.Array[Vector2 | Vector3] = js.native

  /**
   * Returns the total arc length of the curve.
   *
   * @return
   *   {number} The length of the curve.
   */
  def getLength(): Double = js.native

  /**
   * Returns an array of cumulative segment lengths of the curve.
   *
   * @param {number}
   *   [divisions=this.arcLengthDivisions] - The number of divisions.
   * @return
   *   {Array<number>} An array holding the cumulative segment lengths.
   */
  def getLengths(divisions: Double = js.native): js.Array[Double] = js.native

  /**
   * Update the cumulative segment distance cache. The method must be called
   * every time curve parameters are changed. If an updated curve is part of a
   * composed curve like {@link CurvePath}, this method must be called on the
   * composed curve, too.
   */
  def updateArcLengths(): Unit = js.native

  /**
   * Given an interpolation factor in the range `[0,1]`, this method returns an
   * updated interpolation factor in the same range that can be ued to sample
   * equidistant points from a curve.
   *
   * @param {number}
   *   u - The interpolation factor.
   * @param {?number}
   *   distance - An optional distance on the curve.
   * @return
   *   {number} The updated interpolation factor.
   */
  def getUtoTmapping(u: Double, distance: js.UndefOr[Double] = js.undefined): Double = js.native

  /**
   * Returns a unit vector tangent for the given interpolation factor. If the
   * derived curve does not implement its tangent derivation, two points a small
   * delta apart will be used to find its gradient which seems to give a
   * reasonable approximation.
   *
   * @param {number}
   *   t - The interpolation factor.
   * @param {(Vector2|Vector3)}
   *   [optionalTarget] - The optional target vector the result is written to.
   * @return
   *   {(Vector2|Vector3)} The tangent vector.
   */
  def getTangent(t: Double, optionalTarget: js.UndefOr[Vector2 | Vector3] = js.undefined): Vector2 | Vector3 = js.native

  /**
   * Same as {@link Curve#getTangent} but with equidistant samples.
   *
   * @param {number}
   *   u - The interpolation factor.
   * @param {(Vector2|Vector3)}
   *   [optionalTarget] - The optional target vector the result is written to.
   * @return
   *   {(Vector2|Vector3)} The tangent vector.
   * @see
   *   {@link Curve#getPointAt}
   */
  def getTangentAt(u: Double, optionalTarget: js.UndefOr[Vector2 | Vector3] = js.undefined): Vector2 | Vector3 =
    js.native

  /**
   * Generates the Frenet Frames. Requires a curve definition in 3D space. Used
   * in geometries like {@link TubeGeometry} or {@link ExtrudeGeometry}.
   *
   * @param {number}
   *   segments - The number of segments.
   * @param {boolean}
   *   [closed=false] - Whether the curve is closed or not.
   * @return
   *   {{tangents: Array<Vector3>, normals: Array<Vector3>, binormals:
   *   Array<Vector3>}} The Frenet Frames.
   */
  def computeFrenetFrames(segments: Double, closed: Boolean = false): FrenetFrames = js.native

  /**
   * Returns a new curve with copied values from this instance.
   *
   * @return
   *   {Curve} A clone of this instance.
   */
  override def clone(): Curve = js.native

  /**
   * Copies the values of the given curve to this instance.
   *
   * @param {Curve}
   *   source - The curve to copy.
   * @return
   *   {Curve} A reference to this curve.
   */
  def copy(source: Curve): Curve = js.native

  /**
   * Serializes the curve into JSON.
   *
   * @return
   *   {Object} A JSON object representing the serialized curve.
   * @see
   *   {@link ObjectLoader#parse}
   */
  def toJSON(): js.Object = js.native

  /**
   * Deserializes the curve from the given JSON.
   *
   * @param {Object}
   *   json - The JSON holding the serialized curve.
   * @return
   *   {Curve} A reference to this curve.
   */
  def fromJSON(json: js.Object): Curve = js.native

}

@js.native
trait FrenetFrames extends js.Object {
  val tangents: js.Array[Vector3]  = js.native
  val normals: js.Array[Vector3]   = js.native
  val binormals: js.Array[Vector3] = js.native
}
