package THREE.extras.curves

import THREE.Vector3

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import THREE.extras.core.Curve

/**
 * A curve representing a Catmull-Rom spline.
 *
 * ```js
 * //Create a closed wavey loop
 * const curve = new THREE.CatmullRomCurve3( [
 * 	new THREE.Vector3( -10, 0, 10 ),
 * 	new THREE.Vector3( -5, 5, 5 ),
 * 	new THREE.Vector3( 0, 0, 0 ),
 * 	new THREE.Vector3( 5, -5, 5 ),
 * 	new THREE.Vector3( 10, 0, 10 )
 * ] );
 *
 * const points = curve.getPoints( 50 );
 * const geometry = new THREE.BufferGeometry().setFromPoints( points );
 *
 * const material = new THREE.LineBasicMaterial( { color: 0xff0000 } );
 *
 * // Create the final object to add to the scene
 * const curveObject = new THREE.Line( geometry, material );
 * ```
 *
 * @augments
 *   Curve
 */
@js.native
@JSImport("three", "CatmullRomCurve3")
class CatmullRomCurve3(
  points: js.Array[Vector3] = js.Array(),
  closed: Boolean = false,
  curveType: String = "centripetal",
  tension: Double = 0.5
) extends Curve {

  /**
   * This flag can be used for type testing.
   *
   * @type
   *   {boolean}
   * @readonly
   * @default
   *   true
   */
  val isCatmullRomCurve3: Boolean = js.native

  /**
   * Returns a point on the curve.
   *
   * @param {number}
   *   t - A interpolation factor representing a position on the curve. Must be
   *   in the range `[0,1]`.
   * @param {Vector3}
   *   [optionalTarget] - The optional target vector the result is written to.
   * @return
   *   {Vector3} The position on the curve.
   */

  override def copy(source: Curve): CatmullRomCurve3 = js.native

  override def toJSON(): js.Object = js.native

  override def fromJSON(json: js.Object): CatmullRomCurve3 = js.native

}
