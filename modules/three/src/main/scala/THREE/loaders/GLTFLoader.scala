package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import js.Promise

/**
 * A loader for loading GLTF resources. The .gltf and .glb file extensions are
 * supported.
 */
@js.native
@JSImport("three/addons/loaders/GLTFLoader.js", "GLTFLoader")
class GLTFLoader(manager: js.UndefOr[LoadingManager] = js.undefined) extends js.Object {

  /**
   * The path to use when loading resources referenced by the GLTF asset.
   */
  var path: String = js.native

  /**
   * The crossOrigin string to implement CORS for loading the url.
   */
  var crossOrigin: String = js.native

  /**
   * Whether the .gltf loader requires the use of worker threads.
   */
  var requestHeader: js.Dictionary[String] = js.native

  /**
   * Whether the .gltf loader should output more verbose messages.
   */
  var dracoLoader: js.UndefOr[js.Object] = js.native

  /**
   * A loader to be used for loading KTX2 textures.
   */
  var ktx2Loader: js.UndefOr[js.Object] = js.native

  /**
   * A loader to be used for loading meshopt compressed files.
   */
  var meshoptDecoder: js.UndefOr[js.Object] = js.native

  /**
   * Loads a GLTF resource from a URL with callback-style API.
   */
  def load(
    url: String,
    onLoad: js.Function1[GLTFResult, Unit] = null,
    onProgress: js.Function3[js.Any, Int, Int, Unit] = null,
    onError: js.Function1[js.Error, Unit] = null
  ): Unit = js.native

  /**
   * Loads a GLTF resource from a URL asynchronously.
   */
  def loadAsync(
    url: String,
    onProgress: js.UndefOr[js.Function3[js.Any, Int, Int, Unit]] = js.undefined
  ): js.Promise[GLTFResult] = js.native

  /**
   * Parses a GLTF JSON string and returns the result.
   */
  def parse(
    data: String | js.typedarray.ArrayBuffer,
    path: String,
    onLoad: js.Function1[GLTFResult, Unit],
    onError: js.Function1[js.Error, Unit] = null
  ): Unit = js.native

  /**
   * Parses a GLTF JSON string asynchronously and returns the result.
   */
  def parseAsync(
    data: String | js.typedarray.ArrayBuffer,
    path: String
  ): js.Promise[GLTFResult] = js.native

  /**
   * Sets the base path for resolving references.
   */
  def setPath(path: String): this.type = js.native

  /**
   * Sets the crossOrigin string to implement CORS.
   */
  def setCrossOrigin(value: String): this.type = js.native

  /**
   * Sets the request headers to use when fetching resources.
   */
  def setRequestHeader(value: js.Dictionary[String]): this.type = js.native

  /**
   * Sets the Draco loader to use for decompressing Draco compressed geometry.
   */
  def setDRACOLoader(dracoLoader: js.Object): this.type = js.native

  /**
   * Sets the KTX2 loader to use for loading KTX2 compressed textures.
   */
  def setKTX2Loader(ktx2Loader: js.Object): this.type = js.native

  /**
   * Sets the meshopt decoder to use for decompressing meshopt compressed
   * geometry.
   */
  def setMeshoptDecoder(meshoptDecoder: js.Object): this.type = js.native
}

/**
 * The result of loading a GLTF asset.
 */
@js.native
trait GLTFResult extends js.Object {

  /**
   * The loaded scenes.
   */
  val scenes: js.Array[Scene] = js.native

  /**
   * The loaded scene.
   */
  val scene: Scene = js.native

  /**
   * The loaded cameras.
   */
  val cameras: js.Array[Camera] = js.native

  /**
   * The loaded animations.
   */
  val animations: js.Array[js.Object] = js.native

  /**
   * The loaded asset.
   */
  val asset: js.Object = js.native

  /**
   * The loaded parser.
   */
  val parser: js.Object = js.native

  /**
   * The loaded user data.
   */
  val userData: js.Object = js.native
}
