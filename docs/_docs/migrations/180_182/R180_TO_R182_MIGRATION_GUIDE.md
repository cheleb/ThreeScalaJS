# Three.js r180 to r182 Migration Guide for ThreeScalaJS

## Overview

This guide documents the migration from Three.js r180 to r182 for the ThreeScalaJS Scala.js facades. The migration includes API changes, new features, and deprecations that affect how you use Three.js through Scala.js.

## Version Information

- **Current Three.js Version**: r182
- **Previous Version**: r180
- **Migration Status**: ✅ Completed

## Key Changes

### 1. ReflectorNode API Changes (r180)

#### What Changed
- The `resolution` parameter and property were renamed to `resolutionScale` in ReflectorNode
- This was a breaking change introduced in r180

#### Before (r180-)
```scala sc:nocompile
// This would no longer work in r180+
val reflector = new ReflectorNode(
  js.Dynamic.literal(
    resolution = 1.0  // ❌ Deprecated parameter name
  )
)
```

#### After (r180+)
```scala sc:nocompile
// Correct usage in r180+
val reflector = new ReflectorNode(
  js.Dynamic.literal(
    resolutionScale = 1.0  // ✅ New parameter name
  )
)
```

#### New ReflectorNode Implementation
A complete ReflectorNode facade has been added with the following features:

- **Properties**:
  - `resolutionScale: Double` - Replaces the old `resolution` property
  - `color: Int | String | Color` - Reflector color
  - `distortion: Double` - Reflection distortion amount
  - `camera: PerspectiveCamera` - Virtual camera for rendering
  - `texture: js.Object` - Reflection texture

- **Methods**:
  - `update(): Unit` - Updates the reflector
  - `dispose(): Unit` - Cleans up GPU resources

### 2. WebGLRenderer API Changes (r182)

#### What Changed
- `getColorBufferType()` was deprecated in favor of `getOutputBufferType()`
- This change provides more accurate naming for the method's purpose

#### Before (r182-)
```scala
val bufferType = renderer.getColorBufferType()  // ❌ Deprecated in r182
```

#### After (r182+)
```scala
val bufferType = renderer.getOutputBufferType()  // ✅ Recommended
```

#### Backward Compatibility
The deprecated method is still available for backward compatibility:

```scala
// Both methods are available
val newWay = renderer.getOutputBufferType()      // ✅ Preferred
val oldWay = renderer.getColorBufferType()      // ⚠️ Deprecated but still works
```

### 3. Other Changes

#### VOXLoader and SkyMesh
- These components are not currently implemented in ThreeScalaJS
- No migration needed at this time
- Future implementations will use the latest APIs

## Migration Steps

### Step 1: Update ReflectorNode Usage

**Find all ReflectorNode instantiations**:
```bash
find . -name "*.scala" -exec grep -l "ReflectorNode" {} \;
```

**Update parameter names**:
- Change `resolution` → `resolutionScale`
- Update any property access: `reflector.resolution` → `reflector.resolutionScale`

### Step 2: Update Renderer API Calls

**Find all renderer buffer type calls**:
```bash
find . -name "*.scala" -exec grep -l "getColorBufferType" {} \;
```

**Update method calls**:
- Change `getColorBufferType()` → `getOutputBufferType()`

### Step 3: Test Your Application

Run your application and verify:
1. ReflectorNode functionality works correctly
2. Renderer buffer type methods return expected values
3. No compilation errors or runtime exceptions

## New Features Available

### ReflectorNode Support
```scala sc:nocompile
import THREE.*

// Create a reflector node for WebGPURenderer
val reflectorNode = new ReflectorNode(
  js.Dynamic.literal(
    resolutionScale = 0.8,  // Lower for better performance
    color = 0x888888,
    distortion = 0.05
  )
)

// Use in your scene
reflectorNode.update()  // Call before rendering
```

### Enhanced Renderer API
```scala sc:nocompile
val renderer = new WebGLRenderer()
val bufferType = renderer.getOutputBufferType()

// Use buffer type for advanced rendering configurations
```

## API Reference

### ReflectorNode Class
```scala sc:nocompile
class ReflectorNode(options: js.UndefOr[ReflectorNodeOptions] = js.undefined)
  extends js.Object
```

**Constructor Options**:
```scala sc:nocompile
trait ReflectorNodeOptions extends js.Object {
  var resolutionScale: js.UndefOr[Double] = js.undefined  // 0.1 to 2.0 recommended
  var color: js.UndefOr[Int | String | Color] = js.undefined
  var distortion: js.UndefOr[Double] = js.undefined       // 0.0 to 1.0
  var mixer: js.UndefOr[js.Object] = js.undefined
}
```

### WebGLRenderer Updates
```scala sc:nocompile
// New method (r182+)
def getOutputBufferType(): Int = js.native

// Deprecated method (still available)
@deprecated("Use getOutputBufferType() instead", "r182")
def getColorBufferType(): Int = js.native
```

## Troubleshooting

### Common Issues

**Issue**: `ReflectorNode` not found
**Solution**: Ensure you're using the correct import:
```scala
import THREE._
```

**Issue**: `resolution` property not found
**Solution**: Use `resolutionScale` instead (r180+ change)

**Issue**: Deprecation warnings for `getColorBufferType()`
**Solution**: Update to `getOutputBufferType()`

### Verification

To verify your migration is complete:

1. **Compile your project**:
   ```bash
   sbt compile
   ```

2. **Run tests**:
   ```bash
   sbt test
   ```

3. **Check for deprecation warnings**:
   ```bash
   sbt compile -Xlint:deprecation
   ```

## Performance Considerations

### ReflectorNode Optimization
- Use `resolutionScale` values between 0.5 and 1.0 for best performance/quality balance
- Higher values (1.5+) provide better quality but significantly impact performance
- Lower values (0.3-0.5) are good for mobile devices

### Renderer Buffer Types
- The new `getOutputBufferType()` method provides the same functionality
- No performance impact from the API change
- Use the returned buffer type for optimal rendering configurations

## Future-Proofing

### Recommendations
1. **Use new APIs**: Prefer `getOutputBufferType()` over deprecated methods
2. **Update documentation**: Reflect the r182 API changes in your code comments
3. **Monitor Three.js releases**: Stay informed about future API changes
4. **Test regularly**: Verify compatibility with new Three.js versions

### Migration Checklist
- [ ] Updated all ReflectorNode instantiations
- [ ] Changed `resolution` to `resolutionScale`
- [ ] Updated renderer buffer type method calls
- [ ] Tested reflection functionality
- [ ] Verified no compilation warnings
- [ ] Updated project documentation

## Support

If you encounter issues with the migration:
1. Check the [Three.js r182 release notes](https://github.com/mrdoob/three.js/releases/tag/r182)
2. Review the [ThreeScalaJS migration guide](migration_plan_r180_to_r182.md)
3. Consult the [Three.js documentation](https://threejs.org/docs/)

## Conclusion

This migration brings ThreeScalaJS up to date with Three.js r182, providing:
- ✅ Modern ReflectorNode API with proper parameter naming
- ✅ Updated renderer buffer type methods
- ✅ Backward compatibility for existing code
- ✅ Future-proof foundation for upcoming Three.js features

The changes are minimal and focused, ensuring a smooth transition while maintaining full functionality.