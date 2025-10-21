package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Represents mouse buttons and interaction types in context of controls.
 */
@js.native
@JSImport("three", "InterpolationSamplingType")
object InterpolationSamplingType extends js.Object:
  /** Perspective-correct interpolation. */
  val PERSPECTIVE: String = js.native

  /** Linear interpolation. */
  val LINEAR: String = js.native

  /** Flat interpolation. */
  val FLAT: String                = js.native
  override def toString(): String = js.native

/**
 * Represents the different interpolation sampling modes.
 */
@js.native
@JSImport("three", "InterpolationSamplingMode")
object InterpolationSamplingMode extends js.Object:
  /** Normal sampling mode. */
  val NORMAL: String = js.native

  /** Centroid sampling mode. */
  val CENTROID: String = js.native

  /** Sample-specific sampling mode. */
  val SAMPLE: String = js.native

  /** Flat interpolation using the first vertex. */
  val FIRST: String = js.native

  /** Flat interpolation using either vertex. */
  val EITHER: String              = js.native
  override def toString(): String = js.native
