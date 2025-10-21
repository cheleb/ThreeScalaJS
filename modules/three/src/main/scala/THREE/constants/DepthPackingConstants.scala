package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Basic depth packing.
 */
@js.native
@JSImport("three", "BasicDepthPacking")
object BasicDepthPacking extends js.Object:
  override def toString(): String = js.native

/**
 * A depth value is packed into 32 bit RGBA.
 */
@js.native
@JSImport("three", "RGBADepthPacking")
object RGBADepthPacking extends js.Object:
  override def toString(): String = js.native

/**
 * A depth value is packed into 24 bit RGB.
 */
@js.native
@JSImport("three", "RGBDepthPacking")
object RGBDepthPacking extends js.Object:
  override def toString(): String = js.native

/**
 * A depth value is packed into 16 bit RG.
 */
@js.native
@JSImport("three", "RGDepthPacking")
object RGDepthPacking extends js.Object:
  override def toString(): String = js.native
