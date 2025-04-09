package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Abstract base class for cameras.
 */
@js.native
@JSImport("three", "Camera")
class Camera extends Object3D {

  var matrixWorldInverse: Matrix4      = js.native
  var projectionMatrix: Matrix4        = js.native
  var projectionMatrixInverse: Matrix4 = js.native

}
