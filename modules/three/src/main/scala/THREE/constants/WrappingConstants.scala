package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * The texture will simply repeat to infinity.
 */
@js.native
@JSImport("three", "RepeatWrapping")
object RepeatWrapping extends js.Object:
  override def toString(): String = js.native

/**
 * The last pixel of the texture stretches to the edge of the mesh.
 */
@js.native
@JSImport("three", "ClampToEdgeWrapping")
object ClampToEdgeWrapping extends js.Object:
  override def toString(): String = js.native

/**
 * The texture will repeats to infinity, mirroring on each repeat.
 */
@js.native
@JSImport("three", "MirroredRepeatWrapping")
object MirroredRepeatWrapping extends js.Object:
  override def toString(): String = js.native
