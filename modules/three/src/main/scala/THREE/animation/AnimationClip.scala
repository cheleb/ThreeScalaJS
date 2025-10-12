package THREE.animation

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

import THREE.NormalAnimationBlendMode

/**
 * A reusable set of keyframe tracks which represent an animation.
 */

@js.native
@JSImport("three", "AnimationClip")
class AnimationClip protected () extends js.Object:

  /**
   * The clip's name.
   */
  def name: String = js.native

  /**
   * An array of keyframe tracks.
   */
  def tracks: js.Array[KeyframeTrack] = js.native

  /**
   * The clip's duration in seconds.
   */
  def duration: Double = js.native

  /**
   * Defines how the animation is blended/combined when two or more animations
   * are simultaneously played.
   */
  def blendMode: Int = js.native

  /**
   * The UUID of the animation clip.
   */
  def uuid: String = js.native

  /**
   * An object that can be used to store custom data about the animation clip.
   */
  def userData: js.Object = js.native

  /**
   * Sets the duration of this clip to the duration of its longest keyframe
   * track.
   */
  def resetDuration(): AnimationClip = js.native

  /**
   * Trims all tracks to the clip's duration.
   */
  def trim(): AnimationClip = js.native

  /**
   * Performs minimal validation on each track in the clip.
   */
  def validate(): Boolean = js.native

  /**
   * Optimizes each track by removing equivalent sequential keys.
   */
  def optimize(): AnimationClip = js.native

  /**
   * Returns a new animation clip with copied values from this instance.
   */
  override def clone(): AnimationClip = js.native

  /**
   * Serializes this animation clip into JSON.
   */
  def toJSON(): js.Object = js.native

@js.native
@JSImport("three", "AnimationClip")
object AnimationClip extends js.Object:

  /**
   * Factory method for creating an animation clip from the given JSON.
   */
  def parse(json: js.Object): AnimationClip = js.native

  /**
   * Serializes the given animation clip into JSON.
   */
  def toJSON(clip: AnimationClip): js.Object = js.native

  /**
   * Returns a new animation clip from the passed morph targets array of a
   * geometry, taking a name and the number of frames per second.
   */
  def CreateFromMorphTargetSequence(
    name: String,
    morphTargetSequence: js.Array[js.Object],
    fps: Double,
    noLoop: Boolean
  ): AnimationClip = js.native

  /**
   * Searches for an animation clip by name, taking as its first parameter
   * either an array of clips, or a mesh or geometry that contains an array
   * named "animations" property.
   */
  def findByName(objectOrClipArray: js.Object, name: String): AnimationClip | Null = js.native

  /**
   * Returns an array of new AnimationClips created from the morph target
   * sequences of a geometry.
   */
  def CreateClipsFromMorphTargetSequences(
    morphTargets: js.Array[js.Object],
    fps: Double,
    noLoop: Boolean
  ): js.Array[AnimationClip] = js.native

  /**
   * Parses the `animation.hierarchy` format and returns a new animation clip.
   */
  def parseAnimation(animation: js.Object, bones: js.Array[js.Object]): AnimationClip | Null = js.native
