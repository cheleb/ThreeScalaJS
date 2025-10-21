package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * The contents are intended to be specified once by the application, and used
 * many times as the source for drawing and image specification commands.
 */
@js.native
@JSImport("three", "StaticDrawUsage")
object StaticDrawUsage extends js.Object:
  override def toString(): String = js.native

/**
 * The contents are intended to be respecified repeatedly by the application,
 * and used many times as the source for drawing and image specification
 * commands.
 */
@js.native
@JSImport("three", "DynamicDrawUsage")
object DynamicDrawUsage extends js.Object:
  override def toString(): String = js.native

/**
 * The contents are intended to be specified once by the application, and used
 * at most a few times as the source for drawing and image specification
 * commands.
 */
@js.native
@JSImport("three", "StreamDrawUsage")
object StreamDrawUsage extends js.Object:
  override def toString(): String = js.native

/**
 * The contents are intended to be specified once by reading data from the 3D
 * API, and queried many times by the application.
 */
@js.native
@JSImport("three", "StaticReadUsage")
object StaticReadUsage extends js.Object:
  override def toString(): String = js.native

/**
 * The contents are intended to be respecified repeatedly by reading data from
 * the 3D API, and queried many times by the application.
 */
@js.native
@JSImport("three", "DynamicReadUsage")
object DynamicReadUsage extends js.Object:
  override def toString(): String = js.native

/**
 * The contents are intended to be specified once by reading data from the 3D
 * API, and queried at most a few times by the application
 */
@js.native
@JSImport("three", "StreamReadUsage")
object StreamReadUsage extends js.Object:
  override def toString(): String = js.native

/**
 * The contents are intended to be specified once by reading data from the 3D
 * API, and used many times as the source for WebGL drawing and image
 * specification commands.
 */
@js.native
@JSImport("three", "StaticCopyUsage")
object StaticCopyUsage extends js.Object:
  override def toString(): String = js.native

/**
 * The contents are intended to be respecified repeatedly by reading data from
 * the 3D API, and used many times as the source for WebGL drawing and image
 * specification commands.
 */
@js.native
@JSImport("three", "DynamicCopyUsage")
object DynamicCopyUsage extends js.Object:
  override def toString(): String = js.native

/**
 * The contents are intended to be specified once by reading data from the 3D
 * API, and used at most a few times as the source for WebGL drawing and image
 * specification commands.
 */
@js.native
@JSImport("three", "StreamCopyUsage")
object StreamCopyUsage extends js.Object:
  override def toString(): String = js.native
