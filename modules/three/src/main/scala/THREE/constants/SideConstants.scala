package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Only front faces are rendered.
 */
@js.native
@JSImport("three", "FrontSide")
object FrontSide extends js.Object:
  override def toString(): String = js.native

/**
 * Only back faces are rendered.
 */
@js.native
@JSImport("three", "BackSide")
object BackSide extends js.Object:
  override def toString(): String = js.native

/**
 * Both front and back faces are rendered.
 */
@js.native
@JSImport("three", "DoubleSide")
object DoubleSide extends js.Object:
  override def toString(): String = js.native
