package dev.cheleb.scalajswebgl.samples.three.objects

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object RefractorSample:

  def apply() =

    val refractorDiv = div(
      h1("Refractor Demo"),
      p(
        "Demonstrating Refractor - refractive surfaces that create glass or water-like effects."
      ),
      div(cls := "canvas-container")
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 2, 8)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#87CEEB", 1) // Sky blue background

    // Create ground plane
    val groundGeometry = PlaneGeometry(15, 15)
    groundGeometry.rotateX(-scala.math.Pi / 2)
    val groundMaterial = MeshStandardMaterial(color = 0x228b22, roughness = 0.8, metalness = 0.1)
    val ground         = Mesh(groundGeometry, groundMaterial)
    ground.position.y = -1.5
    scene.add(ground)

    // Create objects behind the refractive surface
    val sphereGeometry = SphereGeometry(1, 32, 32)
    val cubeGeometry   = BoxGeometry(1.2, 1.2, 1.2)

    // Create colorful objects that will be seen through the refractor
    val redSphere = Mesh(sphereGeometry, MeshStandardMaterial(color = 0xff4444, roughness = 0.3, metalness = 0.7))
    redSphere.position.set(-2, 1, -3)
    scene.add(redSphere)

    val greenCube = Mesh(cubeGeometry, MeshStandardMaterial(color = 0x44ff44, roughness = 0.5, metalness = 0.3))
    greenCube.position.set(2, 0.8, -3)
    scene.add(greenCube)

    val blueSphere = Mesh(sphereGeometry, MeshStandardMaterial(color = 0x4444ff, roughness = 0.2, metalness = 0.8))
    blueSphere.position.set(0, 1.5, -4)
    scene.add(blueSphere)

    // Create the refractive surface (like a window or glass panel)
    val refractorGeometry = PlaneGeometry(6, 4)

    val refractorOptions = new THREE.RefractorOptions {}
    refractorOptions.color = 0x7f7f7f
    refractorOptions.textureWidth = (window.innerWidth * window.devicePixelRatio).toInt
    refractorOptions.textureHeight = (window.innerHeight * window.devicePixelRatio).toInt
    refractorOptions.clipBias = 0.003

    val refractor = new Refractor(refractorGeometry, refractorOptions)
    refractor.position.set(0, 1, -1)
    refractor.rotation.y = 0 // Keep it facing forward
    scene.add(refractor)

    // Add some lighting
    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 10, 5)
    directionalLight.castShadow = true
    scene.add(directionalLight)

    // Add a point light for more interesting lighting
    val pointLight = PointLight(0xffffff, 0.8, 20)
    pointLight.position.set(0, 5, 2)
    scene.add(pointLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate objects behind the refractor
      redSphere.rotation.x = time * 0.5
      redSphere.rotation.y = time * 0.3
      redSphere.position.y = 1 + scala.math.sin(time * 1.2) * 0.3

      greenCube.rotation.y = time * 0.4
      greenCube.position.x = 2 + scala.math.sin(time * 0.8) * 0.5

      blueSphere.rotation.z = time * 0.6
      blueSphere.position.y = 1.5 + scala.math.sin(time * 1.5) * 0.2

      // Animate the point light
      pointLight.position.x = scala.math.sin(time * 0.7) * 3
      pointLight.position.z = 2 + scala.math.cos(time * 0.9) * 2

      // Subtle camera movement
      camera.position.x = scala.math.sin(time * 0.2) * 1
      camera.position.y = 2 + scala.math.sin(time * 0.3) * 0.5
      camera.lookAt(0, 0, 0)

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
    val container = refractorDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    refractorDiv
