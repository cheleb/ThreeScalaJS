package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * This class can be used to define a linear fog that grows linearly denser with
 * the distance.
 *
 * ```scala
 * val scene = new Scene()
 * scene.fog = new Fog(0xcccccc, 10, 15)
 * ```
 */
@js.native
@JSImport("three", "Fog")
class Fog extends js.Object {

  /** This flag can be used for type testing */
  val isFog: Boolean = js.native

  /** The name of the fog */
  var name: String = js.native

  /** The fog's color */
  var color: Color = js.native

  /**
   * The minimum distance to start applying fog. Objects that are less than
   * `near` units from the active camera won't be affected by fog.
   */
  var near: Double = js.native

  /**
   * The maximum distance at which fog stops being calculated and applied.
   * Objects that are more than `far` units away from the active camera won't be
   * affected by fog.
   */
  var far: Double = js.native

  /**
   * Returns a new fog with copied values from this instance.
   */
  @JSName("clone")
  def jsClone(): Fog = js.native

  /**
   * Serializes the fog into JSON.
   */
  def toJSON(): js.Object = js.native
}
