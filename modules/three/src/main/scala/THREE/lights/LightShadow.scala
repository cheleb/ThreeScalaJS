package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Abstract base class for light shadow classes. These classes represent the
 * shadow configuration for different light types.
 */
@js.native
@JSImport("three", "LightShadow")
class LightShadow(var camera: Camera) extends js.Object {

  /**
   * The intensity of the shadow. The default is `1`. Valid values are in the
   * range `[0, 1]`.
   */
  var intensity: Double = js.native

  /**
   * Shadow map bias, how much to add or subtract from the normalized depth when
   * deciding whether a surface is in shadow.
   *
   * The default is `0`. Very tiny adjustments here (in the order of `0.0001`)
   * may help reduce artifacts in shadows.
   */
  var bias: Double = js.native

  /**
   * Defines how much the position used to query the shadow map is offset along
   * the object normal. The default is `0`. Increasing this value can be used to
   * reduce shadow acne especially in large scenes where light shines onto
   * geometry at a shallow angle. The cost is that shadows may appear distorted.
   */
  var normalBias: Double = js.native

  /**
   * Setting this to values greater than 1 will blur the edges of the shadow.
   * High values will cause unwanted banding effects in the shadows - a greater
   * map size will allow for a higher value to be used here before these effects
   * become visible.
   *
   * The property has no effect when the shadow map type is `PCFSoftShadowMap`
   * and and it is recommended to increase softness by decreasing the shadow map
   * size instead.
   *
   * The property has no effect when the shadow map type is `BasicShadowMap`.
   */
  var radius: Double = js.native

  /**
   * The amount of samples to use when blurring a VSM shadow map.
   */
  var blurSamples: Double = js.native

  /**
   * Defines the width and height of the shadow map. Higher values give better
   * quality shadows at the cost of computation time. Values must be powers of
   * two.
   */
  var mapSize: Vector2 = js.native

  /**
   * The type of shadow texture. The default is `UnsignedByteType`.
   */
  var mapType: Double = js.native

  /**
   * The depth map generated using the internal camera; a location beyond a
   * pixel's depth is in shadow. Computed internally during rendering.
   */
  var map: js.Object = js.native

  /**
   * The distribution map generated using the internal camera; an occlusion is
   * calculated based on the distribution of depths. Computed internally during
   * rendering.
   */
  var mapPass: js.Object = js.native

  /**
   * Model to shadow camera space, to compute location and depth in shadow map.
   * This is computed internally during rendering.
   */
  var matrix: Matrix4 = js.native

  /**
   * Enables automatic updates of the light's shadow. If you do not require
   * dynamic lighting / shadows, you may set this to `false`.
   */
  var autoUpdate: Boolean = js.native

  /**
   * When set to `true`, shadow maps will be updated in the next `render` call.
   * If you have set {@link LightShadow#autoUpdate} to `false`, you will need to
   * set this property to `true` and then make a render call to update the
   * light's shadow.
   */
  var needsUpdate: Boolean = js.native

  /**
   * Used internally by the renderer to get the number of viewports that need to
   * be rendered for this shadow.
   */
  def getViewportCount(): Double = js.native

  /**
   * Gets the shadow cameras frustum. Used internally by the renderer to cull
   * objects.
   */
  def getFrustum(): Frustum = js.native

  /**
   * Update the matrices for the camera and shadow, used internally by the
   * renderer.
   */
  def updateMatrices(light: Light): Unit = js.native

  /**
   * Returns a viewport definition for the given viewport index.
   */
  def getViewport(viewportIndex: Double): Vector4 = js.native

  /**
   * Returns the frame extends.
   */
  def getFrameExtents(): Vector2 = js.native

  /**
   * Frees the GPU-related resources allocated by this instance. Call this
   * method whenever this instance is no longer used in your app.
   */
  def dispose(): Unit = js.native

  /**
   * Copies the values of the given light shadow instance to this instance.
   */
  def copy(source: LightShadow): LightShadow = js.native

  /**
   * Returns a new light shadow instance with copied values from this instance.
   */
  override def clone(): LightShadow = js.native

  /**
   * Serializes the light shadow into JSON.
   */
  def toJSON(): js.Object = js.native
}

/**
 * Companion object for LightShadow with factory method
 */
@js.native
@JSImport("three", "LightShadow")
object LightShadow extends js.Object
