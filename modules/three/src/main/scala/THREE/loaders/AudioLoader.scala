package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.typedarray.{ArrayBuffer, Float32Array}

/**
 * Class for loading an audio file.
 */
@js.native
@JSImport("three", "AudioLoader")
class AudioLoader(loadingManager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * Load an audio buffer from a URL.
   */
  def load(
    url: String,
    onLoad: js.UndefOr[js.Function1[AudioBuffer, Unit]] = js.undefined,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined,
    onError: js.UndefOr[js.Function1[js.Error, Unit]] = js.undefined
  ): AudioBuffer = js.native

  /**
   * Load an audio buffer from a URL asynchronously with Promise.
   */
  def loadAsync(
    url: String,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined
  ): js.Promise[AudioBuffer] = js.native

  /**
   * Set the loading manager for this loader.
   */
  def setPath(path: String): this.type = js.native
}

/**
 * Audio buffer interface for loaded audio data.
 */
@js.native
trait AudioBuffer extends js.Object {
  val sampleRate: Double       = js.native
  val length: Double           = js.native
  val duration: Double         = js.native
  val numberOfChannels: Double = js.native

  def getChannelData(channel: Double): Float32Array = js.native
}
