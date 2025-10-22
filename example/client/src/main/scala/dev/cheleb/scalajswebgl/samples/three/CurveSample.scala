package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*
import THREE.extras.curves.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.Pi

object CurveSample {

  def apply() =

    val curveDiv = div(
      h1("Curve Demo"),
      p("Demonstrating different curve types: CatmullRom, Bezier, Line, and Ellipse curves."),
      div(
        cls := "canvas-container"
      )
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

    // Create different curves

    // 1. CatmullRom curve
    val catmullPoints = js.Array(
      new Vector3(-5, 0, 0),
      new Vector3(-2, 2, 0),
      new Vector3(0, 0, 0),
      new Vector3(2, -2, 0),
      new Vector3(5, 0, 0)
    )
    val catmullCurve       = new CatmullRomCurve3(catmullPoints, closed = true)
    val catmullPointsArray = catmullCurve.getPoints(50)
    val catmullGeometry    = BufferGeometry().setFromPoints(catmullPointsArray.asInstanceOf[js.Array[Vector3]])
    val catmullMaterial    = LineBasicMaterial(js.Dynamic.literal(color = 0xff0000))
    val catmullLine        = Line(catmullGeometry, catmullMaterial)
    scene.add(catmullLine)

    // 2. Cubic Bezier curve
    val bezierCurve = new CubicBezierCurve3(
      new Vector3(-4, -3, 0),
      new Vector3(-2, -1, 0),
      new Vector3(2, -1, 0),
      new Vector3(4, -3, 0)
    )
    val bezierPointsArray = bezierCurve.getPoints(50)
    val bezierGeometry    = BufferGeometry().setFromPoints(bezierPointsArray.asInstanceOf[js.Array[Vector3]])
    val bezierMaterial    = LineBasicMaterial(js.Dynamic.literal(color = 0x00ff00))
    val bezierLine        = Line(bezierGeometry, bezierMaterial)
    scene.add(bezierLine)

    // 3. Quadratic Bezier curve
    val quadBezierCurve = new QuadraticBezierCurve3(
      new Vector3(-4, -5, 0),
      new Vector3(0, -3, 0),
      new Vector3(4, -5, 0)
    )
    val quadBezierPointsArray = quadBezierCurve.getPoints(50)
    val quadBezierGeometry    = BufferGeometry().setFromPoints(quadBezierPointsArray.asInstanceOf[js.Array[Vector3]])
    val quadBezierMaterial    = LineBasicMaterial(js.Dynamic.literal(color = 0x0000ff))
    val quadBezierLine        = Line(quadBezierGeometry, quadBezierMaterial)
    scene.add(quadBezierLine)

    // 4. Line curve
    val lineCurve = new LineCurve3(
      new Vector3(-6, 2, 0),
      new Vector3(6, 2, 0)
    )
    val linePointsArray = lineCurve.getPoints(2)
    val lineGeometry    = BufferGeometry().setFromPoints(linePointsArray.asInstanceOf[js.Array[Vector3]])
    val lineMaterial    = LineBasicMaterial(js.Dynamic.literal(color = 0xffff00))
    val lineLine        = Line(lineGeometry, lineMaterial)
    scene.add(lineLine)

    // 5. Ellipse curve (2D, but we'll display it in 3D space)
    val ellipseCurve       = new EllipseCurve(0, 3, 3, 2, 0, 2 * Pi, false, 0)
    val ellipsePointsArray = ellipseCurve.getPoints(50)
    val ellipseGeometry    = BufferGeometry().setFromPoints(ellipsePointsArray.asInstanceOf[js.Array[Vector3]])
    val ellipseMaterial    = LineBasicMaterial(js.Dynamic.literal(color = 0xff00ff))
    val ellipseLine        = Line(ellipseGeometry, ellipseMaterial)
    scene.add(ellipseLine)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate the entire scene slowly
      scene.rotation.y = time * 0.1

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
    curveDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    curveDiv
}
