package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Utility functions for working with BufferGeometry objects. Provides advanced
 * vertex manipulation and geometry processing capabilities.
 */
@js.native
@JSImport("three", "BufferGeometryUtils")
object BufferGeometryUtils extends js.Object {

  /**
   * Computes vertex tangents using the MikkTSpace algorithm.
   */
  def computeMikkTSpaceTangents(
    geometry: BufferGeometry,
    MikkTSpace: js.Object,
    negateSign: Boolean = true
  ): BufferGeometry = js.native

  /**
   * Merges a set of geometries into a single instance.
   */
  def mergeGeometries(geometries: js.Array[BufferGeometry], useGroups: Boolean = false): BufferGeometry = js.native

  /**
   * Merges a set of attributes into a single instance.
   */
  def mergeAttributes(attributes: js.Array[js.Object]): js.Object = js.native

  /**
   * Performs a deep clone of the given buffer attribute.
   */
  def deepCloneAttribute(attribute: js.Object): js.Object = js.native

  /**
   * Interleaves a set of attributes and returns a new array of corresponding
   * attributes.
   */
  def interleaveAttributes(attributes: js.Array[js.Object]): js.Array[js.Object] = js.native

  /**
   * Returns a new, non-interleaved version of the given attribute.
   */
  def deinterleaveAttribute(attribute: js.Object): js.Object = js.native

  /**
   * Deinterleaves all attributes on the given geometry.
   */
  def deinterleaveGeometry(geometry: BufferGeometry): Unit = js.native

  /**
   * Returns the amount of bytes used by all attributes to represent the
   * geometry.
   */
  def estimateBytesUsed(geometry: BufferGeometry): Double = js.native

  /**
   * Returns a new geometry with vertices for which all similar vertex
   * attributes are merged.
   */
  def mergeVertices(geometry: BufferGeometry, tolerance: Double = 1e-4): BufferGeometry = js.native

  /**
   * Returns a new geometry with vertices converted to TrianglesDrawMode.
   */
  def toTrianglesDrawMode(geometry: BufferGeometry, drawMode: Int): BufferGeometry = js.native

  /**
   * Calculates the morphed attributes of a morphed/skinned BufferGeometry.
   */
  def computeMorphedAttributes(obj: js.Object): js.Object = js.native

  /**
   * Merges the groups for the given geometry.
   */
  def mergeGroups(geometry: BufferGeometry): BufferGeometry = js.native

  /**
   * Modifies the supplied geometry to have smooth normals everywhere except
   * faces that meet at an angle greater than the crease angle.
   */
  def toCreasedNormals(geometry: BufferGeometry, creaseAngle: Double = Math.PI / 3): BufferGeometry = js.native
}
