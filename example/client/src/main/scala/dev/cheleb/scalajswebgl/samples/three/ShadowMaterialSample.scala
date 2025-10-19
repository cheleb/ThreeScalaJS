package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object ShadowMaterialSample:

  def apply() =

    val shadowDiv = div(
      h1("ShadowMaterial Demo"),
      p(
        "Demonstrating ShadowMaterial - a material for receiving shadows with transparency."
      ),
      div(cls := "canvas-container")
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
    renderer.setClearColor("#87CEEB", 1) // Sky blue background

    // Create ground plane that receives shadows
    val groundGeometry = PlaneGeometry(10, 10)
    groundGeometry.rotateX(-scala.math.Pi / 2) // Rotate to be horizontal

    val groundMaterial = new ShadowMaterial(
      js.Dynamic.literal(
        color = 0x000000,
        transparent = true
      )
    )
    groundMaterial.opacity = 0.3

    val ground = Mesh(groundGeometry, groundMaterial)
    ground.position.y = -2
    ground.receiveShadow = true
    scene.add(ground)

    // Create objects that cast shadows
    val cubeGeometry = BoxGeometry(1, 1, 1)
    val cubeMaterial = MeshLambertMaterial(color = 0xff0000)

    val cube1 = Mesh(cubeGeometry, cubeMaterial)
    cube1.position.set(-2, 0, 0)
    cube1.castShadow = true
    scene.add(cube1)

    val cube2 = Mesh(cubeGeometry, cubeMaterial)
    cube2.position.set(2, 0, 0)
    cube2.castShadow = true
    scene.add(cube2)

    val sphereGeometry = SphereGeometry(0.7, 16, 16)
    val sphereMaterial = MeshLambertMaterial(color = 0x00ff00)

    val sphere = Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(0, 1, 2)
    sphere.castShadow = true
    scene.add(sphere)

    // Create light that casts shadows
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 10, 5)
    directionalLight.castShadow = true

    scene.add(directionalLight)

    // Add ambient light for better visibility
    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate cubes
      cube1.rotation.x = time * 0.5
      cube1.rotation.y = time * 0.7

      cube2.rotation.x = -time * 0.3
      cube2.rotation.y = -time * 0.5

      // Animate sphere in a circular path
      sphere.position.x = scala.math.sin(time) * 2
      sphere.position.z = scala.math.cos(time) * 2
      sphere.rotation.y = time

      // Move light slightly for dynamic shadows
      directionalLight.position.x = scala.math.sin(time * 0.5) * 3
      directionalLight.position.z = scala.math.cos(time * 0.5) * 3

      renderer.render(scene, camera)
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = _ => {
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    }
    window.addEventListener("resize", onWindowResize)

    // Append renderer to container
    val container = shadowDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    shadowDiv
