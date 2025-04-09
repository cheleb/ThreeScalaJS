package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Interface that represents a mesh-like object that can be added to a scene.
 */
@js.native
trait MeshObject3D extends Object3D {

  /**
   * The geometry of this mesh-like object.
   */
  var geometry: BufferGeometry

  /**
   * The material of this mesh-like object.
   */
  var material: js.Any
}
