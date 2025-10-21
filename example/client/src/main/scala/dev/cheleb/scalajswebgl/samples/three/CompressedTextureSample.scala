package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array

object CompressedTextureSample {

  def apply() =

    val compressedTextureDiv = div(
      h1("CompressedTexture Demo"),
      p("Demonstrating compressed texture usage with mipmaps and different compressed formats."),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 5

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create geometry for the texture demonstration
    val planeGeometry = PlaneGeometry(3, 3)
    val cubeGeometry  = BoxGeometry(1.5, 1.5, 1.5)

    // Create mock compressed texture data (normally this would come from compressed texture files)
    val createMockMipmapData = (width: Int, height: Int) => {
      val dataSize = (width * height) / 2 // Simulate DXT1 compression ratio
      new Uint8Array(dataSize)
    }

    // Create mipmaps array with different sizes
    val mipmaps = js.Array(
      js.Dynamic
        .literal(
          "data"   -> createMockMipmapData(256, 256),
          "width"  -> 256,
          "height" -> 256
        )
        .asInstanceOf[js.Object],
      js.Dynamic
        .literal(
          "data"   -> createMockMipmapData(128, 128),
          "width"  -> 128,
          "height" -> 128
        )
        .asInstanceOf[js.Object],
      js.Dynamic
        .literal(
          "data"   -> createMockMipmapData(64, 64),
          "width"  -> 64,
          "height" -> 64
        )
        .asInstanceOf[js.Object],
      js.Dynamic
        .literal(
          "data"   -> createMockMipmapData(32, 32),
          "width"  -> 32,
          "height" -> 32
        )
        .asInstanceOf[js.Object]
    )

    // Create compressed texture (RGBA_S3TC_DXT1_Format = 33776)
    val compressedTexture = new CompressedTexture(
      mipmaps = mipmaps,
      width = 256,
      height = 256,
      format = 33776,   // RGBA_S3TC_DXT1_Format
      tpe = 5121,       // UnsignedByteType
      mapping = 300,    // UVMapping
      wrapS = 1001,     // RepeatWrapping
      wrapT = 1001,     // RepeatWrapping
      magFilter = 9729, // LinearFilter
      minFilter = 9987  // LinearMipmapLinearFilter
    )

    // Create materials using the compressed texture
    val planeMaterial = MeshLambertMaterial(
      color = 0xffffff
    )
    planeMaterial.map = compressedTexture

    val cubeMaterial = MeshPhongMaterial(
      color = 0xffffff,
      shininess = 30
    )
    cubeMaterial.map = compressedTexture

    // Create meshes
    val plane = new Mesh(planeGeometry, planeMaterial)
    plane.position.x = -2
    scene.add(plane)

    val cube = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.x = 2
    scene.add(cube)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects
      plane.rotation.z = time * 0.3
      cube.rotation.x = time * 0.5
      cube.rotation.y = time * 0.7

      // Animate texture offset for visual effect
      compressedTexture.offset.x = time * 0.1
      compressedTexture.offset.y = time * 0.1

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
    compressedTextureDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    compressedTextureDiv
}
