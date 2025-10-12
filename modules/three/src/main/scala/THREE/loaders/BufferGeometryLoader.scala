package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * Class for loading a buffer geometry from JSON format.
 */
@js.native
@JSImport("three", "BufferGeometryLoader")
class BufferGeometryLoader(loadingManager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * Load a buffer geometry from a URL.
   */
  def load(
    url: String,
    onLoad: js.UndefOr[js.Function1[BufferGeometry, Unit]] = js.undefined,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined,
    onError: js.UndefOr[js.Function1[js.Error, Unit]] = js.undefined
  ): BufferGeometry = js.native

  /**
   * Load a buffer geometry from a URL asynchronously with Promise.
   */
  def loadAsync(
    url: String,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined
  ): js.Promise[BufferGeometry] = js.native

  /**
   * Parse a JSON structure and return a buffer geometry.
   */
  def parse(json: js.Object): BufferGeometry = js.native

  /**
   * Set the loading manager for this loader.
   */
  def setPath(path: String): this.type = js.native
}
