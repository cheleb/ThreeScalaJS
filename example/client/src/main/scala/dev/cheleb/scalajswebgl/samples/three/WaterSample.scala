package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object WaterSample:

  def apply() =

    val waterDiv = div(
      h1("Water Demo"),
      p(
        "Demonstrating Water - realistic water surface simulation with reflections and wave animation."
      ),
      div(cls := "canvas-container")
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 5, 10)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#87CEEB", 1) // Sky blue background

    // Create water geometry
    val waterGeometry = PlaneGeometry(20, 20, 128, 128)

    // Create water options
    val waterOptions = WaterOptions(
      textureWidth = (window.innerWidth * window.devicePixelRatio).toInt,
      textureHeight = (window.innerHeight * window.devicePixelRatio).toInt,
      waterNormals = null, // Will use default water normals
      sunDirection = new Vector3(0.70707, 0.70707, 0.0),
      sunColor = 0xffffff,
      waterColor = 0x001e0f,
      distortionScale = 3.7,
      fog = false
    )

    // Create water
    val water = new Water(waterGeometry, waterOptions)
    water.rotation.x = -scala.math.Pi / 2 // Make it horizontal
    scene.add(water)

    // Create some objects to reflect in the water
    val sphereGeometry = SphereGeometry(1, 32, 32)
    val cubeGeometry   = BoxGeometry(1.5, 1.5, 1.5)

    // Create floating objects
    val redSphere = Mesh(sphereGeometry, MeshStandardMaterial(color = 0xff4444, roughness = 0.1, metalness = 0.9))
    redSphere.position.set(-3, 2, -2)
    scene.add(redSphere)

    val greenCube = Mesh(cubeGeometry, MeshStandardMaterial(color = 0x44ff44, roughness = 0.3, metalness = 0.7))
    greenCube.position.set(3, 1.5, -1)
    scene.add(greenCube)

    val blueSphere = Mesh(sphereGeometry, MeshStandardMaterial(color = 0x4444ff, roughness = 0.2, metalness = 0.8))
    blueSphere.position.set(0, 2.5, -3)
    scene.add(blueSphere)

    // Add some underwater geometry (below water level)
    val underwaterGeometry = PlaneGeometry(25, 25)
    val underwaterMaterial = MeshStandardMaterial(color = 0x004d4d, roughness = 0.8, metalness = 0.2)
    underwaterMaterial.transparent = true
    underwaterMaterial.opacity = 0.3
    val underwater = Mesh(underwaterGeometry, underwaterMaterial)
    underwater.rotation.x = -scala.math.Pi / 2
    underwater.position.y = -2
    scene.add(underwater)

    // Add lighting
    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 10, 5)
    directionalLight.castShadow = true
    scene.add(directionalLight)

    // Add a point light for more dynamic lighting
    val pointLight = PointLight(0xffffff, 0.6, 20)
    pointLight.position.set(0, 8, 4)
    scene.add(pointLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate floating objects
      redSphere.rotation.x = time * 0.5
      redSphere.rotation.y = time * 0.3
      redSphere.position.y = 2 + scala.math.sin(time * 1.2) * 0.5

      greenCube.rotation.y = time * 0.4
      greenCube.position.y = 1.5 + scala.math.sin(time * 0.8) * 0.3

      blueSphere.rotation.z = time * 0.6
      blueSphere.position.y = 2.5 + scala.math.sin(time * 1.5) * 0.4

      // Animate point light
      pointLight.position.x = scala.math.sin(time * 0.7) * 5
      pointLight.position.z = 4 + scala.math.cos(time * 0.9) * 3

      // Subtle camera movement
      camera.position.x = scala.math.sin(time * 0.2) * 2
      camera.position.y = 5 + scala.math.sin(time * 0.3) * 1
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
    val container = waterDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    waterDiv
