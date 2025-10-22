package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * This class can be used to define an exponential squared fog, which gives a
 * clear view near the camera and a faster than exponentially densening fog
 * farther from the camera.
 *
 * ```scala
 * val scene = new Scene()
 * scene.fog = FogExp2(0xcccccc, 0.002)
 * ```
 */
@js.native
@JSImport("three", "FogExp2")
class FogExp2 extends js.Object {

  /** This flag can be used for type testing */
  val isFogExp2: Boolean = js.native

  /** The name of the fog */
  var name: String = js.native

  /** The fog's color */
  var color: Color = js.native

  /** Defines how fast the fog will grow dense */
  var density: Double = js.native

  /**
   * Returns a new fog with copied values from this instance.
   */
  @JSName("clone")
  def jsClone(): FogExp2 = js.native

  /**
   * Serializes the fog into JSON.
   */
  def toJSON(): js.Object = js.native
}

/**
 * Companion object for creating FogExp2 instances
 */
object FogExp2 {

  /**
   * Creates a new FogExp2 instance
   *
   * @param color
   *   The fog's color (can be a hex number or Color object)
   * @param density
   *   Defines how fast the fog will grow dense (default: 0.00025)
   * @return
   *   A new FogExp2 instance
   */
  def apply(color: Color | Int, density: Double = 0.00025): FogExp2 = {
    val fog = new FogExp2()
    fog.color = color match {
      case c: Color => c
      case i: Int   => new Color(i)
    }
    fog.density = density
    fog
  }

  /**
   * Creates a new FogExp2 instance with hex color
   *
   * @param hexColor
   *   The fog's color as a hex number
   * @param density
   *   Defines how fast the fog will grow dense (default: 0.00025)
   * @return
   *   A new FogExp2 instance
   */
  def apply(hexColor: Int): FogExp2 = {
    val fog = new FogExp2()
    fog.color = new Color(hexColor)
    fog.density = 0.00025
    fog
  }

  def apply(hexColor: Int, density: Double): FogExp2 = {
    val fog = new FogExp2()
    fog.color = new Color(hexColor)
    fog.density = density
    fog
  }
}
