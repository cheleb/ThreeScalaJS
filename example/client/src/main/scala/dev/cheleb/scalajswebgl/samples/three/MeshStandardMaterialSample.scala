package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object MeshStandardMaterialSample {

  def apply() =

    val standardDiv = div(
      h1("MeshStandardMaterial Demo"),
      p(
        "Demonstrating MeshStandardMaterial - a physically-based rendering (PBR) material with roughness and metalness properties for realistic surface rendering."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 12

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create different objects showcasing PBR properties

    // 1. Metallic spheres with different roughness values
    val metallicSphere1   = new SphereGeometry(1.2, 32, 16)
    val metallicMaterial1 = MeshStandardMaterial(
      color = 0xff4444,
      metalness = 1.0, // Fully metallic
      roughness = 0.0, // Perfectly smooth (like chrome)
      emissive = 0x220000,
      emissiveIntensity = 0.1
    )
    val metallicSphere1Mesh = new Mesh(metallicSphere1, metallicMaterial1)
    metallicSphere1Mesh.position.set(-6, 3, 0)
    scene.add(metallicSphere1Mesh)

    val metallicSphere2   = new SphereGeometry(1.2, 32, 16)
    val metallicMaterial2 = MeshStandardMaterial(
      color = 0x44ff44,
      metalness = 1.0, // Fully metallic
      roughness = 0.5, // Medium roughness
      emissive = 0x002200,
      emissiveIntensity = 0.1
    )
    val metallicSphere2Mesh = new Mesh(metallicSphere2, metallicMaterial2)
    metallicSphere2Mesh.position.set(-2, 3, 0)
    scene.add(metallicSphere2Mesh)

    // 2. Non-metallic spheres (dielectric) with different roughness
    val dielectricSphere1   = new SphereGeometry(1.2, 32, 16)
    val dielectricMaterial1 = MeshStandardMaterial(
      color = 0x4444ff,
      metalness = 0.0, // Non-metallic
      roughness = 0.1, // Slightly rough
      emissive = 0x000022,
      emissiveIntensity = 0.1
    )
    val dielectricSphere1Mesh = new Mesh(dielectricSphere1, dielectricMaterial1)
    dielectricSphere1Mesh.position.set(2, 3, 0)
    scene.add(dielectricSphere1Mesh)

    val dielectricSphere2   = new SphereGeometry(1.2, 32, 16)
    val dielectricMaterial2 = MeshStandardMaterial(
      color = 0xffaa00,
      metalness = 0.0, // Non-metallic
      roughness = 0.9, // Very rough (like clay)
      emissive = 0x222200,
      emissiveIntensity = 0.1
    )
    val dielectricSphere2Mesh = new Mesh(dielectricSphere2, dielectricMaterial2)
    dielectricSphere2Mesh.position.set(6, 3, 0)
    scene.add(dielectricSphere2Mesh)

    // 3. Bottom row - mixed materials
    val mixedSphere1   = new SphereGeometry(1.2, 32, 16)
    val mixedMaterial1 = MeshStandardMaterial(
      color = 0xff44ff,
      metalness = 0.8, // Mostly metallic
      roughness = 0.2, // Slightly rough
      emissive = 0x220022,
      emissiveIntensity = 0.1
    )
    val mixedSphere1Mesh = new Mesh(mixedSphere1, mixedMaterial1)
    mixedSphere1Mesh.position.set(-6, -3, 0)
    scene.add(mixedSphere1Mesh)

    val mixedSphere2   = new SphereGeometry(1.2, 32, 16)
    val mixedMaterial2 = MeshStandardMaterial(
      color = 0x44ffff,
      metalness = 0.3, // Slightly metallic
      roughness = 0.7, // Quite rough
      emissive = 0x002222,
      emissiveIntensity = 0.1
    )
    val mixedSphere2Mesh = new Mesh(mixedSphere2, mixedMaterial2)
    mixedSphere2Mesh.position.set(-2, -3, 0)
    scene.add(mixedSphere2Mesh)

    // 4. Reference cubes showing material properties
    val chromeCube     = new BoxGeometry(0.8, 0.8, 0.8)
    val chromeMaterial = MeshStandardMaterial(
      color = 0xdddddd,
      metalness = 1.0,
      roughness = 0.0,
      emissive = 0x111111,
      emissiveIntensity = 0.2
    )
    val chromeCubeMesh = new Mesh(chromeCube, chromeMaterial)
    chromeCubeMesh.position.set(2, -3, 0)
    scene.add(chromeCubeMesh)

    val rubberCube     = new BoxGeometry(0.8, 0.8, 0.8)
    val rubberMaterial = MeshStandardMaterial(
      color = 0xff4444,
      metalness = 0.0,
      roughness = 1.0,
      emissive = 0x220000,
      emissiveIntensity = 0.1
    )
    val rubberCubeMesh = new Mesh(rubberCube, rubberMaterial)
    rubberCubeMesh.position.set(6, -3, 0)
    scene.add(rubberCubeMesh)

    // Add lighting to showcase PBR properties
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val directionalLight2 = DirectionalLight(0xffffff, 0.5)
    directionalLight2.position.set(-5, 3, 2)
    scene.add(directionalLight2)

    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate spheres at different speeds
      metallicSphere1Mesh.rotation.x = time * 0.3
      metallicSphere1Mesh.rotation.y = time * 0.5

      metallicSphere2Mesh.rotation.x = time * 0.4
      metallicSphere2Mesh.rotation.y = time * 0.3

      dielectricSphere1Mesh.rotation.y = time * 0.5
      dielectricSphere1Mesh.rotation.z = time * 0.2

      dielectricSphere2Mesh.rotation.x = time * 0.2
      dielectricSphere2Mesh.rotation.z = time * 0.6

      mixedSphere1Mesh.rotation.x = time * 0.6
      mixedSphere1Mesh.rotation.z = time * 0.3

      mixedSphere2Mesh.rotation.y = time * 0.4
      mixedSphere2Mesh.rotation.z = time * 0.5

      chromeCubeMesh.rotation.x = time * 0.3
      chromeCubeMesh.rotation.y = time * 0.7

      rubberCubeMesh.rotation.z = time * 0.4

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
    standardDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    standardDiv
}
