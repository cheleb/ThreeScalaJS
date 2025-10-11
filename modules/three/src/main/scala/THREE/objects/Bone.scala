package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A bone which is part of a Skeleton. The skeleton in turn is used by the
 * SkinnedMesh.
 *
 * Example:
 * ```scala sc:nocompile
 * val root  = new Bone()
 * val child = new Bone()
 *
 * root.add(child)
 * child.position.y = 5
 * ```
 */
@js.native
@JSImport("three", "Bone")
class Bone extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isBone: Boolean = js.native

  /**
   * The type of this object.
   */
  override val `type`: String = js.native
}

/**
 * Companion object for Bone with factory method.
 */
@js.native
@JSImport("three", "Bone")
object Bone extends js.Object
