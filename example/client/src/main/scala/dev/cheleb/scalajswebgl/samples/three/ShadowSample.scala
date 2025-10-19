package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.*

object ShadowSample {

  def apply() =

    val shadowDiv = div(
      h1("Shadow Mapping Demo"),
      p("Demonstrating shadow mapping with directional, spot, and point lights in Three.js."),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(10, 10, 10)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#87CEEB", 1) // Sky blue background
    renderer.shadowMap.asInstanceOf[js.Dynamic].enabled = true
    renderer.shadowMap.asInstanceOf[js.Dynamic].`type` = 2 // PCFSoftShadowMap

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

      // Enable shadows for objects
      mesh.castShadow = true
      mesh.receiveShadow = true

      scene.add(mesh)
    }

    // Create ground plane
    val groundGeometry = PlaneGeometry(50, 50)
    val groundMaterial = MeshLambertMaterial(color = 0x90ee90)
    val ground         = new Mesh(groundGeometry, groundMaterial)
    ground.rotation.x = -Pi / 2
    ground.position.y = -3
    ground.receiveShadow = true
    scene.add(ground)

    // Create shadow-receiving plane
    val shadowPlaneGeometry = PlaneGeometry(20, 20)
    val shadowMaterial      = ShadowMaterial()
    shadowMaterial.opacity = 0.3
    val shadowPlane = new Mesh(shadowPlaneGeometry, shadowMaterial)
    shadowPlane.rotation.x = -Pi / 2
    shadowPlane.position.y = -2.9
    shadowPlane.receiveShadow = true
    scene.add(shadowPlane)

    // Add lighting with shadows

    // 1. Directional Light with shadows
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(10, 10, 5)

    // Configure shadow properties
    directionalLight.castShadow = true
    directionalLight.shadow.mapSize.asInstanceOf[js.Dynamic].width = 2048
    directionalLight.shadow.mapSize.asInstanceOf[js.Dynamic].height = 2048
    directionalLight.shadow.camera.asInstanceOf[OrthographicCamera].near = 0.5
    directionalLight.shadow.camera.asInstanceOf[OrthographicCamera].far = 50
    directionalLight.shadow.camera.asInstanceOf[OrthographicCamera].left = -20
    directionalLight.shadow.camera.asInstanceOf[OrthographicCamera].right = 20
    directionalLight.shadow.camera.asInstanceOf[OrthographicCamera].top = 20
    directionalLight.shadow.camera.asInstanceOf[OrthographicCamera].bottom = -20
    directionalLight.shadow.bias = -0.0001

    scene.add(directionalLight)

    // 2. Spot Light with shadows
    val spotLight = SpotLight(0xffffff, 1, 0, Pi / 6, 0.1, 2)
    spotLight.position.set(-10, 15, 5)
    spotLight.target.position.set(0, 0, 0)

    // Configure shadow properties
    spotLight.castShadow = true
    spotLight.shadow.mapSize.asInstanceOf[js.Dynamic].width = 1024
    spotLight.shadow.mapSize.asInstanceOf[js.Dynamic].height = 1024
    spotLight.shadow.camera.asInstanceOf[PerspectiveCamera].near = 0.5
    spotLight.shadow.camera.asInstanceOf[PerspectiveCamera].far = 50
    spotLight.shadow.camera.asInstanceOf[PerspectiveCamera].fov = 30
    spotLight.shadow.bias = -0.0001

    scene.add(spotLight)
    scene.add(spotLight.target)

    // 3. Point Light with shadows
    val pointLight = PointLight(0xffffff, 1, 0, 2)
    pointLight.position.set(0, 10, 0)

    // Configure shadow properties
    pointLight.castShadow = true
    pointLight.shadow.mapSize.asInstanceOf[js.Dynamic].width = 1024
    pointLight.shadow.mapSize.asInstanceOf[js.Dynamic].height = 1024
    pointLight.shadow.camera.asInstanceOf[PerspectiveCamera].near = 0.5
    pointLight.shadow.camera.asInstanceOf[PerspectiveCamera].far = 25
    pointLight.shadow.bias = -0.0001

    scene.add(pointLight)

    // Add ambient light for better visibility
    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects
      scene.children.foreach { child =>
        if (child.isInstanceOf[Mesh] && child.castShadow) {
          val mesh = child.asInstanceOf[Mesh]
          mesh.rotation.y = time * 0.5
        }
      }

      // Animate lights
      directionalLight.position.x = cos(time * 0.3) * 10
      directionalLight.position.z = sin(time * 0.3) * 10

      spotLight.position.x = cos(time * 0.5) * 8
      spotLight.position.z = sin(time * 0.5) * 8

      pointLight.position.x = cos(time * 0.7) * 6
      pointLight.position.y = 8 + sin(time * 0.4) * 4

      // Update camera to show shadows better
      camera.position.x = cos(time * 0.2) * 15
      camera.position.z = sin(time * 0.2) * 15
      camera.position.y = 10 + sin(time * 0.3) * 5
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
    shadowDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    // Add shadow control UI
    val controlsDiv = div(
      cls := "shadow-controls",
      h3("Shadow Controls"),
      p("Current shadow configuration:"),
      ul(
        li("Directional Light: Enabled, Map Size 2048x2048"),
        li("Spot Light: Enabled, Map Size 1024x1024"),
        li("Point Light: Enabled, Map Size 1024x1024"),
        li("Shadow Type: PCF Soft Shadows"),
        li("Shadow Bias: -0.0001")
      ),
      p("Watch how different lights cast different shadow patterns!")
    )

    shadowDiv.amend(controlsDiv)
}
