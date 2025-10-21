package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * The current version of three.js as a string.
 * @defaultValue
 *   '180'
 */
@js.native
@JSImport("three", "REVISION")
object REVISION extends js.Object:
  override def toString(): String = js.native

/**
 * Represents mouse buttons and interaction types in context of controls.
 */
@js.native
@JSImport("three", "MOUSE")
object MOUSE extends js.Object:
  /** The left mouse button. */
  val LEFT: Double = js.native

  /** The middle mouse button. */
  val MIDDLE: Double = js.native

  /** The right mouse button. */
  val RIGHT: Double = js.native

  /** A rotate interaction. */
  val ROTATE: Double = js.native

  /** A dolly interaction. */
  val DOLLY: Double = js.native

  /** A pan interaction. */
  val PAN: Double                 = js.native
  override def toString(): String = js.native

/**
 * Represents touch interaction types in context of controls.
 */
@js.native
@JSImport("three", "TOUCH")
object TOUCH extends js.Object:
  /** A rotate interaction. */
  val ROTATE: Double = js.native

  /** A pan interaction. */
  val PAN: Double = js.native

  /** The dolly-pan interaction. */
  val DOLLY_PAN: Double = js.native

  /** A dolly-rotate interaction. */
  val DOLLY_ROTATE: Double        = js.native
  override def toString(): String = js.native
