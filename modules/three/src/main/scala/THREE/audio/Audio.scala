package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Create a non-positional audio object. This uses the Web Audio API and can
 * play audio clips that are either loaded via the AudioLoader or created
 * dynamically.
 */
@js.native
@JSImport("three", "Audio")
class Audio(listener: AudioListener) extends js.Object {

  /**
   * The audio context for this audio source.
   */
  var context: js.Any = js.native

  /**
   * The gain node for this audio source.
   */
  var gain: js.Any = js.native

  /**
   * Whether the audio is currently playing.
   */
  var isPlaying: Boolean = js.native

  /**
   * Whether the audio has loaded.
   */
  var hasPlaybackControl: Boolean = js.native

  /**
   * The source node for this audio.
   */
  var source: js.Any = js.native

  /**
   * The audio buffer for this audio source.
   */
  var buffer: AudioBuffer = js.native

  /**
   * The type of source for this audio.
   */
  var sourceType: String = js.native

  /**
   * The playback rate for this audio.
   */
  var playbackRate: Double = js.native

  /**
   * The current time of the audio playback.
   */
  var currentTime: Double = js.native

  /**
   * Set the audio buffer for this audio source.
   */
  def setBuffer(audioBuffer: AudioBuffer): Unit = js.native

  /**
   * Set the playback rate for this audio source.
   */
  def setPlaybackRate(value: Double): Unit = js.native

  /**
   * Set the volume for this audio source.
   */
  def setVolume(value: Double): Unit = js.native

  /**
   * Get the volume for this audio source.
   */
  def getVolume(): Double = js.native

  /**
   * Set the loop property for this audio source.
   */
  def setLoop(value: Boolean): Unit = js.native

  /**
   * Get the loop property for this audio source.
   */
  def getLoop(): Boolean = js.native

  /**
   * Start playing the audio.
   */
  def play(delay: Double = 0.0): Unit = js.native

  /**
   * Pause the audio playback.
   */
  def pause(): Unit = js.native

  /**
   * Stop the audio playback.
   */
  def stop(): Unit = js.native

  /**
   * Connect this audio source to another audio node.
   */
  def connect(audioNode: js.Any): Unit = js.native

  /**
   * Disconnect this audio source from another audio node.
   */
  def disconnect(): Unit = js.native

  /**
   * Get the filter for this audio source.
   */
  def getFilter(): js.Any = js.native

  /**
   * Set the filter for this audio source.
   */
  def setFilter(filter: js.Any): Unit = js.native

  /**
   * Get the filters for this audio source.
   */
  def getFilters(): js.Array[js.Any] = js.native

  /**
   * Set the filters for this audio source.
   */
  def setFilters(value: js.Array[js.Any]): Unit = js.native

  /**
   * Get the output for this audio source.
   */
  def getOutput(): js.Any = js.native

  /**
   * Update the matrix world for this audio source.
   */
  def updateMatrixWorld(force: Boolean = false): Unit = js.native
}
