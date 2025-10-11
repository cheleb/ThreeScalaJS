package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * LensFlare creates realistic lens flare effects that simulate the scattering
 * of light through a camera lens. It consists of multiple LensFlareElement
 * objects positioned at different distances from the light source.
 */
@js.native
@JSImport("three/addons/objects/Lensflare.js", "Lensflare")
class Lensflare extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isLensFlare: Boolean = js.native

  /**
   * An array of LensFlareElement objects that make up this lens flare.
   */
  var elements: js.Array[LensflareElement] = js.native

  /**
   * Custom update callback function.
   */
  var customUpdateCallback: js.Function0[Unit] = js.native

  /**
   * Adds a LensFlareElement to this lens flare.
   *
   * @param element
   *   The LensFlareElement to add
   */
  def addElement(element: LensflareElement): Unit = js.native

  /**
   * Disposes of this lens flare and cleans up resources.
   */
  def dispose(): Unit = js.native
}
