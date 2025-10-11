package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material used internally for implementing shadow mapping with point lights.
 *
 * Can also be used to customize the shadow casting of an object by assigning an
 * instance of `MeshDistanceMaterial` to
 * {@link Object3D#customDistanceMaterial}. This approach can be used to ensure
 * transparent parts of objects do not cast shadows.
 */
@js.native
@JSImport("three", "MeshDistanceMaterial")
class MeshDistanceMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isMeshDistanceMaterial: Boolean = js.native

  /**
   * The color map. May optionally include an alpha channel, typically combined
   * with transparent or alphaTest properties.
   */
  var map: js.UndefOr[js.Object] = js.native

  /**
   * The alpha map is a grayscale texture that controls the opacity across the
   * surface (black: fully transparent; white: fully opaque).
   */
  var alphaMap: js.UndefOr[js.Object] = js.native

  /**
   * The displacement map affects the position of the mesh's vertices.
   */
  var displacementMap: js.UndefOr[js.Object] = js.native

  /**
   * How much the displacement map affects the mesh (where black is no
   * displacement, and white is maximum displacement).
   */
  var displacementScale: Double = js.native

  /**
   * The offset of the displacement map's values on the mesh's vertices.
   */
  var displacementBias: Double = js.native
}

/**
 * Companion object for MeshDistanceMaterial with factory method
 */
object MeshDistanceMaterial:

  def apply(
    map: js.UndefOr[js.Object] = js.undefined,
    alphaMap: js.UndefOr[js.Object] = js.undefined,
    displacementMap: js.UndefOr[js.Object] = js.undefined,
    displacementScale: js.UndefOr[Double] = js.undefined,
    displacementBias: js.UndefOr[Double] = js.undefined
  ): MeshDistanceMaterial = {
    val params = js.Dynamic.literal()

    if (!js.isUndefined(map)) params.map = map
    if (!js.isUndefined(alphaMap)) params.alphaMap = alphaMap
    if (!js.isUndefined(displacementMap)) params.displacementMap = displacementMap
    if (!js.isUndefined(displacementScale)) params.displacementScale = displacementScale
    if (!js.isUndefined(displacementBias)) params.displacementBias = displacementBias

    new MeshDistanceMaterial(params)
  }
