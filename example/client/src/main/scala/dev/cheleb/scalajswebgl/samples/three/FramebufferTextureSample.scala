package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.sin
import scala.math.cos

object FramebufferTextureSample {

  def apply() =

    val framebufferTextureDiv = div(
      h1("FramebufferTexture Demo"),
      p("Demonstrating FramebufferTexture creation and framebuffer content extraction using copyFramebufferToTexture."),
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

    // Create FramebufferTexture
    val pixelRatio  = window.devicePixelRatio
    val textureSize = 256 * pixelRatio

    val framebufferTexture = new FramebufferTexture(textureSize, textureSize)

    // Create a secondary scene for the framebuffer texture display
    val displayScene = Scene()
    // val displayCamera = new OrthographicCamera(-1, 1, 1, -1, 0, 1)

    // Create a plane to display the framebuffer texture
    val displayGeometry = new PlaneGeometry(2, 2)
    val displayMaterial = MeshBasicMaterial(map = framebufferTexture)
    val displayMesh     = new Mesh(displayGeometry, displayMaterial)
    displayScene.add(displayMesh)

    // Create objects in the main scene

    // 1. Main rotating cube
    val cubeGeometry = new BoxGeometry(2, 2, 2)
    val cubeMaterial = MeshPhongMaterial(
      color = 0x4488ff,
      shininess = 100,
      specular = 0x111111
    )
    val cube = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.z = 0
    scene.add(cube)

    // 2. Smaller cubes at different positions
    val smallCubeGeometry = new BoxGeometry(0.8, 0.8, 0.8)

    val smallCube1 = new Mesh(smallCubeGeometry, MeshPhongMaterial(color = 0xff4444, shininess = 50))
    smallCube1.position.set(-3, 1, -1)
    scene.add(smallCube1)

    val smallCube2 = new Mesh(smallCubeGeometry, MeshPhongMaterial(color = 0x44ff44, shininess = 50))
    smallCube2.position.set(3, -1, -2)
    scene.add(smallCube2)

    val smallCube3 = new Mesh(smallCubeGeometry, MeshPhongMaterial(color = 0xffff44, shininess = 50))
    smallCube3.position.set(0, 3, 1)
    scene.add(smallCube3)

    // 3. Background torus at different depth
    val torusGeometry = new TorusGeometry(3, 1, 16, 100)
    val torusMaterial = MeshPhongMaterial(
      color = 0x8844ff,
      shininess = 30
    )
    val torus = new Mesh(torusGeometry, torusMaterial)
    torus.position.z = -6
    scene.add(torus)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate main cube
      cube.rotation.x = time * 0.3
      cube.rotation.y = time * 0.5

      // Animate small cubes with different movements
      smallCube1.position.x = -3 + sin(time) * 1.5
      smallCube1.position.z = -1 + cos(time * 0.8) * 1
      smallCube1.rotation.z = time * 0.7

      smallCube2.position.y = -1 + cos(time * 1.3) * 1
      smallCube2.position.z = -2 + sin(time * 0.9) * 0.8
      smallCube2.rotation.x = time * 0.5

      smallCube3.position.x = sin(time * 0.8) * 2
      smallCube3.position.y = 3 + cos(time * 1.1) * 0.8
      smallCube3.position.z = 1 + sin(time * 0.7) * 0.5
      smallCube3.rotation.y = time * 0.6

      // Rotate torus slowly
      torus.rotation.x = time * 0.1
      torus.rotation.y = time * 0.15

      // Render main scene
      renderer.render(scene, camera)

      // Copy framebuffer to texture (capture the rendered frame)
      val vector = new Vector2()
      vector.x = (window.innerWidth * pixelRatio / 2) - (textureSize / 2)
      vector.y = (window.innerHeight * pixelRatio / 2) - (textureSize / 2)

      renderer.copyFramebufferToTexture(framebufferTexture, vector)
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
    framebufferTextureDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    framebufferTextureDiv
}
