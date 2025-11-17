package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.Pi

object PointerLockControlsSample {

  def apply() =

    val pointerLockControlsDiv = div(
      h1("PointerLockControls Demo"),
      p("Demonstrating first-person camera controls using Pointer Lock API."),
      div(
        cls := "info-panel",
        p("PointerLockControls provides FPS-style mouse look controls."),
        p("Click anywhere to lock the pointer and enable mouse look. Press ESC to unlock."),
        ul(
          li("Click to lock pointer and enable mouse look"),
          li("Move mouse to look around"),
          li("WASD keys to move forward/backward/left/right"),
          li("Press ESC to unlock pointer")
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
    camera.position.y = 10

    // Create WebGL renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#87ceeb", 1)

    // Create ground plane
    val groundGeometry = new PlaneGeometry(100, 100)
    val groundMaterial = MeshLambertMaterial(color = 0x90ee90)
    val ground         = new Mesh(groundGeometry, groundMaterial)
    ground.rotation.x = -Pi / 2
    scene.add(ground)

    // Create some objects in the scene
    val boxGeometry = new BoxGeometry(2, 2, 2)
    val boxMaterial = MeshStandardMaterial(color = 0xff6b6b, roughness = 0.3, metalness = 0.7)
    val box         = new Mesh(boxGeometry, boxMaterial)
    box.position.set(5, 1, -5)
    scene.add(box)

    val sphereGeometry = new SphereGeometry(1.5, 16, 12)
    val sphereMaterial = MeshStandardMaterial(color = 0x4ecdc4, roughness = 0.5, metalness = 0.3)
    val sphere         = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(-5, 1.5, -8)
    scene.add(sphere)

    val cylinderGeometry = new CylinderGeometry(1, 1, 3, 16)
    val cylinderMaterial = MeshStandardMaterial(color = 0xf9ca24, roughness = 0.4, metalness = 0.5)
    val cylinder         = new Mesh(cylinderGeometry, cylinderMaterial)
    cylinder.position.set(0, 1.5, -10)
    scene.add(cylinder)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(10, 10, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Create PointerLockControls
    val controls = new PointerLockControls(camera, renderer.domElement)

    // Movement variables
    var moveForward  = false
    var moveBackward = false
    var moveLeft     = false
    var moveRight    = false
    val velocity     = Vector3(0, 0, 0)
    val direction    = Vector3(0, 0, 0)

    // Event listeners for keyboard input
    val onKeyDown: dom.KeyboardEvent => Unit = { event =>
      event.code match {
        case "KeyW" | "ArrowUp"    => moveForward = true
        case "KeyA" | "ArrowLeft"  => moveLeft = true
        case "KeyS" | "ArrowDown"  => moveBackward = true
        case "KeyD" | "ArrowRight" => moveRight = true
        case _                     =>
      }
    }

    val onKeyUp: dom.KeyboardEvent => Unit = { event =>
      event.code match {
        case "KeyW" | "ArrowUp"    => moveForward = false
        case "KeyA" | "ArrowLeft"  => moveLeft = false
        case "KeyS" | "ArrowDown"  => moveBackward = false
        case "KeyD" | "ArrowRight" => moveRight = false
        case _                     =>
      }
    }

    // Add event listeners for pointer lock changes
    controls.asInstanceOf[js.Dynamic].addEventListener("lock", () => println("Pointer locked"))

    controls.asInstanceOf[js.Dynamic].addEventListener("unlock", () => println("Pointer unlocked"))

    // Handle click to lock pointer
    val onClick: dom.MouseEvent => Unit = { _ =>
      if (!controls.isLocked) {
        controls.lock()
      }
    }

    renderer.domElement.addEventListener("click", onClick)
    window.addEventListener("keydown", onKeyDown)
    window.addEventListener("keyup", onKeyUp)

    // Animation loop
    val animate: () => Unit = () => {
      val delta = 0.016 // Approximate 60fps

      // Update velocity based on input
      val vx = velocity.x.getOrElse(0.0)
      val vz = velocity.z.getOrElse(0.0)
      velocity.x = vx - (vx * 10.0 * delta)
      velocity.z = vz - (vz * 10.0 * delta)

      direction.z = (if (moveForward) 1.0 else 0.0) + (if (moveBackward) -1.0 else 0.0)
      direction.x = (if (moveLeft) 1.0 else 0.0) + (if (moveRight) -1.0 else 0.0)

      if (moveForward || moveBackward)
        velocity.z = velocity.z.getOrElse(0.0) - (direction.z.getOrElse(0.0) * 400.0 * delta)
      if (moveLeft || moveRight) velocity.x = velocity.x.getOrElse(0.0) - (direction.x.getOrElse(0.0) * 400.0 * delta)

      // Apply movement if pointer is locked
      if (controls.isLocked) {
        controls.moveRight(-(velocity.x.getOrElse(0.0) * delta))
        controls.moveForward(-(velocity.z.getOrElse(0.0) * delta))

        // Keep camera above ground
        if (camera.position.y.getOrElse(0.0) < 1) {
          camera.position.y = 1
        }
      }

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
    }
    window.addEventListener("resize", onWindowResize)

    // Cleanup on unmount
    pointerLockControlsDiv.amend(
      onUnmountCallback { _ =>
        controls.dispose()
        renderer.dispose()
        window.removeEventListener("resize", onWindowResize)
        window.removeEventListener("keydown", onKeyDown)
        window.removeEventListener("keyup", onKeyUp)
        renderer.domElement.removeEventListener("click", onClick)
      }
    )

    // Append renderer to the canvas container
    pointerLockControlsDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    pointerLockControlsDiv
}
