package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material for rendering geometry based on depth information.
 *
 * This material renders objects based on their distance from the camera, with
 * closer objects appearing brighter and farther objects appearing darker. It's
 * commonly used for depth-based rendering, shadow mapping, and various
 * post-processing effects.
 */
@js.native
@JSImport("three", "MeshDepthMaterial")
class MeshDepthMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isMeshDepthMaterial: Boolean = js.native

  /**
   * Whether to render as wireframe.
   */
  var wireframe: Boolean = js.native

  /**
   * Controls wireframe thickness.
   */
  var wireframeLinewidth: Double = js.native

  /**
   * Defines appearance of wireframe ends.
   */
  var wireframeLinecap: String = js.native

  /**
   * Defines appearance of wireframe joints.
   */
  var wireframeLinejoin: String = js.native

  /**
   * The alpha map.
   */
  var alphaMap: js.UndefOr[js.Object] = js.native

  /**
   * The depth packing strategy to use.
   */
  var depthPacking: Int = js.native

  /**
   * Displacement map.
   */
  var displacementMap: js.UndefOr[js.Object] = js.native

  /**
   * How much the displacement map affects the mesh.
   */
  var displacementScale: Double = js.native

  /**
   * The offset of the displacement map's values.
   */
  var displacementBias: Double = js.native

  /**
   * The alpha map.
   */
  var map: js.UndefOr[js.Object] = js.native
}

/**
 * Companion object for MeshDepthMaterial with factory method
 */
object MeshDepthMaterial:

  def apply(
    wireframe: Boolean = false,
    wireframeLinewidth: js.UndefOr[Double] = js.undefined,
    wireframeLinecap: js.UndefOr[String] = js.undefined,
    wireframeLinejoin: js.UndefOr[String] = js.undefined,
    alphaMap: js.UndefOr[js.Object] = js.undefined,
    depthPacking: js.UndefOr[Int] = js.undefined,
    displacementMap: js.UndefOr[js.Object] = js.undefined,
    displacementScale: js.UndefOr[Double] = js.undefined,
    displacementBias: js.UndefOr[Double] = js.undefined,
    map: js.UndefOr[js.Object] = js.undefined
  ): MeshDepthMaterial = {
    val params = js.Dynamic.literal(
      wireframe = wireframe
    )

    if (!js.isUndefined(wireframeLinewidth)) params.wireframeLinewidth = wireframeLinewidth
    if (!js.isUndefined(wireframeLinecap)) params.wireframeLinecap = wireframeLinecap
    if (!js.isUndefined(wireframeLinejoin)) params.wireframeLinejoin = wireframeLinejoin
    if (!js.isUndefined(alphaMap)) params.alphaMap = alphaMap
    if (!js.isUndefined(depthPacking)) params.depthPacking = depthPacking
    if (!js.isUndefined(displacementMap)) params.displacementMap = displacementMap
    if (!js.isUndefined(displacementScale)) params.displacementScale = displacementScale
    if (!js.isUndefined(displacementBias)) params.displacementBias = displacementBias
    if (!js.isUndefined(map)) params.map = map

    new MeshDepthMaterial(params)
  }
