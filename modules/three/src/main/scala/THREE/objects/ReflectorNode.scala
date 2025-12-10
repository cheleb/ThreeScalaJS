package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|

/**
 * A node-based reflector for use with WebGPURenderer.
 *
 * This is the node-based version of Reflector that works with the node material
 * system and WebGPURenderer. Unlike the regular Reflector, this uses the modern
 * node-based rendering pipeline.
 *
 * Note: This class can only be used with WebGPURenderer. For WebGLRenderer, use
 * the regular Reflector class.
 *
 * Example:
 * ```scala sc:nocompile
 * // Create a reflector node with modern API (r180+)
 * val reflectorNode = new ReflectorNode(
 *   js.Dynamic.literal(
 *     resolutionScale = 1.0, // Note: resolutionScale, not resolution (changed in r180)
 *     color = 0xc1cbcb,
 *     distortion = 0.1
 *   )
 * )
 * ```
 *
 * @param options
 *   Configuration options for the reflector node
 */
@js.native
@JSImport("three/nodes", "ReflectorNode")
class ReflectorNode(options: js.UndefOr[ReflectorNodeOptions] = js.undefined) extends js.Object {

  /**
   * The resolution scale of the reflector's internal render target. This
   * replaces the old 'resolution' property that was deprecated in r180.
   *
   * Default is 1.0. Higher values increase quality but reduce performance.
   */
  var resolutionScale: Double = js.native

  /**
   * The color of the reflector. Can be a hex color, CSS color string, or Color
   * object.
   */
  var color: Int | String | Color = js.native

  /**
   * The amount of distortion applied to the reflection. Default is 0 (no
   * distortion).
   */
  var distortion: Double = js.native

  /**
   * The reflector's virtual camera used for rendering the reflection.
   */
  val camera: PerspectiveCamera = js.native

  /**
   * The texture containing the reflection.
   */
  val texture: js.Object = js.native

  /**
   * Updates the reflector node. Should be called before rendering.
   */
  def update(): Unit = js.native

  /**
   * Disposes of GPU resources used by this reflector node. Call this when the
   * reflector is no longer needed.
   */
  def dispose(): Unit = js.native
}

/**
 * Configuration options for ReflectorNode.
 */
trait ReflectorNodeOptions extends js.Object {

  /**
   * The resolution scale of the internal render target. Note: This is called
   * 'resolutionScale' in r180+, replacing the old 'resolution' parameter.
   */
  var resolutionScale: js.UndefOr[Double] = js.undefined

  /**
   * The color of the reflector.
   */
  var color: js.UndefOr[Int | String | Color] = js.undefined

  /**
   * The amount of distortion in the reflection.
   */
  var distortion: js.UndefOr[Double] = js.undefined

  /**
   * The mixer for combining the reflection with the base material.
   */
  var mixer: js.UndefOr[js.Object] = js.undefined
}

/**
 * Companion object for ReflectorNode with factory methods.
 */
object ReflectorNode {

  /**
   * Creates a new ReflectorNode instance.
   */
  def apply(options: js.UndefOr[ReflectorNodeOptions] = js.undefined): ReflectorNode = new ReflectorNode(options)
}
