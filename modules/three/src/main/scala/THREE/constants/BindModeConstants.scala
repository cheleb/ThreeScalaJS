package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * The skinned mesh shares the same world space as the skeleton.
 */
@js.native
@JSImport("three", "AttachedBindMode")
val AttachedBindMode: String = js.native

/**
 * The skinned mesh does not share the same world space as the skeleton. This is
 * useful when a skeleton is shared across multiple skinned meshes.
 */
@js.native
@JSImport("three", "DetachedBindMode")
val DetachedBindMode: String = js.native
