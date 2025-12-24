package dev.cheleb.scalajswebgl.samples.three.geometries

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object ConeSample {

  def apply() =

    val coneDiv = div(
      h1("ConeGeometry Demo"),
      p("Demonstrating different cone configurations with various materials and transformations."),
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

    // Create different cones with various configurations

    // 1. Basic cone with wireframe material
    val basicConeGeometry = new ConeGeometry(1.0, 2.0, 32, 8)
    val wireframeMaterial = MeshBasicMaterial(
      color = 0x00ff88,
      wireframe = true
    )
    val basicCone = new Mesh(basicConeGeometry, wireframeMaterial)
    basicCone.position.x = -4
    scene.add(basicCone)

    // 2. Wide cone with phong material
    val wideConeGeometry = new ConeGeometry(1.5, 1.5, 32, 8)
    val phongMaterial    = MeshPhongMaterial(
      color = 0x4488ff,
      shininess = 100,
      specular = 0x111111
    )
    val wideCone = new Mesh(wideConeGeometry, phongMaterial)
    wideCone.position.x = -1
    scene.add(wideCone)

    // 3. Tall, narrow cone
    val tallConeGeometry = new ConeGeometry(0.5, 3.0, 32, 12)
    val tallMaterial     = MeshPhongMaterial(
      color = 0xff4444,
      shininess = 30
    )
    val tallCone = new Mesh(tallConeGeometry, tallMaterial)
    tallCone.position.x = 2
    tallCone.position.y = -1
    scene.add(tallCone)

    // 4. Low-poly cone with open base
    val lowPolyConeGeometry = new ConeGeometry(1.2, 2.2, 8, 4, openEnded = true)
    val lowPolyMaterial     = MeshBasicMaterial(color = 0xffaa00)
    val lowPolyCone         = new Mesh(lowPolyConeGeometry, lowPolyMaterial)
    lowPolyCone.position.x = 4
    lowPolyCone.position.y = 1
    scene.add(lowPolyCone)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate cones at different speeds
      basicCone.rotation.x = time * 0.5
      basicCone.rotation.y = time * 0.3

      wideCone.rotation.x = time * 0.3
      wideCone.rotation.y = time * 0.7

      tallCone.rotation.z = time * 0.4

      lowPolyCone.rotation.x = time * 0.8
      lowPolyCone.rotation.y = time * 0.6

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
    coneDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    coneDiv
}
