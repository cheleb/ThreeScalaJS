package THREE.constants

/**
 * Texture filtering constants for Three.js
 */
object TextureConstants {

  /**
   * Nearest neighbor filtering. The texture element nearest to the specified
   * texture coordinates is used.
   */
  val NearestFilter: Int = 1003

  /**
   * Linear filtering. The texture elements on either side of the specified
   * texture coordinates are sampled and averaged.
   */
  val LinearFilter: Int = 1006

  /**
   * Nearest mipmap nearest filtering. The mipmap level and texture element
   * nearest to the specified texture coordinates are used.
   */
  val NearestMipmapNearestFilter: Int = 1004

  /**
   * Nearest mipmap linear filtering. The texture element nearest to the
   * specified texture coordinates is sampled from the nearest mipmap level.
   */
  val NearestMipmapLinearFilter: Int = 1005

  /**
   * Linear mipmap nearest filtering. The texture elements on either side of the
   * specified texture coordinates are sampled from the nearest mipmap level and
   * averaged.
   */
  val LinearMipmapNearestFilter: Int = 1007

  /**
   * Linear mipmap linear filtering. The texture elements on either side of the
   * specified texture coordinates are sampled from the two nearest mipmap
   * levels and averaged.
   */
  val LinearMipmapLinearFilter: Int = 1008

}
