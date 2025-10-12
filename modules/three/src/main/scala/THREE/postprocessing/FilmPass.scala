package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Film pass that adds film grain and scanlines effects
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/FilmPass.js", "FilmPass")
class FilmPass(
  noiseIntensity: js.UndefOr[Double] = js.undefined,
  scanlinesIntensity: js.UndefOr[Double] = js.undefined,
  scanlinesCount: js.UndefOr[Double] = js.undefined,
  grayscale: js.UndefOr[Boolean] = js.undefined
) extends EffectPass {

  def setNoiseIntensity(intensity: Double): Unit     = js.native
  def setScanlinesIntensity(intensity: Double): Unit = js.native
  def setScanlinesCount(count: Double): Unit         = js.native
  def setGrayscale(grayscale: Boolean): Unit         = js.native
}

object FilmPass {

  def apply(
    noiseIntensity: js.UndefOr[Double] = js.undefined,
    scanlinesIntensity: js.UndefOr[Double] = js.undefined,
    scanlinesCount: js.UndefOr[Double] = js.undefined,
    grayscale: js.UndefOr[Boolean] = js.undefined
  ): FilmPass =
    new FilmPass(noiseIntensity, scanlinesIntensity, scanlinesCount, grayscale)
}
