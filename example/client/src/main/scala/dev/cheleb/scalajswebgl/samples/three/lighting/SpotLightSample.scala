package dev.cheleb.scalajswebgl.samples.three.lighting

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object SpotLightSample:

  def apply() =

    val spotLightDiv = div(
      h1("SpotLight Demo"),
      p(
        "Demonstrating SpotLight - directional cone lights that emit from a point in one direction."
      ),
      div(cls := "canvas-container")
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 8, 12)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0f0f23", 1)

    // Create ground plane
    val groundGeometry = PlaneGeometry(20, 20)
    groundGeometry.rotateX(-scala.math.Pi / 2)
    val groundMaterial = MeshLambertMaterial(color = 0x404040)
    val ground         = Mesh(groundGeometry, groundMaterial)
    ground.position.y = -3
    scene.add(ground)

    // Create objects to be illuminated
    val sphereGeometry = SphereGeometry(1, 16, 16)
    val cubeGeometry   = BoxGeometry(1.5, 1.5, 1.5)

    // Central target sphere
    val targetSphere = Mesh(sphereGeometry, MeshPhongMaterial(color = 0xffaa00))
    targetSphere.position.set(0, 0, 0)
    scene.add(targetSphere)

    // Surrounding objects
    val objects = (0 until 8).map { i =>
      val angle  = (i * scala.math.Pi * 2) / 8
      val radius = 5
      val x      = scala.math.cos(angle) * radius
      val z      = scala.math.sin(angle) * radius

      val material = MeshPhongMaterial(color = 0x4444ff)
      val obj      = if (i % 2 == 0) Mesh(sphereGeometry, material) else Mesh(cubeGeometry, material)
      obj.position.set(x, 0, z)
      scene.add(obj)
      obj
    }

    // Create multiple colored spotlights
    val redSpotLight = SpotLight(0xff0040, 3, 15, scala.math.Pi / 6, 0.1, 2)
    redSpotLight.position.set(-8, 6, 0)
    redSpotLight.target = targetSphere
    scene.add(redSpotLight)

    val greenSpotLight = SpotLight(0x40ff00, 3, 15, scala.math.Pi / 4, 0.2, 2)
    greenSpotLight.position.set(8, 6, 0)
    greenSpotLight.target = targetSphere
    scene.add(greenSpotLight)

    val blueSpotLight = SpotLight(0x0040ff, 3, 15, scala.math.Pi / 8, 0.05, 2)
    blueSpotLight.position.set(0, 6, -8)
    blueSpotLight.target = targetSphere
    scene.add(blueSpotLight)

    // Add ambient light for better visibility
    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate the target sphere
      targetSphere.rotation.x = time * 0.5
      targetSphere.rotation.y = time * 0.7

      // Animate surrounding objects
      objects.zipWithIndex.foreach { case (obj, i) =>
        val angle  = (i * scala.math.Pi * 2) / 8 + time * 0.3
        val radius = 5
        obj.position.x = scala.math.cos(angle) * radius
        obj.position.z = scala.math.sin(angle) * radius
        obj.rotation.y = time + i * 0.5
      }

      // Animate spotlight angles for dynamic effect
      val angleVariation = scala.math.sin(time * 2) * 0.2
      redSpotLight.angle = scala.math.Pi / 6 + angleVariation
      greenSpotLight.angle = scala.math.Pi / 4 + angleVariation * 0.8
      blueSpotLight.angle = scala.math.Pi / 8 + angleVariation * 1.2

      // Pulse light intensities
      redSpotLight.intensity = 3 + scala.math.sin(time * 2) * 0.5
      greenSpotLight.intensity = 3 + scala.math.sin(time * 2.5) * 0.5
      blueSpotLight.intensity = 3 + scala.math.sin(time * 3) * 0.5

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
    val container = spotLightDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    spotLightDiv
