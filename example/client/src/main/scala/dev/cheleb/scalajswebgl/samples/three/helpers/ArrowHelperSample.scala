package dev.cheleb.scalajswebgl.samples.three.helpers

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object ArrowHelperSample {

  def apply() =

    val arrowHelperDiv = div(
      h1("ArrowHelper Demo"),
      p(
        "Demonstrating the ArrowHelper for visualizing directions in 3D space. Arrows help show vector directions, orientations, and movement paths."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(8, 8, 8)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create multiple ArrowHelpers to demonstrate different directions

    // 1. Arrow pointing in X direction (red)
    val arrowX = new ArrowHelper(new Vector3(1, 0, 0), new Vector3(0, 0, 0), 3, 0xff0000, 0.5, 0.3)
    scene.add(arrowX)

    // 2. Arrow pointing in Y direction (green)
    val arrowY = new ArrowHelper(new Vector3(0, 1, 0), new Vector3(0, 0, 0), 3, 0x00ff00, 0.5, 0.3)
    scene.add(arrowY)

    // 3. Arrow pointing in Z direction (blue)
    val arrowZ = new ArrowHelper(new Vector3(0, 0, 1), new Vector3(0, 0, 0), 3, 0x0000ff, 0.5, 0.3)
    scene.add(arrowZ)

    // 4. Diagonal arrow (yellow)
    val arrowDiagonal = new ArrowHelper(new Vector3(1, 1, 1), new Vector3(-2, -2, -2), 2, 0xffff00, 0.4, 0.2)
    scene.add(arrowDiagonal)

    // 5. Arrow pointing towards origin (cyan)
    val arrowToOrigin = new ArrowHelper(new Vector3(-1, -1, -1), new Vector3(2, 2, 2), 2, 0x00ffff, 0.4, 0.2)
    scene.add(arrowToOrigin)

    // Create some objects to demonstrate arrow usage context

    // 1. Cube with arrow showing its forward direction
    val cubeGeometry = new BoxGeometry(1, 1, 1)
    val cubeMaterial = MeshLambertMaterial(color = 0xff4444)
    val cube         = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(3, 0, 0)
    scene.add(cube)

    // Arrow showing cube's forward direction
    val cubeForwardArrow = new ArrowHelper(
      new Vector3(1, 0, 0),
      new Vector3(cube.position.x, cube.position.y, cube.position.z),
      2,
      0xff6666,
      0.3,
      0.2
    )
    scene.add(cubeForwardArrow)

    // 2. Sphere with arrow showing movement direction
    val sphereGeometry = new SphereGeometry(0.5, 16, 12)
    val sphereMaterial = MeshLambertMaterial(color = 0x44ff44)
    val sphere         = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(0, 3, 0)
    scene.add(sphere)

    // Arrow showing sphere's movement direction
    val sphereMoveArrow = new ArrowHelper(
      new Vector3(0, -1, 0),
      new Vector3(sphere.position.x, sphere.position.y, sphere.position.z),
      2,
      0x66ff66,
      0.3,
      0.2
    )
    scene.add(sphereMoveArrow)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate the entire scene slowly for better visualization
      scene.rotation.y = time * 0.2

      // Animate the cube and its arrow
      cube.rotation.y = time * 0.5
      cubeForwardArrow.setDirection(new Vector3(scala.math.cos(time * 0.5), 0, scala.math.sin(time * 0.5)))

      // Animate the sphere and its arrow
      sphere.position.y = 3 + scala.math.sin(time * 2) * 0.5
      sphereMoveArrow.position.set(
        sphere.position.x.getOrElse(0.0),
        sphere.position.y.getOrElse(0.0),
        sphere.position.z.getOrElse(0.0)
      )

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
    arrowHelperDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    arrowHelperDiv
}
