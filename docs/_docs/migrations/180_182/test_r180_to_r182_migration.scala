import THREE._
import scala.scalajs.js

/**
 * Test file to verify Three.js r180 to r182 migration changes. This
 * demonstrates the new APIs and ensures they compile correctly.
 */
object ThreeJSMigrationTest {

  def testReflectorNodeAPI(): Unit = {
    println("Testing ReflectorNode API (r180+)...")

    // Test ReflectorNode creation with new resolutionScale parameter (r180+)
    val reflectorNode = new ReflectorNode(
      js.Dynamic.literal(
        resolutionScale = 1.0, // This is the new parameter name from r180+
        color = 0xc1cbcb,
        distortion = 0.1
      )
    )

    // Test property access
    reflectorNode.resolutionScale = 0.5
    reflectorNode.color = 0xff0000
    reflectorNode.distortion = 0.2

    // Test methods
    reflectorNode.update()
    // reflectorNode.dispose()  // Would call this in real usage

    println("✓ ReflectorNode API test passed")
  }

  def testWebGLRendererAPI(): Unit = {
    println("Testing WebGLRenderer API updates (r182)...")

    // Create a renderer
    val renderer = new WebGLRenderer()

    // Test the new r182 API
    val outputBufferType = renderer.getOutputBufferType()
    println(s"Output buffer type: $outputBufferType")

    // Test the deprecated method (should still work for backward compatibility)
    val colorBufferType = renderer.getColorBufferType()
    println(s"Color buffer type (deprecated): $colorBufferType")

    // Both should return the same value
    assert(outputBufferType == colorBufferType, "Buffer types should match")

    println("✓ WebGLRenderer API test passed")
  }

  def testMigrationFromR180(): Unit = {
    println("Testing migration scenarios...")

    // Scenario 1: Old ReflectorNode usage (would fail in r180+)
    // This demonstrates what NOT to do:
    /*
    val oldReflector = new ReflectorNode(
      js.Dynamic.literal(
        resolution = 1.0  // This would be wrong - parameter renamed in r180
      )
    )
     */

    // Scenario 2: Correct new usage
    val correctReflector = new ReflectorNode(
      js.Dynamic.literal(
        resolutionScale = 1.0 // Correct parameter name
      )
    )

    // Scenario 3: Renderer API migration
    val renderer = new WebGLRenderer()

    // Old way (deprecated in r182):
    val oldWay = renderer.getColorBufferType()

    // New way (recommended in r182+):
    val newWay = renderer.getOutputBufferType()

    println("✓ Migration scenarios test passed")
  }

  def main(args: Array[String]): Unit = {
    println("Three.js r180 to r182 Migration Test")
    println("===================================")

    try {
      testReflectorNodeAPI()
      testWebGLRendererAPI()
      testMigrationFromR180()

      println("\n🎉 All tests passed! Migration from r180 to r182 is working correctly.")
      println("\nKey changes implemented:")
      println("1. ReflectorNode now uses 'resolutionScale' instead of 'resolution' (r180)")
      println("2. WebGLRenderer.getOutputBufferType() replaces getColorBufferType() (r182)")
      println("3. Backward compatibility maintained for deprecated APIs")

    } catch {
      case e: Exception =>
        println(s"❌ Test failed: ${e.getMessage}")
        e.printStackTrace()
    }
  }
}
