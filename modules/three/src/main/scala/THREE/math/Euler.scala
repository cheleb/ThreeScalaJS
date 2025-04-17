package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * A class representing Euler Angles.
 */
@js.native
@JSImport("three", "Euler")
class Euler(
  var x: Double = js.native,
  var y: Double = js.native,
  var z: Double = js.native,
  var order: js.UndefOr[String] = js.undefined
) extends js.Object {

  val isEuler: Boolean = js.native

  def set(x: Double, y: Double, z: Double, order: js.UndefOr[String] = js.undefined): this.type = js.native
  @JSName("clone")
  def jsClone(): Euler              = js.native
  def copy(euler: Euler): this.type = js.native

  def setFromRotationMatrix(
    m: js.Object,
    order: js.UndefOr[String] = js.undefined,
    update: js.UndefOr[Boolean] = js.undefined
  ): this.type = js.native
  def setFromQuaternion(
    q: js.Object,
    order: js.UndefOr[String] = js.undefined,
    update: js.UndefOr[Boolean] = js.undefined
  ): this.type = js.native
  def setFromVector3(v: Vector3, order: js.UndefOr[String] = js.undefined): this.type = js.native

  def reorder(newOrder: String): this.type = js.native
  def equals(euler: Euler): Boolean        = js.native

  def fromArray(array: js.Array[js.Any]): this.type                                    = js.native
  def toArray(array: js.Array[js.Any] = js.Array(), offset: Int = 0): js.Array[js.Any] = js.native

  def toVector3(optionalResult: js.UndefOr[Vector3] = js.undefined): Vector3 = js.native
}

@js.native
@JSImport("three", "Euler")
object Euler extends js.Object {
  val DefaultOrder: String             = js.native
  val RotationOrders: js.Array[String] = js.native
}
