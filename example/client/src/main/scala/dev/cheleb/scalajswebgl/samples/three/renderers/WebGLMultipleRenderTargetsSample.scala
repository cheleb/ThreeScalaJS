package dev.cheleb.scalajswebgl.samples.three.renderers

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object WebGLMultipleRenderTargetsSample {

  def apply() =

    val webglMRTDiv = div(
      h1("WebGLMultipleRenderTargets Demo"),
      p("Demonstrating WebGLMultipleRenderTargets with multiple color attachments for advanced rendering."),
      div(
        cls := "info-panel",
        p("Multiple Render Targets (MRT) allow rendering to multiple textures simultaneously."),
        p("This enables advanced techniques like deferred shading and post-processing effects."),
        ul(
          li("Color attachment 1: Diffuse color information"),
          li("Color attachment 2: Normal vector information"),
          li("Depth buffer: Depth information for post-processing")
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
    camera.position.z = 8

    // Create WebGL renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create multiple render targets (2 color attachments + depth)
    val rtWidth      = 256
    val rtHeight     = 256
    val renderTarget = WebGLMultipleRenderTargets(
      width = rtWidth,
      height = rtHeight,
      count = 2, // Two color attachments
      options = new WebGLRenderTargetOptions {
        depthBuffer = true
        stencilBuffer = false
        generateMipmaps = false
        minFilter = THREE.LinearFilter
        magFilter = THREE.LinearFilter
        format = THREE.RGBAFormat
        `type` = THREE.UnsignedByteType
      }
    )

    // Display render target information
    println(s"Created MRT with ${renderTarget.textures.length} color attachments")
    println(s"Render target size: ${renderTarget.width} x ${renderTarget.height}")
    println(s"Depth buffer enabled: ${renderTarget.depthBuffer}")

    // Create geometries for demonstration
    val geometries = js.Array(
      new SphereGeometry(1.0, 16, 12),
      new BoxGeometry(1.2, 1.2, 1.2),
      new ConeGeometry(0.8, 1.8, 12)
    )

    // Create materials for different objects
    val materials = js.Array(
      MeshStandardMaterial(
        color = 0xff6b6b,
        roughness = 0.3,
        metalness = 0.7
      ),
      MeshStandardMaterial(
        color = 0x4ecdc4,
        roughness = 0.5,
        metalness = 0.3
      ),
      MeshStandardMaterial(
        color = 0x45b7d1,
        roughness = 0.2,
        metalness = 0.8
      )
    )

    // Create meshes
    val meshes = geometries.zipWithIndex.map { case (geometry, i) =>
      val mesh = new Mesh(geometry, materials(i))
      mesh.position.x = (i - 1) * 2.5
      mesh.position.y = 0
      scene.add(mesh)
      mesh
    }

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Create a simple visualization quad to show MRT capabilities
    val quadGeometry = new PlaneGeometry(4, 3)
    val quadMaterial = MeshBasicMaterial(
      color = 0x888888,
      wireframe = false
    )
    val infoQuad = new Mesh(quadGeometry, quadMaterial)
    infoQuad.position.z = -2
    scene.add(infoQuad)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects
      meshes.zipWithIndex.foreach { case (mesh, i) =>
        mesh.rotation.x = time * (0.5 + i * 0.2)
        mesh.rotation.y = time * (0.3 + i * 0.1)
      }

      // Rotate the info quad slowly
      infoQuad.rotation.y = time * 0.1

      // Render the scene
      renderer.clear()
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
    webglMRTDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    webglMRTDiv
}
