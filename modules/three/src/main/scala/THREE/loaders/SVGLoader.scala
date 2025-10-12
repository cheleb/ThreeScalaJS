package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for loading SVG files.
 */
@js.native
@JSImport("three", "SVGLoader")
class SVGLoader(loadingManager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * Load an SVG from a URL.
   */
  def load(
    url: String,
    onLoad: js.UndefOr[js.Function1[SVGResult, Unit]] = js.undefined,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined,
    onError: js.UndefOr[js.Function1[js.Error, Unit]] = js.undefined
  ): SVGResult = js.native

  /**
   * Load an SVG from a URL asynchronously with Promise.
   */
  def loadAsync(
    url: String,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined
  ): js.Promise[SVGResult] = js.native

  /**
   * Parse SVG content and return an SVGResult.
   */
  def parse(text: String): SVGResult = js.native

  /**
   * Set the loading manager for this loader.
   */
  def setPath(path: String): this.type = js.native
}

/**
 * SVG result object containing parsed paths.
 */
@js.native
trait SVGResult extends js.Object {
  val paths: js.Array[SVGPath] = js.native
  val xml: js.Object           = js.native
}

/**
 * SVG path object containing path data.
 */
@js.native
trait SVGPath extends js.Object {
  val `type`: String      = js.native
  val path: String        = js.native
  val userData: js.Object = js.native
}
