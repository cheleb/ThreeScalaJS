package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Camera that uses perspective projection.
 */
@js.native
@JSImport("three", "PerspectiveCamera")
class PerspectiveCamera(
  var fov: js.UndefOr[Double] = js.undefined,
  var aspect: js.UndefOr[Double] = js.undefined,
  var near: js.UndefOr[Double] = js.undefined,
  var far: js.UndefOr[Double] = js.undefined
) extends Camera {

  var zoom: Double       = js.native
  var focus: Double      = js.native
  var filmGauge: Double  = js.native
  var filmOffset: Double = js.native

  def setFocalLength(focalLength: Double): Unit = js.native
  def getFocalLength(): Double                  = js.native
  def getEffectiveFOV(): Double                 = js.native
  def getFilmWidth(): Double                    = js.native
  def getFilmHeight(): Double                   = js.native

  def setViewOffset(fullWidth: Double, fullHeight: Double, x: Double, y: Double, width: Double, height: Double): Unit =
    js.native
  def clearViewOffset(): Unit = js.native

  def updateProjectionMatrix(): Unit = js.native
}
