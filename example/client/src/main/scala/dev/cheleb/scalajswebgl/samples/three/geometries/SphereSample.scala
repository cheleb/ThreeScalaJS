package dev.cheleb.scalajswebgl.samples.three.geometries

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.Pi

object SphereSample {

  def apply() =

    val sphereDiv = div(
      h1("SphereGeometry Demo"),
      p("Demonstrating different sphere configurations with various materials and transformations."),
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

    // Create different spheres with various configurations

    // 1. Basic sphere with wireframe material
    val basicSphereGeometry = new SphereGeometry(1.0, 32, 16)
    val wireframeMaterial   = MeshBasicMaterial(
      color = 0x00ff88,
      wireframe = true
    )
    val basicSphere = new Mesh(basicSphereGeometry, wireframeMaterial)
    basicSphere.position.x = -4
    scene.add(basicSphere)

    // 2. High-detail sphere with phong material
    val detailedSphereGeometry = new SphereGeometry(1.2, 64, 32)
    val phongMaterial          = MeshPhongMaterial(
      color = 0x4488ff,
      shininess = 100,
      specular = 0x111111
    )
    val detailedSphere = new Mesh(detailedSphereGeometry, phongMaterial)
    detailedSphere.position.x = -1
    scene.add(detailedSphere)

    // 3. Hemisphere (half sphere)
    val hemisphereGeometry = new SphereGeometry(0.8, 32, 16, 0, Pi * 2, 0, Pi)
    val hemisphereMaterial = MeshPhongMaterial(
      color = 0xff4444,
      shininess = 30
    )
    val hemisphere = new Mesh(hemisphereGeometry, hemisphereMaterial)
    hemisphere.position.x = 2
    hemisphere.position.y = -1
    scene.add(hemisphere)

    // 4. Small sphere with basic material
    val smallSphereGeometry = new SphereGeometry(0.5, 16, 8)
    val smallSphereMaterial = MeshBasicMaterial(color = 0xffaa00)
    val smallSphere         = new Mesh(smallSphereGeometry, smallSphereMaterial)
    smallSphere.position.x = 4
    smallSphere.position.y = 1
    scene.add(smallSphere)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate spheres at different speeds
      basicSphere.rotation.x = time * 0.5
      basicSphere.rotation.y = time * 0.3

      detailedSphere.rotation.x = time * 0.3
      detailedSphere.rotation.y = time * 0.7

      hemisphere.rotation.z = time * 0.4

      smallSphere.rotation.x = time * 0.8
      smallSphere.rotation.y = time * 0.6

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
    sphereDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    sphereDiv
}
