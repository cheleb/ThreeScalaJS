package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * Class for managing and tracking loaded and pending data.
 */
@js.native
@JSImport("three", "LoadingManager")
class LoadingManager(
  var onLoad: js.UndefOr[js.Function0[Unit]] = js.undefined,
  var onProgress: js.UndefOr[js.Function3[String, Int, Int, Unit]] = js.undefined,
  var onError: js.UndefOr[js.Function1[String, Unit]] = js.undefined
) extends js.Object {

  var onStart: js.Function3[String, Int, Int, Unit] = js.native

  /**
   * Base path for all file loading.
   */
  def setPath(path: String): this.type = js.native

  /**
   * Set a custom resource URL modifier.
   */
  def setURLModifier(callback: js.Function1[String, String]): this.type = js.native

  /**
   * Given a URL, returns the resolved URL (after any redirects).
   */
  def resolveURL(url: String): String = js.native

  /**
   * Check if item has completed loading.
   */
  def itemEnd(url: String): Unit = js.native

  /**
   * Mark item as being currently loaded.
   */
  def itemStart(url: String): Unit = js.native

  /**
   * Mark an item as having failed to load.
   */
  def itemError(url: String): Unit = js.native

  /**
   * Get current load progress (0 to 100).
   */
  def getItemLoadTime(url: String): Double = js.native

  /**
   * Returns the number of items currently being loaded.
   */
  def getNumberOfItemsToLoad(): Int = js.native

  /**
   * Returns the number of items already loaded.
   */
  def getNumberOfLoadedItems(): Int = js.native
}

/**
 * Default loading manager used by loaders if one isn't specified.
 */
@js.native
@JSImport("three", "DefaultLoadingManager")
object DefaultLoadingManager extends LoadingManager
