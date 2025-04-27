package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * The intersection point of a raycaster intersection test.
 */
@js.native
trait RaycasterIntersection extends js.Object {
  /**
   * The distance from the ray's origin to the intersection point.
   */
  val distance: Double = js.native
  
  /**
   * Some 3D objects e.g. Points provide the distance of the
   * intersection to the nearest point on the ray. 
   * For other objects it will be undefined.
   */
  val distanceToRay: js.UndefOr[Double] = js.native
  
  /**
   * The intersection point, in world coordinates.
   */
  val point: Vector3 = js.native
  
  /**
   * The face that has been intersected.
   */
  val face: js.UndefOr[js.Object] = js.native
  
  /**
   * The face index.
   */
  val faceIndex: js.UndefOr[Int] = js.native
  
  /**
   * The 3D object that has been intersected.
   */
  val `object`: Object3D = js.native
  
  /**
   * U,V coordinates at point of intersection.
   */
  val uv: js.UndefOr[Vector2] = js.native
  
  /**
   * Second set of U,V coordinates at point of intersection.
   */
  val uv1: js.UndefOr[Vector2] = js.native
  
  /**
   * Interpolated normal vector at point of intersection.
   */
  val normal: js.UndefOr[Vector3] = js.native
  
  /**
   * The index number of the instance where the ray
   * intersects the InstancedMesh.
   */
  val instanceId: js.UndefOr[Int] = js.native
}