package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.|

/**
 * Represents a 3x3 matrix in Three.js.
 *
 * The constructor and set method take arguments in row-major order, while
 * internally they are stored in the elements array in column-major order.
 */
@js.native
@JSImport("three", "Matrix3")
class Matrix3(
  n11: js.UndefOr[Double] = js.undefined,
  n12: js.UndefOr[Double] = js.undefined,
  n13: js.UndefOr[Double] = js.undefined,
  n21: js.UndefOr[Double] = js.undefined,
  n22: js.UndefOr[Double] = js.undefined,
  n23: js.UndefOr[Double] = js.undefined,
  n31: js.UndefOr[Double] = js.undefined,
  n32: js.UndefOr[Double] = js.undefined,
  n33: js.UndefOr[Double] = js.undefined
) extends js.Object {

  /**
   * Flag that can be used for type testing
   */
  val isMatrix3: Boolean = js.native

  /**
   * A column-major list of matrix values
   */
  val elements: js.Array[Double] = js.native

  /**
   * Sets the elements of the matrix in row-major order
   */
  def set(
    n11: Double,
    n12: Double,
    n13: Double,
    n21: Double,
    n22: Double,
    n23: Double,
    n31: Double,
    n32: Double,
    n33: Double
  ): this.type = js.native

  /**
   * Sets this matrix to the identity matrix
   */
  def identity(): this.type = js.native

  /**
   * Copies the values from another matrix to this one
   */
  def copy(m: Matrix3): this.type = js.native

  /**
   * Extracts the basis of this matrix into the three axis vectors provided
   */
  def extractBasis(xAxis: Vector3, yAxis: Vector3, zAxis: Vector3): this.type = js.native

  /**
   * Sets this matrix to the upper 3x3 matrix of the given 4x4 matrix
   */
  def setFromMatrix4(m: Matrix4): this.type = js.native

  /**
   * Post-multiplies this matrix by another matrix
   */
  def multiply(m: Matrix3): this.type = js.native

  /**
   * Pre-multiplies this matrix by another matrix
   */
  def premultiply(m: Matrix3): this.type = js.native

  /**
   * Multiplies two matrices and stores the result in this matrix
   */
  def multiplyMatrices(a: Matrix3, b: Matrix3): this.type = js.native

  /**
   * Multiplies every component of the matrix by a scalar
   */
  def multiplyScalar(s: Double): this.type = js.native

  /**
   * Computes and returns the determinant of this matrix
   */
  def determinant(): Double = js.native

  /**
   * Inverts this matrix
   */
  def invert(): this.type = js.native

  /**
   * Transposes this matrix in place
   */
  def transpose(): this.type = js.native

  /**
   * Computes the normal matrix which is the inverse transpose of the upper left
   * 3x3 portion of a 4x4 matrix
   */
  def getNormalMatrix(matrix4: Matrix4): this.type = js.native

  /**
   * Transposes this matrix into the supplied array
   */
  def transposeIntoArray(r: js.Array[Double]): this.type = js.native

  /**
   * Sets the UV transform matrix from offset, repeat, rotation, and center
   */
  def setUvTransform(
    tx: Double,
    ty: Double,
    sx: Double,
    sy: Double,
    rotation: Double,
    cx: Double,
    cy: Double
  ): this.type = js.native

  /**
   * Scales this matrix with the given scalar values
   */
  @deprecated("Use makeScale() instead.", "r185")
  def scale(sx: Double, sy: Double): this.type = js.native

  /**
   * Rotates this matrix by the given angle
   */
  @deprecated("Use makeRotation() instead.", "r185")
  def rotate(theta: Double): this.type = js.native

  /**
   * Translates this matrix by the given scalar values
   */
  @deprecated("Use makeTranslation() instead.", "r185")
  def translate(tx: Double, ty: Double): this.type = js.native

  /**
   * Sets this matrix as a 2D translation transform
   */
  def makeTranslation(x: Double | Vector2, y: js.UndefOr[Double] = js.undefined): this.type = js.native

  /**
   * Sets this matrix as a 2D rotational transformation
   */
  def makeRotation(theta: Double): this.type = js.native

  /**
   * Sets this matrix as a 2D scale transform
   */
  def makeScale(x: Double, y: Double): this.type = js.native

  /**
   * Tests if this matrix equals another matrix
   */
  def equals(matrix: Matrix3): Boolean = js.native

  /**
   * Sets the elements of this matrix from an array
   */
  def fromArray(array: js.Array[Double], offset: Double = 0): this.type = js.native

  /**
   * Returns the elements of this matrix in an array
   */
  def toArray(array: js.Array[Double] = js.Array(), offset: Double = 0): js.Array[Double] = js.native

  /**
   * Returns a clone of this matrix
   */
  override def clone(): Matrix3 = js.native
}
