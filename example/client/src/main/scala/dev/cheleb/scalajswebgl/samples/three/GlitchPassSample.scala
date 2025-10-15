package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object GlitchPassSample {

  def apply() =

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 2, 5)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0a0a0a", 1)

    // Create animated objects
    val cubeGeometry = new BoxGeometry(1.5, 1.5, 1.5)
    val cubeMaterial = MeshPhongMaterial(
      color = 0xff6b6b,
      shininess = 100
    )
    val cube = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(-2, 0, 0)
    scene.add(cube)

    val torusGeometry = new TorusGeometry(0.8, 0.3, 16, 100)
    val torusMaterial = MeshPhongMaterial(
      color = 0x4ecdc4,
      shininess = 80
    )
    val torus = new Mesh(torusGeometry, torusMaterial)
    torus.position.set(2, 0, 0)
    scene.add(torus)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Create post-processing composer
    val composer = EffectComposer(renderer)

    // Create render pass
    val renderPass = RenderPass(scene, camera)
    composer.addPass(renderPass)

    // Create GlitchPass
    val glitchPass = GlitchPass(dtSize = 512, random = true)

    var glitchEnabled = false

    def toggleGlitch(): Unit =
      if (glitchEnabled) {
        composer.reset()
        composer.addPass(renderPass)
        glitchEnabled = false
      } else {
        composer.reset()
        composer.addPass(renderPass)
        composer.addPass(glitchPass)
        glitchEnabled = true
      }

    def triggerGlitch(): Unit =
      if (glitchEnabled) {
        glitchPass.generateTrigger()
      }

    val glitchPassDiv = div(
      h1("GlitchPass Effect Demo"),
      p("Demonstrating Three.js GlitchPass post-processing effect for digital distortion."),
      div(
        cls := "canvas-container"
      ),
      // Controls for glitch effects
      div(
        cls := "controls",
        button(
          "Toggle Glitch Effect",
          onClick --> { _ =>
            toggleGlitch()
          }
        ),
        button(
          "Trigger Glitch",
          onClick --> { _ =>
            triggerGlitch()
          }
        ),
        button(
          "Random Glitch",
          onClick --> { _ =>
            glitchPass.setRandom(true)
            triggerGlitch()
          }
        ),
        button(
          "Small Glitch",
          onClick --> { _ =>
            glitchPass.setDtSize(256)
            triggerGlitch()
          }
        ),
        button(
          "Large Glitch",
          onClick --> { _ =>
            glitchPass.setDtSize(1024)
            triggerGlitch()
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
      cube.rotation.x = animationTime * 0.3

      // Animate torus position and scale
      torus.position.x = 2 + scala.math.cos(animationTime * 1.5) * 1.5
      torus.position.y = scala.math.sin(animationTime * 3) * 1
      torus.rotation.x = animationTime * 0.7
      torus.rotation.z = animationTime * 0.4

      // Pulsing scale effect for torus
      val scale = 1 + scala.math.sin(animationTime * 4) * 0.3
      torus.scale.set(scale, scale, scale)

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
    glitchPassDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    glitchPassDiv
}
