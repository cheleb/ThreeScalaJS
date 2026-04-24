package dev.cheleb.scalajswebgl.samples.three.materials

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.sin

object HTMLTextureSample {

  def apply() =

    // Create the HTML element that will be used as a texture source
    val htmlSource = dom.document.createElement("div").asInstanceOf[dom.html.Div]
    htmlSource.style.width = "256px"
    htmlSource.style.height = "256px"
    htmlSource.style.background = "linear-gradient(135deg, #667eea 0%, #764ba2 100%)"
    htmlSource.style.color = "white"
    htmlSource.style.fontFamily = "Arial, sans-serif"
    htmlSource.style.fontSize = "18px"
    htmlSource.style.display = "flex"
    htmlSource.style.setProperty("flex-direction", "column")
    htmlSource.style.setProperty("align-items", "center")
    htmlSource.style.setProperty("justify-content", "center")
    htmlSource.style.borderRadius = "8px"
    htmlSource.style.padding = "16px"
    htmlSource.style.boxSizing = "border-box"
    htmlSource.innerHTML =
      """<div style="text-align:center">
        |  <h3 style="margin:0 0 8px 0">HTMLTexture</h3>
        |  <p style="margin:0;font-size:14px" id="timer">Time: 0.0s</p>
        |  <div id="bar" style="margin-top:12px;width:80%;height:12px;background:rgba(255,255,255,0.3);border-radius:6px;overflow:hidden">
        |    <div id="fill" style="width:0%;height:100%;background:white;border-radius:6px;transition:width 0.1s"></div>
        |  </div>
        |</div>""".stripMargin

    val htmlTextureDiv = div(
      h1("HTMLTexture Demo"),
      p(
        "Demonstrating HTMLTexture: a live HTML element rendered as a texture on 3D objects. ",
        "The HTML content updates in real-time and is reflected on the mesh surfaces."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 6

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create the HTMLTexture from the div element
    val htmlTexture = new HTMLTexture(htmlSource)

    // --- Object 1: Rotating cube with HTMLTexture ---
    val cubeGeometry = new BoxGeometry(2, 2, 2)
    val cubeMaterial = MeshPhongMaterial(
      color = 0xffffff,
      shininess = 60,
      map = htmlTexture
    )
    val cube = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.x = -2.5
    scene.add(cube)

    // --- Object 2: Sphere with HTMLTexture ---
    val sphereGeometry = new SphereGeometry(1.3, 32, 32)
    val sphereMaterial = MeshPhongMaterial(
      color = 0xffffff,
      shininess = 80,
      map = htmlTexture
    )
    val sphere = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.x = 2.5
    scene.add(sphere)

    // --- Object 3: Plane showing the texture flat ---
    val planeGeometry = new PlaneGeometry(2.5, 2.5)
    val planeMaterial = MeshBasicMaterial(map = htmlTexture)
    val plane         = new Mesh(planeGeometry, planeMaterial)
    plane.position.set(0, -2.5, 0)
    plane.rotation.x = -0.3
    scene.add(plane)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1.5)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val directionalLight2 = DirectionalLight(0xffffff, 0.8)
    directionalLight2.position.set(-5, 3, -3)
    scene.add(directionalLight2)

    val ambientLight = AmbientLight(0xffffff, 1.0)
    scene.add(ambientLight)

    val pointLight = PointLight(0x4488ff, 1.2, 20)
    pointLight.position.set(-3, 3, 3)
    scene.add(pointLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects
      cube.rotation.x = time * 0.3
      cube.rotation.y = time * 0.5

      sphere.rotation.y = time * 0.4

      // Update the HTML content dynamically
      val timerEl = htmlSource.querySelector("#timer")
      if (timerEl != null) {
        val seconds = f"${time % 100}%.1f"
        timerEl.textContent = s"Time: ${seconds}s"
      }
      val fillEl = htmlSource.querySelector("#fill").asInstanceOf[dom.html.Div]
      if (fillEl != null) {
        val pct = ((sin(time * 0.5) + 1) * 50).toInt
        fillEl.style.width = s"$pct%"
      }

      // The HTMLTexture listens for paint events automatically,
      // but we can force an update if needed:
      htmlTexture.needsUpdate = true

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
    htmlTextureDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    htmlTextureDiv
}
