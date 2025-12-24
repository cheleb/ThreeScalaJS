package dev.cheleb.scalajswebgl.samples.three.helpers

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object PlaneHelperSample {

  def apply() =

    val planeHelperDiv = div(
      h1("PlaneHelper Demo"),
      p(
        "Demonstrating the PlaneHelper for visualizing plane objects in 3D space. The helper shows the plane's position, orientation, and boundaries."
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

    // Create a plane
    val plane = new Plane(new Vector3(1, 1, 0.2), 3)

    // Create PlaneHelper to visualize the plane
    val planeHelper = new PlaneHelper(plane, 2, 0xffff00)
    scene.add(planeHelper)

    // Create some objects to demonstrate the plane

    // 1. Cube positioned relative to the plane
    val cubeGeometry = new BoxGeometry(1, 1, 1)
    val cubeMaterial = MeshLambertMaterial(color = 0xff4444)
    val cube         = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(1, 1, 3)
    scene.add(cube)

    // 2. Sphere positioned relative to the plane
    val sphereGeometry = new SphereGeometry(0.5, 16, 12)
    val sphereMaterial = MeshLambertMaterial(color = 0x44ff44)
    val sphere         = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(-1, -1, 3)
    scene.add(sphere)

    // 3. Cone positioned relative to the plane
    val coneGeometry = new ConeGeometry(0.5, 2, 8)
    val coneMaterial = MeshLambertMaterial(color = 0x4444ff)
    val cone         = new Mesh(coneGeometry, coneMaterial)
    cone.position.set(-1, 1, 3)
    scene.add(cone)

    // 4. Torus positioned relative to the plane
    val torusGeometry = new TorusGeometry(0.7, 0.2, 8, 16)
    val torusMaterial = MeshLambertMaterial(color = 0xffaa00)
    val torus         = new Mesh(torusGeometry, torusMaterial)
    torus.position.set(1, -1, 3)
    scene.add(torus)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects around their local axes
      cube.rotation.x = time * 0.5
      cube.rotation.y = time * 0.3

      sphere.rotation.x = time * 0.3
      sphere.rotation.z = time * 0.7

      cone.rotation.y = time * 0.4

      torus.rotation.x = time * 0.2
      torus.rotation.y = time * 0.4

      // Rotate the plane helper slowly to show its orientation
      planeHelper.rotation.x = time * 0.2
      planeHelper.rotation.y = time * 0.1

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
    planeHelperDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    planeHelperDiv
}
