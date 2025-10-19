package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object BoxHelperSample {

  def apply() =

    val boxHelperDiv = div(
      h1("BoxHelper Demo"),
      p(
        "Demonstrating the BoxHelper for visualizing object bounding boxes. The BoxHelper displays a wireframe representation of an object's bounding box, useful for debugging object bounds and spatial relationships."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(8, 8, 8)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create some objects to demonstrate bounding boxes

    // 1. Cube with bounding box
    val cubeGeometry = new BoxGeometry(2, 2, 2)
    val cubeMaterial = MeshLambertMaterial(color = 0xff4444)
    val cube         = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(-3, 0, 0)
    scene.add(cube)

    // Create bounding box helper for the cube
    val cubeBoxHelper = new BoxHelper(cube, 0xff0000)
    scene.add(cubeBoxHelper)

    // 2. Sphere with bounding box
    val sphereGeometry = new SphereGeometry(1.5, 16, 12)
    val sphereMaterial = MeshLambertMaterial(color = 0x44ff44)
    val sphere         = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(3, 0, 0)
    scene.add(sphere)

    // Create bounding box helper for the sphere
    val sphereBoxHelper = new BoxHelper(sphere, 0x00ff00)
    scene.add(sphereBoxHelper)

    // 3. Cone with bounding box
    val coneGeometry = new ConeGeometry(1, 3, 8)
    val coneMaterial = MeshLambertMaterial(color = 0x4444ff)
    val cone         = new Mesh(coneGeometry, coneMaterial)
    cone.position.set(0, 0, 3)
    scene.add(cone)

    // Create bounding box helper for the cone
    val coneBoxHelper = new BoxHelper(cone, 0x0000ff)
    scene.add(coneBoxHelper)

    // 4. Complex object (torus) with bounding box
    val torusGeometry = new TorusGeometry(1.2, 0.4, 8, 16)
    val torusMaterial = MeshLambertMaterial(color = 0xffaa00)
    val torus         = new Mesh(torusGeometry, torusMaterial)
    torus.position.set(0, 0, -3)
    scene.add(torus)

    // Create bounding box helper for the torus
    val torusBoxHelper = new BoxHelper(torus, 0xffaa00)
    scene.add(torusBoxHelper)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects around their local axes
      cube.rotation.x = time * 0.3
      cube.rotation.y = time * 0.5

      sphere.rotation.x = time * 0.4
      sphere.rotation.z = time * 0.6

      cone.rotation.y = time * 0.4

      torus.rotation.x = time * 0.2
      torus.rotation.y = time * 0.4

      // Update bounding box helpers to follow rotating objects
      cubeBoxHelper.update()
      sphereBoxHelper.update()
      coneBoxHelper.update()
      torusBoxHelper.update()

      // Rotate the entire scene slowly
      scene.rotation.y = time * 0.1

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
    boxHelperDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    boxHelperDiv
}
