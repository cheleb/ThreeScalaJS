package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * This class is designed to assist with raycasting. Raycasting is used for
 * mouse picking and more.
 */
@js.native
@JSImport("three", "Raycaster")
class Raycaster(
  var origin: js.UndefOr[Vector3] = js.undefined,
  var direction: js.UndefOr[Vector3] = js.undefined,
  var near: js.UndefOr[Double] = js.undefined,
  var far: js.UndefOr[Double] = js.undefined
) extends js.Object {

  /**
   * This value can be used to filter away intersections that are closer than
   * the value.
   */
  var params: js.Dynamic = js.native

  /**
   * The Ray used for the raycasting.
   */
  val ray: Ray = js.native

  /**
   * Updates the ray with a new origin and direction.
   */
  def set(origin: Vector3, direction: Vector3): Unit = js.native

  /**
   * Checks all intersection between the ray and the objects with or without the
   * descendants. Intersections are returned sorted by distance, closest first.
   */
  def intersectObject(
    obj: Object3D,
    recursive: js.UndefOr[Boolean] = js.undefined,
    optionalTarget: js.UndefOr[js.Array[RaycasterIntersection]] = js.undefined
  ): js.Array[RaycasterIntersection] = js.native

  /**
   * Checks all intersection between the ray and the array of objects.
   * Intersections are returned sorted by distance, closest first.
   */
  def intersectObjects(
    objects: js.Array[Object3D],
    recursive: js.UndefOr[Boolean] = js.undefined,
    optionalTarget: js.UndefOr[js.Array[RaycasterIntersection]] = js.undefined
  ): js.Array[RaycasterIntersection] = js.native

  /**
   * Updates the ray with new origin and direction.
   */
  def setFromCamera(coords: Vector2, camera: Camera): Unit = js.native
}
