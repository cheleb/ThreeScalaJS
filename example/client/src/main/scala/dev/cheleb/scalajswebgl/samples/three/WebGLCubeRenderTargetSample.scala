package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object WebGLCubeRenderTargetSample {

  def apply() =

    val webglCubeRTDiv = div(
      h1("WebGLCubeRenderTarget Demo"),
      p("Demonstrating WebGLCubeRenderTarget for dynamic cube map generation and reflections."),
      div(
        cls := "info-panel",
        p("Cube Render Targets are used to create dynamic cube maps for:"),
        ul(
          li("Real-time reflections and environment mapping"),
          li("Dynamic lighting and shadow mapping"),
          li("Omnidirectional rendering from a point in space"),
          li("Advanced post-processing effects")
        ),
        p("This demo shows a reflective sphere that captures the surrounding scene in real-time.")
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

    // Create WebGL renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create cube render target for dynamic reflections
    val cubeRenderTarget = WebGLCubeRenderTarget(
      size = 256,
      options = new WebGLRenderTargetOptions {
        generateMipmaps = true
        minFilter = THREE.LinearMipmapLinearFilter
        magFilter = THREE.LinearFilter
        format = THREE.RGBAFormat
        `type` = THREE.UnsignedByteType
      }
    )

    // Display cube render target information
    println(s"Created cube render target: ${cubeRenderTarget.width} x ${cubeRenderTarget.height}")
    println(s"Cube render target is cube: ${cubeRenderTarget.isWebGLCubeRenderTarget}")

    // Create the reflective sphere
    val sphereGeometry     = new SphereGeometry(1.5, 32, 32)
    val reflectiveMaterial = MeshStandardMaterial(
      color = 0x888888,
      metalness = 1.0,
      roughness = 0.0
    )
    // Set the environment map after creation
    reflectiveMaterial.envMap = cubeRenderTarget.texture
    val reflectiveSphere = new Mesh(sphereGeometry, reflectiveMaterial)
    scene.add(reflectiveSphere)

    // Create surrounding objects that will be reflected
    val geometries = js.Array(
      new SphereGeometry(0.5, 16, 16),
      new BoxGeometry(1.0, 1.0, 1.0),
      new ConeGeometry(0.5, 1.0, 12)
    )

    val colors = js.Array(0xff6b6b, 0x4ecdc4, 0x45b7d1)

    val surroundingObjects = geometries.zipWithIndex.map { case (geometry, i) =>
      val material = MeshStandardMaterial(
        color = colors(i),
        metalness = 0.3,
        roughness = 0.7
      )
      val mesh = new Mesh(geometry, material)
      mesh.position.set(
        (i - 1) * 3,
        js.Math.sin(i) * 1.5,
        -3 + js.Math.cos(i) * 2
      )
      scene.add(mesh)
      mesh
    }

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Create a cube camera for updating the cube render target
    val cubeCamera = CubeCamera(0.1, 100, cubeRenderTarget)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate the reflective sphere
      reflectiveSphere.rotation.x = time * 0.3
      reflectiveSphere.rotation.y = time * 0.5

      // Animate surrounding objects
      surroundingObjects.zipWithIndex.foreach { case (obj, i) =>
        obj.rotation.x = time * (0.5 + i * 0.2)
        obj.rotation.y = time * (0.3 + i * 0.1)
        obj.position.y = js.Math.sin(time + i) * 1.5
      }

      // Update the cube render target from the sphere's perspective
      // This captures the surrounding scene for reflections
      cubeCamera.parent.position.x = reflectiveSphere.position.x
      cubeCamera.parent.position.y = reflectiveSphere.position.y
      cubeCamera.parent.position.z = reflectiveSphere.position.z
      cubeCamera.update(renderer, scene)

      // Render the scene
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
    webglCubeRTDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    webglCubeRTDiv
}
