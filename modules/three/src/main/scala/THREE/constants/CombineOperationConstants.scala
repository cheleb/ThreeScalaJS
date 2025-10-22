package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Multiplies the environment map color with the surface color.
 */
@js.native
@JSImport("three", "MultiplyOperation")
val MultiplyOperation: Int = js.native

/**
 * Uses reflectivity to blend between the two colors.
 */
@js.native
@JSImport("three", "MixOperation")
val MixOperation: Int = js.native

/**
 * Adds the two colors.
 */
@js.native
@JSImport("three", "AddOperation")
val AddOperation: Int = js.native
