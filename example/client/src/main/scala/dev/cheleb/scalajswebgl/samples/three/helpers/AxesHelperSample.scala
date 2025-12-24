package dev.cheleb.scalajswebgl.samples.three.helpers

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object AxesHelperSample {

  def apply() =

    val axesHelperDiv = div(
      h1("AxesHelper Demo"),
      p(
        "Demonstrating the AxesHelper for visualizing the 3D coordinate system. The X axis is red, Y axis is green, and Z axis is blue."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(5, 5, 5)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create AxesHelper with size 3
    val axesHelper = new AxesHelper(3)
    scene.add(axesHelper)

    // Create some objects to demonstrate the coordinate system

    // 1. Cube on positive X axis (red direction)
    val cubeGeometry = new BoxGeometry(0.5, 0.5, 0.5)
    val cubeMaterial = MeshLambertMaterial(color = 0xff4444)
    val cube         = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(2, 0, 0)
    scene.add(cube)

    // 2. Sphere on positive Y axis (green direction)
    val sphereGeometry = new SphereGeometry(0.3, 16, 12)
    val sphereMaterial = MeshLambertMaterial(color = 0x44ff44)
    val sphere         = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(0, 2, 0)
    scene.add(sphere)

    // 3. Cone on positive Z axis (blue direction)
    val coneGeometry = new ConeGeometry(0.3, 1, 8)
    val coneMaterial = MeshLambertMaterial(color = 0x4444ff)
    val cone         = new Mesh(coneGeometry, coneMaterial)
    cone.position.set(0, 0, 2)
    scene.add(cone)

    // 4. Torus in the center
    val torusGeometry = new TorusGeometry(0.7, 0.2, 8, 16)
    val torusMaterial = MeshLambertMaterial(color = 0xffaa00)
    val torus         = new Mesh(torusGeometry, torusMaterial)
    scene.add(torus)

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
      cube.rotation.x = time * 0.5
      cube.rotation.y = time * 0.3

      sphere.rotation.x = time * 0.3
      sphere.rotation.z = time * 0.7

      cone.rotation.y = time * 0.4

      torus.rotation.x = time * 0.2
      torus.rotation.y = time * 0.4

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
    axesHelperDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    axesHelperDiv
}
