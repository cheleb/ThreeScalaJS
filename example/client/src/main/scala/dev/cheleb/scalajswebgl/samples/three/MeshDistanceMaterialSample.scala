package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.Pi

object MeshDistanceMaterialSample {

  def apply() =

    val distanceDiv = div(
      h1("MeshDistanceMaterial Demo"),
      p(
        "Demonstrating MeshDistanceMaterial - a material used for shadow mapping and distance-based rendering. Perfect for creating depth-based effects and customizing shadow casting behavior."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(10, 8, 10)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create lighting
    val ambientLight = AmbientLight(0xffffff, 0.4)
    scene.add(ambientLight)

    // Directional light for illumination
    val directionalLight = DirectionalLight(0xffffff, 0.8)
    directionalLight.position.set(5, 10, 5)
    scene.add(directionalLight)

    // Create ground plane
    val groundGeometry = PlaneGeometry(15, 15)
    val groundMaterial = MeshLambertMaterial(color = 0x404040)
    val ground         = Mesh(groundGeometry, groundMaterial)
    ground.rotation.x = -Pi / 2
    ground.position.y = -4
    scene.add(ground)

    // Create objects demonstrating MeshDistanceMaterial

    // 1. Basic MeshDistanceMaterial sphere
    val sphereGeometry = SphereGeometry(1.5, 32, 16)
    val sphereMaterial = MeshDistanceMaterial()
    val sphere         = Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(-4, 0, 0)
    scene.add(sphere)

    // 2. MeshDistanceMaterial with displacement
    val cubeGeometry = BoxGeometry(2, 2, 2)
    val cubeMaterial = MeshDistanceMaterial(
      displacementScale = 0.5,
      displacementBias = 0.0
    )
    val cube = Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(0, 0, 0)
    scene.add(cube)

    // 3. MeshDistanceMaterial with alpha map simulation (using color)
    val torusGeometry = TorusGeometry(1, 0.4, 16, 100)
    val torusMaterial = MeshDistanceMaterial()
    val torus         = Mesh(torusGeometry, torusMaterial)
    torus.position.set(4, 0, 0)
    scene.add(torus)

    // 4. Complex object showing displacement effects
    val coneGeometry = ConeGeometry(1.5, 3, 32)
    val coneMaterial = MeshDistanceMaterial(
      displacementScale = 1.0,
      displacementBias = -0.2
    )
    val cone = Mesh(coneGeometry, coneMaterial)
    cone.position.set(0, 3, -2)
    scene.add(cone)

    // Add some regular material objects for comparison
    val smallSphereGeometry = SphereGeometry(0.8, 16, 12)
    val smallSphereMaterial = MeshLambertMaterial(color = 0xff6b6b)
    val smallSphere         = Mesh(smallSphereGeometry, smallSphereMaterial)
    smallSphere.position.set(-2, -2, 1)
    scene.add(smallSphere)

    val smallCubeGeometry = BoxGeometry(0.6, 0.6, 0.6)
    val smallCubeMaterial = MeshLambertMaterial(color = 0x4ecdc4)
    val smallCube         = Mesh(smallCubeGeometry, smallCubeMaterial)
    smallCube.position.set(2, -2, -1)
    scene.add(smallCube)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects at different speeds
      sphere.rotation.x = time * 0.3
      sphere.rotation.y = time * 0.5

      cube.rotation.x = time * 0.4
      cube.rotation.y = time * 0.2

      torus.rotation.x = time * 0.6
      torus.rotation.z = time * 0.3

      cone.rotation.y = time * 0.7

      smallSphere.rotation.y = time * 0.8
      smallCube.rotation.x = time * 0.5

      // Move camera slightly to show depth effect
      camera.position.x = scala.math.cos(time * 0.2) * 3
      camera.position.z = 10 + scala.math.sin(time * 0.2) * 2
      camera.lookAt(0, 0, 0)

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
    distanceDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    distanceDiv
}
