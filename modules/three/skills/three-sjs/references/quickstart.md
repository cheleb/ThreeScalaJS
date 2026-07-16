# ThreeScalaJS Quickstart

## Dependency (SBT)

```sbt
libraryDependencies += "dev.cheleb" %%% "threesjs" % "{{ projectVersion }}"
```

## Minimal Scene Example

```scala
import THREE.*
import org.scalajs.dom.window

val scene = Scene()
val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
val renderer = WebGLRenderer(antialias = true)

val geometry = new BoxGeometry(1, 1, 1)
val material = MeshBasicMaterial(color = 0x00ff00)
val cube = new Mesh(geometry, material)

scene.add(cube)
camera.position.z = 5

val animate = () => {
  cube.rotation.x += 0.01
  cube.rotation.y += 0.01
  renderer.render(scene, camera)
}
renderer.setAnimationLoop(animate)
```

## Where this comes from in the repository

- `README.md` (basic dependency + minimal usage)
- `example/client/src/main/scala/dev/cheleb/scalajswebgl/samples/three/ScenePage.scala` (larger real-world setup)
