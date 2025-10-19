package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object DirectionalLightHelperSample {

  def apply() =

    val directionalLightHelperDiv = div(
      h1("DirectionalLightHelper Demo"),
      p(
        "Demonstrating the DirectionalLightHelper for visualizing directional light direction and position. The helper shows a plane representing the light source and a line indicating the light direction."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create main camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(5, 5, 5)
    camera.lookAt(0, 0, 0)

    // Create directional light
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(3, 3, 3)
    directionalLight.target.position.set(0, 0, 0)
    scene.add(directionalLight)

    // Create DirectionalLightHelper to visualize the directional light
    val lightHelper = new DirectionalLightHelper(directionalLight, 2, 0xffaa00)
    scene.add(lightHelper)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create some objects to demonstrate the lighting

    // 1. Cube positioned in the scene
    val cubeGeometry = new BoxGeometry(1, 1, 1)
    val cubeMaterial = MeshLambertMaterial(color = 0xff4444)
    val cube         = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(2, 0.5, 2)
    scene.add(cube)

    // 2. Sphere positioned in the scene
    val sphereGeometry = new SphereGeometry(0.5, 16, 12)
    val sphereMaterial = MeshLambertMaterial(color = 0x44ff44)
    val sphere         = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(-2, 0.5, -2)
    scene.add(sphere)

    // 3. Cone positioned in the scene
    val coneGeometry = new ConeGeometry(0.5, 2, 8)
    val coneMaterial = MeshLambertMaterial(color = 0x4444ff)
    val cone         = new Mesh(coneGeometry, coneMaterial)
    cone.position.set(-2, 1, 2)
    scene.add(cone)

    // 4. Torus positioned in the scene
    val torusGeometry = new TorusGeometry(0.7, 0.2, 8, 16)
    val torusMaterial = MeshLambertMaterial(color = 0xffaa00)
    val torus         = new Mesh(torusGeometry, torusMaterial)
    torus.position.set(2, 0.5, -2)
    scene.add(torus)

    // Add ambient light for better visibility
    val ambientLight = AmbientLight(0x404040, 0.4)
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

      // Animate the directional light in a circular motion
      directionalLight.position.x = js.Math.cos(time * 0.5) * 4
      directionalLight.position.z = js.Math.sin(time * 0.5) * 4
      directionalLight.position.y = js.Math.sin(time * 0.3) * 2 + 3

      // Update the light helper to reflect light changes
      lightHelper.update()

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
    directionalLightHelperDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    directionalLightHelperDiv
}
