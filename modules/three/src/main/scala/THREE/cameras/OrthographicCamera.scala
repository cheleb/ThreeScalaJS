package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Camera that uses orthographic projection.
 */
@js.native
@JSImport("three", "OrthographicCamera")
class OrthographicCamera(
  var left: Double = -1.0,
  var right: Double = 1.0,
  var top: Double = 1.0,
  var bottom: Double = -1.0,
  var near: Double = 0.1,
  var far: Double = 2000.0
) extends Camera {

  def updateProjectionMatrix(): Unit = js.native
  def setViewOffset(fullWidth: Double, fullHeight: Double, x: Double, y: Double, width: Double, height: Double): Unit =
    js.native
  def clearViewOffset(): Unit = js.native
}
