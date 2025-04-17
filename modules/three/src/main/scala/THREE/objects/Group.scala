package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * This is almost identical to an Object3D. Its purpose is to make working with
 * groups of objects syntactically clearer.
 *
 * A group is useful for collecting objects to manipulate them as a whole, such
 * as rotating, scaling, or setting their visibility.
 */
@js.native
@JSImport("three", "Group")
class Group extends Object3D {

  /**
   * This flag can be used for type testing.
   *
   * @type
   *   {boolean}
   * @readonly
   * @default
   *   true
   */
  val isGroup: Boolean = js.native

  /**
   * The type of this object.
   *
   * @type
   *   {string}
   * @readonly
   * @default
   *   'Group'
   */
  override val `type`: String = js.native
}

/**
 * Companion object for Group with factory method.
 */
@js.native
@JSImport("three", "Group")
object Group extends js.Object
