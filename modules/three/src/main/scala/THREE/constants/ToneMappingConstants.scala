package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * No tone mapping is applied.
 */
@js.native
@JSImport("three", "NoToneMapping")
object NoToneMapping extends js.Object:
  override def toString(): String = js.native

/**
 * Linear tone mapping.
 */
@js.native
@JSImport("three", "LinearToneMapping")
object LinearToneMapping extends js.Object:
  override def toString(): String = js.native

/**
 * Reinhard tone mapping.
 */
@js.native
@JSImport("three", "ReinhardToneMapping")
object ReinhardToneMapping extends js.Object:
  override def toString(): String = js.native

/**
 * Cineon tone mapping.
 */
@js.native
@JSImport("three", "CineonToneMapping")
object CineonToneMapping extends js.Object:
  override def toString(): String = js.native

/**
 * ACES Filmic tone mapping.
 */
@js.native
@JSImport("three", "ACESFilmicToneMapping")
object ACESFilmicToneMapping extends js.Object:
  override def toString(): String = js.native

/**
 * Custom tone mapping. Expects a custom implementation by modifying shader code
 * of the material's fragment shader.
 */
@js.native
@JSImport("three", "CustomToneMapping")
object CustomToneMapping extends js.Object:
  override def toString(): String = js.native

/**
 * AgX tone mapping.
 */
@js.native
@JSImport("three", "AgXToneMapping")
object AgXToneMapping extends js.Object:
  override def toString(): String = js.native

/**
 * Neutral tone mapping. Implementation based on the Khronos 3D Commerce Group
 * standard tone mapping.
 */
@js.native
@JSImport("three", "NeutralToneMapping")
object NeutralToneMapping extends js.Object:
  override def toString(): String = js.native
