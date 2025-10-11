package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|

/**
 * Can be used to create a flat, reflective surface like a mirror.
 *
 * Note that this class can only be used with WebGLRenderer. When using
 * WebGPURenderer, use ReflectorNode.
 *
 * Example:
 * ```scala sc:nocompile
 * val geometry = PlaneGeometry(100, 100)
 *
 * val reflector = new Reflector(
 *   geometry,
 *   js.Dynamic.literal(
 *     clipBias = 0.003,
 *     textureWidth = window.innerWidth * window.devicePixelRatio,
 *     textureHeight = window.innerHeight * window.devicePixelRatio,
 *     color = 0xc1cbcb
 *   )
 * )
 *
 * scene.add(reflector)
 * ```
 */
@js.native
@JSImport("three/examples/jsm/objects/Reflector.js", "Reflector")
class Reflector(
  geometry: BufferGeometry,
  options: js.UndefOr[ReflectorOptions] = js.undefined
) extends Mesh(geometry, js.undefined) {

  /**
   * This flag can be used for type testing.
   */
  val isReflector: Boolean = js.native

  /**
   * Whether to force an update, no matter if the reflector is in view or not.
   */
  var forceUpdate: Boolean = js.native

  /**
   * The reflector's virtual camera. This is used to render the scene from the
   * mirror's point of view.
   */
  val camera: PerspectiveCamera = js.native

  /**
   * Returns the reflector's internal render target.
   */
  def getRenderTarget(): js.Any = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native
}

/**
 * Constructor options for Reflector.
 */
trait ReflectorOptions extends js.Object {
  var color: js.UndefOr[Int | String | Color] = js.undefined
  var textureWidth: js.UndefOr[Int]           = js.undefined
  var textureHeight: js.UndefOr[Int]          = js.undefined
  var clipBias: js.UndefOr[Double]            = js.undefined
  var shader: js.UndefOr[js.Object]           = js.undefined
  var multisample: js.UndefOr[Int]            = js.undefined
}

/**
 * Companion object for Reflector with factory method.
 */
@js.native
@JSImport("three/examples/jsm/objects/Reflector.js", "Reflector")
object Reflector extends js.Object
