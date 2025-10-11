package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * An advanced physically based material, with advanced features like clearcoat,
 * transmission, and refraction.
 *
 * This material extends MeshStandardMaterial with more advanced properties for
 * realistic rendering of complex materials like glass, liquids, gemstones, and
 * varnished surfaces.
 */
@js.native
@JSImport("three", "MeshPhysicalMaterial")
class MeshPhysicalMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isMeshPhysicalMaterial: Boolean = js.native

  /**
   * Color of the material.
   */
  var color: Color = js.native

  /**
   * The roughness of the material - mathematically 0.0 to 1.0.
   */
  var roughness: Double = js.native

  /**
   * The metalness of the material - mathematically 0.0 to 1.0.
   */
  var metalness: Double = js.native

  /**
   * The clearcoat layer intensity - mathematically 0.0 to 1.0. Simulates a
   * clear coating like varnish or lacquer.
   */
  var clearcoat: Double = js.native

  /**
   * The roughness of the clearcoat layer - mathematically 0.0 to 1.0.
   */
  var clearcoatRoughness: Double = js.native

  /**
   * The transmission (refraction) ratio - mathematically 0.0 to 1.0. 0.0 means
   * no transmission, 1.0 means fully transmissive.
   */
  var transmission: Double = js.native

  /**
   * The thickness of the material - affects the refraction.
   */
  var thickness: Double = js.native

  /**
   * The index of refraction (IOR) of the material.
   */
  var ior: Double = js.native

  /**
   * The color of light attenuation through the material.
   */
  var attenuationColor: Color = js.native

  /**
   * The distance light travels through the material before being attenuated.
   */
  var attenuationDistance: Double = js.native

  /**
   * The specular intensity of the material.
   */
  var specularIntensity: Double = js.native

  /**
   * The specular color of the material.
   */
  var specularColor: Color = js.native

  /**
   * The specular tint of the material.
   */
  var specularTint: Double = js.native

  /**
   * The sheen color of the material.
   */
  var sheenColor: Color = js.native

  /**
   * The sheen roughness of the material.
   */
  var sheenRoughness: Double = js.native

  /**
   * The sheen intensity of the material.
   */
  var sheen: Double = js.native

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
   * The roughness map.
   */
  var roughnessMap: js.UndefOr[js.Object] = js.native

  /**
   * The metalness map.
   */
  var metalnessMap: js.UndefOr[js.Object] = js.native

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
 * Companion object for MeshPhysicalMaterial with factory method
 */
object MeshPhysicalMaterial:

  def apply(
    color: Int | String | Color = 0xffffff,
    roughness: js.UndefOr[Double] = js.undefined,
    metalness: js.UndefOr[Double] = js.undefined,
    clearcoat: js.UndefOr[Double] = js.undefined,
    clearcoatRoughness: js.UndefOr[Double] = js.undefined,
    transmission: js.UndefOr[Double] = js.undefined,
    thickness: js.UndefOr[Double] = js.undefined,
    ior: js.UndefOr[Double] = js.undefined,
    attenuationColor: js.UndefOr[Int | String | Color] = js.undefined,
    attenuationDistance: js.UndefOr[Double] = js.undefined,
    specularIntensity: js.UndefOr[Double] = js.undefined,
    specularColor: js.UndefOr[Int | String | Color] = js.undefined,
    sheen: js.UndefOr[Double] = js.undefined,
    sheenColor: js.UndefOr[Int | String | Color] = js.undefined,
    sheenRoughness: js.UndefOr[Double] = js.undefined,
    wireframe: Boolean = false,
    emissive: js.UndefOr[Int | String | Color] = js.undefined,
    emissiveIntensity: js.UndefOr[Double] = js.undefined
  ): MeshPhysicalMaterial = {
    val params = js.Dynamic.literal(
      color = color.asInstanceOf[js.Any],
      wireframe = wireframe
    )

    if (!js.isUndefined(roughness)) params.roughness = roughness
    if (!js.isUndefined(metalness)) params.metalness = metalness
    if (!js.isUndefined(clearcoat)) params.clearcoat = clearcoat
    if (!js.isUndefined(clearcoatRoughness)) params.clearcoatRoughness = clearcoatRoughness
    if (!js.isUndefined(transmission)) params.transmission = transmission
    if (!js.isUndefined(thickness)) params.thickness = thickness
    if (!js.isUndefined(ior)) params.ior = ior
    if (!js.isUndefined(attenuationColor)) params.attenuationColor = attenuationColor.asInstanceOf[js.Any]
    if (!js.isUndefined(attenuationDistance)) params.attenuationDistance = attenuationDistance
    if (!js.isUndefined(specularIntensity)) params.specularIntensity = specularIntensity
    if (!js.isUndefined(specularColor)) params.specularColor = specularColor.asInstanceOf[js.Any]
    if (!js.isUndefined(sheen)) params.sheen = sheen
    if (!js.isUndefined(sheenColor)) params.sheenColor = sheenColor.asInstanceOf[js.Any]
    if (!js.isUndefined(sheenRoughness)) params.sheenRoughness = sheenRoughness
    if (!js.isUndefined(emissive)) params.emissive = emissive.asInstanceOf[js.Any]
    if (!js.isUndefined(emissiveIntensity)) params.emissiveIntensity = emissiveIntensity

    new MeshPhysicalMaterial(params)
  }
