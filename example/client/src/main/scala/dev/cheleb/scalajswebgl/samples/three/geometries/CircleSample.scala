package dev.cheleb.scalajswebgl.samples.three.geometries

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object CircleSample {

  def apply() =

    val circleDiv = div(
      h1("CircleGeometry Demo"),
      p("Demonstrating different circle configurations with various materials and transformations."),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 8

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create different circles with various configurations

    // 1. Basic circle with wireframe material
    val basicCircleGeometry = new CircleGeometry(1.0, 16)
    val wireframeMaterial   = MeshBasicMaterial(
      color = 0x00ff88,
      wireframe = true
    )
    val basicCircle = new Mesh(basicCircleGeometry, wireframeMaterial)
    basicCircle.position.x = -4
    scene.add(basicCircle)

    // 2. High-detail circle with phong material
    val detailedCircleGeometry = new CircleGeometry(1.2, 32)
    val phongMaterial          = MeshPhongMaterial(
      color = 0x4488ff,
      shininess = 100,
      specular = 0x111111
    )
    val detailedCircle = new Mesh(detailedCircleGeometry, phongMaterial)
    detailedCircle.position.x = -1
    scene.add(detailedCircle)

    // 3. Small circle
    val smallCircleGeometry = new CircleGeometry(0.6, 12)
    val smallMaterial       = MeshPhongMaterial(
      color = 0xff4444,
      shininess = 30
    )
    val smallCircle = new Mesh(smallCircleGeometry, smallMaterial)
    smallCircle.position.x = 2
    smallCircle.position.y = -1
    scene.add(smallCircle)

    // 4. Low-poly circle with basic material
    val lowPolyCircleGeometry = new CircleGeometry(0.8, 6)
    val lowPolyMaterial       = MeshBasicMaterial(color = 0xffaa00)
    val lowPolyCircle         = new Mesh(lowPolyCircleGeometry, lowPolyMaterial)
    lowPolyCircle.position.x = 4
    lowPolyCircle.position.y = 1
    scene.add(lowPolyCircle)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate circles at different speeds
      basicCircle.rotation.x = time * 0.5
      basicCircle.rotation.y = time * 0.3

      detailedCircle.rotation.x = time * 0.3
      detailedCircle.rotation.y = time * 0.7

      smallCircle.rotation.z = time * 0.4

      lowPolyCircle.rotation.x = time * 0.8
      lowPolyCircle.rotation.y = time * 0.6

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
    circleDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    circleDiv
}
