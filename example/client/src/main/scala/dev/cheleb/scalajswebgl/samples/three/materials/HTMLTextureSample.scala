package dev.cheleb.scalajswebgl.samples.three.materials

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.math.sin

@js.native
@JSImport("three-html-render/polyfill", JSImport.Namespace)
object HtmlInCanvasPolyfill extends js.Object {
  def installHtmlInCanvasPolyfill(): Unit = js.native
}

object HTMLTextureSample {

  def apply() =

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

    // Install the polyfill if native HTML-in-Canvas API is not available
    if (!js.Dynamic.global.HTMLCanvasElement.prototype.hasOwnProperty("requestPaint").asInstanceOf[Boolean]) {
      HtmlInCanvasPolyfill.installHtmlInCanvasPolyfill()
    }

    // Create the HTML element that will be used as a texture source
    val htmlSource = dom.document.createElement("div").asInstanceOf[dom.html.Div]
    htmlSource.id = "draw_element"
    htmlSource.style.width = "512px"
    htmlSource.style.background = "linear-gradient(135deg, #667eea 0%, #764ba2 100%)"
    htmlSource.style.color = "white"
    htmlSource.style.fontFamily = "Arial, sans-serif"
    htmlSource.style.fontSize = "24px"
    htmlSource.style.setProperty("line-height", "1.5")
    htmlSource.style.setProperty("text-align", "center")
    htmlSource.style.padding = "30px"
    htmlSource.innerHTML =
      """<div>
        |  <h2 style="margin:0 0 12px 0">HTMLTexture</h2>
        |  <p style="margin:0;font-size:18px" id="timer">Time: 0.0s</p>
        |  <div style="margin-top:16px;width:80%;height:16px;background:rgba(255,255,255,0.3);border-radius:8px;overflow:hidden;display:inline-block">
        |    <div id="fill" style="width:0%;height:100%;background:white;border-radius:8px"></div>
        |  </div>
        |  <p style="margin-top:12px;font-size:16px">Live HTML on 3D mesh!</p>
        |</div>""".stripMargin

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(50, window.innerWidth / window.innerHeight, 0.1, 2000)
    camera.position.z = 8

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#aaaaaa", 1)

    // Pre-setup: attach the HTML element to the canvas and trigger an initial paint
    // before the renderer tries to use the texture. This ensures the polyfill has
    // completed at least one snapshot before texElementImage2D is called.
    val canvas = renderer.domElement
    canvas.asInstanceOf[js.Dynamic].setAttribute("layoutsubtree", "true")
    canvas.appendChild(htmlSource)
    canvas.asInstanceOf[js.Dynamic].requestPaint()

    // Create the HTMLTexture from the div element
    val htmlTexture = new HTMLTexture(htmlSource)

    // --- Object 1: Rotating cube with HTMLTexture ---
    val cubeGeometry = new BoxGeometry(2.5, 2.5, 2.5)
    val cubeMaterial = MeshStandardMaterial(
      roughness = 0.2,
      metalness = 0.3
    )
    cubeMaterial.map = htmlTexture
    val cube = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.x = -3
    scene.add(cube)

    // --- Object 2: Sphere with HTMLTexture ---
    val sphereGeometry = new SphereGeometry(1.5, 32, 32)
    val sphereMaterial = MeshStandardMaterial(
      roughness = 0.1,
      metalness = 0.4
    )
    sphereMaterial.map = htmlTexture
    val sphere = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.x = 3
    scene.add(sphere)

    // --- Object 3: Plane showing the texture flat ---
    val planeGeometry = new PlaneGeometry(3, 3)
    val planeMaterial = MeshBasicMaterial(map = htmlTexture)
    val plane         = new Mesh(planeGeometry, planeMaterial)
    plane.position.set(0, -3, 0)
    plane.rotation.x = -0.4
    scene.add(plane)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 2.0)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val directionalLight2 = DirectionalLight(0xffffff, 1.0)
    directionalLight2.position.set(-5, 3, -3)
    scene.add(directionalLight2)

    val ambientLight = AmbientLight(0xffffff, 1.5)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects
      cube.rotation.x = sin(time * 0.5) * 0.5
      cube.rotation.y = time * 0.4

      sphere.rotation.y = time * 0.3

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

      renderer.render(scene, camera)
    }

    // Defer the animation loop start to allow the polyfill to complete
    // its first requestPaint() + rAF snapshot cycle.
    window.requestAnimationFrame { _ =>
      window.requestAnimationFrame { _ =>
        renderer.setAnimationLoop(animate)
      }
    }

    // Handle window resize
    val onWindowResize: dom.Event => Unit = { _ =>
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    }
    window.addEventListener("resize", onWindowResize)

    // Append renderer to the canvas container
    htmlTextureDiv.ref.querySelector(".canvas-container").appendChild(canvas)

    htmlTextureDiv
}
