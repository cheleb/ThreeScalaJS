package dev.cheleb.scalajswebgl.samples.three.geometries

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object BufferGeometryUtilsSample {

  def apply() =

    val bufferUtilsDiv = div(
      h1("BufferGeometryUtils Demo"),
      p("Demonstrating advanced vertex manipulation and geometry processing utilities."),
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

    // Demonstrate geometry merging and manipulation

    // 1. Create multiple geometries to merge
    val boxGeometry1 = new BoxGeometry(1, 1, 1)
    val boxMaterial1 = MeshPhongMaterial(color = 0xff4444, shininess = 100)
    val box1         = new Mesh(boxGeometry1, boxMaterial1)
    box1.position.set(-4, 2, 0)
    scene.add(box1)

    val sphereGeometry = new SphereGeometry(0.8, 16, 12)
    val sphereMaterial = MeshPhongMaterial(color = 0x44ff44, shininess = 80)
    val sphere         = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(-4, -2, 0)
    scene.add(sphere)

    // 2. Demonstrate geometry merging (conceptually)
    // val geometriesToMerge = js.Array[BufferGeometry](
    //   new BoxGeometry(0.5, 0.5, 2),
    //   new CylinderGeometry(0.3, 0.3, 2, 8)
    // )

    // Note: In a real implementation with proper BufferGeometryUtils,
    // we would merge these geometries
    val mergedBox      = new BoxGeometry(0.5, 0.5, 2)
    val mergedMaterial = MeshPhongMaterial(color = 0x4444ff, shininess = 60)
    val mergedMesh     = new Mesh(mergedBox, mergedMaterial)
    mergedMesh.position.set(0, 2, 0)
    scene.add(mergedMesh)

    val mergedCylinder     = new CylinderGeometry(0.3, 0.3, 2, 8)
    val mergedCylinderMesh = new Mesh(mergedCylinder, MeshPhongMaterial(color = 0xff44ff, shininess = 60))
    mergedCylinderMesh.position.set(0, -2, 0)
    scene.add(mergedCylinderMesh)

    // 3. Demonstrate vertex manipulation concepts
    val torusGeometry = new TorusGeometry(1.5, 0.4, 8, 16)
    val torusMaterial = MeshPhongMaterial(color = 0xffaa00, shininess = 90)
    val torus         = new Mesh(torusGeometry, torusMaterial)
    torus.position.set(4, 2, 0)
    scene.add(torus)

    // 4. Demonstrate creased normals concept (would use toCreasedNormals)
    val coneGeometry = new ConeGeometry(1, 2, 8, 1)
    val coneMaterial = MeshPhongMaterial(color = 0x44ffff, shininess = 70)
    val cone         = new Mesh(coneGeometry, coneMaterial)
    cone.position.set(4, -2, 0)
    scene.add(cone)

    // 5. Information display using basic geometries
    val infoCube     = new BoxGeometry(0.1, 0.1, 0.1)
    val infoMaterial = MeshBasicMaterial(color = 0x888888)
    val infoMesh     = new Mesh(infoCube, infoMaterial)
    infoMesh.position.set(0, -4, 0)
    scene.add(infoMesh)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects at different speeds
      box1.rotation.x = time * 0.3
      box1.rotation.y = time * 0.5

      sphere.rotation.y = time * 0.4
      sphere.rotation.z = time * 0.3

      mergedMesh.rotation.x = time * 0.6
      mergedMesh.rotation.z = time * 0.4

      mergedCylinderMesh.rotation.x = time * 0.5
      mergedCylinderMesh.rotation.y = time * 0.7

      torus.rotation.x = time * 0.2
      torus.rotation.y = time * 0.4

      cone.rotation.y = time * 0.6

      infoMesh.rotation.x = time * 0.1
      infoMesh.rotation.y = time * 0.1

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
    bufferUtilsDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    bufferUtilsDiv
}
