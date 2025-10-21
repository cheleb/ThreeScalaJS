package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * The texture will simply repeat to infinity.
 */
@js.native
@JSGlobal("THREE.RepeatWrapping")
val RepeatWrapping: Int = js.native

/**
 * The last pixel of the texture stretches to the edge of the mesh.
 */
@js.native
@JSGlobal("THREE.ClampToEdgeWrapping")
val ClampToEdgeWrapping: Int = js.native

/**
 * The texture will repeats to infinity, mirroring on each repeat.
 */
@js.native
@JSGlobal("THREE.MirroredRepeatWrapping")
val MirroredRepeatWrapping: Int = js.native
