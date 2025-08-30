This is **ThreeScalaJS**, a Scala.js project that provides type-safe Scala bindings for the popular Three.js 3D graphics library. Here's a comprehensive overview:

## Project Overview

**ThreeScalaJS** is a Scala.js facade library that enables Scala developers to create 3D web applications using Three.js through idiomatic Scala syntax. The project bridges the gap between Scala.js and Three.js, allowing developers to leverage Three.js's powerful 3D rendering capabilities while writing code in Scala.


## Documentation && demo

https://cheleb.github.io/ThreeScalaJS/docs/index.html

Check out the live demo at: [https://cheleb.github.io/ThreeScalaJS/demo](https://cheleb.github.io/ThreeScalaJS/demo)

## Architecture

The project follows a modular structure:

- **`modules/core`**: Contains core utilities and Laminar (reactive UI library) integration
- **`modules/three`**: The main Three.js Scala bindings/facades
- **`example/client`**: A demonstration application showcasing the library's capabilities

## Key Features

### Three.js Bindings
The `modules/three` module provides comprehensive Scala facades for Three.js components:

- **Cameras**: PerspectiveCamera, OrthographicCamera, CubeCamera, etc.
- **Geometries**: BoxGeometry, SphereGeometry, PlaneGeometry, custom geometries
- **Materials**: MeshBasicMaterial, MeshPhongMaterial, PointsMaterial, etc.
- **Lights**: DirectionalLight, AmbientLight, PointLight, SpotLight
- **Math Utilities**: Vector3, Matrix4, Quaternion, Euler angles, etc.
- **Objects**: Mesh, Group, Points, Line, Sprite
- **Renderers**: WebGLRenderer with configurable parameters
- **Scenes**: Scene management and hierarchy
- **Textures**: Texture loading and management
- **Controls**: OrbitControls for camera manipulation
- **Loaders**: GLTFLoader, TextureLoader for asset loading

### Example Application
The included example demonstrates:
- Interactive 3D globe rendering with Earth texture
- GLTF model loading (Scala logo)
- Location markers/pinners for famous cities
- Mouse hover interactions with raycasting
- Orbit controls for camera manipulation
- Real-time rendering loop

## Technology Stack

- **Scala 3.7.2**: Modern Scala with advanced language features
- **Scala.js**: Compiles Scala to JavaScript for web deployment
- **Laminar**: Reactive UI library for Scala.js
- **Three.js**: Underlying 3D graphics library (included as git submodule)
- **WebGL**: Hardware-accelerated 3D rendering in browsers

## Development Setup

The project includes a complete development environment:
- Hot reloading during development
- Vite for fast serving
- SBT build system
- VS Code integration with Metals
- Docker support for containerized development

## Usage Example

```scala
import THREE.*

// Create scene, camera, and renderer
val scene = Scene()
val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
val renderer = WebGLRenderer(antialias = true)

// Create geometry and material
val geometry = new BoxGeometry(1, 1, 1)
val material = MeshBasicMaterial(color = 0x00ff00)
val cube = new Mesh(geometry, material)

scene.add(cube)
camera.position.z = 5

// Animation loop
val animate = () => {
  cube.rotation.x += 0.01
  cube.rotation.y += 0.01
  renderer.render(scene, camera)
}
renderer.setAnimationLoop(animate)
```

## Purpose

ThreeScalaJS serves as a bridge for Scala developers who want to create 3D web applications without writing JavaScript directly. It provides type safety, better IDE support, and Scala ecosystem integration while maintaining access to Three.js's full feature set for creating games, visualizations, interactive 3D experiences, and more.

The project demonstrates how Scala.js can be used to create sophisticated web applications that rival JavaScript-based solutions in terms of performance and capabilities, particularly in the domain of 3D graphics and interactive visualizations.