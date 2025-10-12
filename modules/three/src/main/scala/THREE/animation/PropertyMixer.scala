package THREE.animation

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import THREE.animation.PropertyBinding

/**
 * Buffered scene graph property that allows weighted accumulation; used
 * internally.
 */
@js.native
@JSImport("three", "PropertyMixer")
class PropertyMixer protected () extends js.Object:

  /**
   * The property binding.
   */
  def binding: PropertyBinding = js.native

  /**
   * The keyframe track value size.
   */
  def valueSize: Double = js.native

  /**
   * The cumulative weight.
   */
  def cumulativeWeight: Double = js.native

  /**
   * The cumulative weight for additive animations.
   */
  def cumulativeWeightAdditive: Double = js.native

  /**
   * The use count.
   */
  def useCount: Double = js.native

  /**
   * The reference count.
   */
  def referenceCount: Double = js.native

  /**
   * Accumulates data in the `incoming` region into `accu<i>`.
   */
  def accumulate(accuIndex: Double, weight: Double): Unit = js.native

  /**
   * Accumulates data in the `incoming` region into `add`.
   */
  def accumulateAdditive(weight: Double): Unit = js.native

  /**
   * Applies the state of `accu<i>` to the binding when accus differ.
   */
  def apply(accuIndex: Double): Unit = js.native

  /**
   * Remembers the state of the bound property and copy it to both accus.
   */
  def saveOriginalState(): Unit = js.native

  /**
   * Applies the state previously taken via
   * {@link PropertyMixer#saveOriginalState} to the binding.
   */
  def restoreOriginalState(): Unit = js.native
