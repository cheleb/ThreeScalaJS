package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Parameters for GlitchPass configuration
 */
case class GlitchPassParameters(
  dtSize: js.UndefOr[Int] = js.undefined,
  random: js.UndefOr[Boolean] = js.undefined
)

/**
 * Glitch pass that creates digital glitch effects
 */
@js.native
@JSImport("three/examples/jsm/postprocessing/GlitchPass.js", "GlitchPass")
class GlitchPass(
  dtSize: js.UndefOr[Int] = js.undefined,
  random: js.UndefOr[Boolean] = js.undefined
) extends EffectPass {

  def generateTrigger(): Unit          = js.native
  def setDtSize(dtSize: Int): Unit     = js.native
  def setRandom(random: Boolean): Unit = js.native
}

object GlitchPass {

  def apply(
    dtSize: js.UndefOr[Int] = js.undefined,
    random: js.UndefOr[Boolean] = js.undefined
  ): GlitchPass =
    new GlitchPass(dtSize, random)

  def apply(parameters: GlitchPassParameters): GlitchPass =
    new GlitchPass(parameters.dtSize, parameters.random)
}
