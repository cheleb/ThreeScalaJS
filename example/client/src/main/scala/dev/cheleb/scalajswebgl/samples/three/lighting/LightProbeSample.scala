package dev.cheleb.scalajswebgl.samples.three.lighting

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object LightProbeSample:

  def apply() =

    val lightProbeDiv = div(
      h1("LightProbe Demo"),
      p(
        "Demonstrating LightProbe - image-based lighting that captures environmental lighting information for realistic illumination."
      ),
      div(cls := "canvas-container")
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 2, 5)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0f0f23", 1)
    renderer.toneMapping = 2 // Reinhard tone mapping
    renderer.toneMappingExposure = 1.0

    // Create objects to be illuminated
    val sphereGeometry = SphereGeometry(1, 64, 64)
    val cubeGeometry   = BoxGeometry(1.5, 1.5, 1.5)
    val torusGeometry  = TorusGeometry(0.8, 0.3, 32, 64)

    // Create materials that work well with light probes
    val sphere1 = Mesh(sphereGeometry, MeshStandardMaterial(color = 0xff4444, metalness = 0.7, roughness = 0.3))
    sphere1.position.set(-3, 0, 0)
    scene.add(sphere1)

    val sphere2 = Mesh(sphereGeometry, MeshStandardMaterial(color = 0x44ff44, metalness = 0.1, roughness = 0.8))
    sphere2.position.set(3, 0, 0)
    scene.add(sphere2)

    val cube1 = Mesh(cubeGeometry, MeshStandardMaterial(color = 0x4444ff, metalness = 0.5, roughness = 0.5))
    cube1.position.set(0, -2, -1)
    scene.add(cube1)

    val torus1 = Mesh(torusGeometry, MeshStandardMaterial(color = 0xffaa00, metalness = 0.9, roughness = 0.1))
    torus1.position.set(0, 2, 1)
    scene.add(torus1)

    // Create a simple light probe with basic spherical harmonics
    // In a real application, this would be generated from an environment map
    val lightProbe = LightProbe()

    // Initialize spherical harmonics coefficients properly
    // Three.js expects sh.coefficients to be a Float32Array with 9 * 3 = 27 elements
    val coefficients = new js.typedarray.Float32Array(27)

    // Set basic ambient lighting (L0 coefficients)
    coefficients(0) = 0.5f // L0 r
    coefficients(1) = 0.5f // L0 g
    coefficients(2) = 0.5f // L0 b

    // Set minimal directional lighting for some variation
    coefficients(3) = 0.1f // L1-1 r
    coefficients(4) = 0.1f // L1-1 g
    coefficients(5) = 0.1f // L1-1 b

    // Initialize the rest to near zero for a subtle effect
    for (i <- 6 until 27) {
      coefficients(i) = 0.02f
    }

    // Create the sh object with coefficients property
    val shObject = js.Dynamic
      .literal(
        "coefficients" -> coefficients
      )
      .asInstanceOf[js.Object]

    lightProbe.sh = shObject
    lightProbe.intensity = 1.0

    scene.add(lightProbe)

    // Add a subtle directional light for some additional illumination
    val directionalLight = DirectionalLight(0xffffff, 0.5)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate objects
      sphere1.rotation.x = time * 0.3
      sphere1.rotation.y = time * 0.5

      sphere2.rotation.x = -time * 0.2
      sphere2.rotation.y = -time * 0.4

      cube1.rotation.z = time * 0.3

      torus1.rotation.x = time * 0.4
      torus1.rotation.y = time * 0.6

      // Animate camera for better visualization
      camera.position.x = scala.math.cos(time * 0.2) * 8
      camera.position.z = scala.math.sin(time * 0.2) * 8
      camera.lookAt(0, 0, 0)

      // Slightly vary light probe intensity for dynamic effect
      lightProbe.intensity = 1.0 + scala.math.sin(time * 2) * 0.2

      renderer.render(scene, camera)
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = _ => {
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    }
    window.addEventListener("resize", onWindowResize)

    // Append renderer to container
    val container = lightProbeDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    lightProbeDiv
