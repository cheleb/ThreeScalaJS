package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.Pi

object LensFlareSample {

  def apply() =

    val lensFlareDiv = div(
      h1("Lens Flare Demo"),
      p("Demonstrating realistic lens flare effects with multiple flare elements, textures, and dynamic lighting."),
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
    renderer.setClearColor("#000511", 1)

    // Create a bright point light source for the lens flare
    val light = PointLight(0xffffff, 2, 100)
    light.position.set(0, 5, 0)
    scene.add(light)

    // Create lens flare
    val lensFlare = new Lensflare()

    // Create flare textures (using simple colored textures for demo)
    val flareTexture1 = CanvasTexture(createFlareTexture("#ffffff", 64, 64))
    val flareTexture2 = CanvasTexture(createFlareTexture("#ff4444", 128, 128))
    val flareTexture3 = CanvasTexture(createFlareTexture("#4444ff", 96, 96))
    val flareTexture4 = CanvasTexture(createFlareTexture("#44ff44", 80, 80))

    // Create flare elements with different properties
    val element1 = new LensflareElement(flareTexture1, 60, 0.1, new Color(0xffffff))
    val element2 = new LensflareElement(flareTexture2, 40, 0.3, new Color(0xff6666))
    val element3 = new LensflareElement(flareTexture3, 70, 0.5, new Color(0x6666ff))
    val element4 = new LensflareElement(flareTexture4, 20, 0.7, new Color(0x66ff66))
    val element5 = new LensflareElement(flareTexture1, 120, 0.9, new Color(0xffffff))

    // Add elements to the lens flare
    lensFlare.addElement(element1)
    lensFlare.addElement(element2)
    lensFlare.addElement(element3)
    lensFlare.addElement(element4)
    lensFlare.addElement(element5)

    // Position the lens flare at the light source
    lensFlare.position.x = light.position.x
    lensFlare.position.y = light.position.y
    lensFlare.position.z = light.position.z
    scene.add(lensFlare)

    // Create some geometry to catch the light and show shadows
    val sphereGeometry = SphereGeometry(1, 32, 32)
    val sphereMaterial = MeshPhongMaterial(color = 0x4444ff, shininess = 100)
    val sphere         = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(0, 0, 0)
    scene.add(sphere)

    // Create ground plane
    val groundGeometry = PlaneGeometry(20, 20)
    val groundMaterial = MeshLambertMaterial(color = 0x222233)
    val groundMesh     = new Mesh(groundGeometry, groundMaterial)
    groundMesh.rotation.x = -Pi / 2
    groundMesh.position.y = -3
    scene.add(groundMesh)

    // Add ambient lighting
    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    // Animation variables
    var time       = 0.0
    var lightAngle = 0.0

    // Animation loop
    val animate: () => Unit = () => {
      time += 0.02
      lightAngle += 0.01

      // Animate the light in a circular pattern
      light.position.x = scala.math.sin(lightAngle) * 8
      light.position.z = scala.math.cos(lightAngle) * 8
      light.position.y = 2 + scala.math.sin(time * 0.5) * 3

      // Update lens flare position to match light
      lensFlare.position.x = light.position.x
      lensFlare.position.y = light.position.y
      lensFlare.position.z = light.position.z

      // Rotate the sphere
      sphere.rotation.x = time * 0.5
      sphere.rotation.y = time * 0.3

      // Animate camera to follow the light
      camera.position.x = scala.math.sin(time * 0.2) * 12
      camera.position.z = scala.math.cos(time * 0.2) * 12
      camera.position.y = 2 + scala.math.sin(time * 0.3) * 2
      camera.lookAt(sphere.position)

      // Update lens flares (this calculates visibility and positioning)

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
      p("Lens Flare Demo"),
      p("• White light source with colored flare elements"),
      p("• Different sized elements at various distances"),
      p("• Camera orbits to show flare from different angles"),
      p("• Lens flares appear when light is in view")
    )

    // Append renderer to container
    val container = lensFlareDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)
    container.appendChild(instructions.ref)

    lensFlareDiv

  /**
   * Creates a simple circular flare texture on a canvas
   */
  private def createFlareTexture(color: String, width: Int, height: Int): dom.HTMLCanvasElement = {
    val canvas = dom.document.createElement("canvas").asInstanceOf[dom.HTMLCanvasElement]
    canvas.width = width
    canvas.height = height

    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

    // Create radial gradient for the flare
    val gradient = ctx.createRadialGradient(width / 2, height / 2, 0, width / 2, height / 2, width / 2)
    gradient.addColorStop(0, color + "ff")
    gradient.addColorStop(0.3, color + "88")
    gradient.addColorStop(0.6, color + "22")
    gradient.addColorStop(1, color + "00")

    ctx.fillStyle = gradient
    ctx.beginPath()
    ctx.arc(width / 2, height / 2, width / 2, 0, 2 * Pi)
    ctx.fill()

    canvas
  }
}
