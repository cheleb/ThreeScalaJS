# Three.js r185 → r186 Migration Plan for ThreeScalaJS

## Overview

Source of truth: `submodules/three.js-r185` vs `submodules/three.js-r186`
(`diff -ru submodules/three.js-r185/src submodules/three.js-r186/src` and the
same for `examples/jsm`). Only changes touching APIs exposed by the Scala.js
facades in `modules/three` are listed. Node/TSL/WebGPU internals are out of
scope (not bound).

## 🔴 Deprecations / Breaking changes

| Change | r185 | r186 | Facade action |
|--------|------|------|---------------|
| `PCFSoftShadowMap` removed (falls back to `PCFShadowMap` with a warning) | supported (deprecated warning) | `@deprecated since r186` | Mark `PCFSoftShadowMap` `@deprecated` |
| `Source` renamed | `THREE.Source` | `THREE.TextureSource` (`Source` kept as deprecated alias) | Add `TextureSource` facade, expose `Texture.source` |
| `Light.dispose()` moved | defined on `Light` | defined on `Object3D` | Add `Object3D.dispose()`; subclasses' existing `dispose()` become `override` |
| `FirstPersonControls` up/down keys | `E` / `Q` | `R` / `F` | Doc only |

## 🟢 New APIs

| API | Location | Facade action |
|-----|----------|---------------|
| `Object3D.dispose()` | `core/Object3D.js` | Add |
| `Object3D.intersectsFrustum(frustum)` (implemented by `Mesh`, `Line`, `Points`, `Sprite`) | `core/Object3D.js` | Add on `Object3D` |
| `RenderTarget.resolveColorBuffer`, `storeMultisampledColorBuffer`, `storeMultisampledDepthBuffer`, `storeMultisampledStencilBuffer` (+ constructor options) | `core/RenderTarget.js` | Add to `WebGLRenderTarget` and `WebGLRenderTargetOptions` |
| `LightShadow.getCamera(viewportIndex)` | `lights/LightShadow.js` | Add |
| `LightShadow` exported from `three` core | `Three.Core.js` | Already imported from `"three"` – nothing to do |
| `MeshPhysicalMaterial.retroreflectivity` | `materials/MeshPhysicalMaterial.js` | Add property + constructor parameter |
| `Plane.toJSON()` / `Plane.fromJSON(json)` | `math/Plane.js` | Add |
| `TrackballControls.rollSpeed`, `multiTouchRoll` | `examples/jsm/controls/TrackballControls.js` | Add |
| `AnimationUtils.hasTangents`, `KeyframeTrack.settings` (Bezier tangents) | `animation/*` | Not bound – skipped |
| `RenderObjectRefreshType` constant | `constants.js` | WebGPU-only – skipped |

## ⚪ Behavioural changes (no facade impact)

- `toJSON()` of `Object3D`, `Material`, `BufferAttribute`, `LightShadow`, `Scene`… now always serializes properties (no default-omission).
- `Ray.intersectTriangle` uses a watertight algorithm.
- `PMREMGenerator` blur rewritten (spiral kernel).
- Post-processing passes (`BloomPass`, `UnrealBloomPass`, `SSAOPass`, `SSRPass`) allocate internal render targets without depth buffer.
- `GLTFLoader` handles missing skinning attributes and `KHR_texture_transform` rotation.

## Steps

1. Update facades listed above in `modules/three/src/main/scala/THREE`.
2. `sbt compile` (all modules, including `example/client`).
3. Replace `PCFSoftShadowMap` usages in example code (`ShadowSample` set the raw value `2` via `js.Dynamic`, now uses the `PCFShadowMap` facade constant).
