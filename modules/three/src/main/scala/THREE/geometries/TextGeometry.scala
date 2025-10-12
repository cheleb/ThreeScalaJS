package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A class for generating text as a single geometry. It is constructed by
 * providing a string of text, and a set of parameters consisting of a loaded
 * font and extrude settings.
 */
@js.native
@JSImport("three/examples/jsm/geometries/TextGeometry.js", "TextGeometry")
class TextGeometry(
  text: String,
  parameters: js.Object = js.Dynamic.literal()
) extends ExtrudeGeometry(js.Array(), parameters) {

  val geometryType: String = js.native
}

object TextGeometry {
  def apply(
    text: String,
    font: js.UndefOr[js.Object] = js.undefined,
    size: Double = 1,
    height: Double = 0.2,
    depth: Double = 50,
    curveSegments: Int = 12,
    steps: Int = 1,
    bevelEnabled: Boolean = false,
    bevelThickness: Double = 10,
    bevelSize: Double = 8,
    bevelOffset: Double = 0,
    bevelSegments: Int = 3,
// FIXME    extrudePath: js.UndefOr[Curve] = js.undefined,
    uvGenerator: js.UndefOr[js.Object] = js.undefined
  ): TextGeometry = new TextGeometry(
    text,
    js.Dynamic.literal(
      font = font,
      size = size,
      height = height,
      depth = depth,
      curveSegments = curveSegments,
      steps = steps,
      bevelEnabled = bevelEnabled,
      bevelThickness = bevelThickness,
      bevelSize = bevelSize,
      bevelOffset = bevelOffset,
      bevelSegments = bevelSegments
    )
  )
}
