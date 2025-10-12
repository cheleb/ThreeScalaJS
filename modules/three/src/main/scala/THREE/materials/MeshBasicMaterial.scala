package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material for drawing geometries in a simple shaded way.
 */
@js.native
@JSImport("three", "MeshBasicMaterial")
class MeshBasicMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  var color: Color               = js.native
  var map: js.UndefOr[js.Object] = js.native

  var aoMap: js.UndefOr[js.Object] = js.native
  var aoMapIntensity: Double       = js.native

  var specularMap: js.UndefOr[js.Object] = js.native
  var alphaMap: js.UndefOr[js.Object]    = js.native

  var fog: Boolean               = js.native
  var wireframe: Boolean         = js.native
  var wireframeLinewidth: Double = js.native
}

// Manual customization of the constructor
object MeshBasicMaterial:

  def apply(color: Int, wireframe: Boolean = false) =
    new MeshBasicMaterial(js.Dynamic.literal(color = color, wireframe = wireframe))
  def apply(map: Texture, wireframe: Boolean) =
    new MeshBasicMaterial(js.Dynamic.literal(map = map, wireframe = wireframe))
