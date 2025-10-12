package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * Class for loading a JSON format material.
 */
@js.native
@JSImport("three", "MaterialLoader")
class MaterialLoader(loadingManager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * Load a material from a URL.
   */
  def load(
    url: String,
    onLoad: js.UndefOr[js.Function1[Material, Unit]] = js.undefined,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined,
    onError: js.UndefOr[js.Function1[js.Error, Unit]] = js.undefined
  ): Material = js.native

  /**
   * Load a material from a URL asynchronously with Promise.
   */
  def loadAsync(
    url: String,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined
  ): js.Promise[Material] = js.native

  /**
   * Parse a JSON structure and return a material.
   */
  def parse(json: js.Object): Material = js.native

  /**
   * Set the loading manager for this loader.
   */
  def setPath(path: String): this.type = js.native

  /**
   * Set textures for the material loader.
   */
  def setTextures(textures: js.Object): this.type = js.native
}
