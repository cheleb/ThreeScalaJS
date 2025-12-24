package dev.cheleb.scalajswebgl.samples.three.objects

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object LODSample:

  def apply() =

    val lodDiv = div(
      h1("LOD (Level of Detail) Demo"),
      p(
        "Demonstrating Level of Detail - objects automatically switch between different detail levels based on distance from camera."
      ),
      div(cls := "canvas-container")
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 0, 50)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0f0f23", 1)

    // Create LOD object
    val lod = LOD()

    // High detail mesh (close distance)
    val highDetailGeometry = SphereGeometry(2, 64, 64)
    val highDetailMesh     = Mesh(highDetailGeometry, MeshPhongMaterial(color = 0x44ff44))
    lod.addLevel(highDetailMesh, 0) // Show when distance < 15

    // Medium detail mesh (medium distance)
    val mediumDetailGeometry = SphereGeometry(2, 32, 32)
    val mediumDetailMesh     = Mesh(mediumDetailGeometry, MeshPhongMaterial(color = 0xffaa00))
    lod.addLevel(mediumDetailMesh, 15) // Show when distance >= 15 and < 30

    // Low detail mesh (far distance)
    val lowDetailGeometry = SphereGeometry(2, 16, 16)
    val lowDetailMesh     = Mesh(lowDetailGeometry, MeshPhongMaterial(color = 0xff4444))
    lod.addLevel(lowDetailMesh, 30) // Show when distance >= 30

    scene.add(lod)

    // Add some other objects for reference
    val groundGeometry = PlaneGeometry(100, 100)
    val groundMesh     = Mesh(groundGeometry, MeshLambertMaterial(color = 0x333333))
    groundMesh.rotation.x = -scala.math.Pi / 2
    groundMesh.position.y = -10
    scene.add(groundMesh)

    // Add lighting
    val ambientLight = AmbientLight(0x404040, 0.4)
    scene.add(ambientLight)

    val directionalLight = DirectionalLight(0xffffff, 0.8)
    directionalLight.position.set(10, 10, 5)
    scene.add(directionalLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate the LOD object
      lod.position.x = scala.math.sin(time * 0.5) * 20
      lod.position.z = scala.math.cos(time * 0.5) * 20
      lod.rotation.y = time * 0.3

      // Update LOD based on camera distance
      lod.update(camera)

      // Show current LOD level in console for debugging
      val currentLevel = lod.getCurrentLevel()
      val dx           = camera.position.x.getOrElse(0.0) - lod.position.x.getOrElse(0.0)
      val dy           = camera.position.y.getOrElse(0.0) - lod.position.y.getOrElse(0.0)
      val dz           = camera.position.z.getOrElse(0.0) - lod.position.z.getOrElse(0.0)
      val distance     = scala.math.sqrt(dx * dx + dy * dy + dz * dz)
      println(s"Distance: $distance, Current LOD Level: $currentLevel")

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

    // Add instructions
    val instructions = div(
      styleAttr := "position: absolute; top: 10px; right: 10px; color: white; font-family: monospace;",
      p("Move the mouse to zoom in/out with camera"),
      p("Watch the sphere change detail levels based on distance"),
      p("Green = High detail (close)"),
      p("Orange = Medium detail (medium distance)"),
      p("Red = Low detail (far)")
    )

    // Append renderer to container
    val container = lodDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)
    container.appendChild(instructions.ref)

    lodDiv
