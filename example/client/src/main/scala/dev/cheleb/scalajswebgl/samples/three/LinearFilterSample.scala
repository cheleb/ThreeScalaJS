package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*
import THREE.constants.TextureConstants.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8ClampedArray
import scala.math

object LinearFilterSample {

  def apply() =

    val linearFilterDiv = div(
      h1("LinearFilter vs NearestFilter Demo"),
      p(
        "Demonstrating the difference between LinearFilter (smooth interpolation) and NearestFilter (pixelated) texture filtering."
      ),
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

    // Create a simple checkerboard texture data
    val size      = 256
    val dataArray = new Uint8ClampedArray(size * size * 4)

    for (y <- 0 until size) {
      for (x <- 0 until size) {
        val index   = (y * size + x) * 4
        val isWhite = (x / 32 + y / 32) % 2 == 0
        val color   = if (isWhite) 255 else 0

        dataArray(index) = color     // R
        dataArray(index + 1) = color // G
        dataArray(index + 2) = color // B
        dataArray(index + 3) = 255   // A
      }
    }

    // Create texture with LinearFilter
    val linearTexture = DataTexture(
      data = dataArray,
      width = size,
      height = size
    )
    linearTexture.magFilter = LinearFilter
    linearTexture.minFilter = LinearFilter

    // Create texture with NearestFilter
    val nearestTexture = DataTexture(
      data = dataArray,
      width = size,
      height = size
    )
    nearestTexture.magFilter = NearestFilter
    nearestTexture.minFilter = NearestFilter

    // Create materials
    val linearMaterial  = MeshBasicMaterial(linearTexture, false)
    val nearestMaterial = MeshBasicMaterial(nearestTexture, false)

    // Create planes
    val linearPlaneGeometry  = PlaneGeometry(3, 3)
    val nearestPlaneGeometry = PlaneGeometry(3, 3)

    val linearPlane  = new Mesh(linearPlaneGeometry, linearMaterial)
    val nearestPlane = new Mesh(nearestPlaneGeometry, nearestMaterial)

    // Position planes
    linearPlane.position.x = -2
    nearestPlane.position.x = 2

    // Add planes to scene
    scene.add(linearPlane)
    scene.add(nearestPlane)

    // Add labels (using simple colored planes for demo)

    // For demo purposes, we'll use simple colored labels
    val labelGeometry = PlaneGeometry(2, 0.5)
    val labelMaterial = MeshBasicMaterial(color = 0xffffff)

    val linearLabel = new Mesh(labelGeometry, labelMaterial)
    linearLabel.position.x = -2
    linearLabel.position.y = -2.5
    scene.add(linearLabel)

    val nearestLabel = new Mesh(labelGeometry, labelMaterial)
    nearestLabel.position.x = 2
    nearestLabel.position.y = -2.5
    scene.add(nearestLabel)

    // Add lighting
    val ambientLight = AmbientLight(0xffffff, 0.8)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate planes slowly
      linearPlane.rotation.z = time * 0.1
      nearestPlane.rotation.z = time * 0.1

      // Move camera slightly for better viewing
      camera.position.x = math.sin(time * 0.2) * 2

      camera.lookAt(0, 0, 0)
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
    linearFilterDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    linearFilterDiv
}
