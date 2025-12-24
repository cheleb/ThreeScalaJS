package dev.cheleb.scalajswebgl.samples.three.lighting

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object RectAreaLightSample:

  def apply() =

    val rectAreaDiv = div(
      h1("RectAreaLight Demo"),
      p(
        "Demonstrating RectAreaLight - rectangular area lights that simulate windows or strip lighting."
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
    renderer.setClearColor("#1a1a2e", 1)

    // Create ground plane
    val groundGeometry = PlaneGeometry(20, 20)
    groundGeometry.rotateX(-scala.math.Pi / 2)
    val groundMaterial = MeshStandardMaterial(color = 0x404040, roughness = 0.8, metalness = 0.2)
    val ground         = Mesh(groundGeometry, groundMaterial)
    ground.position.y = -2
    scene.add(ground)

    // Create objects to be illuminated
    val sphereGeometry = SphereGeometry(1, 32, 32)
    val cubeGeometry   = BoxGeometry(1.5, 1.5, 1.5)

    // Create central illuminated objects
    val centralSphere = Mesh(sphereGeometry, MeshStandardMaterial(color = 0xff4444, roughness = 0.3, metalness = 0.7))
    centralSphere.position.set(0, 1, 0)
    scene.add(centralSphere)

    val cube1 = Mesh(cubeGeometry, MeshStandardMaterial(color = 0x44ff44, roughness = 0.5, metalness = 0.3))
    cube1.position.set(-3, 0.5, -2)
    scene.add(cube1)

    val cube2 = Mesh(cubeGeometry, MeshStandardMaterial(color = 0x4444ff, roughness = 0.2, metalness = 0.8))
    cube2.position.set(3, 0.5, -2)
    scene.add(cube2)

    // Create rectangular area lights (simulating windows/panels)
    val windowLight1 = RectAreaLight(0xffffff, 3, 4, 6) // Large horizontal window
    windowLight1.position.set(-6, 3, -3)
    windowLight1.lookAt(0, 0, 0)
    scene.add(windowLight1)

    val windowLight2 = RectAreaLight(0xffffff, 2, 3, 8) // Tall vertical window
    windowLight2.position.set(6, 2, -3)
    windowLight2.lookAt(0, 0, 0)
    scene.add(windowLight2)

    val panelLight1 = RectAreaLight(0xffffff, 4, 2, 2) // Small square panel
    panelLight1.position.set(0, 4, -4)
    panelLight1.lookAt(0, 0, 0)
    scene.add(panelLight1)

    val panelLight2 = RectAreaLight(0xffffff, 2, 6, 2) // Long horizontal strip
    panelLight2.position.set(0, -1, -2)
    panelLight2.lookAt(0, 0, 0)
    scene.add(panelLight2)

    // Add ambient light for better visibility
    val ambientLight = AmbientLight(0x404040, 0.2)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate central objects
      centralSphere.rotation.x = time * 0.3
      centralSphere.rotation.y = time * 0.5

      cube1.rotation.y = time * 0.4
      cube2.rotation.y = -time * 0.6

      // Animate light intensities for dynamic effect
      windowLight1.intensity = 3 + scala.math.sin(time * 1.5) * 0.5
      windowLight2.intensity = 2 + scala.math.sin(time * 1.8) * 0.3
      panelLight1.intensity = 4 + scala.math.sin(time * 2.2) * 0.8
      panelLight2.intensity = 2 + scala.math.sin(time * 1.3) * 0.4

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
    val container = rectAreaDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    rectAreaDiv
