package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.typedarray.TypedArray

/**
 * Abstract base class of interpolants over parametric samples.
 *
 * The parameter domain is one dimensional, typically the time or a path along a
 * curve defined by the data.
 *
 * The sample values can have any dimensionality and derived classes may apply
 * special interpretations to the data.
 *
 * This class provides the interval seek in a Template Method, deferring the
 * actual interpolation to derived classes.
 */
@js.native
@JSImport("three", "Interpolant")
class Interpolant protected (
  val parameterPositions: TypedArray[?, ?],
  val sampleValues: TypedArray[?, ?],
  sampleSize: Int,
  val resultBuffer: js.UndefOr[TypedArray[?, ?]] = js.undefined
) extends js.Object {

  /**
   * A cache index.
   */
  val _cachedIndex: Int = js.native

  /**
   * The value size.
   */
  val valueSize: Int = js.native

  /**
   * The interpolation settings.
   */
  var settings: js.UndefOr[js.Object] = js.native

  /**
   * The default settings object.
   */
  val DefaultSettings_ : js.Object = js.native

  /**
   * Evaluate the interpolant at position `t`.
   *
   * @param t
   *   \- The interpolation factor.
   * @return
   *   The result buffer.
   */
  def evaluate(t: Double): TypedArray[?, ?] = js.native

  /**
   * Returns the interpolation settings.
   */
  protected def getSettings_(): js.Object = js.native

  /**
   * Copies a sample value to the result buffer.
   *
   * @param index
   *   \- An index into the sample value buffer.
   */
  protected def copySampleValue_(index: Int): TypedArray[?, ?] = js.native

  /**
   * Method that is executed when the interval has changed.
   */
  protected def intervalChanged_(i1: Int, t0: Double, t1: Double): Unit = js.native

  /**
   * Abstract method to be implemented by derived classes.
   */
  protected def interpolate_(i1: Int, t0: Double, t: Double, t1: Double): TypedArray[?, ?] = js.native
}
