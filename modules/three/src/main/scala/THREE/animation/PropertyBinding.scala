package THREE.animation

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import THREE.Object3D

/**
 * This holds a reference to a real property in the scene graph; used
 * internally.
 */
@js.native
@JSImport("three", "PropertyBinding")
class PropertyBinding protected () extends js.Object:

  /**
   * The object path to the animated property.
   */
  def path: String = js.native

  /**
   * An object holding information about the path.
   */
  def parsedPath: js.Object = js.native

  /**
   * The object owns the animated property.
   */
  def node: js.Object = js.native

  /**
   * The root node.
   */
  def rootNode: Object3D = js.native

  /**
   * Binds the property.
   */
  def bind(): Unit = js.native

  /**
   * Unbinds the property.
   */
  def unbind(): Unit = js.native

  /**
   * Gets the value.
   */
  def getValue(array: js.Array[Double], offset: Int): Unit = js.native

  /**
   * Sets the value.
   */
  def setValue(array: js.Array[Double], offset: Int): Unit = js.native

@js.native
@JSImport("three", "PropertyBinding")
object PropertyBinding extends js.Object:

  /**
   * Factory method for creating a property binding from the given parameters.
   */
  def create(root: Object3D, path: String, parsedPath: js.Object = ???): PropertyBinding = js.native

  /**
   * Replaces spaces with underscores and removes unsupported characters from
   * node names, to ensure compatibility with parseTrackName().
   */
  def sanitizeNodeName(name: String): String = js.native

  /**
   * Parses the given track name (an object path to an animated property) and
   * returns an object with information about the path.
   */
  def parseTrackName(trackName: String): js.Object = js.native

  /**
   * Searches for a node in the hierarchy of the given root object by the given
   * node name.
   */
  def findNode(root: Object3D, nodeName: String): js.Object | Null = js.native

  /**
   * Binding type enumeration.
   */
  @js.native
  object BindingType extends js.Object:
    val Direct: Int         = js.native
    val EntireArray: Int    = js.native
    val ArrayElement: Int   = js.native
    val HasFromToArray: Int = js.native

  /**
   * Versioning enumeration.
   */
  @js.native
  object Versioning extends js.Object:
    val None: Int                   = js.native
    val NeedsUpdate: Int            = js.native
    val MatrixWorldNeedsUpdate: Int = js.native
