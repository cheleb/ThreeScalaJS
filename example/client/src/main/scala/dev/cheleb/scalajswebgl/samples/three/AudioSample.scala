package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object AudioSample {

  // Create audio listener and attach to camera
  val audioListener = new AudioListener()
  val audio         = new PositionalAudio(audioListener)
  val audioAnalyser = new AudioAnalyser(audio, 32)

  def apply() =

    val audioDiv = div(
      h1("Audio Demo"),
      p("Demonstrating 3D spatial audio with positional sources and frequency analysis."),
      div(
        cls := "audio-controls",
        button(
          "Play Audio",
          onClick --> { _ =>
            playAllAudio()
          }
        ),
        button(
          "Pause Audio",
          onClick --> { _ =>
            pauseAllAudio()
          }
        ),
        button(
          "Stop Audio",
          onClick --> { _ =>
            stopAllAudio()
          }
        )
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 0, 5)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0a0a0a", 1)

    // Create visual objects to represent audio sources
    val source1Geometry = new SphereGeometry(0.2, 16, 16)
    val source1Material = MeshBasicMaterial(color = 0xff0040)
    val source1Mesh     = new Mesh(source1Geometry, source1Material)
    source1Mesh.position.set(-3, 0, 0)
    scene.add(source1Mesh)

    val source2Geometry = new SphereGeometry(0.2, 16, 16)
    val source2Material = MeshBasicMaterial(color = 0x00ff40)
    val source2Mesh     = new Mesh(source2Geometry, source2Material)
    source2Mesh.position.set(3, 0, 0)
    scene.add(source2Mesh)

    val source3Geometry = new SphereGeometry(0.2, 16, 16)
    val source3Material = MeshBasicMaterial(color = 0x0040ff)
    val source3Mesh     = new Mesh(source3Geometry, source3Material)
    source3Mesh.position.set(0, 2, -2)
    scene.add(source3Mesh)

    // Add some lighting
    val directionalLight = DirectionalLight(0xffffff, 0.8)
    directionalLight.position.set(1, 1, 1)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate visual objects
      source1Mesh.rotation.x = time * 0.5
      source1Mesh.rotation.y = time * 0.3

      source2Mesh.rotation.x = time * 0.3
      source2Mesh.rotation.y = time * 0.7

      source3Mesh.rotation.z = time * 0.4

      // Pulsing effect to simulate audio visualization
      val pulse = 1.0 + scala.math.sin(time * 2) * 0.3
      source1Mesh.scale.set(pulse * 0.8, pulse * 0.8, pulse * 0.8)
      source2Mesh.scale.set(pulse * 1.2, pulse * 1.2, pulse * 1.2)
      source3Mesh.scale.set(pulse * 0.6, pulse * 0.6, pulse * 0.6)

      //   // Update audio analyser (if needed for visualizations)
      val frequencyData = audioAnalyser.getFrequencyData()
      //   // Here you could use frequencyData to drive visual effects
      source1Mesh.material.asInstanceOf[MeshBasicMaterial].color.setHSL(frequencyData(0) / 255.0, 1.0, 0.5)
      source3Mesh.scale.set(
        frequencyData(1) / 255.0 + 0.5,
        frequencyData(1) / 255.0 + 0.5,
        frequencyData(1) / 255.0 + 0.5
      )

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
    audioDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    audioDiv
  private def playAllAudio(): Unit =
    // This would play all audio sources when audio files are available
    println("Playing all audio sources")
    val audioLoader = new AudioLoader()

    audioLoader.load(
      "/ThreeScalaJS/demo/sounds/zogzog.mp3",
      { audioBuffer =>

        audio.setBuffer(audioBuffer)
        audio.setRefDistance(20)
        audio.setLoop(true)
        audio.play()

      }
    )

  private def pauseAllAudio(): Unit =
    // This would pause all audio sources when audio files are available
    println("Pausing all audio sources")
    audio.pause()

  private def stopAllAudio(): Unit =
    // This would stop all audio sources when audio files are available
    println("Stopping all audio sources")
    audio.stop()
}
