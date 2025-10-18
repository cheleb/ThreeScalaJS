package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object OutputPassSample {

  def apply() =

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 5, 10)

    // Create renderer with different tone mapping modes
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create a complex scene with various materials and lighting
    val geometries = List(
      BoxGeometry(2, 2, 2),
      SphereGeometry(1.5, 32, 32),
      ConeGeometry(1.5, 3, 16),
      CylinderGeometry(1.5, 1.5, 3, 16),
      TorusGeometry(1.5, 0.5, 16, 100)
    )

    geometries.zipWithIndex.foreach { case (geometry, i) =>
      val material = MeshStandardMaterial(
        color = 0x666666 + i * 0x111111,
        metalness = 0.5,
        roughness = 0.3
      )
      val mesh = new Mesh(geometry, material)

      val angle  = (i.toDouble / geometries.length) * scala.math.Pi * 2
      val radius = 6
      mesh.position.set(
        scala.math.cos(angle) * radius,
        scala.math.sin(i) * 2,
        scala.math.sin(angle) * radius
      )
      scene.add(mesh)
    }

    // Add floor
    val floorGeometry = PlaneGeometry(20, 20)
    val floorMaterial = MeshStandardMaterial(color = 0x888888, metalness = 0.1, roughness = 0.8)
    val floor         = new Mesh(floorGeometry, floorMaterial)
    floor.rotation.x = -scala.math.Pi / 2
    floor.position.y = -3
    scene.add(floor)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 2)
    directionalLight.position.set(5, 10, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Create additional point lights for better lighting
    val pointLight1 = PointLight(0xffffff, 1, 20)
    pointLight1.position.set(-5, 8, 5)
    scene.add(pointLight1)

    val pointLight2 = PointLight(0xffffff, 0.5, 20)
    pointLight2.position.set(5, 8, -5)
    scene.add(pointLight2)

    // Create post-processing composer
    val composer = EffectComposer(renderer)

    // Create render pass
    val renderPass = RenderPass(scene, camera)
    composer.addPass(renderPass)

    // Create OutputPass for tone mapping and color space conversion
    val outputPass = OutputPass()

    var currentToneMapping: Int = 0
    val toneMappingOptions      = List(
      ("No Tone Mapping", 0),
      ("Linear", 1),
      ("Reinhard", 2),
      ("Cineon", 3),
      ("ACES Filmic", 4),
      ("AgX", 5),
      ("Neutral", 6)
    )

    def switchToneMapping(toneMapping: Int): Unit = {
      currentToneMapping = toneMapping
      renderer.toneMapping = toneMapping
      // Force material update by triggering uniformsNeedUpdate
      outputPass.material.uniformsNeedUpdate = true
    }

    // Initialize with default tone mapping
    switchToneMapping(0)

    val outputPassDiv = div(
      h1("OutputPass - Tone Mapping and Color Space Conversion"),
      p(
        "Demonstrating Three.js OutputPass for tone mapping and color space conversion. " +
          "The OutputPass should typically be the last pass in your post-processing chain " +
          "to apply tone mapping and convert to the correct color space."
      ),
      div(
        cls := "canvas-container"
      ),
      // Controls for tone mapping
      div(
        cls := "controls",
        div(
          cls := "tone-mapping-controls",
          h3("Tone Mapping Modes:"),
          toneMappingOptions.map { case (name, value) =>
            button(
              name,
              cls := "tone-mapping-button",
              cls("active") <-- Val(currentToneMapping == value),
              onClick --> { _ =>
                switchToneMapping(value)
              }
            )
          }
        ),
        div(
          cls := "slider-container",
          label("Exposure: ", renderer.toneMappingExposure.toString),
          input(
            `type`   := "range",
            minAttr  := "0.1",
            maxAttr  := "3.0",
            stepAttr := "0.1",
            value    := renderer.toneMappingExposure.toString,
            onInput --> { evt =>
              val exposure = evt.target.asInstanceOf[dom.HTMLInputElement].value.toDouble
              renderer.toneMappingExposure = exposure
            }
          )
        )
      )
    )

    // Animation variables
    var animationTime = 0.0

    // Animation loop
    val animate: () => Unit = () => {
      animationTime += 0.016 // Approximate 60 FPS

      // Animate camera for better demonstration
      camera.position.x = scala.math.sin(animationTime * 0.3) * 8
      camera.position.z = scala.math.cos(animationTime * 0.3) * 8 + 2
      camera.lookAt(0, 0, 0)

      // Animate point lights for dynamic lighting
      pointLight1.position.x = scala.math.sin(animationTime) * 6
      pointLight1.position.z = scala.math.cos(animationTime) * 6

      pointLight2.position.x = scala.math.cos(animationTime * 0.7) * 6
      pointLight2.position.z = scala.math.sin(animationTime * 0.7) * 6

      // Render with post-processing
      composer.render()
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = { _ =>
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
      composer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    }
    window.addEventListener("resize", onWindowResize)

    // Append renderer to the canvas container
    outputPassDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    outputPassDiv
}
