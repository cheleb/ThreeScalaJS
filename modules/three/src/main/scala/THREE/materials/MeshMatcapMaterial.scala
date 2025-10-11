package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material for rendering objects using matcap (material capture) textures.
 *
 * Matcap materials use pre-rendered sphere textures that capture how a material
 * should appear under different lighting conditions and viewing angles. This
 * technique is commonly used for clay-like materials, metals, and stylized
 * rendering.
 */
@js.native
@JSImport("three", "MeshMatcapMaterial")
class MeshMatcapMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isMeshMatcapMaterial: Boolean = js.native

  /**
   * Color of the material.
   */
  var color: Color = js.native

  /**
   * The matcap texture map.
   */
  var matcap: js.UndefOr[js.Object] = js.native

  /**
   * The alpha map.
   */
  var alphaMap: js.UndefOr[js.Object] = js.native

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
}

/**
 * Companion object for MeshMatcapMaterial with factory method
 */
object MeshMatcapMaterial:

  def apply(
    color: Int | String | Color = 0xffffff,
    matcap: js.UndefOr[js.Object] = js.undefined,
    bumpMap: js.UndefOr[js.Object] = js.undefined,
    bumpScale: js.UndefOr[Double] = js.undefined,
    normalMap: js.UndefOr[js.Object] = js.undefined,
    displacementMap: js.UndefOr[js.Object] = js.undefined,
    displacementScale: js.UndefOr[Double] = js.undefined,
    wireframe: Boolean = false
  ): MeshMatcapMaterial = {
    val params = js.Dynamic.literal(
      color = color.asInstanceOf[js.Any],
      wireframe = wireframe
    )

    if (!js.isUndefined(matcap)) params.matcap = matcap
    if (!js.isUndefined(bumpMap)) params.bumpMap = bumpMap
    if (!js.isUndefined(bumpScale)) params.bumpScale = bumpScale
    if (!js.isUndefined(normalMap)) params.normalMap = normalMap
    if (!js.isUndefined(displacementMap)) params.displacementMap = displacementMap
    if (!js.isUndefined(displacementScale)) params.displacementScale = displacementScale

    new MeshMatcapMaterial(params)
  }
