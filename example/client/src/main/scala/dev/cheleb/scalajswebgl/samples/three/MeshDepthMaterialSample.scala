package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object MeshDepthMaterialSample {

  def apply() =

    val depthDiv = div(
      h1("MeshDepthMaterial Demo"),
      p(
        "Demonstrating MeshDepthMaterial - a material that renders objects based on their distance from the camera. Closer objects appear brighter while distant objects appear darker. Perfect for depth-based rendering, shadow mapping, and post-processing effects."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 15

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0a0a0a", 1)

    // Create different geometries with MeshDepthMaterial to show depth-based rendering

    // 1. Front row - closest objects (brightest)
    val frontSphereGeometry = new SphereGeometry(1, 32, 16)
    val frontSphereMaterial = MeshDepthMaterial()
    val frontSphere         = new Mesh(frontSphereGeometry, frontSphereMaterial)
    frontSphere.position.x = -6
    frontSphere.position.y = 2
    frontSphere.position.z = 2
    scene.add(frontSphere)

    val frontCubeGeometry = new BoxGeometry(1.5, 1.5, 1.5)
    val frontCubeMaterial = MeshDepthMaterial()
    val frontCube         = new Mesh(frontCubeGeometry, frontCubeMaterial)
    frontCube.position.x = -2
    frontCube.position.y = 2
    frontCube.position.z = 2
    scene.add(frontCube)

    val frontTorusGeometry = new TorusGeometry(0.8, 0.3, 16, 100)
    val frontTorusMaterial = MeshDepthMaterial()
    val frontTorus         = new Mesh(frontTorusGeometry, frontTorusMaterial)
    frontTorus.position.x = 2
    frontTorus.position.y = 2
    frontTorus.position.z = 2
    scene.add(frontTorus)

    val frontConeGeometry = new ConeGeometry(1, 2, 32)
    val frontConeMaterial = MeshDepthMaterial()
    val frontCone         = new Mesh(frontConeGeometry, frontConeMaterial)
    frontCone.position.x = 6
    frontCone.position.y = 2
    frontCone.position.z = 2
    scene.add(frontCone)

    // 2. Middle row - medium distance
    val midSphereGeometry = new SphereGeometry(1, 32, 16)
    val midSphereMaterial = MeshDepthMaterial()
    val midSphere         = new Mesh(midSphereGeometry, midSphereMaterial)
    midSphere.position.x = -6
    midSphere.position.y = -1
    midSphere.position.z = 0
    scene.add(midSphere)

    val midCubeGeometry = new BoxGeometry(1.5, 1.5, 1.5)
    val midCubeMaterial = MeshDepthMaterial()
    val midCube         = new Mesh(midCubeGeometry, midCubeMaterial)
    midCube.position.x = -2
    midCube.position.y = -1
    midCube.position.z = 0
    scene.add(midCube)

    val midTorusGeometry = new TorusGeometry(0.8, 0.3, 16, 100)
    val midTorusMaterial = MeshDepthMaterial()
    val midTorus         = new Mesh(midTorusGeometry, midTorusMaterial)
    midTorus.position.x = 2
    midTorus.position.y = -1
    midTorus.position.z = 0
    scene.add(midTorus)

    val midConeGeometry = new ConeGeometry(1, 2, 32)
    val midConeMaterial = MeshDepthMaterial()
    val midCone         = new Mesh(midConeGeometry, midConeMaterial)
    midCone.position.x = 6
    midCone.position.y = -1
    midCone.position.z = 0
    scene.add(midCone)

    // 3. Back row - farthest objects (darkest)
    val backSphereGeometry = new SphereGeometry(1, 32, 16)
    val backSphereMaterial = MeshDepthMaterial()
    val backSphere         = new Mesh(backSphereGeometry, backSphereMaterial)
    backSphere.position.x = -6
    backSphere.position.y = -4
    backSphere.position.z = -2
    scene.add(backSphere)

    val backCubeGeometry = new BoxGeometry(1.5, 1.5, 1.5)
    val backCubeMaterial = MeshDepthMaterial()
    val backCube         = new Mesh(backCubeGeometry, backCubeMaterial)
    backCube.position.x = -2
    backCube.position.y = -4
    backCube.position.z = -2
    scene.add(backCube)

    val backTorusGeometry = new TorusGeometry(0.8, 0.3, 16, 100)
    val backTorusMaterial = MeshDepthMaterial()
    val backTorus         = new Mesh(backTorusGeometry, backTorusMaterial)
    backTorus.position.x = 2
    backTorus.position.y = -4
    backTorus.position.z = -2
    scene.add(backTorus)

    val backConeGeometry = new ConeGeometry(1, 2, 32)
    val backConeMaterial = MeshDepthMaterial()
    val backCone         = new Mesh(backConeGeometry, backConeMaterial)
    backCone.position.x = 6
    backCone.position.y = -4
    backCone.position.z = -2
    scene.add(backCone)

    // Add some wireframe versions to show structure
    val wireframeSphereGeometry = new SphereGeometry(1.2, 16, 12)
    val wireframeSphereMaterial = MeshDepthMaterial(wireframe = true)
    val wireframeSphere         = new Mesh(wireframeSphereGeometry, wireframeSphereMaterial)
    wireframeSphere.position.x = 0
    wireframeSphere.position.y = 4
    wireframeSphere.position.z = 3
    scene.add(wireframeSphere)

    // Add lighting (minimal, since depth material works with depth)
    val ambientLight = AmbientLight(0xffffff, 0.5)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects at different speeds
      frontSphere.rotation.x = time * 0.5
      frontSphere.rotation.y = time * 0.3

      frontCube.rotation.x = time * 0.4
      frontCube.rotation.z = time * 0.2

      frontTorus.rotation.x = time * 0.6
      frontTorus.rotation.y = time * 0.4

      frontCone.rotation.y = time * 0.5

      midSphere.rotation.y = time * 0.4
      midCube.rotation.x = time * 0.3
      midTorus.rotation.z = time * 0.5
      midCone.rotation.x = time * 0.4

      backSphere.rotation.z = time * 0.3
      backCube.rotation.y = time * 0.2
      backTorus.rotation.x = time * 0.4
      backCone.rotation.z = time * 0.3

      wireframeSphere.rotation.x = time * 0.3
      wireframeSphere.rotation.y = time * 0.5

      // Move camera slightly to show depth effect
      camera.position.x = scala.math.sin(time * 0.1) * 2
      camera.lookAt(0, 0, 0)

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
    depthDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    depthDiv
}
