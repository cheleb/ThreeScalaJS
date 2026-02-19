# Three.js r182 → r183 Migration Plan for ThreeScalaJS

## Overview

This document outlines the migration plan for updating the ThreeScalaJS project from Three.js r182 to r183. The main changes involve deprecated APIs and new class introductions.

## Summary of Changes

### 🔴 Breaking Changes / Deprecations

| Change | r182 | r183 | Priority |
|--------|------|------|----------|
| Clock deprecated | `THREE.Clock` | `THREE.Timer` | High |
| PostProcessing renamed | `THREE.PostProcessing` | `THREE.RenderPipeline` | High |
| getColorBufferType deprecated | `getColorBufferType()` | `getOutputBufferType()` | Medium |

### 🟢 New APIs

| API | Description | Location |
|-----|-------------|----------|
| `Timer` | Replacement for Clock with improved API | `THREE/core/Timer.js` |
| `RenderPipeline` | Renamed from PostProcessing | `THREE/renderers/common/RenderPipeline.js` |

---

## Scala.js Facade Updates

### 1. Create Timer.scala (NEW)

**File:** `modules/three/src/main/scala/THREE/core/Timer.scala`

```scala
package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

/**
 * This class is an alternative to Clock with a different API design and behavior.
 * The goal is to avoid the conceptual flaws that became apparent in Clock over time.
 * 
 * - Timer has an update() method that updates its internal state. That makes it possible to
 *   call getDelta() and getElapsed() multiple times per simulation step without getting different values.
 * - The class can make use of the Page Visibility API to avoid large time delta values when the app
 *   is inactive (e.g. tab switched or browser hidden).
 * 
 * @since r183
 */
@js.native
@JSImport("three", "Timer")
class Timer extends js.Object {

  /**
   * Connect the timer to the given document. Calling this method is not mandatory to
   * use the timer but enables the usage of the Page Visibility API to avoid large time
   * delta values.
   */
  def connect(document: dom.Document): Unit = js.native

  /**
   * Disconnects the timer from the DOM and also disables the usage of the Page Visibility API.
   */
  def disconnect(): Unit = js.native

  /**
   * Returns the time delta in seconds.
   */
  def getDelta(): Double = js.native

  /**
   * Returns the elapsed time in seconds.
   */
  def getElapsed(): Double = js.native

  /**
   * Returns the timescale.
   */
  def getTimescale(): Double = js.native

  /**
   * Sets the given timescale which scale the time delta computation in update().
   */
  def setTimescale(timescale: Double): Timer = js.native

  /**
   * Resets the time computation for the current simulation step.
   */
  def reset(): Timer = js.native

  /**
   * Can be used to free all internal resources. Usually called when
   * the timer instance isn't required anymore.
   */
  def dispose(): Unit = js.native

  /**
   * Updates the internal state of the timer. This method should be called
   * once per simulation step and before you perform queries against the timer
   * (e.g. via getDelta()).
   * 
   * @param timestamp The current time in milliseconds. Can be obtained from the 
   *                  requestAnimationFrame callback argument. If not provided, the current
   *                  time will be determined with performance.now.
   */
  def update(timestamp: js.UndefOr[Double] = js.undefined): Timer = js.native
}

object Timer {
  def apply(): Timer = new Timer()
}
```

### 2. Create Clock.scala (DEPRECATED)

**File:** `modules/three/src/main/scala/THREE/core/Clock.scala`

```scala
package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * Class for keeping track of time.
 * 
 * @deprecated since r183. Use [[Timer]] instead.
 * @see [[Timer]] for the recommended replacement
 */
@js.native
@JSImport("three", "Clock")
@deprecated("Use THREE.Timer instead. Clock will be removed in a future version.", "r183")
class Clock(autoStart: Boolean = true) extends js.Object {

  /** If set to true, the clock starts automatically when getDelta() is called for the first time. */
  var autoStart: Boolean = js.native

  /** Holds the time at which the clock's start() method was last called. */
  var startTime: Double = js.native

  /** Holds the time at which the clock's start(), getElapsedTime() or getDelta() methods were last called. */
  var oldTime: Double = js.native

  /** Keeps track of the total time that the clock has been running. */
  var elapsedTime: Double = js.native

  /** Whether the clock is running or not. */
  var running: Boolean = js.native

  /** Starts the clock. */
  def start(): Unit = js.native

  /** Stops the clock. */
  def stop(): Unit = js.native

  /** Returns the elapsed time in seconds. */
  def getElapsedTime(): Double = js.native

  /** Returns the delta time in seconds. */
  def getDelta(): Double = js.native
}

object Clock {
  def apply(autoStart: Boolean = true): Clock = new Clock(autoStart)
}
```

### 3. Create RenderPipeline.scala (NEW)

**File:** `modules/three/src/main/scala/THREE/renderers/RenderPipeline.scala`

```scala
package THREE

import scala.scalajs.js
import scala.scalajs.js.annotation.*

/**
 * RenderPipeline is the new name for PostProcessing since r183.
 * It manages a series of post-processing passes to be applied to a scene.
 * 
 * @since r183
 */
@js.native
@JSImport("three/webgpu", "RenderPipeline")
class RenderPipeline(renderer: js.Object, outputNode: js.UndefOr[js.Object] = js.undefined) extends js.Object {

  /**
   * Renders the scene with all post-processing passes applied.
   */
  def render(): Unit = js.native

  /**
   * Sets the resolution scale for the render pipeline.
   */
  def setResolutionScale(scale: Double): Unit = js.native

  /**
   * Gets the resolution scale for the render pipeline.
   */
  def getResolutionScale(): Double = js.native
}

object RenderPipeline {
  def apply(renderer: js.Object, outputNode: js.UndefOr[js.Object] = js.undefined): RenderPipeline =
    new RenderPipeline(renderer, outputNode)
}
```

### 4. Update WebGLRenderer.scala

The `WebGLRenderer.scala` already has the correct implementation with:
- `getOutputBufferType()` - the new method (r182+)
- `getColorBufferType()` - deprecated method with annotation

**No changes needed** - the facade is already up to date.

---

## Example Updates

### PostProcessingSample.scala

The current example uses `EffectComposer` from the examples/jsm which is different from the core `PostProcessing`/`RenderPipeline` class. The `EffectComposer` is still valid for WebGL rendering.

**No immediate changes needed** - the example uses the jsm addon, not the core PostProcessing class.

### Animation Samples

If any animation samples use `Clock`, they should be updated to use `Timer`:

```scala
// Old (r182)
val clock = new Clock()
def animate(): Unit = {
  val delta = clock.getDelta()
  // ...
}

// New (r183)
val timer = new Timer()
timer.connect(dom.document) // Optional: use Page Visibility API
def animate(timestamp: Double): Unit = {
  timer.update(timestamp)
  val delta = timer.getDelta()
  // ...
}
```

---

## Verification Checklist

- [ ] `Timer.scala` created and compiles
- [ ] `Clock.scala` created with deprecation warning
- [ ] `RenderPipeline.scala` created (for WebGPU usage)
- [ ] All existing examples still compile
- [ ] `package.json` has `"three": "0.183.0"` ✓ (already done)
- [ ] Run `sbt compile` to verify all facades
- [ ] Run `sbt test` to verify all tests pass

---

## Notes

1. **EffectComposer vs RenderPipeline**: The `EffectComposer` used in examples is from `three/examples/jsm/postprocessing/EffectComposer.js` and is still the recommended way for WebGL post-processing. The `RenderPipeline` is a new class for WebGPU rendering.

2. **Clock Deprecation**: The `Clock` class will still work but will emit a console warning. It's recommended to migrate to `Timer` for new code.

3. **WebGPU vs WebGL**: The `RenderPipeline` class is primarily for WebGPU rendering. For WebGL, continue using `EffectComposer` from the examples/jsm addons.

---

## References

- Three.js Migration Guide: https://github.com/mrdoob/three.js/wiki/Migration-Guide
- Three.js Releases: https://github.com/mrdoob/three.js/releases
- Timer API: https://threejs.org/docs/#api/en/core/Timer
