package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * No tone mapping is applied.
 */
@js.native
@JSGlobal("THREE.NoToneMapping")
val NoToneMapping: Int = js.native

/**
 * Linear tone mapping.
 */
@js.native
@JSGlobal("THREE.LinearToneMapping")
val LinearToneMapping: Int = js.native

/**
 * Reinhard tone mapping.
 */
@js.native
@JSGlobal("THREE.ReinhardToneMapping")
val ReinhardToneMapping: Int = js.native

/**
 * Cineon tone mapping.
 */
@js.native
@JSGlobal("THREE.CineonToneMapping")
val CineonToneMapping: Int = js.native

/**
 * ACES Filmic tone mapping.
 */
@js.native
@JSGlobal("THREE.ACESFilmicToneMapping")
val ACESFilmicToneMapping: Int = js.native

/**
 * Custom tone mapping. Expects a custom implementation by modifying shader code
 * of the material's fragment shader.
 */
@js.native
@JSGlobal("THREE.CustomToneMapping")
val CustomToneMapping: Int = js.native

/**
 * AgX tone mapping.
 */
@js.native
@JSGlobal("THREE.AgXToneMapping")
val AgXToneMapping: Int = js.native

/**
 * Neutral tone mapping. Implementation based on the Khronos 3D Commerce Group
 * standard tone mapping.
 */
@js.native
@JSGlobal("THREE.NeutralToneMapping")
val NeutralToneMapping: Int = js.native
