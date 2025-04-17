package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * A class representing Euler Angles.
 */
@js.native
@JSImport("three", "Euler")
class Euler(
  var x: Double = 0,
  var y: Double = 0,
  var z: Double = 0,
  var order: String = Euler.DEFAULT_ORDER
) extends js.Object {

  val isEuler: Boolean = js.native

  def set(x: Double, y: Double, z: Double, order: String): Euler = js.native
  @JSName("clone")
  def jsClone(): Euler          = js.native
  def copy(euler: Euler): Euler = js.native

  def setFromRotationMatrix(
    m: js.Object,
    order: js.UndefOr[String] = js.undefined,
    update: js.UndefOr[Boolean] = js.undefined
  ): this.type = js.native
  def setFromQuaternion(
    q: js.Object,
    order: js.UndefOr[String] = js.undefined,
    update: js.UndefOr[Boolean] = js.undefined
  ): Euler = js.native
  def setFromVector3(v: Vector3, order: String): Euler = js.native

  def reorder(newOrder: String): Euler = js.native
  def equals(euler: Euler): Boolean    = js.native

  def fromArray(array: js.Array[js.Any]): Euler                                        = js.native
  def toArray(array: js.Array[js.Any] = js.Array(), offset: Int = 0): js.Array[js.Any] = js.native

  def toVector3(optionalResult: js.UndefOr[Vector3] = js.undefined): Vector3 = js.native
}

@js.native
@JSImport("three", "Euler")
object Euler extends js.Object {
  val DEFAULT_ORDER: String = js.native
}
