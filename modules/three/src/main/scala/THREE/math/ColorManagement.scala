package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class that manages conversions between color spaces.
 */
@js.native
@JSImport("three", "ColorManagement")
object ColorManagement extends js.Object {

  /** Whether color management is enabled */
  var enabled: Boolean = js.native

  /** Current working color space */
  var workingColorSpace: String = js.native

  /** Supported color spaces */
  val spaces: js.Dictionary[js.Object] = js.native

  /** Converts a color from one color space to another */
  def convert(color: Color, sourceColorSpace: String, targetColorSpace: String): Color = js.native

  /** Converts a color from the working color space to target color space */
  def fromWorkingColorSpace(color: Color, targetColorSpace: String): Color = js.native

  /** Converts a color from source color space to working color space */
  def toWorkingColorSpace(color: Color, sourceColorSpace: String): Color = js.native

  /** Gets primaries for a color space */
  def getPrimaries(colorSpace: String): js.Array[Double] = js.native

  /** Gets transfer function for a color space */
  def getTransfer(colorSpace: String): String = js.native

  /** Gets luminance coefficients for a color space */
  def getLuminanceCoefficients(target: js.Object, colorSpace: js.UndefOr[String] = js.undefined): js.Object = js.native

  /** Defines new color spaces */
  def define(colorSpaces: js.Dictionary[js.Object]): Unit = js.native

  /** Internal: Gets a transform matrix between color spaces */
  def _getMatrix(targetMatrix: Matrix3, sourceColorSpace: String, targetColorSpace: String): Matrix3 = js.native

  /** Internal: Gets drawing buffer color space */
  def _getDrawingBufferColorSpace(colorSpace: String): String = js.native

  /** Internal: Gets unpack color space */
  def _getUnpackColorSpace(colorSpace: js.UndefOr[String] = js.undefined): String = js.native
}

/**
 * Converts color component from sRGB to linear space
 */
@js.native
@JSImport("three", "SRGBToLinear")
object SRGBToLinear extends js.Function1[Double, Double] {
  def apply(c: Double): Double = js.native
}

/**
 * Converts color component from linear to sRGB space
 */
@js.native
@JSImport("three", "LinearToSRGB")
object LinearToSRGB extends js.Function1[Double, Double] {
  def apply(c: Double): Double = js.native
}
