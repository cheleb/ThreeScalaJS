package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object LineDashedMaterialSample:

  def apply() =

    val dashedDiv = div(
      h1("LineDashedMaterial Demo"),
      p(
        "Demonstrating LineDashedMaterial - a material for drawing wireframe-style geometries with dashed lines."
      ),
      div(cls := "canvas-container")
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 10

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0f0f23", 1)

    // Simple dashed line example using LineSegmentsGeometry
    val geometry = new LineSegmentsGeometry()

    val positions = js.Array[Double](
      -4, 0, 0, 4, 0, 0, // horizontal line
      0, -4, 0, 0, 4, 0  // vertical line
    )
    geometry.setPositions(positions)

    val material = LineDashedMaterial(color = 0xff0000, dashSize = 2, gapSize = 1)
    val line     = new LineSegments()
    line.geometry = geometry
    line.material = material
    line.computeLineDistances()
    scene.add(line)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001
      line.rotation.z = time * 0.5
      material.scale = 1 + scala.math.sin(time * 2) * 0.5
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
    val container = dashedDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    dashedDiv
