package dev.cheleb.scalajswebgl.samples.three.helpers

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object PolarGridHelperSample {

  def apply() =

    val polarGridHelperDiv = div(
      h1("PolarGridHelper Demo"),
      p(
        "Demonstrating the PolarGridHelper for visualizing a polar coordinate grid. The polar grid helps with angular measurements and radial positioning in 3D space."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(8, 8, 8)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create PolarGridHelper with radius 10, 16 sectors, 8 rings, 64 divisions
    val polarGridHelper = new PolarGridHelper(10, 16, 8, 64, 0x444444, 0x888888)
    scene.add(polarGridHelper)

    // Create objects positioned using polar coordinates to demonstrate the grid

    // 1. Objects along different rings (radii)
    val ringObjects = (1 to 3).map { ringIndex =>
      val radius = 2 + ringIndex * 2
      val angle  = (ringIndex * scala.math.Pi * 2) / 3

      val cubeGeometry = new BoxGeometry(0.8, 0.8, 0.8)
      val cubeMaterial = MeshLambertMaterial(color = 0xff4444 + ringIndex * 0x111111)
      val cube         = new Mesh(cubeGeometry, cubeMaterial)
      cube.position.set(
        scala.math.sin(angle) * radius,
        0.4,
        scala.math.cos(angle) * radius
      )
      scene.add(cube)
      cube
    }

    // 2. Objects along different sectors (angles)
    val sectorObjects = (0 until 6).map { sectorIndex =>
      val angle  = (sectorIndex * scala.math.Pi * 2) / 6
      val radius = 6

      val sphereGeometry = new SphereGeometry(0.3, 12, 8)
      val sphereMaterial = MeshLambertMaterial(color = 0x44ff44 + sectorIndex * 0x111111)
      val sphere         = new Mesh(sphereGeometry, sphereMaterial)
      sphere.position.set(
        scala.math.sin(angle) * radius,
        0.3,
        scala.math.cos(angle) * radius
      )
      scene.add(sphere)
      sphere
    }

    // 3. Central object
    val centralGeometry = new ConeGeometry(0.5, 2, 8)
    val centralMaterial = MeshLambertMaterial(color = 0x4444ff)
    val centralCone     = new Mesh(centralGeometry, centralMaterial)
    centralCone.position.set(0, 1, 0)
    scene.add(centralCone)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(10, 10, 10)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects around their local axes
      ringObjects.zipWithIndex.foreach { case (cube, index) =>
        cube.rotation.x = time * 0.5 + index * 0.5
        cube.rotation.y = time * 0.3 + index * 0.3
      }

      sectorObjects.zipWithIndex.foreach { case (sphere, index) =>
        sphere.rotation.y = time * 0.7 + index * 0.2
        sphere.rotation.z = time * 0.3 + index * 0.4
      }

      centralCone.rotation.y = time * 0.8

      // Rotate the entire scene slowly
      scene.rotation.y = time * 0.1

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
    polarGridHelperDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    polarGridHelperDiv
}
