package dev.cheleb.scalajswebgl.samples.three.geometries

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object RingSample {

  def apply() =

    val ringDiv = div(
      h1("RingGeometry Demo"),
      p("Demonstrating different ring configurations with various materials and transformations."),
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

    // Create different rings with various configurations

    // 1. Basic ring with wireframe material
    val basicRingGeometry = new RingGeometry(0.5, 1.0, 16, 2)
    val wireframeMaterial = MeshBasicMaterial(
      color = 0x00ff88,
      wireframe = true
    )
    val basicRing = new Mesh(basicRingGeometry, wireframeMaterial)
    basicRing.position.x = -4
    scene.add(basicRing)

    // 2. Thin ring with phong material
    val thinRingGeometry = new RingGeometry(0.8, 1.0, 32, 1)
    val phongMaterial    = MeshPhongMaterial(
      color = 0x4488ff,
      shininess = 100,
      specular = 0x111111
    )
    val thinRing = new Mesh(thinRingGeometry, phongMaterial)
    thinRing.position.x = -1
    scene.add(thinRing)

    // 3. Thick ring
    val thickRingGeometry = new RingGeometry(0.3, 1.2, 32, 3)
    val thickMaterial     = MeshPhongMaterial(
      color = 0xff4444,
      shininess = 30
    )
    val thickRing = new Mesh(thickRingGeometry, thickMaterial)
    thickRing.position.x = 2
    thickRing.position.y = -1
    scene.add(thickRing)

    // 4. Small ring with basic material
    val smallRingGeometry = new RingGeometry(0.2, 0.5, 8, 2)
    val smallMaterial     = MeshBasicMaterial(color = 0xffaa00)
    val smallRing         = new Mesh(smallRingGeometry, smallMaterial)
    smallRing.position.x = 4
    smallRing.position.y = 1
    scene.add(smallRing)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate rings at different speeds
      basicRing.rotation.x = time * 0.5
      basicRing.rotation.y = time * 0.3

      thinRing.rotation.x = time * 0.3
      thinRing.rotation.y = time * 0.7

      thickRing.rotation.z = time * 0.4

      smallRing.rotation.x = time * 0.8
      smallRing.rotation.y = time * 0.6

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
    ringDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    ringDiv
}
