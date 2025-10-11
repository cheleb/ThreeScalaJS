package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material that visualizes the normals of a mesh by coloring them based on
 * their direction.
 *
 * This material is commonly used for debugging purposes to visualize the
 * surface normals of a geometry. The colors represent the direction of the
 * normals:
 *   - Red: X-axis direction
 *   - Green: Y-axis direction
 *   - Blue: Z-axis direction
 */
@js.native
@JSImport("three", "MeshNormalMaterial")
class MeshNormalMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isMeshNormalMaterial: Boolean = js.native

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
   * Whether the material is rendered with flat shading.
   */
  var flatShading: Boolean = js.native

  /**
   * Whether the material is affected by fog.
   */
  var fog: Boolean = js.native

  /**
   * The bump map.
   */
  var bumpMap: js.UndefOr[js.Object] = js.native

  /**
   * How much the bump map affects the material.
   */
  var bumpScale: Double = js.native

  /**
   * The normal map.
   */
  var normalMap: js.UndefOr[js.Object] = js.native

  /**
   * The type of normal map.
   */
  var normalMapType: Int = js.native

  /**
   * How much the normal map affects the material.
   */
  var normalScale: Vector2 = js.native

  /**
   * The displacement map.
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
  var alphaMap: js.UndefOr[js.Object] = js.native
}

/**
 * Companion object for MeshNormalMaterial with factory method
 */
object MeshNormalMaterial:

  def apply(
    wireframe: Boolean = false,
    flatShading: Boolean = false,
    bumpMap: js.UndefOr[js.Object] = js.undefined,
    bumpScale: js.UndefOr[Double] = js.undefined,
    normalMap: js.UndefOr[js.Object] = js.undefined,
    normalScale: js.UndefOr[Vector2] = js.undefined,
    displacementMap: js.UndefOr[js.Object] = js.undefined,
    displacementScale: js.UndefOr[Double] = js.undefined,
    displacementBias: js.UndefOr[Double] = js.undefined,
    alphaMap: js.UndefOr[js.Object] = js.undefined
  ): MeshNormalMaterial = {
    val params = js.Dynamic.literal(
      wireframe = wireframe,
      flatShading = flatShading
    )

    if (!js.isUndefined(bumpMap)) params.bumpMap = bumpMap
    if (!js.isUndefined(bumpScale)) params.bumpScale = bumpScale
    if (!js.isUndefined(normalMap)) params.normalMap = normalMap
    if (!js.isUndefined(normalScale)) params.normalScale = normalScale
    if (!js.isUndefined(displacementMap)) params.displacementMap = displacementMap
    if (!js.isUndefined(displacementScale)) params.displacementScale = displacementScale
    if (!js.isUndefined(displacementBias)) params.displacementBias = displacementBias
    if (!js.isUndefined(alphaMap)) params.alphaMap = alphaMap

    new MeshNormalMaterial(params)
  }
