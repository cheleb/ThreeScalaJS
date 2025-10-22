package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Represents the different timestamp query types.
 */
@js.native
@JSImport("three", "TimestampQuery")
object TimestampQuery extends js.Object:
  /** A `compute` timestamp query. */
  val COMPUTE: String = js.native

  /** A `render` timestamp query. */
  val RENDER: String              = js.native
  override def toString(): String = js.native
