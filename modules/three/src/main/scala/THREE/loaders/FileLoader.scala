package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.typedarray.ArrayBuffer

/**
 * Class for loading a file as a string or ArrayBuffer.
 */
@js.native
@JSImport("three/addons/loaders/", "FileLoader")
class FileLoader(loadingManager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * Load a file from a URL.
   */
  def load(
    url: String,
    onLoad: js.UndefOr[js.Function1[String | ArrayBuffer, Unit]] = js.undefined,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined,
    onError: js.UndefOr[js.Function1[js.Error, Unit]] = js.undefined
  ): String | ArrayBuffer = js.native

  /**
   * Load a file from a URL asynchronously with Promise.
   */
  def loadAsync(
    url: String,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined
  ): js.Promise[String | ArrayBuffer] = js.native

  /**
   * Set the loading manager for this loader.
   */
  def setPath(path: String): this.type = js.native

  /**
   * Set the response type for the loader.
   */
  def setResponseType(responseType: String): this.type = js.native

  /**
   * Set the mime type for the loader.
   */
  def setMimeType(mimeType: String): this.type = js.native

  /**
   * Set whether to use credentials when fetching the file.
   */
  def setWithCredentials(withCredentials: Boolean): this.type = js.native
}
