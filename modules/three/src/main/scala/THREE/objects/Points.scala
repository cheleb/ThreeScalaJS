package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.scalajs.js.|

/**
 * A class for displaying points.
 */
@js.native
@JSImport("three", "Points")
class Points(
  var geometry: js.UndefOr[BufferGeometry] = js.undefined,
  var material: js.UndefOr[Material | js.Array[Material]] = js.undefined
) extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isPoints: Boolean = js.native

  /**
   * A dictionary representing the morph targets in the geometry.
   */
  var morphTargetDictionary: js.UndefOr[js.Dictionary[Int]] = js.native

  /**
   * An array of weights for morph targets.
   */
  var morphTargetInfluences: js.UndefOr[js.Array[Double]] = js.native

  /**
   * Updates morph targets to influence this object.
   */
  def updateMorphTargets(): Unit = js.native
}

/**
 * Companion object for Points with factory method.
 */
@js.native
@JSImport("three", "Points")
object Points extends js.Object
