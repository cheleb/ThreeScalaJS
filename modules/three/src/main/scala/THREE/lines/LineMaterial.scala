package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * A material for drawing line segments with custom width.
 */
@js.native
@JSImport("three/examples/jsm/lines/LineMaterial.js", "LineMaterial")
class LineMaterial(parameters: js.UndefOr[js.Dynamic] = js.undefined) extends Material {

  /**
   * This flag can be used for type testing.
   */
  val isLineMaterial: Boolean = js.native

  /**
   * Defines whether the material is rendered with flat shading. Default is
   * false.
   */
  var flatShading: Boolean = js.native

  /**
   * Line thickness. Default is 1.
   */
  var linewidth: Double = js.native

  /**
   * The color of the line. Default is white (0xffffff).
   */
  var color: Color = js.native

  /**
   * Whether the line width is defined in world units or pixels. Default is
   * false (pixels).
   */
  var worldUnits: Boolean = js.native

  /**
   * Define appearance of line ends. Default is 'round'. Other options are
   * 'butt' and 'square'.
   */
  var linecap: String = js.native

  /**
   * Define appearance of line joints. Default is 'round'. Other options are
   * 'butt' and 'bevel'.
   */
  var linejoin: String = js.native

  /**
   * Whether fog is applied to the line. Default is false.
   */
  var fog: Boolean = js.native

  /**
   * The current resolution of the renderer.
   */
  var resolution: Vector2 = js.native

  /**
   * The uniforms of the material.
   */
  var uniforms: js.Dynamic = js.native
}
