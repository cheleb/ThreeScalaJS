package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSImport("three", "Vector3")
class Vector3(
  var x: js.UndefOr[Double] = js.undefined,
  var y: js.UndefOr[Double] = js.undefined,
  var z: js.UndefOr[Double] = js.undefined
) extends js.Object {
  val isVector3: Boolean = js.native

  def set(x: Double, y: Double, z: Double): this.type         = js.native
  def setFromMatrix3Column(m: Matrix3, index: Int): this.type = js.native

  def copy(v: Vector3): this.type          = js.native
  def add(v: Vector3): this.type           = js.native
  def multiplyScalar(s: Double): this.type = js.native
}
