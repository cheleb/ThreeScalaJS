package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * This class can be used to define a linear fog that grows linearly denser with
 * the distance.
 *
 * ```scala
 * val scene = new Scene()
 * scene.fog = Fog(0xcccccc, 10, 15)
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

/**
 * Companion object for creating Fog instances
 */
object Fog {

  /**
   * Creates a new Fog instance
   *
   * @param color
   *   The fog's color (can be a hex number or Color object)
   * @param near
   *   The minimum distance to start applying fog (default: 1)
   * @param far
   *   The maximum distance at which fog stops being calculated (default: 1000)
   * @return
   *   A new Fog instance
   */
  def apply(color: Color | Int, near: Double = 1.0, far: Double = 1000.0): Fog = {
    val fog = new Fog()
    fog.color = color match {
      case c: Color => c
      case i: Int   => new Color(i)
    }
    fog.near = near
    fog.far = far
    fog
  }

  /**
   * Creates a new Fog instance with hex color
   *
   * @param hexColor
   *   The fog's color as a hex number
   * @param near
   *   The minimum distance to start applying fog (default: 1)
   * @param far
   *   The maximum distance at which fog stops being calculated (default: 1000)
   * @return
   *   A new Fog instance
   */
  def apply(hexColor: Int): Fog = {
    val fog = new Fog()
    fog.color = new Color(hexColor)
    fog.near = 1.0
    fog.far = 1000.0
    fog
  }

  def apply(hexColor: Int, near: Double, far: Double): Fog = {
    val fog = new Fog()
    fog.color = new Color(hexColor)
    fog.near = near
    fog.far = far
    fog
  }
}
