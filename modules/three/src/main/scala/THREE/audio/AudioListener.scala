package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * The AudioListener represents a virtual listener of the audio sources in a
 * scene. It is similar to a camera in the visual scene - it has a position and
 * orientation in 3D space, and defines from where the audio is heard.
 */
@js.native
@JSImport("three", "AudioListener")
class AudioListener extends js.Object {

  /**
   * The audio context to use for the listener.
   */
  var context: js.Any = js.native

  /**
   * The gain node for the listener.
   */
  var gain: js.Any = js.native

  /**
   * The filter node for the listener.
   */
  var filter: js.Any = js.native

  /**
   * Time delta for the listener.
   */
  var timeDelta: Double = js.native

  /**
   * Set the master volume for the listener.
   */
  def setMasterVolume(value: Double): Unit = js.native

  /**
   * Get the master volume for the listener.
   */
  def getMasterVolume(): Double = js.native

  /**
   * Get the input for the listener.
   */
  def getInput(): js.Any = js.native

  /**
   * Remove the filter from the listener.
   */
  def removeFilter(): Unit = js.native

  /**
   * Set the filter for the listener.
   */
  def setFilter(value: js.Any): Unit = js.native

  /**
   * Get the filter for the listener.
   */
  def getFilter(): js.Any = js.native

  /**
   * Set the position of the listener in 3D space.
   */
  def setPosition(x: Double, y: Double, z: Double): Unit = js.native

  /**
   * Set the orientation of the listener in 3D space.
   */
  def setOrientation(x: Double, y: Double, z: Double, xUp: Double, yUp: Double, zUp: Double): Unit = js.native

  /**
   * Update the position and orientation of the listener based on a matrix.
   */
  def updateMatrixWorld(force: Boolean = false): Unit = js.native
}
