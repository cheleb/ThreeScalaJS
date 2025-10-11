package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|

/**
 * Can be used to create a flat, refractive surface like for special windows or
 * water effects.
 *
 * Note that this class can only be used with WebGLRenderer. When using
 * WebGPURenderer, use viewportSharedTexture.
 *
 * Example:
 * ```scala sc:nocompile
 * val geometry = PlaneGeometry(100, 100)
 *
 * val refractor = new Refractor(
 *   geometry,
 *   js.Dynamic.literal(
 *     color = 0xcbcbcb,
 *     textureWidth = 1024,
 *     textureHeight = 1024
 *   )
 * )
 *
 * scene.add(refractor)
 * ```
 */
@js.native
@JSImport("three/examples/jsm/objects/Refractor.js", "Refractor")
class Refractor(
  geometry: BufferGeometry,
  options: js.UndefOr[RefractorOptions] = js.undefined
) extends Mesh(geometry, js.undefined) {

  /**
   * This flag can be used for type testing.
   */
  val isRefractor: Boolean = js.native

  /**
   * The refractor's virtual camera. This is used to render the scene from the
   * refractor's point of view.
   */
  val camera: PerspectiveCamera = js.native

  /**
   * Returns the refractor's internal render target.
   */
  def getRenderTarget(): js.Any = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Constructor options for Refractor.
 */
trait RefractorOptions extends js.Object {
  var color: js.UndefOr[Int | String | Color] = js.undefined
  var textureWidth: js.UndefOr[Int]           = js.undefined
  var textureHeight: js.UndefOr[Int]          = js.undefined
  var clipBias: js.UndefOr[Double]            = js.undefined
  var shader: js.UndefOr[js.Object]           = js.undefined
  var multisample: js.UndefOr[Int]            = js.undefined
}

/**
 * Companion object for Refractor with factory method.
 */
@js.native
@JSImport("three/examples/jsm/objects/Refractor.js", "Refractor")
object Refractor extends js.Object
