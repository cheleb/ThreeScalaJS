package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * Class for loading an ImageBitmap.
 */
@js.native
@JSImport("three", "ImageBitmapLoader")
class ImageBitmapLoader(loadingManager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * Load an ImageBitmap from a URL.
   */
  def load(
    url: String,
    onLoad: js.UndefOr[js.Function1[org.scalajs.dom.ImageBitmap, Unit]] = js.undefined,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined,
    onError: js.UndefOr[js.Function1[js.Error, Unit]] = js.undefined
  ): org.scalajs.dom.ImageBitmap = js.native

  /**
   * Load an ImageBitmap from a URL asynchronously with Promise.
   */
  def loadAsync(
    url: String,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined
  ): js.Promise[org.scalajs.dom.ImageBitmap] = js.native

  /**
   * Set the loading manager for this loader.
   */
  def setPath(path: String): this.type = js.native

  /**
   * Set options for the loader.
   */
  def setOptions(options: js.Object): this.type = js.native
}
