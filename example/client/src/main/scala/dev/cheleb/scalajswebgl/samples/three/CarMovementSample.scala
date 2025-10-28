package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import org.scalajs.dom.KeyboardEvent
import scala.scalajs.js
import scala.collection.mutable.Set as MutableSet
import scala.math.{Pi, cos, sin}

object CarMovementSample {

  def apply() =

    val carDiv = div(
      h1("Car Movement Demo"),
      p("Use WASD keys to move the car around the scene. The camera follows the car."),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 5, 10)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#87CEEB", 1) // Sky blue background

    // Create ground plane
    val groundGeometry = new PlaneGeometry(100, 100)
    val groundMaterial = MeshLambertMaterial(color = 0x90ee90) // Light green
    val ground         = new Mesh(groundGeometry, groundMaterial)
    ground.rotation.x = -Pi / 2 // Rotate to horizontal
    ground.receiveShadow = true
    scene.add(ground)

    // Create car body (simple box)
    val carBodyGeometry = new BoxGeometry(2, 0.5, 4)
    val carBodyMaterial = MeshPhongMaterial(color = 0xff0000) // Red car
    val carBody         = new Mesh(carBodyGeometry, carBodyMaterial)
    carBody.position.y = 0.25
    carBody.castShadow = true
    scene.add(carBody)

    // Create car wheels (cylinders)
    val wheelGeometry = new CylinderGeometry(0.3, 0.3, 0.2, 16)
    val wheelMaterial = MeshPhongMaterial(color = 0x333333) // Dark gray

    val wheels = for (_ <- 0 until 4) yield {
      val wheel = new Mesh(wheelGeometry, wheelMaterial)
      wheel.castShadow = true
      wheel.receiveShadow = true
      //   wheel.rotation.x = Pi / 2
      wheel.rotation.z = Pi / 2

      scene.add(wheel)
      wheel
    }

    // Position wheels relative to car body
    wheels(0).position.set(-1, 0.2, 1.2)  // Front left
    wheels(1).position.set(1, 0.2, 1.2)   // Front right
    wheels(2).position.set(-1, 0.2, -1.2) // Rear left
    wheels(3).position.set(1, 0.2, -1.2)  // Rear right

    // Group car parts together for easier movement
    val carGroup = new Group()
    carGroup.add(carBody)
    wheels.foreach(wheel => carGroup.add(wheel))
    scene.add(carGroup)

    // Car movement variables
    val carSpeed    = 0.1
    val turnSpeed   = 0.05
    var carX        = 0.0
    var carZ        = 0.0
    var carRotation = 0.0

    // Keyboard input tracking
    val keysPressed = MutableSet[String]()

    // Lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(10, 10, 5)
    directionalLight.castShadow = true
    // directionalLight.shadow.mapSize.set(2048, 2048)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Enable shadows
    // renderer.shadowMap.enabled = true
    // renderer.shadowMap.`type` = THREE.PCFSoftShadowMap

    // Keyboard event handlers
    val onKeyDown: KeyboardEvent => Unit = { event =>
      keysPressed.add(event.key.toLowerCase())
    }

    val onKeyUp: KeyboardEvent => Unit = { event =>
      keysPressed.remove(event.key.toLowerCase())
    }

    dom.document.addEventListener("keydown", onKeyDown)
    dom.document.addEventListener("keyup", onKeyUp)

    // Animation loop
    val animate: () => Unit = () => {
      // Handle car movement
      var moveX   = 0.0
      var moveZ   = 0.0
      var rotateY = 0.0

      if (keysPressed.contains("w") || keysPressed.contains("arrowup")) {
        moveZ -= carSpeed * cos(carRotation)
        moveX -= carSpeed * sin(carRotation)
      }
      if (keysPressed.contains("s") || keysPressed.contains("arrowdown")) {
        moveZ += carSpeed * cos(carRotation)
        moveX += carSpeed * sin(carRotation)
      }
      if (keysPressed.contains("a") || keysPressed.contains("arrowleft")) {
        rotateY += turnSpeed
      }
      if (keysPressed.contains("d") || keysPressed.contains("arrowright")) {
        rotateY -= turnSpeed
      }

      // Update car position and rotation
      carX = carX + moveX
      carZ = carZ + moveZ
      carRotation = carRotation + rotateY

      carGroup.position.set(carX, 0, carZ)
      carGroup.rotation.y = carRotation

      // Update camera to follow car
      camera.position.set(carX, 8, carZ + 12)
      camera.lookAt(carX, 0, carZ)

      // Rotate wheels for visual effect
      val wheelRotation = js.Date.now() * 0.01
      wheels.foreach(_.rotation.x = wheelRotation)

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

    // Append renderer to the canvas container
    carDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    carDiv
}
