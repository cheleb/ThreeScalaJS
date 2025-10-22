package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object FirstPersonControlsSample {

  def apply() =

    val firstPersonControlsDiv = div(
      h1("FirstPersonControls Demo"),
      p("Demonstrating first-person camera controls for immersive navigation."),
      div(
        cls := "info-panel",
        p("FirstPersonControls provides FPS-style camera movement with mouse look and keyboard navigation."),
        p("Use keyboard and mouse to navigate through the scene."),
        ul(
          li("WASD: Move forward/backward/left/right"),
          li("R/F: Move up/down"),
          li("Mouse: Look around (hold and drag)"),
          li("Left mouse button: Move forward"),
          li("Right mouse button: Move backward")
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

    // Create a more complex scene with multiple objects
    val geometries = js.Array(
      new SphereGeometry(1.0, 16, 12),
      new BoxGeometry(2.0, 2.0, 2.0),
      new ConeGeometry(1.0, 3.0, 8),
      new CylinderGeometry(0.8, 0.8, 2.0, 16),
      new TorusGeometry(1.5, 0.4, 8, 16),
      new PlaneGeometry(10, 10)
    )

    // Create materials
    val materials = js.Array(
      MeshStandardMaterial(
        color = 0xff4444,
        roughness = 0.3,
        metalness = 0.7
      ),
      MeshStandardMaterial(
        color = 0x44ff44,
        roughness = 0.5,
        metalness = 0.3
      ),
      MeshStandardMaterial(
        color = 0x4444ff,
        roughness = 0.2,
        metalness = 0.8
      ),
      MeshStandardMaterial(
        color = 0xffff44,
        roughness = 0.4,
        metalness = 0.5
      ),
      MeshStandardMaterial(
        color = 0xff44ff,
        roughness = 0.6,
        metalness = 0.2
      ),
      MeshStandardMaterial(
        color = 0x44ffff,
        roughness = 0.1,
        metalness = 0.9
      )
    )

    // Create meshes and position them in 3D space
    val meshes = geometries.zipWithIndex.map { case (geometry, i) =>
      val mesh = new Mesh(geometry, materials(i))
      // Arrange objects in a 3D grid pattern
      val row = i / 3
      val col = i % 3
      mesh.position.set(
        (col - 1) * 8,
        (row - 0.5) * 6,
        -5 - (i * 2)
      )
      scene.add(mesh)
      mesh
    }

    // Add ground plane
    val groundGeometry = new PlaneGeometry(50, 50)
    val groundMaterial = MeshStandardMaterial(
      color = 0x333333,
      roughness = 0.8,
      metalness = 0.1
    )
    val ground = new Mesh(groundGeometry, groundMaterial)
    ground.rotation.x = -scala.math.Pi / 2
    ground.position.y = -10
    scene.add(ground)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(10, 10, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    // Add some point lights for atmosphere
    val pointLight1 = PointLight(0xff0000, 0.5, 20)
    pointLight1.position.set(-10, 5, 0)
    scene.add(pointLight1)

    val pointLight2 = PointLight(0x0000ff, 0.5, 20)
    pointLight2.position.set(10, 5, 0)
    scene.add(pointLight2)

    // Create FirstPersonControls
    val controls = FirstPersonControls(camera, renderer.domElement)
    controls.movementSpeed = 10.0
    controls.lookSpeed = 0.005
    controls.lookVertical = true
    controls.autoForward = false
    controls.activeLook = true

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate some objects for visual interest
      meshes.zipWithIndex.foreach { case (mesh, i) =>
        mesh.rotation.x = time * (0.5 + i * 0.1)
        mesh.rotation.y = time * (0.3 + i * 0.15)
      }

      // Update controls
      controls.update(0.016) // Assume ~60fps

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
    firstPersonControlsDiv.amend(
      onUnmountCallback { _ =>
        controls.dispose()
        renderer.dispose()
        window.removeEventListener("resize", onWindowResize)
      }
    )

    // Append renderer to the canvas container
    firstPersonControlsDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    firstPersonControlsDiv
}
