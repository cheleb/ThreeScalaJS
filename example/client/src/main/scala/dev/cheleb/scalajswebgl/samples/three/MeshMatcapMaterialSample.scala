package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object MeshMatcapMaterialSample {

  def apply() =

    val matcapDiv = div(
      h1("MeshMatcapMaterial Demo"),
      p(
        "Demonstrating MeshMatcapMaterial - materials using matcap (material capture) textures for consistent lighting and stylized rendering."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 10

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create different objects showcasing matcap materials

    // 1. Clay-like matcap material (simulated)
    val claySphere   = new SphereGeometry(1.5, 32, 16)
    val clayMaterial = MeshMatcapMaterial(
      color = 0xd2b48c, // Tan color for clay
      bumpScale = 0.5
    )
    // Note: In a real implementation, you would load a clay matcap texture:
    // clayMaterial.matcap = clayMatcapTexture
    val clayMesh = new Mesh(claySphere, clayMaterial)
    clayMesh.position.set(-4, 2, 0)
    scene.add(clayMesh)

    // 2. Metallic matcap material (simulated)
    val metalSphere   = new SphereGeometry(1.5, 32, 16)
    val metalMaterial = MeshMatcapMaterial(
      color = 0x888888, // Gray base for metal
      bumpScale = 0.2
    )
    // Note: In a real implementation, you would load a metal matcap texture:
    // metalMaterial.matcap = metalMatcapTexture
    val metalMesh = new Mesh(metalSphere, metalMaterial)
    metalMesh.position.set(0, 2, 0)
    scene.add(metalMesh)

    // 3. Skin-like matcap material (simulated)
    val skinSphere   = new SphereGeometry(1.5, 32, 16)
    val skinMaterial = MeshMatcapMaterial(
      color = 0xffdbac, // Skin tone
      bumpScale = 0.1
    )
    // Note: In a real implementation, you would load a skin matcap texture:
    // skinMaterial.matcap = skinMatcapTexture
    val skinMesh = new Mesh(skinSphere, skinMaterial)
    skinMesh.position.set(4, 2, 0)
    scene.add(skinMesh)

    // 4. Complex geometry with matcap - torus
    val matcapTorus   = new TorusGeometry(1, 0.4, 16, 100)
    val torusMaterial = MeshMatcapMaterial(
      color = 0x4a90e2,
      bumpScale = 0.3
    )
    val torusMesh = new Mesh(matcapTorus, torusMaterial)
    torusMesh.position.set(-4, -2, 0)
    scene.add(torusMesh)

    // 5. Cube with detailed surface
    val matcapCube   = new BoxGeometry(2, 2, 2)
    val cubeMaterial = MeshMatcapMaterial(
      color = 0xe94b3c,
      bumpScale = 0.8 // Strong bump mapping effect
    )
    val cubeMesh = new Mesh(matcapCube, cubeMaterial)
    cubeMesh.position.set(0, -2, 0)
    scene.add(cubeMesh)

    // 6. Icosahedron geometry (complex shape)
    val matcapIcosahedron   = new IcosahedronGeometry(1.2, 0)
    val icosahedronMaterial = MeshMatcapMaterial(
      color = 0x50c878,
      bumpScale = 0.4
    )
    val icosahedronMesh = new Mesh(matcapIcosahedron, icosahedronMaterial)
    icosahedronMesh.position.set(4, -2, 0)
    scene.add(icosahedronMesh)

    // Add some lighting (matcap materials are mostly lighting-independent)
    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Add a directional light for subtle rim lighting effect
    val directionalLight = DirectionalLight(0xffffff, 0.3)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects at different speeds
      clayMesh.rotation.x = time * 0.3
      clayMesh.rotation.y = time * 0.5

      metalMesh.rotation.x = time * 0.4
      metalMesh.rotation.y = time * 0.3

      skinMesh.rotation.y = time * 0.5
      skinMesh.rotation.z = time * 0.2

      torusMesh.rotation.x = time * 0.6
      torusMesh.rotation.z = time * 0.3

      cubeMesh.rotation.x = time * 0.2
      cubeMesh.rotation.y = time * 0.4

      icosahedronMesh.rotation.x = time * 0.5
      icosahedronMesh.rotation.y = time * 0.7

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
    matcapDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    matcapDiv
}
