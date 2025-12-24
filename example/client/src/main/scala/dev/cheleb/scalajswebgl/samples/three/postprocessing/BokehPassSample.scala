package dev.cheleb.scalajswebgl.samples.three.postprocessing

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.annotation.nowarn

object BokehPassSample {

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

    // Create multiple objects at different depths for depth of field effect
    val geometries = List(
      (BoxGeometry(1, 1, 1), MeshPhongMaterial(color = 0xff4444, shininess = 100), -4.0),           // Red cube - far
      (SphereGeometry(0.8, 32, 16), MeshPhongMaterial(color = 0x44ff44, shininess = 50), -2.0),     // Green sphere - middle
      (TorusGeometry(0.6, 0.2, 16, 100), MeshPhongMaterial(color = 0x4444ff, shininess = 75), 0.0), // Blue torus - near
      (ConeGeometry(0.5, 1.5, 32), MeshPhongMaterial(color = 0xffff44, shininess = 30), 2.0),       // Yellow cone - closer
      (
        CylinderGeometry(0.4, 0.4, 1.2, 32),
        MeshPhongMaterial(color = 0xff44ff, shininess = 60),
        4.0
      ) // Magenta cylinder - very close
    )

    val objects = geometries.map { case (geometry, material, zPos) =>
      val mesh = new Mesh(geometry, material)
      mesh.position.set((scala.math.random() * 4 - 2).toDouble, (scala.math.random() * 2 - 1).toDouble, zPos)
      scene.add(mesh)
      mesh
    }

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

    // Create BokehPass for depth of field effect
    val bokehPass =
      BokehPass(scene, camera, focusValue = 2.0, aspectValue = 1.0, apertureValue = 0.01, maxblurValue = 0.5)

    @nowarn
    var currentEffect: String = "none"
    var focusDistance         = 2.0

    def switchEffect(effect: String): Unit = {
      // Reset composer to only have render pass
      composer.reset()

      effect match {
        case "bokeh" =>
          composer.addPass(renderPass)
          composer.addPass(bokehPass)
          currentEffect = "bokeh"
        case _ =>
          composer.addPass(renderPass)
          currentEffect = "none"
      }
    }

    // Initialize with bokeh effect
    switchEffect("bokeh")

    val bokehPassDiv = div(
      h1("BokehPass - Depth of Field Effect"),
      p(
        "Demonstrating Three.js BokehPass for depth of field effects. Objects at different distances will have varying levels of blur."
      ),
      div(
        cls := "canvas-container"
      ),
      // Controls for adjusting focus and effect
      div(
        cls := "controls",
        button(
          "Bokeh Effect",
          onClick --> { _ =>
            switchEffect("bokeh")
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
          label("Focus Distance: ", focusDistance.toString),
          input(
            `type`   := "range",
            minAttr  := "-5",
            maxAttr  := "10",
            stepAttr := "0.1",
            value    := focusDistance.toString,
            onInput --> { evt =>
              focusDistance = evt.target.asInstanceOf[dom.HTMLInputElement].value.toDouble
              bokehPass.setFocus(focusDistance)
            }
          )
        ),
        div(
          cls := "slider-container",
          label("Aperture: ", "0.01"),
          input(
            `type`   := "range",
            minAttr  := "0.001",
            maxAttr  := "0.1",
            stepAttr := "0.001",
            value    := "0.01",
            onInput --> { evt =>
              val aperture = evt.target.asInstanceOf[dom.HTMLInputElement].value.toDouble
              bokehPass.setAperture(aperture)
            }
          )
        ),
        div(
          cls := "slider-container",
          label("Max Blur: ", "0.5"),
          input(
            `type`   := "range",
            minAttr  := "0.1",
            maxAttr  := "2.0",
            stepAttr := "0.1",
            value    := "0.5",
            onInput --> { evt =>
              val maxBlur = evt.target.asInstanceOf[dom.HTMLInputElement].value.toDouble
              bokehPass.setMaxBlur(maxBlur)
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
      objects.zipWithIndex.foreach { case (obj, index) =>
        val offset = index * 0.5
        obj.rotation.x = animationTime * (0.5 + index * 0.1) + offset
        obj.rotation.y = animationTime * (0.3 + index * 0.05) + offset

        // Move objects back and forth along Z-axis for better depth demonstration
        val zOffset = scala.math.sin(animationTime * (0.5 + index * 0.2) + offset) * 1.5
        obj.position.z = geometries(index)._3 + zOffset
      }

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
    bokehPassDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    bokehPassDiv
}
