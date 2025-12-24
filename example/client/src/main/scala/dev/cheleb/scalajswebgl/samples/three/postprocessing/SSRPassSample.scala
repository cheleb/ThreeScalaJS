package dev.cheleb.scalajswebgl.samples.three.postprocessing

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.annotation.nowarn

object SSRPassSample {

  def apply() =

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 3, 8)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create reflective floor
    val floorGeometry = PlaneGeometry(10, 10)
    val floorMaterial = MeshPhysicalMaterial(
      color = 0x222222,
      metalness = 0.8,
      roughness = 0.2
    )
    val floor = new Mesh(floorGeometry, floorMaterial)
    floor.rotation.x = -scala.math.Pi / 2
    floor.position.y = -2
    scene.add(floor)

    // Create reflective spheres
    val sphereGeometry = SphereGeometry(1, 64, 32)

    val metalSphere1 = new Mesh(
      sphereGeometry,
      MeshPhysicalMaterial(
        color = 0xff4444,
        metalness = 1.0,
        roughness = 0.0
      )
    )
    metalSphere1.position.set(-3, 0, 0)
    scene.add(metalSphere1)

    val metalSphere2 = new Mesh(
      sphereGeometry,
      MeshPhysicalMaterial(
        color = 0x44ff44,
        metalness = 1.0,
        roughness = 0.0
      )
    )
    metalSphere2.position.set(3, 0, 0)
    scene.add(metalSphere2)

    // Create some objects to be reflected
    val cubeGeometry = BoxGeometry(1.5, 1.5, 1.5)
    val cube1        = new Mesh(
      cubeGeometry,
      MeshPhysicalMaterial(
        color = 0x4444ff,
        metalness = 0.0,
        roughness = 0.3
      )
    )
    cube1.position.set(0, 2, -2)
    scene.add(cube1)

    val torusGeometry = TorusGeometry(0.8, 0.3, 16, 100)
    val torus         = new Mesh(
      torusGeometry,
      MeshPhysicalMaterial(
        color = 0xffff44,
        metalness = 0.0,
        roughness = 0.2
      )
    )
    torus.position.set(-1, 1, 1)
    scene.add(torus)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 10, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    // Create point lights for better reflections
    val pointLight1 = PointLight(0xff0040, 1, 10)
    pointLight1.position.set(-5, 3, 2)
    scene.add(pointLight1)

    val pointLight2 = PointLight(0x0040ff, 1, 10)
    pointLight2.position.set(5, 3, 2)
    scene.add(pointLight2)

    // Create post-processing composer
    val composer = EffectComposer(renderer)

    // Create render pass
    val renderPass = RenderPass(scene, camera)
    composer.addPass(renderPass)

    // Create SSRPass for screen space reflections
    val ssrPass = SSRPass(
      renderer = renderer,
      scene = scene,
      camera = camera,
      width = (window.innerWidth * 0.8).toDouble,
      height = (window.innerHeight * 0.8).toDouble
    )

    @nowarn
    var currentEffect: String = "none"
    var maxDistance           = 10.0
    var resolutionScale       = 1.0

    def switchEffect(effect: String): Unit = {
      // Reset composer to only have render pass
      composer.reset()

      effect match {
        case "ssr" =>
          composer.addPass(renderPass)
          composer.addPass(ssrPass)
          currentEffect = "ssr"
        case _ =>
          composer.addPass(renderPass)
          currentEffect = "none"
      }
    }

    // Initialize with SSR effect
    switchEffect("ssr")

    val ssrPassDiv = div(
      h1("SSRPass - Screen Space Reflections"),
      p(
        "Demonstrating Three.js SSRPass for realistic screen space reflections. Notice how the metallic spheres and floor reflect the surrounding objects and lighting."
      ),
      div(
        cls := "canvas-container"
      ),
      // Controls for adjusting SSR parameters
      div(
        cls := "controls",
        button(
          "SSR Effect",
          onClick --> { _ =>
            switchEffect("ssr")
          }
        ),
        button(
          "No Effects",
          onClick --> { _ =>
            switchEffect("none")
          }
        ),
        div(
          cls := "slider-container",
          label("Max Distance: ", maxDistance.toString),
          input(
            `type`   := "range",
            minAttr  := "1",
            maxAttr  := "50",
            stepAttr := "1",
            value    := maxDistance.toString,
            onInput --> { evt =>
              maxDistance = evt.target.asInstanceOf[dom.HTMLInputElement].value.toDouble
              ssrPass.maxDistance = maxDistance
            }
          )
        ),
        div(
          cls := "slider-container",
          label("Resolution Scale: ", resolutionScale.toString),
          input(
            `type`   := "range",
            minAttr  := "0.1",
            maxAttr  := "2.0",
            stepAttr := "0.1",
            value    := resolutionScale.toString,
            onInput --> { evt =>
              resolutionScale = evt.target.asInstanceOf[dom.HTMLInputElement].value.toDouble
              ssrPass.resolutionScale = resolutionScale
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

      // Animate objects
      metalSphere1.rotation.y = animationTime * 0.5
      metalSphere2.rotation.y = -animationTime * 0.3

      cube1.rotation.x = animationTime * 0.4
      cube1.rotation.y = animationTime * 0.6

      torus.rotation.x = animationTime * 0.3
      torus.rotation.z = animationTime * 0.5

      // Animate point lights for dynamic reflections
      pointLight1.position.x = scala.math.sin(animationTime) * 4
      pointLight2.position.x = scala.math.cos(animationTime) * 4

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
    ssrPassDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    ssrPassDiv
}
