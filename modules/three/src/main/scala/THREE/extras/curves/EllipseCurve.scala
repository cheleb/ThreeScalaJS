package THREE.extras.curves

import THREE.Vector2

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import THREE.extras.core.Curve

/**
 * A curve representing an ellipse.
 *
 * ```js
 * const curve = new THREE.EllipseCurve(
 * 	0, 0,
 * 	10, 10,
 * 	0, 2 * Math.PI,
 * 	false,
 * 	0
 * );
 *
 * const points = curve.getPoints( 50 );
 * const geometry = new THREE.BufferGeometry().setFromPoints( points );
 *
 * const material = new THREE.LineBasicMaterial( { color: 0xff0000 } );
 *
 * // Create the final object to add to the scene
 * const ellipse = new THREE.Line( geometry, material );
 * ```
 *
 * @augments
 *   Curve
 */
@js.native
@JSImport("three", "EllipseCurve")
class EllipseCurve(
  aX: Double = 0,
  aY: Double = 0,
  xRadius: Double = 1,
  yRadius: Double = 1,
  aStartAngle: Double = 0,
  aEndAngle: Double = Math.PI * 2,
  aClockwise: Boolean = false,
  aRotation: Double = 0
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
  val isEllipseCurve: Boolean = js.native

  override def copy(source: Curve): EllipseCurve = js.native

  override def toJSON(): js.Object = js.native

  override def fromJSON(json: js.Object): EllipseCurve = js.native

}
