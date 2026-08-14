package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSImport("three", "Matrix4")
class Matrix4(
  n11: js.UndefOr[Double] = js.undefined,
  n12: js.UndefOr[Double] = js.undefined,
  n13: js.UndefOr[Double] = js.undefined,
  n14: js.UndefOr[Double] = js.undefined,
  n21: js.UndefOr[Double] = js.undefined,
  n22: js.UndefOr[Double] = js.undefined,
  n23: js.UndefOr[Double] = js.undefined,
  n24: js.UndefOr[Double] = js.undefined,
  n31: js.UndefOr[Double] = js.undefined,
  n32: js.UndefOr[Double] = js.undefined,
  n33: js.UndefOr[Double] = js.undefined,
  n34: js.UndefOr[Double] = js.undefined,
  n41: js.UndefOr[Double] = js.undefined,
  n42: js.UndefOr[Double] = js.undefined,
  n43: js.UndefOr[Double] = js.undefined,
  n44: js.UndefOr[Double] = js.undefined
) extends js.Object {
  val elements: js.Array[Double] = js.native
  val isMatrix4: Boolean         = js.native

  /**
   * Computes and returns the determinant of this matrix assuming an affine transformation.
   */
  def determinantAffine(): Double = js.native
}
