package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material for shiny surfaces with specular highlights.
 *
 * The material uses a non-physically based Blinn-Phong model for calculating
 * reflectance. Unlike the Lambertian model used in the MeshLambertMaterial this
 * can simulate shiny surfaces with specular highlights (such as varnished
 * wood).
 */
@js.native
@JSImport("three", "MeshPhongMaterial")
class MeshPhongMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isMeshPhongMaterial: Boolean = js.native

  /**
   * Color of the material.
   */
  var color: Color = js.native

  /**
   * Specular color of the material.
   */
  var specular: Color = js.native

  /**
   * How shiny the specular highlight is; a higher value gives a sharper
   * highlight.
   */
  var shininess: Double = js.native

  /**
   * The color map.
   */
  var map: js.UndefOr[js.Object] = js.native

  /**
   * The light map.
   */
  var lightMap: js.UndefOr[js.Object] = js.native

  /**
   * Intensity of the baked light.
   */
  var lightMapIntensity: Double = js.native

  /**
   * The ambient occlusion map.
   */
  var aoMap: js.UndefOr[js.Object] = js.native

  /**
   * Intensity of the ambient occlusion effect.
   */
  var aoMapIntensity: Double = js.native

  /**
   * Emissive (light) color of the material.
   */
  var emissive: Color = js.native

  /**
   * Intensity of the emissive light.
   */
  var emissiveIntensity: Double = js.native

  /**
   * Emissive (glow) map.
   */
  var emissiveMap: js.UndefOr[js.Object] = js.native

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
   * The specular map.
   */
  var specularMap: js.UndefOr[js.Object] = js.native

  /**
   * The alpha map.
   */
  var alphaMap: js.UndefOr[js.Object] = js.native

  /**
   * The environment map.
   */
  var envMap: js.UndefOr[js.Object] = js.native

  /**
   * The rotation of the environment map.
   */
  var envMapRotation: Euler = js.native

  /**
   * How to combine the result of the surface's color with the environment map.
   */
  var combine: Int = js.native

  /**
   * How much the environment map affects the surface.
   */
  var reflectivity: Double = js.native

  /**
   * The index of refraction (IOR) of air divided by the index of refraction of
   * the material.
   */
  var refractionRatio: Double = js.native

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
 * Companion object for MeshPhongMaterial with factory method
 */
object MeshPhongMaterial:

  def apply(
    color: Int | String | Color = 0xffffff,
    wireframe: Boolean = false,
    specular: js.UndefOr[Int | String | Color] = js.undefined,
    shininess: js.UndefOr[Double] = js.undefined
  ): MeshPhongMaterial = {
    val params = js.Dynamic.literal(
      color = color.asInstanceOf[js.Any],
      wireframe = wireframe
    )

    if (!js.isUndefined(specular)) params.specular = specular.asInstanceOf[js.Any]
    if (!js.isUndefined(shininess)) params.shininess = shininess

    new MeshPhongMaterial(params)
  }
