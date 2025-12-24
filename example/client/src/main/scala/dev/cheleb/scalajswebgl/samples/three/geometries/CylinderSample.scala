package dev.cheleb.scalajswebgl.samples.three.geometries

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object CylinderSample {

  def apply() =

    val cylinderDiv = div(
      h1("CylinderGeometry Demo"),
      p("Demonstrating different cylinder configurations with various materials and transformations."),
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

    // Create different cylinders with various configurations

    // 1. Basic cylinder with wireframe material
    val basicCylinderGeometry = new CylinderGeometry(1.0, 1.0, 2.0, 32, 8)
    val wireframeMaterial     = MeshBasicMaterial(
      color = 0x00ff88,
      wireframe = true
    )
    val basicCylinder = new Mesh(basicCylinderGeometry, wireframeMaterial)
    basicCylinder.position.x = -4
    scene.add(basicCylinder)

    // 2. Cone-shaped cylinder (different top and bottom radius)
    val coneGeometry  = new CylinderGeometry(1.5, 0.5, 2.5, 32, 8)
    val phongMaterial = MeshPhongMaterial(
      color = 0x4488ff,
      shininess = 100,
      specular = 0x111111
    )
    val coneCylinder = new Mesh(coneGeometry, phongMaterial)
    coneCylinder.position.x = -1
    scene.add(coneCylinder)

    // 3. Short, wide cylinder
    val wideCylinderGeometry = new CylinderGeometry(1.2, 1.2, 0.8, 32, 4)
    val wideMaterial         = MeshPhongMaterial(
      color = 0xff4444,
      shininess = 30
    )
    val wideCylinder = new Mesh(wideCylinderGeometry, wideMaterial)
    wideCylinder.position.x = 2
    wideCylinder.position.y = -1
    scene.add(wideCylinder)

    // 4. Tall, thin cylinder with open ends
    val thinCylinderGeometry = new CylinderGeometry(0.3, 0.3, 3.0, 16, 8, openEnded = true)
    val thinMaterial         = MeshBasicMaterial(color = 0xffaa00)
    val thinCylinder         = new Mesh(thinCylinderGeometry, thinMaterial)
    thinCylinder.position.x = 4
    thinCylinder.position.y = 1
    scene.add(thinCylinder)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate cylinders at different speeds
      basicCylinder.rotation.x = time * 0.5
      basicCylinder.rotation.y = time * 0.3

      coneCylinder.rotation.x = time * 0.3
      coneCylinder.rotation.y = time * 0.7

      wideCylinder.rotation.z = time * 0.4

      thinCylinder.rotation.x = time * 0.8
      thinCylinder.rotation.y = time * 0.6

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
    cylinderDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    cylinderDiv
}
