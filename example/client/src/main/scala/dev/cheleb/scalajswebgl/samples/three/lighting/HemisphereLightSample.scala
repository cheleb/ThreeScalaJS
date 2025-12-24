package dev.cheleb.scalajswebgl.samples.three.lighting

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object HemisphereLightSample:

  def apply() =

    val hemisphereDiv = div(
      h1("HemisphereLight Demo"),
      p(
        "Demonstrating HemisphereLight - sky-like ambient lighting with color fading from sky to ground."
      ),
      div(cls := "canvas-container")
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 5, 8)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#87CEEB", 1) // Sky blue background

    // Create ground plane
    val groundGeometry = PlaneGeometry(15, 15)
    groundGeometry.rotateX(-scala.math.Pi / 2)
    val groundMaterial = MeshLambertMaterial(color = 0x228b22) // Forest green
    val ground         = Mesh(groundGeometry, groundMaterial)
    ground.position.y = -2
    scene.add(ground)

    // Create objects to show lighting gradient
    val sphereGeometry = SphereGeometry(1, 16, 16)
    val cubeGeometry   = BoxGeometry(1.2, 1.2, 1.2)

    // Create multiple objects at different heights to show lighting gradient
    val objects = (0 until 5).map { i =>
      val height   = -1 + i * 0.8
      val material = MeshLambertMaterial(color = 0x666666)
      val obj      = if (i % 2 == 0) Mesh(sphereGeometry, material) else Mesh(cubeGeometry, material)
      obj.position.set((i - 2) * 2, height, 0)
      scene.add(obj)
      obj
    }

    // Create animated objects
    val animatedSphere = Mesh(sphereGeometry, MeshPhongMaterial(color = 0xffaa00))
    animatedSphere.position.set(0, 2, -3)
    scene.add(animatedSphere)

    // Create HemisphereLight with sky and ground colors
    val hemisphereLight = HemisphereLight(
      skyColor = 0x87ceeb,    // Sky blue
      groundColor = 0x8b4513, // Saddle brown
      intensity = 1.5
    )
    scene.add(hemisphereLight)

    // Add a subtle directional light for some definition
    val directionalLight = DirectionalLight(0xffffff, 0.3)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate the orange sphere
      animatedSphere.position.x = scala.math.sin(time) * 3
      animatedSphere.position.z = scala.math.cos(time) * 2
      animatedSphere.rotation.y = time

      // Animate other objects more subtly
      objects.zipWithIndex.foreach { case (obj, i) =>
        obj.rotation.y = time * 0.2 + i * 0.5
        obj.position.y = -1 + i * 0.8 + scala.math.sin(time * 2 + i) * 0.1
      }

      // Animate light colors for dynamic effect
      val skyIntensity = 1.5 + scala.math.sin(time * 1.5) * 0.3

      hemisphereLight.intensity = skyIntensity

      // Update ground color based on time
      val groundColorVariation = (scala.math.sin(time * 0.8) * 0.1 + 1.0)
      hemisphereLight.groundColor = new Color(
        (0x8b4513 * groundColorVariation).toInt // Saddle brown with variation
      )

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
    val container = hemisphereDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    hemisphereDiv
