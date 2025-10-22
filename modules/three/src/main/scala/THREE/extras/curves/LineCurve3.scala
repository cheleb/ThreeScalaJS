package THREE.extras.curves

import THREE.Vector3

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import THREE.extras.core.Curve

/**
 * A curve representing a 3D line segment.
 *
 * @augments
 *   Curve
 */
@js.native
@JSImport("three", "LineCurve3")
class LineCurve3(
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
  val isLineCurve3: Boolean = js.native

  override def copy(source: Curve): LineCurve3 = js.native

  override def toJSON(): js.Object = js.native

  override def fromJSON(json: js.Object): LineCurve3 = js.native

}
