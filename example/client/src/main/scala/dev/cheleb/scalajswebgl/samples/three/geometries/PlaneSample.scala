package dev.cheleb.scalajswebgl.samples.three.geometries

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.Pi

object PlaneSample {

  def apply() =

    val planeDiv = div(
      h1("PlaneGeometry Demo"),
      p("Demonstrating different plane configurations with various materials and transformations."),
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

    // Create different planes with various configurations

    // 1. Basic plane with wireframe material
    val basicPlaneGeometry = new PlaneGeometry(3, 3, 4, 4)
    val wireframeMaterial  = MeshBasicMaterial(
      color = 0x00ff88,
      wireframe = true
    )
    val basicPlane = new Mesh(basicPlaneGeometry, wireframeMaterial)
    basicPlane.position.x = -4
    scene.add(basicPlane)

    // 2. High-detail plane with phong material
    val detailedPlaneGeometry = new PlaneGeometry(2.5, 2.5, 32, 32)
    val phongMaterial         = MeshPhongMaterial(
      color = 0x4488ff,
      shininess = 100,
      specular = 0x111111
    )
    val detailedPlane = new Mesh(detailedPlaneGeometry, phongMaterial)
    detailedPlane.position.x = -1
    detailedPlane.rotation.x = -Pi / 4
    scene.add(detailedPlane)

    // 3. Rectangular plane with different proportions
    val rectPlaneGeometry = new PlaneGeometry(4, 2, 8, 4)
    val rectMaterial      = MeshPhongMaterial(
      color = 0xff4444,
      shininess = 30
    )
    val rectPlane = new Mesh(rectPlaneGeometry, rectMaterial)
    rectPlane.position.x = 2
    rectPlane.position.y = -1
    rectPlane.rotation.y = Pi / 6
    scene.add(rectPlane)

    // 4. Small square plane with basic material
    val smallPlaneGeometry = new PlaneGeometry(1.5, 1.5, 2, 2)
    val smallPlaneMaterial = MeshBasicMaterial(color = 0xffaa00)
    val smallPlane         = new Mesh(smallPlaneGeometry, smallPlaneMaterial)
    smallPlane.position.x = 4
    smallPlane.position.y = 1
    smallPlane.rotation.z = Pi / 3
    scene.add(smallPlane)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate planes at different speeds
      basicPlane.rotation.x = time * 0.5
      basicPlane.rotation.y = time * 0.3

      detailedPlane.rotation.x = time * 0.3
      detailedPlane.rotation.y = time * 0.7

      rectPlane.rotation.z = time * 0.4

      smallPlane.rotation.x = time * 0.8
      smallPlane.rotation.y = time * 0.6

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
    planeDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    planeDiv
}
