package THREE.animation

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import THREE.Object3D
import THREE.NormalAnimationBlendMode
import THREE.AdditiveAnimationBlendMode
import THREE.LoopRepeat
import THREE.LoopOnce
import THREE.LoopPingPong

/**
 * An instance of `AnimationAction` schedules the playback of an animation which
 * is stored in {@link AnimationClip}.
 */
@js.native
@JSImport("three", "AnimationAction")
class AnimationAction protected () extends js.Object:

  /**
   * Defines how the animation is blended/combined when two or more animations
   * are simultaneously played.
   */
  def blendMode: Int = js.native

  /**
   * The loop mode, set via {@link AnimationAction#setLoop}.
   */
  def loop: Int = js.native

  /**
   * The local time of this action (in seconds, starting with `0`).
   */
  def time: Double = js.native

  /**
   * Scaling factor for the {@link AnimationAction#time}. A value of `0` causes
   * the animation to pause. Negative values cause the animation to play
   * backwards.
   */
  def timeScale: Double = js.native

  /**
   * The degree of influence of this action (in the interval `[0, 1]`). Values
   * between `0` (no impact) and `1` (full impact) can be used to blend between
   * several actions.
   */
  def weight: Double = js.native

  /**
   * The number of repetitions of the performed clip over the course of this
   * action.
   */
  def repetitions: Double = js.native

  /**
   * If set to `true`, the playback of the action is paused.
   */
  def paused: Boolean = js.native

  /**
   * If set to `false`, the action is disabled so it has no impact.
   */
  def enabled: Boolean = js.native

  /**
   * If set to true the animation will automatically be paused on its last
   * frame.
   */
  def clampWhenFinished: Boolean = js.native

  /**
   * Enables smooth interpolation without separate clips for start, loop and
   * end.
   */
  def zeroSlopeAtStart: Boolean = js.native

  /**
   * Enables smooth interpolation without separate clips for start, loop and
   * end.
   */
  def zeroSlopeAtEnd: Boolean = js.native

  /**
   * Starts the playback of the animation.
   */
  def play(): AnimationAction = js.native

  /**
   * Stops the playback of the animation.
   */
  def stop(): AnimationAction = js.native

  /**
   * Resets the playback of the animation.
   */
  def reset(): AnimationAction = js.native

  /**
   * Returns `true` if the animation is running.
   */
  def isRunning(): Boolean = js.native

  /**
   * Returns `true` when {@link AnimationAction#play} has been called.
   */
  def isScheduled(): Boolean = js.native

  /**
   * Defines the time when the animation should start.
   */
  def startAt(time: Double): AnimationAction = js.native

  /**
   * Configures the loop settings for this action.
   */
  def setLoop(mode: Int, repetitions: Double): AnimationAction = js.native

  /**
   * Sets the effective weight of this action.
   */
  def setEffectiveWeight(weight: Double): AnimationAction = js.native

  /**
   * Returns the effective weight of this action.
   */
  def getEffectiveWeight(): Double = js.native

  /**
   * Fades the animation in by increasing its weight gradually from `0` to `1`,
   * within the passed time interval.
   */
  def fadeIn(duration: Double): AnimationAction = js.native

  /**
   * Fades the animation out by decreasing its weight gradually from `1` to `0`,
   * within the passed time interval.
   */
  def fadeOut(duration: Double): AnimationAction = js.native

  /**
   * Causes this action to fade in and the given action to fade out, within the
   * passed time interval.
   */
  def crossFadeFrom(fadeOutAction: AnimationAction, duration: Double, warp: Boolean = false): AnimationAction =
    js.native

  /**
   * Causes this action to fade out and the given action to fade in, within the
   * passed time interval.
   */
  def crossFadeTo(fadeInAction: AnimationAction, duration: Double, warp: Boolean = false): AnimationAction = js.native

  /**
   * Stops any fading which is applied to this action.
   */
  def stopFading(): AnimationAction = js.native

  /**
   * Sets the effective time scale of this action.
   */
  def setEffectiveTimeScale(timeScale: Double): AnimationAction = js.native

  /**
   * Returns the effective time scale of this action.
   */
  def getEffectiveTimeScale(): Double = js.native

  /**
   * Sets the duration for a single loop of this action.
   */
  def setDuration(duration: Double): AnimationAction = js.native

  /**
   * Synchronizes this action with the passed other action.
   */
  def syncWith(action: AnimationAction): AnimationAction = js.native

  /**
   * Decelerates this animation's speed to `0` within the passed time interval.
   */
  def halt(duration: Double): AnimationAction = js.native

  /**
   * Changes the playback speed, within the passed time interval, by modifying
   * {@link AnimationAction#timeScale} gradually from `startTimeScale` to
   * `endTimeScale`.
   */
  def warp(startTimeScale: Double, endTimeScale: Double, duration: Double): AnimationAction = js.native

  /**
   * Stops any scheduled warping which is applied to this action.
   */
  def stopWarping(): AnimationAction = js.native

  /**
   * Returns the animation mixer of this animation action.
   */
  def getMixer(): AnimationMixer = js.native

  /**
   * Returns the animation clip of this animation action.
   */
  def getClip(): AnimationClip = js.native

  /**
   * Returns the root object of this animation action.
   */
  def getRoot(): Object3D = js.native
