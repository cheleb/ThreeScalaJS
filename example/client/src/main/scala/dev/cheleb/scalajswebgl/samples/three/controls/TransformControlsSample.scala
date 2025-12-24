package dev.cheleb.scalajswebgl.samples.three.controls

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object TransformControlsSample {

  def apply() =

    val transformControlsDiv = div(
      h1("TransformControls Demo"),
      p("Demonstrating gizmo-based transformation controls for 3D objects."),
      div(
        cls := "info-panel",
        p("TransformControls provides a visual gizmo for transforming objects in 3D space."),
        p("Click on an object to select it, then use the gizmo to translate, rotate, or scale."),
        ul(
          li("Click on an object to attach the transform controls"),
          li("Use the gizmo handles to transform the object"),
          li("Press 'Q' to switch to translate mode"),
          li("Press 'W' to switch to rotate mode"),
          li("Press 'E' to switch to scale mode"),
          li("Press 'R' to switch to local/world space"),
          li("Press '+' or '-' to increase/decrease gizmo size")
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
    camera.position.set(0, 5, 10)
    camera.lookAt(0, 0, 0)

    // Create WebGL renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

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
      mesh.position.x = (i - 1) * 3.0
      mesh.position.y = 0
      scene.add(mesh)
      mesh
    }

    // Store meshes for later use (to avoid unused variable warning)
    val _ = meshes

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Create TransformControls
    val transformControls = TransformControls(camera, renderer.domElement)
    scene.add(transformControls.getHelper())

    // Add grid helper for reference
    val gridHelper = GridHelper(20, 20)
    scene.add(gridHelper)

    // Variables to track current object
    var currentObject: js.UndefOr[Object3D] = js.undefined

    // Function to attach controls to an object
    def attachToObject(obj: Object3D): Unit = {
      if (currentObject.isDefined) {
        transformControls.detach()
      }
      transformControls.attach(obj)
      currentObject = obj
    }

    // Raycaster for object picking
    val raycaster = Raycaster()
    val mouse     = Vector2()

    // Mouse event handlers
    val onMouseClick: dom.MouseEvent => Unit = { event =>
      val rect = renderer.domElement.getBoundingClientRect()
      mouse.x = ((event.clientX - rect.left) / rect.width) * 2 - 1
      mouse.y = -((event.clientY - rect.top) / rect.height) * 2 + 1

      raycaster.setFromCamera(mouse, camera)
      val intersects = raycaster.intersectObjects(scene.children)

      if (intersects.length > 0) {
        val intersectedObject = intersects(0).`object`
        if (intersectedObject != gridHelper && intersectedObject != transformControls.getHelper()) {
          attachToObject(intersectedObject)
        }
      }
    }

    // Keyboard event handlers for mode switching
    val onKeyDown: dom.KeyboardEvent => Unit = { event =>
      event.key match {
        case "q" | "Q" =>
          transformControls.setMode("translate")
          println("Switched to translate mode")
        case "w" | "W" =>
          transformControls.setMode("rotate")
          println("Switched to rotate mode")
        case "e" | "E" =>
          transformControls.setMode("scale")
          println("Switched to scale mode")
        case "r" | "R" =>
          val currentSpace = transformControls.space
          val newSpace     = if (currentSpace == "world") "local" else "world"
          transformControls.setSpace(newSpace)
          println(s"Switched to $newSpace space")
        case "+" | "=" =>
          val newSize = scala.math.min(transformControls.size + 0.1, 3.0)
          transformControls.setSize(newSize)
          println(s"Gizmo size: $newSize")
        case "-" | "_" =>
          val newSize = scala.math.max(transformControls.size - 0.1, 0.1)
          transformControls.setSize(newSize)
          println(s"Gizmo size: $newSize")
        case _ =>
      }
    }

    // Add event listeners
    renderer.domElement.addEventListener("click", onMouseClick)
    window.addEventListener("keydown", onKeyDown)

    // Animation loop
    val animate: () => Unit = () => {
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
    transformControlsDiv.amend(
      onUnmountCallback { _ =>
        transformControls.dispose()
        renderer.dispose()
        window.removeEventListener("resize", onWindowResize)
        window.removeEventListener("keydown", onKeyDown)
        renderer.domElement.removeEventListener("click", onMouseClick)
      }
    )

    // Append renderer to the canvas container
    transformControlsDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    transformControlsDiv
}
