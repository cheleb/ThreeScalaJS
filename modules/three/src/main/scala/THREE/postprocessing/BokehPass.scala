package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * BokehPass applies a depth of field effect using a bokeh shader
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/BokehPass.js", "BokehPass")
class BokehPass(scene: Scene, camera: Camera, params: BokehPassParameters = ???) extends EffectPass {

  def setFocus(focus: Double): Unit                          = js.native
  def setAspect(aspect: Double): Unit                        = js.native
  def setAperture(aperture: Double): Unit                    = js.native
  def setMaxBlur(maxBlur: Double): Unit                      = js.native
  def setWidthAndHeight(width: Double, height: Double): Unit = js.native
  override def dispose(): Unit                               = js.native
}

object BokehPass {

  def apply(scene: Scene, camera: Camera, params: BokehPassParameters): BokehPass =
    new BokehPass(scene, camera, params)

  def apply(
    scene: Scene,
    camera: Camera,
    focusValue: Double = 1.0,
    aspectValue: Double = 1.0,
    apertureValue: Double = 0.025,
    maxblurValue: Double = 1.0
  ): BokehPass =
    new BokehPass(
      scene,
      camera,
      new BokehPassParameters {
        this.focus = focusValue
        this.aspect = aspectValue
        this.aperture = apertureValue
        this.maxblur = maxblurValue
      }
    )
}
