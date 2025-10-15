package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.annotation.nowarn

object SSAOPassSample {

  def apply() =

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 5, 10)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create floor
    val floorGeometry = PlaneGeometry(20, 20)
    val floorMaterial = MeshLambertMaterial(color = 0x888888)
    val floor         = new Mesh(floorGeometry, floorMaterial)
    floor.rotation.x = -scala.math.Pi / 2
    floor.position.y = -3
    scene.add(floor)

    // Create various objects to demonstrate SSAO
    val geometries = List(
      BoxGeometry(2, 2, 2),
      SphereGeometry(1.5, 32, 32),
      ConeGeometry(1.5, 3, 16),
      CylinderGeometry(1.5, 1.5, 3, 16),
      TorusGeometry(1.5, 0.5, 16, 100)
    )

    geometries.zipWithIndex.foreach { case (geometry, i) =>
      val material = MeshLambertMaterial(color = 0x666666 + i * 0x111111)
      val mesh     = new Mesh(geometry, material)

      val angle  = (i.toDouble / geometries.length) * scala.math.Pi * 2
      val radius = 6
      mesh.position.set(
        scala.math.cos(angle) * radius,
        scala.math.sin(i) * 2,
        scala.math.sin(angle) * radius
      )
      scene.add(mesh)
    }

    // Create walls and corners for better SSAO demonstration
    val wallGeometry = PlaneGeometry(20, 10)
    val wallMaterial = MeshLambertMaterial(color = 0x777777)

    val backWall = new Mesh(wallGeometry, wallMaterial)
    backWall.position.set(0, 2, -10)
    scene.add(backWall)

    val leftWall = new Mesh(wallGeometry, wallMaterial)
    leftWall.rotation.y = scala.math.Pi / 2
    leftWall.position.set(-10, 2, 0)
    scene.add(leftWall)

    val rightWall = new Mesh(wallGeometry, wallMaterial)
    rightWall.rotation.y = -scala.math.Pi / 2
    rightWall.position.set(10, 2, 0)
    scene.add(rightWall)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 10, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Create additional point lights for better shadows
    val pointLight1 = PointLight(0xffffff, 0.5, 20)
    pointLight1.position.set(-5, 8, 5)
    scene.add(pointLight1)

    val pointLight2 = PointLight(0xffffff, 0.3, 20)
    pointLight2.position.set(5, 8, -5)
    scene.add(pointLight2)

    // Create post-processing composer
    val composer = EffectComposer(renderer)

    // Create render pass
    val renderPass = RenderPass(scene, camera)
    composer.addPass(renderPass)

    // Create SSAOPass for screen space ambient occlusion
    val ssaoPass = SSAOPass(
      scene = scene,
      camera = camera,
      width = (window.innerWidth * 0.8).toDouble,
      height = (window.innerHeight * 0.8).toDouble,
      kernelSize = 32
    )

    @nowarn
    var currentEffect: String = "none"
    var kernelRadius          = 8.0
    var minDistance           = 0.005
    var maxDistance           = 0.1

    def switchEffect(effect: String): Unit = {
      // Reset composer to only have render pass
      composer.reset()

      effect match {
        case "ssao" =>
          composer.addPass(renderPass)
          composer.addPass(ssaoPass)
          currentEffect = "ssao"
        case _ =>
          composer.addPass(renderPass)
          currentEffect = "none"
      }
    }

    // Initialize with SSAO effect
    switchEffect("ssao")

    val ssaoPassDiv = div(
      h1("SSAOPass - Screen Space Ambient Occlusion"),
      p(
        "Demonstrating Three.js SSAOPass for realistic ambient occlusion effects. Notice how crevices and corners become darker, creating more realistic depth perception."
      ),
      div(
        cls := "canvas-container"
      ),
      // Controls for adjusting SSAO parameters
      div(
        cls := "controls",
        button(
          "SSAO Effect",
          onClick --> { _ =>
            switchEffect("ssao")
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
          label("Kernel Radius: ", kernelRadius.toString),
          input(
            `type`   := "range",
            minAttr  := "1",
            maxAttr  := "32",
            stepAttr := "1",
            value    := kernelRadius.toString,
            onInput --> { evt =>
              kernelRadius = evt.target.asInstanceOf[dom.HTMLInputElement].value.toDouble
              ssaoPass.kernelRadius = kernelRadius
            }
          )
        ),
        div(
          cls := "slider-container",
          label("Min Distance: ", minDistance.toString),
          input(
            `type`   := "range",
            minAttr  := "0.001",
            maxAttr  := "0.1",
            stepAttr := "0.001",
            value    := minDistance.toString,
            onInput --> { evt =>
              minDistance = evt.target.asInstanceOf[dom.HTMLInputElement].value.toDouble
              ssaoPass.minDistance = minDistance
            }
          )
        ),
        div(
          cls := "slider-container",
          label("Max Distance: ", maxDistance.toString),
          input(
            `type`   := "range",
            minAttr  := "0.01",
            maxAttr  := "1.0",
            stepAttr := "0.01",
            value    := maxDistance.toString,
            onInput --> { evt =>
              maxDistance = evt.target.asInstanceOf[dom.HTMLInputElement].value.toDouble
              ssaoPass.maxDistance = maxDistance
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

      // Animate camera for better SSAO demonstration
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
    ssaoPassDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    ssaoPassDiv
}
