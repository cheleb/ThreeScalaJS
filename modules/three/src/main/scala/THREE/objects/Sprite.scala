package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A sprite is a plane that always faces towards the camera. Sprites do not cast
 * shadows, do not receive shadows, and do not have any depth testing.
 */
@js.native
@JSImport("three", "Sprite")
class Sprite(var material: js.UndefOr[SpriteMaterial] = js.undefined) extends Object3D {

  /**
   * This flag can be used for type testing.
   */
  val isSprite: Boolean = js.native

  /**
   * The sprite's center point.
   */
  var center: Vector2 = js.native

  /**
   * Updates the sprite's screen-space rendering geometry.
   */
  def updateMorphTargets(): Unit = js.native

  /**
   * Computes intersection points between a casted ray and this sprite.
   *
   * @param raycaster
   *   \- The raycaster.
   * @param intersects
   *   \- The target array that holds the intersection points.
   */
  def raycast(raycaster: Raycaster, intersects: js.Array[js.Object]): Unit = js.native
}
