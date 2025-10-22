package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object DragControlsSample {

  def apply() =

    val dragControlsDiv = div(
      h1("DragControls Demo"),
      p("Demonstrating drag and drop interaction with 3D objects."),
      div(
        cls := "info-panel",
        p("DragControls allows you to drag 3D objects around the scene."),
        p("Click and drag on any object to move it. Right-click and drag to rotate."),
        ul(
          li("Left mouse button: Pan/translate objects"),
          li("Right mouse button: Rotate objects"),
          li("Objects will snap to the plane perpendicular to the camera")
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

    // Create geometries for demonstration
    val geometries = js.Array(
      new SphereGeometry(1.0, 16, 12),
      new BoxGeometry(1.2, 1.2, 1.2),
      new ConeGeometry(0.8, 1.8, 12),
      new CylinderGeometry(0.6, 0.6, 1.5, 16)
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
      ),
      MeshStandardMaterial(
        color = 0xf9ca24,
        roughness = 0.4,
        metalness = 0.5
      )
    )

    // Create meshes
    val meshes = geometries.zipWithIndex.map { case (geometry, i) =>
      val mesh = new Mesh(geometry, materials(i))
      mesh.position.x = (i - 1.5) * 2.5
      mesh.position.y = (i % 2 - 0.5) * 2.0
      scene.add(mesh)
      mesh
    }

    // Convert meshes to Object3D array for DragControls
    val objects = meshes.asInstanceOf[js.Array[Object3D]]

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Create DragControls
    val controls = DragControls(objects, camera, renderer.domElement)
    controls.rotateSpeed = 2.0

    // Add event listeners for visual feedback
    controls
      .asInstanceOf[js.Dynamic]
      .addEventListener(
        "dragstart",
        { (event: js.Dynamic) =>
          val obj = event.`object`.asInstanceOf[Mesh]
          obj.material.asInstanceOf[MeshStandardMaterial].emissive.setHex(0xaaaaaa)
          println(s"Started dragging: ${obj.geometry.asInstanceOf[BufferGeometry].`type`}")
        }
      )

    controls
      .asInstanceOf[js.Dynamic]
      .addEventListener(
        "dragend",
        { (event: js.Dynamic) =>
          val obj = event.`object`.asInstanceOf[Mesh]
          obj.material.asInstanceOf[MeshStandardMaterial].emissive.setHex(0x000000)
          println(s"Finished dragging: ${obj.geometry.asInstanceOf[BufferGeometry].`type`}")
        }
      )

    controls
      .asInstanceOf[js.Dynamic]
      .addEventListener(
        "hoveron",
        { (event: js.Dynamic) =>
          val obj = event.`object`.asInstanceOf[Mesh]
          println(s"Hovering over: ${obj.geometry.asInstanceOf[BufferGeometry].`type`}")
        }
      )

    controls
      .asInstanceOf[js.Dynamic]
      .addEventListener(
        "hoveroff",
        { (event: js.Dynamic) =>
          val obj = event.`object`.asInstanceOf[Mesh]
          println(s"No longer hovering over: ${obj.geometry.asInstanceOf[BufferGeometry].`type`}")
        }
      )

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Subtle rotation for all objects
      meshes.foreach { mesh =>
        mesh.rotation.x = time * 0.1
        mesh.rotation.y = time * 0.05
      }

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

    // Cleanup on unmount
    dragControlsDiv.amend(
      onUnmountCallback { _ =>
        controls.dispose()
        renderer.dispose()
        window.removeEventListener("resize", onWindowResize)
      }
    )

    // Append renderer to the canvas container
    dragControlsDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    dragControlsDiv
}
