package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * Class for loading a CubeTexture.
 */
@js.native
@JSImport("three", "CubeTextureLoader")
class CubeTextureLoader(loadingManager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * Load a cube texture from six URLs.
   */
  def load(
    urls: js.Array[String],
    onLoad: js.UndefOr[js.Function1[CubeTexture, Unit]] = js.undefined,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined,
    onError: js.UndefOr[js.Function1[js.Error, Unit]] = js.undefined
  ): CubeTexture = js.native

  /**
   * Set the path for the six CubeTexture images.
   */
  def setPath(path: String): this.type = js.native
}
