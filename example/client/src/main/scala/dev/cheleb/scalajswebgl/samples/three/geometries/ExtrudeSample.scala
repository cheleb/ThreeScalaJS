package dev.cheleb.scalajswebgl.samples.three.geometries

import com.raquo.laminar.api.L.*
import scala.math._

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object ExtrudeSample {

  def apply() =

    val extrudeDiv = div(
      h1("ExtrudeGeometry Demo"),
      p("Demonstrating extruded 2D shapes with various materials and extrusion settings."),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 10

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create different extruded shapes

    // 1. Rectangle extrusion
    val rectangleShape = new Shape()
    rectangleShape.moveTo(-1.5, -1).lineTo(1.5, -1).lineTo(1.5, 1).lineTo(-1.5, 1).lineTo(-1.5, -1)

    val rectangleGeometry = new ExtrudeGeometry(
      rectangleShape,
      js.Dynamic.literal(
        depth = 1,
        bevelEnabled = true,
        bevelThickness = 0.2,
        bevelSize = 0.1
      )
    )
    val rectangleMaterial = MeshPhongMaterial(
      color = 0x00ff88,
      shininess = 100,
      specular = 0x111111
    )
    val rectangle = new Mesh(rectangleGeometry, rectangleMaterial)
    rectangle.position.x = -4
    scene.add(rectangle)

    // 2. Star shape extrusion
    val starShape   = new Shape()
    val starPoints  = 5
    val outerRadius = 1.0
    val innerRadius = 0.5

    for (i <- 0 until starPoints * 2) {
      val radius = if (i % 2 == 0) outerRadius else innerRadius
      val angle  = (i * Pi) / starPoints
      val x      = radius * cos(angle)
      val y      = radius * sin(angle)

      if (i == 0) {
        starShape.moveTo(x, y)
      } else {
        starShape.lineTo(x, y)
      }
    }

    val starGeometry = new ExtrudeGeometry(
      starShape,
      js.Dynamic.literal(
        depth = 1.5,
        bevelEnabled = false
      )
    )
    val starMaterial = MeshPhongMaterial(
      color = 0xff4444,
      shininess = 30
    )
    val star = new Mesh(starGeometry, starMaterial)
    star.position.x = 0
    scene.add(star)

    // 3. Heart shape extrusion with bevel
    val heartShape = new Shape()
    heartShape.moveTo(0, 0.5)
    heartShape.bezierCurveTo(0, 0.5, -0.5, 0, -0.5, -0.5)
    heartShape.bezierCurveTo(-0.5, -1, 0, -1, 0, -1.5)
    heartShape.bezierCurveTo(0, -1, 0.5, -1, 0.5, -0.5)
    heartShape.bezierCurveTo(0.5, 0, 0, 0.5, 0, 0.5)

    val heartGeometry = new ExtrudeGeometry(
      heartShape,
      js.Dynamic.literal(
        depth = 0.8,
        bevelEnabled = true,
        bevelThickness = 0.3,
        bevelSize = 0.2,
        bevelSegments = 8
      )
    )
    val heartMaterial = MeshPhongMaterial(
      color = 0xff69b4,
      shininess = 80
    )
    val heart = new Mesh(heartGeometry, heartMaterial)
    heart.position.x = 4
    scene.add(heart)

    // 4. Triangle with hole
    val triangleWithHoleShape = new Shape()
    triangleWithHoleShape.moveTo(-1, -1).lineTo(2, -1).lineTo(0.5, 2).lineTo(-1, -1)

    // Add a hole (smaller triangle in the center)
    val hole = new Shape()
    hole.moveTo(0, 0).lineTo(0.5, -0.5).lineTo(-0.5, -0.5).lineTo(0, 0)
    triangleWithHoleShape.holes.push(hole)

    val triangleGeometry = new ExtrudeGeometry(
      triangleWithHoleShape,
      js.Dynamic.literal(
        depth = 1.2,
        bevelEnabled = true,
        bevelThickness = 0.1
      )
    )
    val triangleMaterial = MeshBasicMaterial(color = 0x4488ff)
    val triangle         = new Mesh(triangleGeometry, triangleMaterial)
    triangle.position.y = -3
    scene.add(triangle)

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
      rectangle.rotation.x = time * 0.3
      rectangle.rotation.y = time * 0.5

      star.rotation.x = time * 0.4
      star.rotation.z = time * 0.2

      heart.rotation.y = time * 0.6
      heart.rotation.z = time * 0.3

      triangle.rotation.x = time * 0.2
      triangle.rotation.y = time * 0.7

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
    extrudeDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    extrudeDiv
}
