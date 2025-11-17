package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|

/**
 * A basic flat, reflective water effect.
 *
 * Note that this class can only be used with WebGLRenderer. When using
 * WebGPURenderer, use WaterMesh.
 */
@js.native
@JSImport("three/examples/jsm/objects/Water.js", "Water")
class Water(
  geometry: BufferGeometry,
  options: js.UndefOr[WaterOptions] = js.undefined
) extends Mesh(geometry, js.undefined) {

  /**
   * This flag can be used for type testing.
   */
  val isWater: Boolean = js.native
}

/**
 * Constructor options for Water.
 */
trait WaterOptions extends js.Object {
  var textureWidth: js.UndefOr[Double]                = js.undefined
  var textureHeight: js.UndefOr[Double]               = js.undefined
  var clipBias: js.UndefOr[Double]                    = js.undefined
  var alpha: js.UndefOr[Double]                       = js.undefined
  var time: js.UndefOr[Double]                        = js.undefined
  var waterNormals: js.UndefOr[Texture | Null]        = js.undefined
  var sunDirection: js.UndefOr[Vector3]               = js.undefined
  var sunColor: js.UndefOr[Color | String | Double]   = js.undefined
  var waterColor: js.UndefOr[Color | String | Double] = js.undefined
  var eye: js.UndefOr[Vector3]                        = js.undefined
  var distortionScale: js.UndefOr[Double]             = js.undefined
  var side: js.UndefOr[Double]                        = js.undefined
  var fog: js.UndefOr[Boolean]                        = js.undefined
}

object WaterOptions {
  def apply(
    textureWidth: js.UndefOr[Double] = js.undefined,
    textureHeight: js.UndefOr[Double] = js.undefined,
    clipBias: js.UndefOr[Double] = js.undefined,
    alpha: js.UndefOr[Double] = js.undefined,
    time: js.UndefOr[Double] = js.undefined,
    waterNormals: js.UndefOr[Texture | Null] = js.undefined,
    sunDirection: js.UndefOr[Vector3] = js.undefined,
    sunColor: js.UndefOr[Color | String | Double] = js.undefined,
    waterColor: js.UndefOr[Color | String | Double] = js.undefined,
    eye: js.UndefOr[Vector3] = js.undefined,
    distortionScale: js.UndefOr[Double] = js.undefined,
    side: js.UndefOr[Double] = js.undefined,
    fog: js.UndefOr[Boolean] = js.undefined
  ): WaterOptions = {
    val opts = js.Dynamic.literal().asInstanceOf[WaterOptions]
    textureWidth.foreach_(v => opts.textureWidth = v)
    textureHeight.foreach_(v => opts.textureHeight = v)
    clipBias.foreach_(v => opts.clipBias = v)
    alpha.foreach_(v => opts.alpha = v)
    time.foreach_(v => opts.time = v)
    waterNormals.foreach_(v => opts.waterNormals = v)
    sunDirection.foreach_(v => opts.sunDirection = v)
    sunColor.foreach_(v => opts.sunColor = v)
    waterColor.foreach_(v => opts.waterColor = v)
    eye.foreach_(v => opts.eye = v)
    distortionScale.foreach_(v => opts.distortionScale = v)
    side.foreach_(v => opts.side = v)
    fog.foreach_(v => opts.fog = v)
    opts
  }
}
