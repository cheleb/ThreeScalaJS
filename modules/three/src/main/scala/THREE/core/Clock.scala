package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.annotation.nowarn

/**
 * Class for keeping track of time.
 *
 * @deprecated
 *   since r183. Use [[Timer]] instead.
 * @see
 *   [[Timer]] for the recommended replacement
 */
@js.native
@JSImport("three", "Clock")
@deprecated("Use THREE.Timer instead. Clock will be removed in a future version.", "r183")
class Clock(var autoStart: Boolean = true) extends js.Object {

  /** Holds the time at which the clock's start() method was last called. */
  var startTime: Double = js.native

  /**
   * Holds the time at which the clock's start(), getElapsedTime() or getDelta()
   * methods were last called.
   */
  var oldTime: Double = js.native

  /** Keeps track of the total time that the clock has been running. */
  var elapsedTime: Double = js.native

  /** Whether the clock is running or not. */
  var running: Boolean = js.native

  /** Starts the clock. */
  def start(): Unit = js.native

  /** Stops the clock. */
  def stop(): Unit = js.native

  /** Returns the elapsed time in seconds. */
  def getElapsedTime(): Double = js.native

  /** Returns the delta time in seconds. */
  def getDelta(): Double = js.native
}

object Clock {
  @nowarn
  def apply(autoStart: Boolean = true): Clock = new Clock(autoStart)
}
