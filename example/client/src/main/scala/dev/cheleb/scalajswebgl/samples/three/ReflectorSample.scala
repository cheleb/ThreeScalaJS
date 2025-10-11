package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object ReflectorSample:

  def apply() =

    val reflectorDiv = div(
      h1("Reflector Demo"),
      p(
        "Demonstrating reflective surfaces using the Reflector class. Move the camera around to see reflections."
      ),
      div(cls := "canvas-container")
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 5, 10)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0f0f23", 1)

    // Create ground reflector
    val groundGeometry = PlaneGeometry(20, 20)
    val reflector      = new Reflector(
      groundGeometry,
      js.Dynamic
        .literal(
          clipBias = 0.003,
          textureWidth = (window.innerWidth * window.devicePixelRatio * 0.5).toInt,
          textureHeight = (window.innerHeight * window.devicePixelRatio * 0.5).toInt,
          color = 0x889999,
          multisample = 4
        )
        .asInstanceOf[ReflectorOptions]
    )
    reflector.rotation.x = -scala.math.Pi / 2
    reflector.position.y = -2.5
    scene.add(reflector)

    // Create some objects to reflect
    val cubeGeometry = BoxGeometry(2, 2, 2)
    val cubeMaterial = MeshPhongMaterial(color = 0xff0000)
    val cube         = Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(-4, 1, 0)
    scene.add(cube)

    val sphereGeometry = SphereGeometry(1.5, 32, 32)
    val sphereMaterial = MeshPhongMaterial(color = 0x00ff00)
    val sphere         = Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(4, 1.5, 0)
    scene.add(sphere)

    val torusGeometry = TorusGeometry(1, 0.4, 16, 100)
    val torusMaterial = MeshPhongMaterial(color = 0x0000ff)
    val torus         = Mesh(torusGeometry, torusMaterial)
    torus.position.set(0, 1, 4)
    scene.add(torus)

    // Add lighting
    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    val directionalLight = DirectionalLight(0xffffff, 0.8)
    directionalLight.position.set(10, 10, 5)
    scene.add(directionalLight)

    // Add some additional point lights for better reflections
    val pointLight1 = PointLight(0xffffff, 0.5, 100)
    pointLight1.position.set(-5, 5, 5)
    scene.add(pointLight1)

    val pointLight2 = PointLight(0xffffff, 0.5, 100)
    pointLight2.position.set(5, 5, -5)
    scene.add(pointLight2)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate the objects
      cube.rotation.x = time * 0.5
      cube.rotation.y = time * 0.3
      cube.position.y = 1 + scala.math.sin(time * 2) * 0.5

      sphere.rotation.y = time * 0.7
      sphere.position.x = 4 * scala.math.cos(time * 0.8)

      torus.rotation.x = time * 0.4
      torus.rotation.z = time * 0.6
      torus.position.z = 4 * scala.math.sin(time * 0.6)

      // Animate the point lights
      pointLight1.position.x = -5 * scala.math.cos(time * 0.5)
      pointLight1.position.z = 5 * scala.math.sin(time * 0.5)

      pointLight2.position.x = 5 * scala.math.cos(time * 0.7)
      pointLight2.position.z = -5 * scala.math.sin(time * 0.7)

      renderer.render(scene, camera)
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = _ => {
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)

      // Note: Reflector texture size would need to be updated here for dynamic resizing
      // This requires proper typing of getRenderTarget() return value
    }
    window.addEventListener("resize", onWindowResize)

    // Add instructions
    val instructions = div(
      styleAttr := "position: absolute; top: 10px; right: 10px; color: white; font-family: monospace;",
      p("Use mouse to orbit camera around"),
      p("Watch the objects reflect in the ground mirror"),
      p("Red cube, green sphere, and blue torus are being reflected"),
      p("Point lights are also moving to create dynamic reflections")
    )

    // Append renderer to container
    val container = reflectorDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)
    container.appendChild(instructions.ref)

    reflectorDiv
