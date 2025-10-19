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
 * scene.fog = new FogExp2(0xcccccc, 0.002)
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
