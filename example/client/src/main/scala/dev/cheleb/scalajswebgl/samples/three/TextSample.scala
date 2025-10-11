package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import scala.math._

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object TextSample {

  def apply() =

    val textDiv = div(
      h1("TextGeometry Demo"),
      p("Demonstrating 3D text rendering with extruded fonts. Note: Requires font files to be available."),
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

    // For now, create alternative geometries that demonstrate text-like concepts
    // In a real implementation, you would load a font file and use TextGeometry

    // 1. Create letter-like shapes using basic geometries
    val letterHGeometry = new BoxGeometry(0.2, 2, 0.2)
    val letterHMaterial = MeshPhongMaterial(
      color = 0x00ff88,
      shininess = 100
    )
    val letterH1 = new Mesh(letterHGeometry, letterHMaterial)
    letterH1.position.set(-3, 0, 0)
    scene.add(letterH1)

    val letterH2     = new BoxGeometry(0.2, 2, 0.2)
    val letterH2Mesh = new Mesh(letterH2, letterHMaterial)
    letterH2Mesh.position.set(-2.6, 0, 0)
    scene.add(letterH2Mesh)

    val letterHCrossbar     = new BoxGeometry(0.8, 0.2, 0.2)
    val letterHCrossbarMesh = new Mesh(letterHCrossbar, letterHMaterial)
    letterHCrossbarMesh.position.set(-2.8, 0.8, 0)
    scene.add(letterHCrossbarMesh)

    // 2. Create letter "E" using multiple boxes
    val letterE1     = new BoxGeometry(0.2, 2, 0.2)
    val letterE1Mesh = new Mesh(letterE1, MeshPhongMaterial(color = 0xff4444, shininess = 80))
    letterE1Mesh.position.set(-1, 0, 0)
    scene.add(letterE1Mesh)

    val letterETop     = new BoxGeometry(1, 0.2, 0.2)
    val letterETopMesh = new Mesh(letterETop, MeshPhongMaterial(color = 0xff4444, shininess = 80))
    letterETopMesh.position.set(-0.6, 1.4, 0)
    scene.add(letterETopMesh)

    val letterEMiddle     = new BoxGeometry(0.8, 0.2, 0.2)
    val letterEMiddleMesh = new Mesh(letterEMiddle, MeshPhongMaterial(color = 0xff4444, shininess = 80))
    letterEMiddleMesh.position.set(-0.7, 0.8, 0)
    scene.add(letterEMiddleMesh)

    val letterEBottom     = new BoxGeometry(1, 0.2, 0.2)
    val letterEBottomMesh = new Mesh(letterEBottom, MeshPhongMaterial(color = 0xff4444, shininess = 80))
    letterEBottomMesh.position.set(-0.6, -1.4, 0)
    scene.add(letterEBottomMesh)

    // 3. Create letter "L" shape
    val letterL1     = new BoxGeometry(0.2, 2, 0.2)
    val letterL1Mesh = new Mesh(letterL1, MeshPhongMaterial(color = 0x4488ff, shininess = 60))
    letterL1Mesh.position.set(1, 0, 0)
    scene.add(letterL1Mesh)

    val letterLBottom     = new BoxGeometry(1, 0.2, 0.2)
    val letterLBottomMesh = new Mesh(letterLBottom, MeshPhongMaterial(color = 0x4488ff, shininess = 60))
    letterLBottomMesh.position.set(0.6, -1.4, 0)
    scene.add(letterLBottomMesh)

    // 4. Create letter "O" using torus
    val letterO     = new TorusGeometry(0.8, 0.2, 8, 16)
    val letterOMesh = new Mesh(letterO, MeshPhongMaterial(color = 0xffaa00, shininess = 90))
    letterOMesh.position.set(3, 0, 0)
    scene.add(letterOMesh)

    // Add informational text about TextGeometry
    val infoText     = new TorusGeometry(0.3, 0.1, 6, 8)
    val infoMaterial = MeshBasicMaterial(color = 0x888888)
    val infoMesh     = new Mesh(infoText, infoMaterial)
    infoMesh.position.set(0, -3, 0)
    infoMesh.rotation.x = Pi / 2
    scene.add(infoMesh)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate letters at different speeds
      letterH1.rotation.y = time * 0.3
      letterH2Mesh.rotation.y = time * 0.3
      letterHCrossbarMesh.rotation.y = time * 0.3

      letterE1Mesh.rotation.y = time * 0.4
      letterETopMesh.rotation.y = time * 0.4
      letterEMiddleMesh.rotation.y = time * 0.4
      letterEBottomMesh.rotation.y = time * 0.4

      letterL1Mesh.rotation.y = time * 0.5
      letterLBottomMesh.rotation.y = time * 0.5

      letterOMesh.rotation.y = time * 0.2

      infoMesh.rotation.z = time * 0.1

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
    textDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    textDiv
}
