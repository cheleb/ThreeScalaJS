package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.annotation.nowarn

object PostProcessingSample {

  def apply() =

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 2, 5)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create animated objects
    val cubeGeometry = new BoxGeometry(1, 1, 1)
    val cubeMaterial = MeshPhongMaterial(
      color = 0x44aa88,
      shininess = 100
    )
    val cube = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(-2, 0, 0)
    scene.add(cube)

    val sphereGeometry = new SphereGeometry(0.5, 32, 16)
    val sphereMaterial = MeshPhongMaterial(
      color = 0x8844aa,
      shininess = 50
    )
    val sphere = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(2, 0, 0)
    scene.add(sphere)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Create post-processing composer
    val composer = EffectComposer(renderer)

    // Create render pass
    val renderPass = RenderPass(scene, camera)
    composer.addPass(renderPass)

    // Create effect passes
    val bloomPass       = BloomPass(1.5, 25, 4, 256)
    val unrealBloomPass =
      UnrealBloomPass(new Vector2(window.innerWidth * 0.8, window.innerHeight * 0.8), 1.5, 0.4, 0.85)
    val filmPass      = FilmPass(0.25, 0.5, 512, false)
    val dotScreenPass = DotScreenPass(new Vector2(0.5, 0.5), 1.57, 3.0)

    @nowarn
    var currentEffect: String = "none"

    def switchEffect(effect: String): Unit = {
      // Reset composer to only have render pass
      composer.reset()

      effect match {
        case "bloom" =>
          composer.addPass(renderPass)
          composer.addPass(bloomPass)
          currentEffect = "bloom"
        case "unrealBloom" =>
          composer.addPass(renderPass)
          composer.addPass(unrealBloomPass)
          currentEffect = "unrealBloom"
        case "film" =>
          composer.addPass(renderPass)
          composer.addPass(filmPass)
          currentEffect = "film"
        case "dotScreen" =>
          composer.addPass(renderPass)
          composer.addPass(dotScreenPass)
          currentEffect = "dotScreen"
        case _ =>
          composer.addPass(renderPass)
          currentEffect = "none"
      }
    }

    // Initialize with no effects
    switchEffect("none")

    val postProcessingDiv = div(
      h1("Post-Processing Effects Demo"),
      p("Demonstrating Three.js post-processing effects including bloom, film grain, and dot screen effects."),
      div(
        cls := "canvas-container"
      ),
      // Controls for switching effects
      div(
        cls := "controls",
        button(
          "Bloom Effect",
          onClick --> { _ =>
            switchEffect("bloom")
          }
        ),
        button(
          "Unreal Bloom Effect",
          onClick --> { _ =>
            switchEffect("unrealBloom")
          }
        ),
        button(
          "Film Grain Effect",
          onClick --> { _ =>
            switchEffect("film")
          }
        ),
        button(
          "Dot Screen Effect",
          onClick --> { _ =>
            switchEffect("dotScreen")
          }
        ),
        button(
          "No Effects",
          onClick --> { _ =>
            switchEffect("none")
          }
        )
      )
    )

    // Animation variables
    var animationTime = 0.0

    // Animation loop
    val animate: () => Unit = () => {
      animationTime += 0.016 // Approximate 60 FPS

      // Animate cube position and rotation
      cube.position.x = -2 + scala.math.sin(animationTime) * 2
      cube.position.y = scala.math.sin(animationTime * 2) * 0.5
      cube.rotation.y = animationTime * 0.5

      // Animate sphere position and scale
      sphere.position.x = 2 + scala.math.cos(animationTime * 1.5) * 1.5
      sphere.position.y = scala.math.sin(animationTime * 3) * 1
      sphere.rotation.x = animationTime * 0.7

      // Pulsing scale effect
      val scale = 1 + scala.math.sin(animationTime * 4) * 0.3
      sphere.scale.set(scale, scale, scale)

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
    postProcessingDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    postProcessingDiv
}
