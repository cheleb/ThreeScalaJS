package THREE.animation

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import THREE.Object3D

/**
 * `AnimationMixer` is a player for animations on a particular object in the
 * scene. When multiple objects in the scene are animated independently, one
 * `AnimationMixer` may be used for each object.
 */
@js.native
@JSImport("three", "AnimationMixer")
class AnimationMixer protected (root: Object3D) extends js.Object:

  /**
   * The global mixer time (in seconds; starting with `0` on the mixer's
   * creation).
   */
  def time: Double = js.native

  /**
   * A scaling factor for the global time.
   */
  def timeScale: Double = js.native

  /**
   * Returns an instance of {@link AnimationAction} for the passed clip.
   */
  def clipAction(clip: AnimationClip | String, optionalRoot: Object3D = ???): AnimationAction = js.native

  /**
   * Returns an existing animation action for the passed clip.
   */
  def existingAction(clip: AnimationClip | String, optionalRoot: Object3D = ???): AnimationAction | Null = js.native

  /**
   * Deactivates all previously scheduled actions on this mixer.
   */
  def stopAllAction(): AnimationMixer = js.native

  /**
   * Advances the global mixer time and updates the animation.
   */
  def update(deltaTime: Double): AnimationMixer = js.native

  /**
   * Sets the global mixer to a specific time and updates the animation
   * accordingly.
   */
  def setTime(time: Double): AnimationMixer = js.native

  /**
   * Returns this mixer's root object.
   */
  def getRoot(): Object3D = js.native

  /**
   * Deallocates all memory resources for a clip.
   */
  def uncacheClip(clip: AnimationClip): Unit = js.native

  /**
   * Deallocates all memory resources for a root object.
   */
  def uncacheRoot(root: Object3D): Unit = js.native

  /**
   * Deallocates all memory resources for an action.
   */
  def uncacheAction(clip: AnimationClip | String, optionalRoot: Object3D = ???): Unit = js.native
