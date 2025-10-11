package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.Pi

object MeshLambertMaterialSample {

  def apply() =

    val lambertDiv = div(
      h1("MeshLambertMaterial Demo"),
      p(
        "Demonstrating MeshLambertMaterial - a material for non-shiny surfaces with diffuse lighting. Perfect for matte surfaces without specular highlights."
      ),
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

    // Create different geometries with MeshLambertMaterial

    // 1. Sphere with basic lambert material
    val sphereGeometry = new SphereGeometry(1.5, 32, 16)
    val sphereMaterial = MeshLambertMaterial(
      color = 0x4488ff,
      emissive = 0x001122,
      emissiveIntensity = 0.2
    )
    val sphere = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.x = -4
    scene.add(sphere)

    // 2. Cube with lambert material
    val cubeGeometry = new BoxGeometry(2, 2, 2)
    val cubeMaterial = MeshLambertMaterial(
      color = 0xff4444,
      emissive = 0x220000,
      emissiveIntensity = 0.1
    )
    val cube = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.x = 0
    scene.add(cube)

    // 3. Torus with lambert material
    val torusGeometry = new TorusGeometry(1, 0.4, 16, 100)
    val torusMaterial = MeshLambertMaterial(
      color = 0x44ff44,
      emissive = 0x002200,
      emissiveIntensity = 0.3
    )
    val torus = new Mesh(torusGeometry, torusMaterial)
    torus.position.x = 4
    scene.add(torus)

    // 4. Plane with lambert material (showing flat shading)
    val planeGeometry = new PlaneGeometry(4, 4, 10, 10)
    val planeMaterial = MeshLambertMaterial(
      color = 0xffaa00,
      emissive = 0x222200,
      emissiveIntensity = 0.1
    )
    val plane = new Mesh(planeGeometry, planeMaterial)
    plane.position.y = -3
    plane.rotation.x = -Pi / 2
    scene.add(plane)

    // Add lighting to showcase lambert material properties
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val directionalLight2 = DirectionalLight(0xffffff, 0.5)
    directionalLight2.position.set(-5, 3, 2)
    scene.add(directionalLight2)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects at different speeds
      sphere.rotation.x = time * 0.3
      sphere.rotation.y = time * 0.5

      cube.rotation.x = time * 0.4
      cube.rotation.y = time * 0.2

      torus.rotation.x = time * 0.6
      torus.rotation.z = time * 0.3

      // Simple plane rotation
      plane.rotation.z = time * 0.1

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
    lambertDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    lambertDiv
}
