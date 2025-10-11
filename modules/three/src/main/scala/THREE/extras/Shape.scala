package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

@js.native
@JSImport("three", "Shape")
class Shape(
  points: js.Array[Vector2] =
    js.Array(new Vector2(0.5, 0.5), new Vector2(-0.5, 0.5), new Vector2(-0.5, -0.5), new Vector2(0.5, -0.5))
) extends js.Object {

  val uuid: String               = js.native
  val holes: js.Array[js.Object] = js.native

  def moveTo(x: Double, y: Double): Shape                                                                = js.native
  def lineTo(x: Double, y: Double): Shape                                                                = js.native
  def bezierCurveTo(cp1x: Double, cp1y: Double, cp2x: Double, cp2y: Double, x: Double, y: Double): Shape = js.native
  def quadraticCurveTo(cpx: Double, cpy: Double, x: Double, y: Double): Shape                            = js.native
  def getPoints(divisions: Int = 12): js.Array[Vector2]                                                  = js.native
  def extractPoints(divisions: Int = 12): js.Object                                                      = js.native
}
