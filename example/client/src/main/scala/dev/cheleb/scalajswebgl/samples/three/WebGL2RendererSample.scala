package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object WebGL2RendererSample {

  def apply() =

    val webgl2Div = div(
      h1("WebGL2Renderer Demo"),
      p("Demonstrating WebGL 2.0 features with advanced rendering capabilities."),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 8

    // Create WebGL2 renderer
    val renderer = WebGL2Renderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create a simple sphere to demonstrate
    val geometry = new SphereGeometry(1.0, 32, 16)
    val material = MeshStandardMaterial(
      color = 0x00ff88,
      roughness = 0.5,
      metalness = 0.5
    )
    val sphere = new Mesh(geometry, material)
    scene.add(sphere)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate sphere
      sphere.rotation.x = time * 0.5
      sphere.rotation.y = time * 0.3

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
    webgl2Div.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    webgl2Div
}
