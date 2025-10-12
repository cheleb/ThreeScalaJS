package THREE.animation

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.Float32Array

import THREE.InterpolateLinear
import THREE.InterpolateSmooth
import THREE.InterpolateDiscrete

/**
 * Represents a timed sequence of keyframes, which are composed of lists of
 * times and related values, and which are used to animate a specific property
 * of an object.
 */
@js.native
@JSImport("three", "KeyframeTrack")
class KeyframeTrack protected () extends js.Object:

  /**
   * The track's name can refer to morph targets or bones or possibly other
   * values within an animated object.
   */
  def name: String = js.native

  /**
   * The keyframe times.
   */
  def times: Float32Array = js.native

  /**
   * The keyframe values.
   */
  def values: Float32Array = js.native

  /**
   * Converts the keyframe track to JSON.
   */
  def toJSON(): js.Object = js.native

  /**
   * Defines the interpolation factor method for this keyframe track.
   */
  def setInterpolation(interpolation: Int): KeyframeTrack = js.native

  /**
   * Returns the current interpolation type.
   */
  def getInterpolation(): Int = js.native

  /**
   * Returns the value size.
   */
  def getValueSize(): Double = js.native

  /**
   * Moves all keyframes either forward or backward in time.
   */
  def shift(timeOffset: Double): KeyframeTrack = js.native

  /**
   * Scale all keyframe times by a factor (useful for frame - seconds
   * conversions).
   */
  def scale(timeScale: Double): KeyframeTrack = js.native

  /**
   * Removes keyframes before and after animation without changing any values
   * within the defined time range.
   */
  def trim(startTime: Double, endTime: Double): KeyframeTrack = js.native

  /**
   * Performs minimal validation on the keyframe track.
   */
  def validate(): Boolean = js.native

  /**
   * Optimizes this keyframe track by removing equivalent sequential keys.
   */
  def optimize(): KeyframeTrack = js.native

  /**
   * Returns a new keyframe track with copied values from this instance.
   */
  override def clone(): KeyframeTrack = js.native

@js.native
@JSImport("three", "KeyframeTrack")
object KeyframeTrack extends js.Object:

  /**
   * Converts the keyframe track to JSON.
   */
  def toJSON(track: KeyframeTrack): js.Object = js.native

  /**
   * The value type name.
   */
  val ValueTypeName: String = js.native

  /**
   * The time buffer type of this keyframe track.
   */
  val TimeBufferType: js.Function = js.native

  /**
   * The value buffer type of this keyframe track.
   */
  val ValueBufferType: js.Function = js.native

  /**
   * The default interpolation type of this keyframe track.
   */
  val DefaultInterpolation: Int = js.native
