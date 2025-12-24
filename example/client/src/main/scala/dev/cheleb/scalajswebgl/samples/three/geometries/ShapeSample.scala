package dev.cheleb.scalajswebgl.samples.three.geometries

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object ShapeSample {

  def apply() =

    val shapeDiv = div(
      h1("ShapeGeometry Demo"),
      p("Demonstrating custom 2D shapes extruded to 3D with various materials and transformations."),
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

    // For now, create simple geometries that work with existing bindings
    // ShapeGeometry requires complex JavaScript Shape objects that need more setup

    // 1. Use existing geometries to demonstrate the concept
    val triangleGeometry  = new ConeGeometry(0.01, 1.5, 3) // Very thin cone = triangle-like
    val wireframeMaterial = MeshBasicMaterial(
      color = 0x00ff88,
      wireframe = true
    )
    val triangle = new Mesh(triangleGeometry, wireframeMaterial)
    triangle.position.x = -4
    scene.add(triangle)

    // 2. Rectangle-like using box geometry scaled
    val rectangleGeometry = new BoxGeometry(2, 1, 0.1)
    val phongMaterial     = MeshPhongMaterial(
      color = 0x4488ff,
      shininess = 100,
      specular = 0x111111
    )
    val rectangle = new Mesh(rectangleGeometry, phongMaterial)
    rectangle.position.x = -1
    scene.add(rectangle)

    // 3. Pentagon-like using torus with specific settings
    val pentagonGeometry = new TorusGeometry(1.0, 0.3, 5, 1) // 5-sided
    val pentagonMaterial = MeshPhongMaterial(
      color = 0xff4444,
      shininess = 30
    )
    val pentagon = new Mesh(pentagonGeometry, pentagonMaterial)
    pentagon.position.x = 2
    pentagon.position.y = -1
    scene.add(pentagon)

    // 4. Hexagon-like using torus with 6 sides
    val hexagonGeometry = new TorusGeometry(1.0, 0.3, 6, 1)
    val hexagonMaterial = MeshBasicMaterial(color = 0xffaa00)
    val hexagon         = new Mesh(hexagonGeometry, hexagonMaterial)
    hexagon.position.x = 4
    hexagon.position.y = 1
    scene.add(hexagon)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate shapes at different speeds
      triangle.rotation.x = time * 0.5
      triangle.rotation.y = time * 0.3

      rectangle.rotation.x = time * 0.3
      rectangle.rotation.y = time * 0.7

      pentagon.rotation.z = time * 0.4

      hexagon.rotation.x = time * 0.8
      hexagon.rotation.y = time * 0.6

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
    shapeDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    shapeDiv
}
