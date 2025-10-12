package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Create a positional audio object. This uses the Web Audio API's PannerNode to
 * create 3D spatial audio that changes based on the position of the listener
 * and the audio source.
 */
@js.native
@JSImport("three", "PositionalAudio")
class PositionalAudio(listener: AudioListener) extends Audio(listener) {

  /**
   * The panner node for this positional audio.
   */
  var panner: js.Any = js.native

  /**
   * Set the reference distance for this positional audio.
   */
  def setRefDistance(value: Double): Unit = js.native

  /**
   * Get the reference distance for this positional audio.
   */
  def getRefDistance(): Double = js.native

  /**
   * Set the rolloff factor for this positional audio.
   */
  def setRolloffFactor(value: Double): Unit = js.native

  /**
   * Get the rolloff factor for this positional audio.
   */
  def getRolloffFactor(): Double = js.native

  /**
   * Set the distance model for this positional audio.
   */
  def setDistanceModel(value: String): Unit = js.native

  /**
   * Get the distance model for this positional audio.
   */
  def getDistanceModel(): String = js.native

  /**
   * Set the max distance for this positional audio.
   */
  def setMaxDistance(value: Double): Unit = js.native

  /**
   * Get the max distance for this positional audio.
   */
  def getMaxDistance(): Double = js.native

  /**
   * Set the directional cone for this positional audio.
   */
  def setDirectionalCone(coneInnerAngle: Double, coneOuterAngle: Double, coneOuterGain: Double): Unit = js.native

  /**
   * Update the matrix world for this positional audio.
   */
  // def updateMatrixWorld(force: Boolean = false): Unit = js.native
}
