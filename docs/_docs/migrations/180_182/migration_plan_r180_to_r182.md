# Three.js r180 to r182 Migration Plan for Scala.js Facades

## Overview
This document outlines the migration plan for updating the ThreeScalaJS facades from Three.js r180 to r182. Based on the analysis of the JavaScript Three.js source code and the current Scala.js facade implementation, here are the required changes.

## Analysis Summary

### Current State
- **Three.js Version**: Currently using r182 (as indicated in submodules/three.js/src/constants.js)
- **Scala.js Facades**: Need updates to match r182 API changes
- **Breaking Changes Identified**: Several API changes between r180 and r182

### Key Changes Between r180 and r182

#### 1. ReflectorNode Changes (r180)
- **Change**: `resolution` parameter/property renamed to `resolutionScale`
- **Impact**: Breaking change for anyone using ReflectorNode
- **Current Status**: ReflectorNode not yet implemented in Scala.js facades (only regular Reflector exists)
- **Action Required**: When implementing ReflectorNode, use the new `resolutionScale` API

#### 2. Renderer API Changes (r182)
- **Change**: `getColorBufferType()` deprecated in favor of `getOutputBufferType()`
- **Impact**: API cleanup, affects buffer type access
- **Current Status**: Neither method currently exposed in WebGLRenderer facade
- **Action Required**: Add `getOutputBufferType()` method to WebGLRenderer facade

#### 3. Other Deprecations (r182)
- **VOXLoader**: Array-like access deprecated
- **SkyMesh**: `isSky` property deprecated
- **Current Status**: Neither VOXLoader nor SkyMesh currently implemented in facades
- **Action Required**: None for now, but note for future implementations

## Detailed Migration Plan

### Phase 1: ReflectorNode Implementation (New Feature)
**Files to Create/Update**:
- `modules/three/src/main/scala/THREE/objects/ReflectorNode.scala` (new file)

**Implementation Details**:
```scala
@js.native
@JSImport("three/nodes", "ReflectorNode")
class ReflectorNode(
  options: js.UndefOr[ReflectorNodeOptions] = js.undefined
) extends js.Object {
  // Use resolutionScale instead of resolution (r180+ API)
  var resolutionScale: js.UndefOr[Double] = js.undefined
  // Other properties...
}

trait ReflectorNodeOptions extends js.Object {
  var resolutionScale: js.UndefOr[Double] = js.undefined  // Note: resolutionScale, not resolution
  var color: js.UndefOr[Int | String | Color] = js.undefined
  // Other options...
}
```

### Phase 2: WebGLRenderer API Updates
**Files to Update**:
- `modules/three/src/main/scala/THREE/renderers/WebGLRenderer.scala`

**Changes Required**:
1. Add `getOutputBufferType()` method
2. Consider adding deprecated `getColorBufferType()` for backward compatibility

**Implementation**:
```scala
// Add to WebGLRenderer class
def getOutputBufferType(): Int = js.native

// Optional: Add deprecated method for compatibility
@deprecated("Use getOutputBufferType() instead", "r182")
def getColorBufferType(): Int = js.native
```

### Phase 3: Documentation Updates
**Files to Update**:
- All relevant ScalaDoc comments
- Example code in documentation
- Migration guide

**Key Documentation Changes**:
1. Update Reflector examples to mention ReflectorNode for WebGPURenderer
2. Add notes about API changes in r182
3. Document new `getOutputBufferType()` method

### Phase 4: Testing Strategy
**Test Coverage Needed**:
1. ReflectorNode instantiation and property access
2. WebGLRenderer `getOutputBufferType()` functionality
3. Backward compatibility for any deprecated methods
4. Integration tests with actual Three.js r182

### Phase 5: Build and Dependency Updates
**Build Configuration**:
1. Ensure project is using Three.js r182 from submodules
2. Update any version references in build files
3. Verify all dependencies are compatible

## Implementation Timeline

| Phase | Task | Estimated Time | Priority |
|-------|------|----------------|----------|
| 1 | ReflectorNode Implementation | 2-4 hours | High |
| 2 | WebGLRenderer Updates | 1-2 hours | High |
| 3 | Documentation Updates | 1-2 hours | Medium |
| 4 | Testing | 2-3 hours | High |
| 5 | Build Updates | 1 hour | Medium |

## Risk Assessment

### Low Risk Items
- ReflectorNode implementation (new feature, no breaking changes)
- WebGLRenderer new method addition (additive change)

### Medium Risk Items
- Potential API mismatches between facade definitions and actual Three.js implementation
- Build configuration issues with Three.js version

### Mitigation Strategies
1. Thorough testing with actual Three.js r182 instances
2. Gradual rollout with feature flags if needed
3. Comprehensive documentation of changes

## Rollback Plan

If issues are discovered:
1. Revert to previous facade definitions
2. Use feature flags to disable new functionality
3. Provide clear migration path for users

## Success Criteria

1. All new facade definitions compile without errors
2. Runtime tests pass with Three.js r182
3. Documentation is complete and accurate
4. No breaking changes introduced for existing users
5. New ReflectorNode and renderer APIs work as expected

## Next Steps

1. ✅ Complete migration analysis (DONE)
2. ⏳ Implement ReflectorNode facade
3. ⏳ Update WebGLRenderer facade
4. ⏳ Write comprehensive tests
5. ⏳ Update documentation
6. ⏳ Perform integration testing
7. ⏳ Release updated facades

This plan provides a clear roadmap for migrating the ThreeScalaJS facades from r180 to r182 while maintaining backward compatibility and adding support for new Three.js features.