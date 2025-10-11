package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import scala.math._

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object LatheSample {

  def apply() =

    val latheDiv = div(
      h1("LatheGeometry Demo"),
      p("Demonstrating rotationally symmetric shapes created by rotating 2D profiles around the Y-axis."),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 12

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create different lathe geometries

    // 1. Classic vase shape
    val vasePoints = js.Array[Vector2](
      new Vector2(0, -2),   // bottom
      new Vector2(1, -1.8), // curve start
      new Vector2(1.2, -1),
      new Vector2(1, -0.2),
      new Vector2(1.5, 0.5), // widest point
      new Vector2(1.2, 1.2),
      new Vector2(1, 1.8),
      new Vector2(0.8, 2.2), // neck
      new Vector2(0.5, 2.5)  // top
    )

    val vaseGeometry = new LatheGeometry(vasePoints, segments = 32)
    val vaseMaterial = MeshPhongMaterial(
      color = 0x88ccff,
      shininess = 100,
      specular = 0x111111
    )
    val vase = new Mesh(vaseGeometry, vaseMaterial)
    vase.position.x = -6
    scene.add(vase)

    // 2. Bowl shape
    val bowlPoints = js.Array[Vector2](
      new Vector2(0, 0), // center bottom
      new Vector2(0.5, 0.2),
      new Vector2(1.5, 0.5),
      new Vector2(2, 1),
      new Vector2(2.2, 1.5),
      new Vector2(2, 2),
      new Vector2(1.8, 2.5),
      new Vector2(1.2, 2.8),
      new Vector2(0.8, 3) // rim
    )

    val bowlGeometry = new LatheGeometry(bowlPoints, segments = 24)
    val bowlMaterial = MeshPhongMaterial(
      color = 0xff8844,
      shininess = 80
    )
    val bowl = new Mesh(bowlGeometry, bowlMaterial)
    bowl.position.x = -2
    scene.add(bowl)

    // 3. Wine glass shape
    val wineGlassPoints = js.Array[Vector2](
      new Vector2(0, -0.5), // base bottom
      new Vector2(0.3, -0.3),
      new Vector2(0.5, 0),
      new Vector2(0.8, 0.5), // base top
      new Vector2(0.2, 0.8), // stem start
      new Vector2(0.2, 2.5), // stem
      new Vector2(0.8, 2.8), // bowl start
      new Vector2(1.2, 3),
      new Vector2(1.5, 3.2),
      new Vector2(1.8, 3.4),
      new Vector2(1.5, 3.6),
      new Vector2(1.2, 3.8),
      new Vector2(0.8, 4) // rim
    )

    val wineGlassGeometry = new LatheGeometry(wineGlassPoints, segments = 32)
    val wineGlassMaterial = new MeshPhongMaterial(
      js.Dynamic.literal(
        color = 0xffdddd,
        shininess = 120,
        transparent = true,
        opacity = 0.8
      )
    )
    val wineGlass = new Mesh(wineGlassGeometry, wineGlassMaterial)
    wineGlass.position.x = 2
    scene.add(wineGlass)

    // 4. Decorative pedestal
    val pedestalPoints = js.Array[Vector2](
      new Vector2(0, 0), // bottom
      new Vector2(1, 0.2),
      new Vector2(1.2, 0.5),
      new Vector2(1, 1),
      new Vector2(1.5, 1.5), // main body
      new Vector2(1.2, 2),
      new Vector2(1.8, 2.5),
      new Vector2(1.5, 3),
      new Vector2(1.8, 3.5),
      new Vector2(1.2, 3.8),
      new Vector2(1.5, 4),
      new Vector2(1.2, 4.2),
      new Vector2(1, 4.5),
      new Vector2(0.8, 4.8) // top
    )

    val pedestalGeometry = new LatheGeometry(pedestalPoints, segments = 20)
    val pedestalMaterial = MeshPhongMaterial(
      color = 0x44ff88,
      shininess = 60
    )
    val pedestal = new Mesh(pedestalGeometry, pedestalMaterial)
    pedestal.position.x = 6
    scene.add(pedestal)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects at different speeds
      vase.rotation.y = time * 0.3

      bowl.rotation.y = time * 0.5
      bowl.rotation.x = sin(time * 0.7) * 0.1

      wineGlass.rotation.y = time * 0.4

      pedestal.rotation.y = time * 0.2
      pedestal.rotation.x = sin(time * 0.3) * 0.05

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
    latheDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    latheDiv
}
