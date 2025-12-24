package dev.cheleb.scalajswebgl.samples.three.geometries

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object TorusSample {

  def apply() =

    val torusDiv = div(
      h1("TorusGeometry Demo"),
      p("Demonstrating different torus (donut) configurations with various materials and transformations."),
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

    // Create different tori with various configurations

    // 1. Basic torus with wireframe material
    val basicTorusGeometry = new TorusGeometry(1.0, 0.4, 16, 8)
    val wireframeMaterial  = MeshBasicMaterial(
      color = 0x00ff88,
      wireframe = true
    )
    val basicTorus = new Mesh(basicTorusGeometry, wireframeMaterial)
    basicTorus.position.x = -4
    scene.add(basicTorus)

    // 2. Thin torus with phong material
    val thinTorusGeometry = new TorusGeometry(1.2, 0.2, 32, 16)
    val phongMaterial     = MeshPhongMaterial(
      color = 0x4488ff,
      shininess = 100,
      specular = 0x111111
    )
    val thinTorus = new Mesh(thinTorusGeometry, phongMaterial)
    thinTorus.position.x = -1
    scene.add(thinTorus)

    // 3. Thick torus
    val thickTorusGeometry = new TorusGeometry(0.8, 0.6, 32, 12)
    val thickMaterial      = MeshPhongMaterial(
      color = 0xff4444,
      shininess = 30
    )
    val thickTorus = new Mesh(thickTorusGeometry, thickMaterial)
    thickTorus.position.x = 2
    thickTorus.position.y = -1
    scene.add(thickTorus)

    // 4. Small torus with basic material
    val smallTorusGeometry = new TorusGeometry(0.5, 0.3, 8, 6)
    val smallMaterial      = MeshBasicMaterial(color = 0xffaa00)
    val smallTorus         = new Mesh(smallTorusGeometry, smallMaterial)
    smallTorus.position.x = 4
    smallTorus.position.y = 1
    scene.add(smallTorus)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate tori at different speeds
      basicTorus.rotation.x = time * 0.5
      basicTorus.rotation.y = time * 0.3

      thinTorus.rotation.x = time * 0.3
      thinTorus.rotation.y = time * 0.7

      thickTorus.rotation.z = time * 0.4

      smallTorus.rotation.x = time * 0.8
      smallTorus.rotation.y = time * 0.6

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
    torusDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    torusDiv
}
