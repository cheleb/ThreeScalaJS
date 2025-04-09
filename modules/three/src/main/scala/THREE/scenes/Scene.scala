package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Scenes allow you to set up what and where is to be rendered by three.js.
 */
@js.native
@JSImport("three", "Scene")
class Scene extends Object3D {

  var background: js.Any           = js.native
  var environment: js.Any          = js.native
  var fog: js.Any                  = js.native
  var backgroundBlurriness: Double = js.native
  var backgroundIntensity: Double  = js.native

  var overrideMaterial: js.UndefOr[Material] = js.native
}
