package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom
import js.Promise

/**
 * A loader for the S3TC texture compression format (DDS files).
 */
@js.native
@JSImport("three/addons/loaders/DDSLoader.js", "DDSLoader")
class DDSLoader(loadingManager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * Load a DDS texture from a URL.
   */
  def load(
    url: String,
    onLoad: js.UndefOr[js.Function1[CompressedTexture, Unit]] = js.undefined,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined,
    onError: js.UndefOr[js.Function1[js.Error, Unit]] = js.undefined
  ): CompressedTexture = js.native

  /**
   * Load a DDS texture from a URL asynchronously with Promise.
   */
  def loadAsync(
    url: String,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined
  ): js.Promise[CompressedTexture] = js.native

  /**
   * Parse DDS texture data from an ArrayBuffer.
   */
  def parse(
    buffer: js.typedarray.ArrayBuffer,
    loadMipmaps: Boolean
  ): js.Object = js.native

  /**
   * Set the loading manager for this loader.
   */
  def setPath(path: String): this.type = js.native
}
