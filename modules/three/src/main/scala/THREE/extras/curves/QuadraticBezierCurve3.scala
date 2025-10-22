package THREE.extras.curves

import THREE.Vector3

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import THREE.extras.core.Curve

/**
 * A curve representing a 3D Quadratic Bezier curve.
 *
 * @augments
 *   Curve
 */
@js.native
@JSImport("three", "QuadraticBezierCurve3")
class QuadraticBezierCurve3(
  v0: Vector3 = new Vector3(),
  v1: Vector3 = new Vector3(),
  v2: Vector3 = new Vector3()
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
  val isQuadraticBezierCurve3: Boolean = js.native

  override def copy(source: Curve): QuadraticBezierCurve3 = js.native

  override def toJSON(): js.Object = js.native

  override def fromJSON(json: js.Object): QuadraticBezierCurve3 = js.native

}
