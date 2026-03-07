package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * This class is an alternative to Clock with a different API design and
 * behavior. The goal is to avoid the conceptual flaws that became apparent in
 * Clock over time.
 *
 *   - Timer has an update() method that updates its internal state. That makes
 *     it possible to call getDelta() and getElapsed() multiple times per
 *     simulation step without getting different values.
 *   - The class can make use of the Page Visibility API to avoid large time
 *     delta values when the app is inactive (e.g. tab switched or browser
 *     hidden).
 *
 * @since r183
 */
@js.native
@JSImport("three", "Timer")
class Timer extends js.Object {

  /**
   * Connect the timer to the given document. Calling this method is not
   * mandatory to use the timer but enables the usage of the Page Visibility API
   * to avoid large time delta values.
   */
  def connect(document: dom.Document): Unit = js.native

  /**
   * Disconnects the timer from the DOM and also disables the usage of the Page
   * Visibility API.
   */
  def disconnect(): Unit = js.native

  /**
   * Returns the time delta in seconds.
   */
  def getDelta(): Double = js.native

  /**
   * Returns the elapsed time in seconds.
   */
  def getElapsed(): Double = js.native

  /**
   * Returns the timescale.
   */
  def getTimescale(): Double = js.native

  /**
   * Sets the given timescale which scale the time delta computation in
   * update().
   */
  def setTimescale(timescale: Double): Timer = js.native

  /**
   * Resets the time computation for the current simulation step.
   */
  def reset(): Timer = js.native

  /**
   * Can be used to free all internal resources. Usually called when the timer
   * instance isn't required anymore.
   */
  def dispose(): Unit = js.native

  /**
   * Updates the internal state of the timer. This method should be called once
   * per simulation step and before you perform queries against the timer (e.g.
   * via getDelta()).
   *
   * @param timestamp
   *   The current time in milliseconds. Can be obtained from the
   *   requestAnimationFrame callback argument. If not provided, the current
   *   time will be determined with performance.now.
   */
  def update(timestamp: js.UndefOr[Double] = js.undefined): Timer = js.native
}

object Timer {
  def apply(): Timer = new Timer()
}
