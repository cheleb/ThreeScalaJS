package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Disables face culling.
 */
@js.native
@JSImport("three", "CullFaceNone")
object CullFaceNone extends js.Object:
  override def toString(): String = js.native

/**
 * Culls back faces.
 */
@js.native
@JSImport("three", "CullFaceBack")
object CullFaceBack extends js.Object:
  override def toString(): String = js.native

/**
 * Culls front faces.
 */
@js.native
@JSImport("three", "CullFaceFront")
object CullFaceFront extends js.Object:
  override def toString(): String = js.native

/**
 * Culls both front and back faces.
 */
@js.native
@JSImport("three", "CullFaceFrontBack")
object CullFaceFrontBack extends js.Object:
  override def toString(): String = js.native
