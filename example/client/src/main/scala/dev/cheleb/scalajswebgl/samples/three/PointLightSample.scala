package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object PointLightSample:

  def apply() =

    val pointLightDiv = div(
      h1("PointLight Demo"),
      p(
        "Demonstrating PointLight - omnidirectional lights that emit from a single point, like a lightbulb."
      ),
      div(cls := "canvas-container")
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
    renderer.setClearColor("#0f0f23", 1)

    // Create objects to be illuminated
    val sphereGeometry = SphereGeometry(1, 32, 32)
    val cubeGeometry   = BoxGeometry(1.5, 1.5, 1.5)

    // Red sphere
    val sphere1 = Mesh(sphereGeometry, MeshPhongMaterial(color = 0xff4444))
    sphere1.position.set(-3, 0, 0)
    scene.add(sphere1)

    // Green sphere
    val sphere2 = Mesh(sphereGeometry, MeshPhongMaterial(color = 0x44ff44))
    sphere2.position.set(3, 0, 0)
    scene.add(sphere2)

    // Blue cube
    val cube1 = Mesh(cubeGeometry, MeshPhongMaterial(color = 0x4444ff))
    cube1.position.set(0, -2, -2)
    scene.add(cube1)

    // Yellow cube
    val cube2 = Mesh(cubeGeometry, MeshPhongMaterial(color = 0xffff44))
    cube2.position.set(0, 2, 2)
    scene.add(cube2)

    // Create multiple colored point lights
    val redLight = PointLight(0xff0040, 2, 10)
    redLight.position.set(-5, 3, 2)
    scene.add(redLight)

    val greenLight = PointLight(0x40ff00, 2, 10)
    greenLight.position.set(5, 3, 2)
    scene.add(greenLight)

    val blueLight = PointLight(0x0040ff, 2, 10)
    blueLight.position.set(0, -3, 2)
    scene.add(blueLight)

    // Add some ambient light for better visibility
    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate objects
      sphere1.rotation.x = time * 0.5
      sphere1.rotation.y = time * 0.7

      sphere2.rotation.x = -time * 0.3
      sphere2.rotation.y = -time * 0.5

      cube1.rotation.z = time * 0.4
      cube2.rotation.z = -time * 0.6

      // Animate lights in circular motion
      val radius = 6
      redLight.position.x = scala.math.cos(time * 0.5) * radius
      redLight.position.z = scala.math.sin(time * 0.5) * radius + 2

      greenLight.position.x = scala.math.cos(time * 0.7 + scala.math.Pi * 2 / 3) * radius
      greenLight.position.z = scala.math.sin(time * 0.7 + scala.math.Pi * 2 / 3) * radius + 2

      blueLight.position.x = scala.math.cos(time * 0.6 + scala.math.Pi * 4 / 3) * radius
      blueLight.position.z = scala.math.sin(time * 0.6 + scala.math.Pi * 4 / 3) * radius + 2

      // Pulse light intensities
      redLight.intensity = 2 + scala.math.sin(time * 3) * 0.5
      greenLight.intensity = 2 + scala.math.sin(time * 3 + scala.math.Pi * 2 / 3) * 0.5
      blueLight.intensity = 2 + scala.math.sin(time * 3 + scala.math.Pi * 4 / 3) * 0.5

      renderer.render(scene, camera)
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = _ => {
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    }
    window.addEventListener("resize", onWindowResize)

    // Append renderer to container
    val container = pointLightDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    pointLightDiv
