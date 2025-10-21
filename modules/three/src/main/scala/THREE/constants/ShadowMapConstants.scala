package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Gives unfiltered shadow maps - fastest, but lowest quality.
 */
@js.native
@JSImport("three", "BasicShadowMap")
object BasicShadowMap extends js.Object:
  override def toString(): String = js.native

/**
 * Filters shadow maps using the Percentage-Closer Filtering (PCF) algorithm.
 */
@js.native
@JSImport("three", "PCFShadowMap")
object PCFShadowMap extends js.Object:
  override def toString(): String = js.native

/**
 * Filters shadow maps using the Percentage-Closer Filtering (PCF) algorithm
 * with better soft shadows especially when using low-resolution shadow maps.
 */
@js.native
@JSImport("three", "PCFSoftShadowMap")
object PCFSoftShadowMap extends js.Object:
  override def toString(): String = js.native

/**
 * Filters shadow maps using the Variance Shadow Map (VSM) algorithm. When using
 * VSMShadowMap all shadow receivers will also cast shadows.
 */
@js.native
@JSImport("three", "VSMShadowMap")
object VSMShadowMap extends js.Object:
  override def toString(): String = js.native
