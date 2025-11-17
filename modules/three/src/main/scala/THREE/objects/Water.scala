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
    textureWidth.foreach(v => opts.textureWidth = v)
    textureHeight.foreach(v => opts.textureHeight = v)
    clipBias.foreach(v => opts.clipBias = v)
    alpha.foreach(v => opts.alpha = v)
    time.foreach(v => opts.time = v)
    waterNormals.foreach(v => opts.waterNormals = v)
    sunDirection.foreach(v => opts.sunDirection = v)
    sunColor.foreach(v => opts.sunColor = v)
    waterColor.foreach(v => opts.waterColor = v)
    eye.foreach(v => opts.eye = v)
    distortionScale.foreach(v => opts.distortionScale = v)
    side.foreach(v => opts.side = v)
    fog.foreach(v => opts.fog = v)
    opts
  }
}
