package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.typedarray.TypedArray

/**
 * Class representing a 4D vector.
 *
 * A 4D vector is typically used for representing homogeneous coordinates or
 * quaternions.
 */
@js.native
@JSImport("three", "Vector4")
class Vector4(
  var x: js.UndefOr[Double] = js.undefined,
  var y: js.UndefOr[Double] = js.undefined,
  var z: js.UndefOr[Double] = js.undefined,
  var w: js.UndefOr[Double] = js.undefined
) extends js.Object {

  val isVector4: Boolean = js.native

  def set(x: Double, y: Double, z: Double, w: Double): this.type = js.native

  def setScalar(scalar: Double): this.type = js.native

  def setX(x: Double): this.type = js.native

  def setY(y: Double): this.type = js.native

  def setZ(z: Double): this.type = js.native

  def setW(w: Double): this.type = js.native

  def setComponent(index: Int, value: Double): this.type = js.native

  def getComponent(index: Int): Double = js.native

  @JSName("clone")
  def jsClone(): Vector4 = js.native

  def copy(v: Vector4): this.type = js.native

  def add(v: Vector4): this.type = js.native

  def addScalar(s: Double): this.type = js.native

  def addVectors(a: Vector4, b: Vector4): this.type = js.native

  def addScaledVector(v: Vector4, s: Double): this.type = js.native

  def sub(v: Vector4): this.type = js.native

  def subScalar(s: Double): this.type = js.native

  def subVectors(a: Vector4, b: Vector4): this.type = js.native

  def multiply(v: Vector4): this.type = js.native

  def multiplyScalar(scalar: Double): this.type = js.native

  def applyMatrix4(m: Matrix4): this.type = js.native

  def divideScalar(scalar: Double): this.type = js.native

  def setAxisAngleFromQuaternion(q: Quaternion): this.type = js.native

  def setAxisAngleFromRotationMatrix(m: Matrix4): this.type = js.native

  def min(v: Vector4): this.type = js.native

  def max(v: Vector4): this.type = js.native

  def clamp(min: Vector4, max: Vector4): this.type = js.native

  def clampScalar(minVal: Double, maxVal: Double): this.type = js.native

  def clampLength(min: Double, max: Double): this.type = js.native

  def floor(): this.type = js.native

  def ceil(): this.type = js.native

  def round(): this.type = js.native

  def roundToZero(): this.type = js.native

  def negate(): this.type = js.native

  def dot(v: Vector4): Double = js.native

  def lengthSq(): Double = js.native

  def length(): Double = js.native

  def manhattanLength(): Double = js.native

  def normalize(): this.type = js.native

  def setLength(length: Double): this.type = js.native

  def lerp(v: Vector4, alpha: Double): this.type = js.native

  def lerpVectors(v1: Vector4, v2: Vector4, alpha: Double): this.type = js.native

  def equals(v: Vector4): Boolean = js.native

  def fromArray(array: js.Array[Double], offset: Int = 0): this.type = js.native

  def toArray(array: js.Array[Double] = js.Array[Double](), offset: Int = 0): js.Array[Double] = js.native

  def fromBufferAttribute(attribute: js.Object, index: Int): this.type = js.native

  def random(): this.type = js.native
}
