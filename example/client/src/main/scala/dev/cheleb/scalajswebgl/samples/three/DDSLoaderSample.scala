package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
//import scala.math.max

object DDSLoaderSample {

  def apply() =

    val ddsLoaderDiv = div(
      h1("DDSLoader Demo"),
      p("Demonstrating DDS (DirectDraw Surface) compressed texture loading with S3TC compression formats."),
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

    // Create geometry for texture demonstration

    val cubeGeometry = BoxGeometry(1.5, 1.5, 1.5)

    // For demo purposes, we'll create a mock DDS texture since we don't have actual DDS files
    // In a real application, you would use: val compressedTexture = DDSLoader().load("path/to/texture.dds")
    // In a real application, you would load actual DDS files like:
    val ddsLoader = new DDSLoader()

    val dds = "disturb_dxt1_nomip"
    // val dds = "explosion_dxt5_mip"

    val map1 = ddsLoader.load(s"/ThreeScalaJS/demo/textures/compressed/$dds.dds")
    map1.minFilter = map1.magFilter = THREE.LinearFilter
    map1.anisotropy = 4;
    map1.colorSpace = THREE.SRGBColorSpace;

    //  val dds       = "explosion_dxt5_mip.dds"
    val cubemap1 = ddsLoader.load("/ThreeScalaJS/demo/textures/compressed/Mountains.dds")

    cubemap1.magFilter = THREE.LinearFilter
    cubemap1.minFilter = THREE.LinearFilter
    cubemap1.mapping = THREE.CubeRefractionMapping
    cubemap1.colorSpace = THREE.SRGBColorSpace
    // material1.needsUpdate = true

    val material1 = MeshBasicMaterial(map = map1, envMap = cubemap1, color = 0xffffff)
//    material1.needsUpdate = true

    val geometry = BoxGeometry(2, 2, 2);
    val cube1    = Mesh(geometry, material1);
    // Create materials using the loaded texture
    val cubeMaterial = MeshPhongMaterial(
      color = 0xffffff,
      shininess = 30,
      specular = 0x111111,
      map = map1
    )

    // Create meshes

    val cube = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.x = 2
    scene.add(cube)

    scene.add(cube1)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 10)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0xffffff, 4.4)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects
      cube.rotation.x = time * 0.5
      cube.rotation.y = time * 0.7

      cube1.rotation.x = time * 0.5
      cube1.rotation.y = time * 0.7

      // Animate texture offset for visual effect
      map1.offset.x = time * 0.1
      map1.offset.y = time * 0.1

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
    ddsLoaderDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    ddsLoaderDiv
}
