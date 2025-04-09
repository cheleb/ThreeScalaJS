package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Camera that uses orthographic projection.
 */
@js.native
@JSImport("three", "OrthographicCamera")
class OrthographicCamera(
  var left: js.UndefOr[Double] = js.undefined,
  var right: js.UndefOr[Double] = js.undefined,
  var top: js.UndefOr[Double] = js.undefined,
  var bottom: js.UndefOr[Double] = js.undefined,
  var near: js.UndefOr[Double] = js.undefined,
  var far: js.UndefOr[Double] = js.undefined
) extends Camera {

  def updateProjectionMatrix(): Unit = js.native
  def setViewOffset(fullWidth: Double, fullHeight: Double, x: Double, y: Double, width: Double, height: Double): Unit =
    js.native
  def clearViewOffset(): Unit = js.native
}
