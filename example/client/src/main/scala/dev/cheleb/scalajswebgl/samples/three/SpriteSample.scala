package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.Pi

object SpriteSample {

  def apply() =

    val spriteDiv = div(
      h1("Sprite Demo"),
      p("Demonstrating billboard sprites that always face the camera with various materials and animations."),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 2, 8)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0f0f23", 1)

    // Create sprite materials
    val spriteMaterial1 = new SpriteMaterial()
    spriteMaterial1.color = new Color(0xff4444)
    spriteMaterial1.sizeAttenuation = true

    val spriteMaterial2 = new SpriteMaterial()
    spriteMaterial2.color = new Color(0x44ff44)
    spriteMaterial2.sizeAttenuation = false

    val spriteMaterial3 = new SpriteMaterial()
    spriteMaterial3.color = new Color(0x4444ff)
    spriteMaterial3.sizeAttenuation = true

    // Create sprites
    val sprite1 = new Sprite(spriteMaterial1)
    sprite1.position.set(-3, 1, 0)
    sprite1.scale.set(2, 2, 1)
    scene.add(sprite1)

    val sprite2 = new Sprite(spriteMaterial2)
    sprite2.position.set(0, 1, 0)
    sprite2.scale.set(1.5, 1.5, 1)
    scene.add(sprite2)

    val sprite3 = new Sprite(spriteMaterial3)
    sprite3.position.set(3, 1, 0)
    sprite3.scale.set(2.5, 2.5, 1)
    scene.add(sprite3)

    // Create ground plane for reference
    val groundGeometry = PlaneGeometry(20, 20)
    val groundMaterial = MeshLambertMaterial(color = 0x333333)
    val groundMesh     = new Mesh(groundGeometry, groundMaterial)
    groundMesh.rotation.x = -Pi / 2
    groundMesh.position.y = -2
    scene.add(groundMesh)

    // Add lighting
    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    val directionalLight = DirectionalLight(0xffffff, 0.8)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    // Animation variables
    var time = 0.0

    // Animation loop
    val animate: () => Unit = () => {
      time += 0.02

      // Animate sprites in circular patterns
      sprite1.position.x = -3 + scala.math.sin(time) * 2
      sprite1.position.z = scala.math.cos(time) * 2
      sprite1.rotation.z = time * 0.5

      sprite2.position.x = scala.math.sin(time * 1.3) * 2.5
      sprite2.position.z = scala.math.cos(time * 1.3) * 2.5
      sprite2.rotation.z = -time * 0.7

      sprite3.position.x = 3 + scala.math.sin(time * 0.8) * 1.5
      sprite3.position.z = scala.math.cos(time * 0.8) * 1.5
      sprite3.rotation.z = time * 0.3

      // Rotate camera around the scene
      camera.position.x = scala.math.sin(time * 0.2) * 10
      camera.position.z = scala.math.cos(time * 0.2) * 10
      camera.lookAt(0, 0, 0)

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

    // Add instructions
    val instructions = div(
      styleAttr := "position: absolute; top: 10px; right: 10px; color: white; font-family: monospace;",
      p("Sprite Billboard Demo"),
      p("Red: Size attenuation ON (gets smaller with distance)"),
      p("Green: Size attenuation OFF (constant size)"),
      p("Blue: Size attenuation ON with different scale"),
      p("Sprites always face the camera!"),
      p("Camera orbits around the scene")
    )

    // Append renderer to container
    val container = spriteDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)
    container.appendChild(instructions.ref)

    spriteDiv
}
