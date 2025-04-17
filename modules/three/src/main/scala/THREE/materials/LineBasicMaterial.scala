package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material for drawing wireframe-style geometries with solid lines.
 */
@js.native
@JSImport("three", "LineBasicMaterial")
class LineBasicMaterial(parameters: js.UndefOr[js.Object] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isLineBasicMaterial: Boolean = js.native

  /**
   * Color of the material. Default is white (0xffffff).
   */
  var color: Color = js.native

  /**
   * Controls line thickness. Default is 1. Due to limitations of the OpenGL
   * Core Profile with the WebGL renderer on most platforms linewidth will
   * always be 1 regardless of the set value.
   */
  var linewidth: Double = js.native

  /**
   * Define appearance of line ends. Default is 'round'. Available values are
   * 'butt', 'round' and 'square'.
   */
  var linecap: String = js.native

  /**
   * Define appearance of line joints. Default is 'round'. Available values are
   * 'round', 'bevel' and 'miter'.
   */
  var linejoin: String = js.native

  /**
   * Whether the material is affected by fog. Default is true.
   */
  var fog: Boolean = js.native
}

/**
 * Companion object for LineBasicMaterial with factory method.
 */
// @js.native
// @JSImport("three", "LineBasicMaterial")
// object LineBasicMaterial extends js.Object {

//   /**
//    * Factory method to create a LineBasicMaterial with parameters.
//    */
//   def apply(parameters: js.Object): LineBasicMaterial = new LineBasicMaterial(parameters)

//   /**
//    * Factory method to create a LineBasicMaterial with default parameters.
//    */
//   def apply(): LineBasicMaterial = new LineBasicMaterial()
// }
