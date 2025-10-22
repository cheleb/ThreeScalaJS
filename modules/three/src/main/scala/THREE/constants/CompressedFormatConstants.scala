package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * A DXT1-compressed image in an RGB image format.
 */
@js.native
@JSImport("three", "RGB_S3TC_DXT1_Format")
val RGB_S3TC_DXT1_Format: Int = js.native

/**
 * A DXT1-compressed image in an RGB image format with a simple on/off alpha
 * value.
 */
@js.native
@JSImport("three", "RGBA_S3TC_DXT1_Format")
val RGBA_S3TC_DXT1_Format: Int = js.native

/**
 * A DXT3-compressed image in an RGBA image format. Compared to a 32-bit RGBA
 * texture, it offers 4:1 compression.
 */
@js.native
@JSImport("three", "RGBA_S3TC_DXT3_Format")
val RGBA_S3TC_DXT3_Format: Int = js.native

/**
 * A DXT5-compressed image in an RGBA image format. It also provides a 4:1
 * compression, but differs to the DXT3 compression in how the alpha compression
 * is done.
 */
@js.native
@JSImport("three", "RGBA_S3TC_DXT5_Format")
val RGBA_S3TC_DXT5_Format: Int = js.native

/**
 * PVRTC RGB compression in 4-bit mode. One block for each 4×4 pixels.
 */
@js.native
@JSImport("three", "RGB_PVRTC_4BPPV1_Format")
val RGB_PVRTC_4BPPV1_Format: Int = js.native

/**
 * PVRTC RGB compression in 2-bit mode. One block for each 8×4 pixels.
 */
@js.native
@JSImport("three", "RGB_PVRTC_2BPPV1_Format")
val RGB_PVRTC_2BPPV1_Format: Int = js.native

/**
 * PVRTC RGBA compression in 4-bit mode. One block for each 4×4 pixels.
 */
@js.native
@JSImport("three", "RGBA_PVRTC_4BPPV1_Format")
val RGBA_PVRTC_4BPPV1_Format: Int = js.native

/**
 * PVRTC RGBA compression in 2-bit mode. One block for each 8×4 pixels.
 */
@js.native
@JSImport("three", "RGBA_PVRTC_2BPPV1_Format")
val RGBA_PVRTC_2BPPV1_Format: Int = js.native

/**
 * ETC1 RGB format.
 */
@js.native
@JSImport("three", "RGB_ETC1_Format")
val RGB_ETC1_Format: Int = js.native

/**
 * ETC2 RGB format.
 */
@js.native
@JSImport("three", "RGB_ETC2_Format")
val RGB_ETC2_Format: Int = js.native

/**
 * ETC2 RGBA format.
 */
@js.native
@JSImport("three", "RGBA_ETC2_EAC_Format")
val RGBA_ETC2_EAC_Format: Int = js.native

/**
 * ASTC RGBA 4x4 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_4x4_Format")
val RGBA_ASTC_4x4_Format: Int = js.native

/**
 * ASTC RGBA 5x4 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_5x4_Format")
val RGBA_ASTC_5x4_Format: Int = js.native

/**
 * ASTC RGBA 5x5 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_5x5_Format")
val RGBA_ASTC_5x5_Format: Int = js.native

/**
 * ASTC RGBA 6x5 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_6x5_Format")
val RGBA_ASTC_6x5_Format: Int = js.native

/**
 * ASTC RGBA 6x6 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_6x6_Format")
val RGBA_ASTC_6x6_Format: Int = js.native

/**
 * ASTC RGBA 8x5 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_8x5_Format")
val RGBA_ASTC_8x5_Format: Int = js.native

/**
 * ASTC RGBA 8x6 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_8x6_Format")
val RGBA_ASTC_8x6_Format: Int = js.native

/**
 * ASTC RGBA 8x8 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_8x8_Format")
val RGBA_ASTC_8x8_Format: Int = js.native

/**
 * ASTC RGBA 10x5 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_10x5_Format")
val RGBA_ASTC_10x5_Format: Int = js.native

/**
 * ASTC RGBA 10x6 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_10x6_Format")
val RGBA_ASTC_10x6_Format: Int = js.native

/**
 * ASTC RGBA 10x8 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_10x8_Format")
val RGBA_ASTC_10x8_Format: Int = js.native

/**
 * ASTC RGBA 10x10 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_10x10_Format")
val RGBA_ASTC_10x10_Format: Int = js.native

/**
 * ASTC RGBA 12x10 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_12x10_Format")
val RGBA_ASTC_12x10_Format: Int = js.native

/**
 * ASTC RGBA 12x12 format.
 */
@js.native
@JSImport("three", "RGBA_ASTC_12x12_Format")
val RGBA_ASTC_12x12_Format: Int = js.native

/**
 * BPTC RGBA format.
 */
@js.native
@JSImport("three", "RGBA_BPTC_Format")
val RGBA_BPTC_Format: Int = js.native

/**
 * BPTC Signed RGB format.
 */
@js.native
@JSImport("three", "RGB_BPTC_SIGNED_Format")
val RGB_BPTC_SIGNED_Format: Int = js.native

/**
 * BPTC Unsigned RGB format.
 */
@js.native
@JSImport("three", "RGB_BPTC_UNSIGNED_Format")
val RGB_BPTC_UNSIGNED_Format: Int = js.native

/**
 * RGTC1 Red format.
 */
@js.native
@JSImport("three", "RED_RGTC1_Format")
val RED_RGTC1_Format: Int = js.native

/**
 * RGTC1 Signed Red format.
 */
@js.native
@JSImport("three", "SIGNED_RED_RGTC1_Format")
val SIGNED_RED_RGTC1_Format: Int = js.native

/**
 * RGTC2 Red Green format.
 */
@js.native
@JSImport("three", "RED_GREEN_RGTC2_Format")
val RED_GREEN_RGTC2_Format: Int = js.native

/**
 * RGTC2 Signed Red Green format.
 */
@js.native
@JSImport("three", "SIGNED_RED_GREEN_RGTC2_Format")
val SIGNED_RED_GREEN_RGTC2_Format: Int = js.native
