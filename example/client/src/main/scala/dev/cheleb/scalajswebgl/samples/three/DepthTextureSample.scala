package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.sin
import scala.math.cos

object DepthTextureSample {

  def apply() =

    val depthTextureDiv = div(
      h1("DepthTexture Demo"),
      p("Demonstrating DepthTexture creation and basic depth-based rendering concepts."),
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

    // Create DepthTexture
    val depthTexture = new DepthTexture(
      width = 512,
      height = 512,
      tpe = UnsignedIntType,
      format = DepthFormat,
      depth = DepthStencilFormat
    )
    depthTexture.compareFunction = LessCompare.toString().toInt

    // Create objects in the scene

    // 1. Main sphere with depth material to show depth variations
    val mainSphereGeometry = new SphereGeometry(2.0, 32, 32)
    val mainSphereMaterial = MeshPhongMaterial(
      color = 0x4488ff,
      shininess = 100,
      specular = 0x111111
    )
    val mainSphere = new Mesh(mainSphereGeometry, mainSphereMaterial)
    mainSphere.position.z = 0
    scene.add(mainSphere)

    // 2. Smaller spheres at different depths
    val smallSphereGeometry = new SphereGeometry(0.5, 16, 16)

    val smallSphere1 = new Mesh(smallSphereGeometry, MeshPhongMaterial(color = 0xff4444, shininess = 50))
    smallSphere1.position.set(-3, 1, -1)
    scene.add(smallSphere1)

    val smallSphere2 = new Mesh(smallSphereGeometry, MeshPhongMaterial(color = 0x44ff44, shininess = 50))
    smallSphere2.position.set(3, -1, -2)
    scene.add(smallSphere2)

    val smallSphere3 = new Mesh(smallSphereGeometry, MeshPhongMaterial(color = 0xffff44, shininess = 50))
    smallSphere3.position.set(0, 3, 1)
    scene.add(smallSphere3)

    // 3. Background plane at different depth
    val planeGeometry = new PlaneGeometry(15, 15)
    val planeMaterial = MeshPhongMaterial(
      color = 0x222222,
      shininess = 10
    )
    val plane = new Mesh(planeGeometry, planeMaterial)
    plane.position.z = -8
    scene.add(plane)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate main sphere
      mainSphere.rotation.x = time * 0.3
      mainSphere.rotation.y = time * 0.5

      // Animate small spheres with different depth movements
      smallSphere1.position.x = -3 + sin(time) * 1.5
      smallSphere1.position.z = -1 + cos(time * 0.8) * 1
      smallSphere1.rotation.z = time * 0.7

      smallSphere2.position.y = -1 + cos(time * 1.3) * 1
      smallSphere2.position.z = -2 + sin(time * 0.9) * 0.8
      smallSphere2.rotation.x = time * 0.5

      smallSphere3.position.x = sin(time * 0.8) * 2
      smallSphere3.position.y = 3 + cos(time * 1.1) * 0.8
      smallSphere3.position.z = 1 + sin(time * 0.7) * 0.5
      smallSphere3.rotation.y = time * 0.6

      // Render scene
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
    depthTextureDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    depthTextureDiv
}
