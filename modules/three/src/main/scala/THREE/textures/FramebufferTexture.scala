package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * This class can only be used in combination with `copyFramebufferToTexture()`
 * methods of renderers. It extracts the contents of the current bound
 * framebuffer and provides it as a texture for further usage.
 *
 * @example
 *   ```scala
 *   val pixelRatio  = scala.scalajs.dom.window.devicePixelRatio
 *   val textureSize = 128 * pixelRatio
 *
 *   val frameTexture = new FramebufferTexture(textureSize, textureSize)
 *
 *   // calculate start position for copying part of the frame data
 *   val vector = new Vector2()
 *   vector.x = (scala.scalajs.dom.window.innerWidth * pixelRatio / 2) - (textureSize / 2)
 *   vector.y = (scala.scalajs.dom.window.innerHeight * pixelRatio / 2) - (textureSize / 2)
 *
 *   renderer.render(scene, camera)
 *
 *   // copy part of the rendered frame into the framebuffer texture
 *   renderer.copyFramebufferToTexture(frameTexture, vector)
 *   ```
 */
@js.native
@JSImport("three", "FramebufferTexture")
class FramebufferTexture(
  var width: js.UndefOr[Double] = js.undefined,
  var height: js.UndefOr[Double] = js.undefined
) extends Texture {

  /**
   * This flag can be used for type testing.
   */
  val isFramebufferTexture: Boolean = js.native
}
