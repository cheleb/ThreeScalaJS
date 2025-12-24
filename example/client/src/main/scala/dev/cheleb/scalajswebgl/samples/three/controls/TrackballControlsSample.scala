package dev.cheleb.scalajswebgl.samples.three.controls

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object TrackballControlsSample {

  def apply() =

    val trackballControlsDiv = div(
      h1("TrackballControls Demo"),
      p("Demonstrating trackball-style camera manipulation similar to CAD applications."),
      div(
        cls := "info-panel",
        p("TrackballControls provides intuitive camera control without maintaining a constant up vector."),
        p("Unlike OrbitControls, the camera can freely rotate over the poles without flipping."),
        ul(
          li("Left mouse button: Rotate camera around target"),
          li("Middle mouse button: Zoom in/out"),
          li("Right mouse button: Pan camera"),
          li("Mouse wheel: Zoom in/out"),
          li("A/S/D keys: Rotate, zoom, pan respectively (modifier keys)")
        )
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 0, 10)

    // Create WebGL renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0a0a0a", 1)

    // Create a scene with multiple objects arranged in a sphere
    val geometries = js.Array(
      new SphereGeometry(1.0, 16, 12),
      new BoxGeometry(2.0, 2.0, 2.0),
      new ConeGeometry(1.0, 3.0, 8),
      new CylinderGeometry(0.8, 0.8, 2.0, 16),
      new TorusGeometry(1.5, 0.4, 8, 16),
      new OctahedronGeometry(1.5, 0),
      new IcosahedronGeometry(1.5, 0),
      new DodecahedronGeometry(1.5, 0)
    )

    // Create materials with different colors
    val materials = js.Array(
      MeshStandardMaterial(color = 0xff4444, roughness = 0.3, metalness = 0.7),
      MeshStandardMaterial(color = 0x44ff44, roughness = 0.5, metalness = 0.3),
      MeshStandardMaterial(color = 0x4444ff, roughness = 0.2, metalness = 0.8),
      MeshStandardMaterial(color = 0xffff44, roughness = 0.4, metalness = 0.5),
      MeshStandardMaterial(color = 0xff44ff, roughness = 0.6, metalness = 0.2),
      MeshStandardMaterial(color = 0x44ffff, roughness = 0.1, metalness = 0.9),
      MeshStandardMaterial(color = 0xff8844, roughness = 0.7, metalness = 0.1),
      MeshStandardMaterial(color = 0x8844ff, roughness = 0.8, metalness = 0.4)
    )

    // Create meshes and position them in a spherical arrangement
    val meshes = geometries.zipWithIndex.map { case (geometry, i) =>
      val mesh = new Mesh(geometry, materials(i))

      // Arrange objects in a sphere around the origin
      val phi    = scala.math.Pi * 2 * i / geometries.length
      val theta  = scala.math.Pi * (i % 2) * 0.5
      val radius = 8.0

      mesh.position.set(
        radius * scala.math.sin(theta) * scala.math.cos(phi),
        radius * scala.math.cos(theta),
        radius * scala.math.sin(theta) * scala.math.sin(phi)
      )

      scene.add(mesh)
      mesh
    }

    // Add a central object as the target
    val centerGeometry = new SphereGeometry(0.5, 16, 12)
    val centerMaterial = MeshStandardMaterial(color = 0xffffff, roughness = 0.1, metalness = 0.9)
    val centerMesh     = new Mesh(centerGeometry, centerMaterial)
    scene.add(centerMesh)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(10, 10, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    // Add some point lights for atmosphere
    val pointLight1 = PointLight(0xff0000, 0.5, 30)
    pointLight1.position.set(-10, 5, 0)
    scene.add(pointLight1)

    val pointLight2 = PointLight(0x0000ff, 0.5, 30)
    pointLight2.position.set(10, 5, 0)
    scene.add(pointLight2)

    val pointLight3 = PointLight(0x00ff00, 0.5, 30)
    pointLight3.position.set(0, 0, 10)
    scene.add(pointLight3)

    // Create TrackballControls
    val controls = TrackballControls(camera, renderer.domElement)
    controls.rotateSpeed = 1.0
    controls.zoomSpeed = 1.2
    controls.panSpeed = 0.8
    controls.noRotate = false
    controls.noZoom = false
    controls.noPan = false
    controls.staticMoving = false
    controls.dynamicDampingFactor = 0.3
    controls.minDistance = 1.0
    controls.maxDistance = 100.0

    // Set target to center
    controls.target.set(0, 0, 0)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate objects for visual interest
      meshes.zipWithIndex.foreach { case (mesh, i) =>
        mesh.rotation.x = time * (0.5 + i * 0.1)
        mesh.rotation.y = time * (0.3 + i * 0.15)
      }

      // Rotate center object
      centerMesh.rotation.x = time * 0.5
      centerMesh.rotation.y = time * 0.8

      // Update controls
      controls.update()

      // Render the scene
      renderer.clear()
      renderer.render(scene, camera)
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = { _ =>
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
      controls.handleResize()
    }
    window.addEventListener("resize", onWindowResize)

    // Cleanup on unmount
    trackballControlsDiv.amend(
      onUnmountCallback { _ =>
        controls.dispose()
        renderer.dispose()
        window.removeEventListener("resize", onWindowResize)
      }
    )

    // Append renderer to the canvas container
    trackballControlsDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    trackballControlsDiv
}
