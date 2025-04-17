package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A continuous line.
 *
 * This is nearly the same as LineSegments; the only difference is that it is
 * rendered using gl.LINE_STRIP instead of gl.LINES.
 */
@js.native
@JSImport("three", "Line")
class Line(
  var geometry: BufferGeometry = js.native,

  /**
   * Material for the line.
   */
  var material: js.Any = js.native
) extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isLine: Boolean = js.native

  /**
   * An array of weights typically from 0-1 that specify how much of the morph
   * is applied.
   */
  var morphTargetInfluences: js.UndefOr[js.Array[Double]] = js.native

  /**
   * A dictionary of morphTargets based on the morphTarget.name property.
   */
  var morphTargetDictionary: js.UndefOr[js.Dictionary[Double]] = js.native

  /**
   * Computes an array of distance values which are necessary for
   * LineDashedMaterial. For each vertex in the geometry, the method calculates
   * the cumulative length from the current point to the very beginning of the
   * line.
   */
  def computeLineDistances(): this.type = js.native

  /**
   * Updates the morphTargets to have no influence on the object. Resets the
   * morphTargetInfluences and morphTargetDictionary properties.
   */
  def updateMorphTargets(): Unit = js.native
}

/**
 * Companion object for Line class
 */
@js.native
@JSImport("three", "Line")
object Line extends js.Object
