package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * Class for loading a font in JSON format.
 */
@js.native
@JSImport("three/addons/loaders/FontLoader.js", "FontLoader")
class FontLoader(loadingManager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * Load a font from a URL.
   */
  def load(
    url: String,
    onLoad: js.UndefOr[js.Function1[js.Object, Unit]] = js.undefined,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined,
    onError: js.UndefOr[js.Function1[js.Error, Unit]] = js.undefined
  ): js.Object = js.native

  /**
   * Load a font from a URL asynchronously with Promise.
   */
  def loadAsync(
    url: String,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined
  ): js.Promise[js.Object] = js.native

  /**
   * Parse a JSON structure and return a font.
   */
  def parse(json: js.Object): js.Object = js.native

  /**
   * Set the loading manager for this loader.
   */
  def setPath(path: String): this.type = js.native
}
