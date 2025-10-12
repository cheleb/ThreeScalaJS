package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.annotation.nowarn

object AdvancedLoadersSample {

  // Create scene
  val scene   = Scene()
  def apply() =

    val loadersDiv = div(
      h1("Advanced Loaders Demo"),
      p("Demonstrating various Three.js loaders: TextureLoader, FontLoader, AudioLoader, SVGLoader, and ObjectLoader."),
      div(
        cls := "canvas-container"
      ),
      div(
        cls := "controls-panel",
        h3("Controls"),
        button(
          "Load Texture",
          onClick --> { _ =>
            loadTextureDemo()
          }
        ),
        button(
          "Load Font & Create Text",
          onClick --> { _ =>
            loadFontDemo()
          }
        ),
        button(
          "Load Audio",
          onClick --> { _ =>
            loadAudioDemo()
          }
        ),
        button(
          "Load SVG",
          onClick --> { _ =>
            loadSVGDemo()
          }
        ),
        button(
          "Load 3D Object",
          onClick --> { _ =>
            loadObjectDemo()
          }
        )
      )
    )

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 2, 8)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.6, window.innerHeight * 0.6)
    renderer.setClearColor("#2d1b69", 1)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Create a simple cube to show basic scene functionality
    val cubeGeometry = new BoxGeometry(1, 1, 1)
    val cubeMaterial = MeshPhongMaterial(
      color = 0x44aa88,
      shininess = 100
    )
    val cube = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(-3, 0, 0)
    scene.add(cube)

    // Animation loop
    var animationTime       = 0.0
    val animate: () => Unit = () => {
      animationTime += 0.016

      // Animate cube
      cube.rotation.x = animationTime * 0.5
      cube.rotation.y = animationTime * 0.3

      renderer.render(scene, camera)
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = { _ =>
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.6, window.innerHeight * 0.6)
    }
    window.addEventListener("resize", onWindowResize)

    // Append renderer to the canvas container
    loadersDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    loadersDiv

  private def loadTextureDemo(): Unit = {
    // Demonstrate TextureLoader
    val textureLoader = new TextureLoader()

    // In a real application, you would load from a URL like:
    textureLoader.load(
      "/ThreeScalaJS/demo/img/laminar.png",
      { texture =>
        dom.console.log("Texture loaded:", texture)
        val material = MeshBasicMaterial(map = texture, wireframe = false)
        // Apply material to mesh
        dom.console.log("Texture loaded and material created:", material)
        val cubeGeometry = new BoxGeometry(2, 2, 2)
        val cubeMaterial = MeshPhongMaterial(
          color = 0x44aa88,
          shininess = 100,
          map = texture
        )
        val cube = new Mesh(cubeGeometry, cubeMaterial)
        cube.position.set(0, 0, 0)
        scene.add(cube)
      }
    )

    dom.console.log("TextureLoader demo - would load texture from URL")
  }

  private def loadFontDemo(): Unit = {
    // Demonstrate FontLoader

    // FIXME: Warning "a pure expression does nothing in statement position" --- IGNORE ---
    val fontLoader = new FontLoader()

    // In a real application, you would load from a font JSON file:
    fontLoader.load(
      "/ThreeScalaJS/demo/fonts/helvetiker_regular.typeface.json",
      { font =>
        val textGeometry = TextGeometry(
          "Hello World",
          font = font,
          size = 0.5,
          height = 0.2,
          depth = 2
        )
        val textMesh = new Mesh(textGeometry, MeshPhongMaterial(color = 0xff0000))
        scene.add(textMesh)
      }
    )

    dom.console.log("FontLoader demo - would load font and create 3D text")
  }

  private def loadAudioDemo(): Unit = {
    // Demonstrate AudioLoader

    val audioLoader = new AudioLoader()

    // In a real application, you would load an audio file:
    audioLoader.load(
      "/ThreeScalaJS/demo/sounds/zogzog.mp3",
      { audioBuffer =>
        val audioListener = new AudioListener()

        val audio = new PositionalAudio(audioListener)
        audio.setBuffer(audioBuffer)
        audio.setRefDistance(20)
        audio.play()
      }
    )

    dom.console.log("AudioLoader demo - would load and play audio file")
  }

  private def loadSVGDemo(): Unit = {
    // Demonstrate SVGLoader
    val svgLoader = new SVGLoader()

    // In a real application, you would load an SVG file:
    svgLoader.load(
      "/ThreeScalaJS/demo/img/scala.svg",
      svgResult =>
        dom.console.log("SVG loaded:", svgResult)
        svgResult.paths.foreach { path =>
          val pathShapes = svgLoader.parse(path.path)
          // Create geometry from SVG paths
          val geometry  = new ShapeGeometry(pathShapes)
          val scalaMesh = new Mesh(geometry, MeshBasicMaterial(color = 0x008f4c))
          scalaMesh.position.set(-3, 0, 0)
          scene.add(scalaMesh)
          dom.console.log(s"SVG path added to scene: $pathShapes")
        }
    )

    dom.console.log("SVGLoader demo - would load and parse SVG file")
  }

  private def loadObjectDemo(): Unit = {
    // Demonstrate ObjectLoader
    @nowarn // FIXME: Warning "a pure expression does nothing in statement position" --- IGNORE ---
    val objectLoader = new ObjectLoader()

    // In a real application, you would load a JSON scene file:
    // objectLoader.load(
    //   "models/scene.json",
    //   { loadedObject =>
    //     scene.add(loadedObject)
    //   }
    // )

    dom.console.log("ObjectLoader demo - would load 3D scene from JSON")
  }
}
