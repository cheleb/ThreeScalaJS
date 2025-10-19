package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object VertexNormalsHelperSample {

  def apply() =

    val vertexNormalsHelperDiv = div(
      h1("VertexNormalsHelper Demo"),
      p(
        "Demonstrating the VertexNormalsHelper for visualizing vertex normals. Vertex normals are essential for lighting calculations and show the direction each vertex is facing."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(5, 5, 5)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create a mesh with vertex normals
    val geometry = new BoxGeometry(2, 2, 2, 4, 4, 4) // Higher detail for better normal visualization

    val material = MeshStandardMaterial(
      color = 0x44aa88,
      roughness = 0.7,
      metalness = 0.1
    )

    val mesh = new Mesh(geometry, material)
    mesh.position.set(0, 0, 0)
    scene.add(mesh)

    // Create VertexNormalsHelper to visualize the normals
    val normalsHelper = new VertexNormalsHelper(mesh, 0.5, 0xff0000)
    scene.add(normalsHelper)

    // Create additional objects to show different geometries

    // 2. Sphere with normals
    val sphereGeometry = new SphereGeometry(1, 16, 12)
    val sphereMaterial = MeshStandardMaterial(color = 0x8844aa, roughness = 0.3, metalness = 0.8)
    val sphere         = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(3, 0, 0)
    scene.add(sphere)

    val sphereNormalsHelper = new VertexNormalsHelper(sphere, 0.3, 0x00ff00)
    scene.add(sphereNormalsHelper)

    // 3. Torus with normals
    val torusGeometry = new TorusGeometry(0.8, 0.3, 8, 16)
    val torusMaterial = MeshStandardMaterial(color = 0xaa8844, roughness = 0.5, metalness = 0.3)
    val torus         = new Mesh(torusGeometry, torusMaterial)
    torus.position.set(-3, 0, 0)
    scene.add(torus)

    val torusNormalsHelper = new VertexNormalsHelper(torus, 0.4, 0x0000ff)
    scene.add(torusNormalsHelper)

    // Add lighting for better visualization
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val directionalLight2 = DirectionalLight(0xffffff, 0.5)
    directionalLight2.position.set(-5, -5, -5)
    scene.add(directionalLight2)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects to show how normals change with rotation
      mesh.rotation.x = time * 0.3
      mesh.rotation.y = time * 0.5

      sphere.rotation.x = time * 0.4
      sphere.rotation.z = time * 0.2

      torus.rotation.x = time * 0.2
      torus.rotation.y = time * 0.6

      // Update normals helpers to reflect the new rotations
      normalsHelper.update()
      sphereNormalsHelper.update()
      torusNormalsHelper.update()

      // Rotate the entire scene slowly
      scene.rotation.y = time * 0.1

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
    vertexNormalsHelperDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    vertexNormalsHelperDiv
}
