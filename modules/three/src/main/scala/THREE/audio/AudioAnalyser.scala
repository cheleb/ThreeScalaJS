package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.Uint8Array

/**
 * Create a frequency analyser for audio sources. This uses the Web Audio API's
 * AnalyserNode to provide frequency and time domain data for visualization.
 */
@js.native
@JSImport("three", "AudioAnalyser")
class AudioAnalyser(audio: js.Any, fftSize: js.UndefOr[Int] = js.undefined) extends js.Object {

  /**
   * The analyser node for this analyser.
   */
  var analyser: js.Any = js.native

  /**
   * The data array for frequency data.
   */
  var data: Uint8Array = js.native

  /**
   * The FFT size for this analyser.
   */
  var analyserFftSize: Int = js.native

  /**
   * Get the frequency data for this analyser.
   */
  def getFrequencyData(): Uint8Array = js.native

  /**
   * Get the average frequency for this analyser.
   */
  def getAverageFrequency(): Double = js.native

  /**
   * Get the data array for this analyser.
   */
  def getData(file: js.Any): js.Any = js.native
}
