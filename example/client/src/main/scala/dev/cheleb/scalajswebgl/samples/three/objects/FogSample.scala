package dev.cheleb.scalajswebgl.samples.three.objects

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math._

object FogSample {

  def apply() =

    val fogDiv = div(
      h1("Fog Effects Demo"),
      p("Demonstrating linear fog (Fog) and exponential fog (FogExp2) effects in Three.js."),
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
    renderer.setClearColor("#87CEEB", 1) // Sky blue background

    // Create geometries for demonstration
    val geometries = List(
      new SphereGeometry(1.0, 16, 12),
      new BoxGeometry(1.5, 1.5, 1.5),
      new ConeGeometry(1.0, 2.0, 8),
      new CylinderGeometry(0.8, 0.8, 2.0, 12),
      new TorusGeometry(0.8, 0.3, 8, 16)
    )

    val colors = List(0xff6b6b, 0x4ecdc4, 0x45b7d1, 0xf9ca24, 0x6c5ce7)

    // Create materials
    val materials = colors.map(color => MeshLambertMaterial(color = color))

    // Create objects and position them
    geometries.zip(materials).zipWithIndex.foreach { case ((geometry, material), index) =>
      val mesh   = new Mesh(geometry, material)
      val angle  = (index.toDouble / geometries.length) * Pi * 2
      val radius = 6.0
      mesh.position.x = cos(angle) * radius
      mesh.position.z = sin(angle) * radius
      mesh.position.y = sin(angle * 2) * 2
      scene.add(mesh)
    }

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Create ground plane
    val groundGeometry = PlaneGeometry(50, 50)
    val groundMaterial = MeshLambertMaterial(color = 0x90ee90)
    val ground         = new Mesh(groundGeometry, groundMaterial)
    ground.rotation.x = -Pi / 2
    ground.position.y = -3
    scene.add(ground)

    // Add fog effects
    val linearFog = Fog(color = 0xaaaaaa, near = 5, far = 16)
    scene.fog = linearFog

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects
      scene.children.foreach { child =>
        if (child.isInstanceOf[Mesh]) {
          val mesh = child.asInstanceOf[Mesh]
          mesh.rotation.y = time * 0.5
        }
      }

      // Animate camera to show fog effect better
      camera.position.x = sin(time * 0.2) * 3
      camera.position.z = 8 + cos(time * 0.3) * 2
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
    fogDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    // Add fog control UI (simplified for demo)
    val controlsDiv = div(
      cls := "fog-controls",
      h3("Fog Controls"),
      p(s"Current fog: Linear Fog (color: #87CEEB, near: 15, far: 35)"),
      p("Try switching between linear and exponential fog by modifying the scene.fog property!")
    )

    fogDiv.amend(controlsDiv)
}
