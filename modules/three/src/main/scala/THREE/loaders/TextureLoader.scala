package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom
import js.Promise

/**
 * Class for loading a texture.
 */
@js.native
@JSImport("three", "TextureLoader")
class TextureLoader(loadingManager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * Load a texture from a URL.
   */
  def load(
    url: String,
    onLoad: js.UndefOr[js.Function1[Texture, Unit]] = js.undefined,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined,
    onError: js.UndefOr[js.Function1[js.Error, Unit]] = js.undefined
  ): Texture = js.native

  /**
   * Load a texture from a URL asynchronously with Promise.
   */
  def loadAsync(
    url: String,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined
  ): js.Promise[Texture] = js.native

  /**
   * Set the loading manager for this loader.
   */
  def setPath(path: String): this.type = js.native
}
