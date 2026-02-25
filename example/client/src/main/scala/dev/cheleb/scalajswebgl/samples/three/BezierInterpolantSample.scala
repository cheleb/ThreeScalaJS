package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.scalajs.js.typedarray.Float32Array

object BezierInterpolantSample {

  def apply() =

    val sampleDiv = div(
      h1("Bezier Interpolant Demo"),
      p(
        "Comparing BezierInterpolant (green) with LinearInterpolant (yellow) and CubicInterpolant (cyan). ",
        "Keyframe positions are shown as red spheres."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(60, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(5, 3, 8)
    camera.lookAt(5, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Orbit controls
    val controls = OrbitControls(camera, renderer.domElement)
    controls.target.set(5, 0, 0)
    controls.update()

    // Define keyframes: 5 keyframes with time and value
    val times  = new Float32Array(js.Array[Float](0.0f, 2.0f, 4.0f, 7.0f, 10.0f))
    val values = new Float32Array(js.Array[Float](0.0f, 3.0f, -1.0f, 2.0f, 0.0f))

    // Define Bezier tangent control points (2D: time, value pairs)
    // For each keyframe and each component (stride=1), we have 2 values: (time, value)
    // Total: 5 keyframes * 1 component * 2 = 10 values per tangent array
    val outTangents = new Float32Array(
      js.Array[Float](
        0.5f, 1.0f,  // keyframe 0 out-tangent
        2.5f, 4.0f,  // keyframe 1 out-tangent
        5.0f, -1.0f, // keyframe 2 out-tangent
        8.0f, 3.0f,  // keyframe 3 out-tangent
        10.5f, 0.0f  // keyframe 4 out-tangent (unused, last keyframe)
      )
    )
    val inTangents = new Float32Array(
      js.Array[Float](
        -0.5f, 0.0f, // keyframe 0 in-tangent (unused, first keyframe)
        1.5f, 2.0f,  // keyframe 1 in-tangent
        3.5f, 0.0f,  // keyframe 2 in-tangent
        6.0f, 1.0f,  // keyframe 3 in-tangent
        9.5f, -0.5f  // keyframe 4 in-tangent
      )
    )

    // Create BezierInterpolant
    val bezierInterpolant = new BezierInterpolant(times, values, 1)
    bezierInterpolant.settings = js.Dynamic.literal(
      inTangents = inTangents,
      outTangents = outTangents
    )

    // Create LinearInterpolant for comparison
    val linearInterpolant = new LinearInterpolant(times, values, 1)

    // Create CubicInterpolant for comparison
    val cubicInterpolant = new CubicInterpolant(times, values, 1)

    // Sample the interpolants at many points
    val numSamples = 200
    val tMin       = 0.0
    val tMax       = 10.0

    val bezierPoints = js.Array[Vector3]()
    val linearPoints = js.Array[Vector3]()
    val cubicPoints  = js.Array[Vector3]()

    for (i <- 0 until numSamples) {
      val t = tMin + (tMax - tMin) * i.toDouble / (numSamples - 1)

      val bezierResult = bezierInterpolant.evaluate(t)
      bezierPoints.push(new Vector3(t, bezierResult(0).asInstanceOf[Double], 0))

      val linearResult = linearInterpolant.evaluate(t)
      linearPoints.push(new Vector3(t, linearResult(0).asInstanceOf[Double], 0))

      val cubicResult = cubicInterpolant.evaluate(t)
      cubicPoints.push(new Vector3(t, cubicResult(0).asInstanceOf[Double], 0))
    }

    // Draw Bezier curve (green)
    val bezierGeometry = BufferGeometry().setFromPoints(bezierPoints)
    val bezierMaterial = LineBasicMaterial(js.Dynamic.literal(color = 0x00ff00))
    val bezierLine     = Line(bezierGeometry, bezierMaterial)
    scene.add(bezierLine)

    // Draw Linear curve (yellow)
    val linearGeometry = BufferGeometry().setFromPoints(linearPoints)
    val linearMaterial = LineBasicMaterial(js.Dynamic.literal(color = 0xffff00))
    val linearLine     = Line(linearGeometry, linearMaterial)
    scene.add(linearLine)

    // Draw Cubic curve (cyan)
    val cubicGeometry = BufferGeometry().setFromPoints(cubicPoints)
    val cubicMaterial = LineBasicMaterial(js.Dynamic.literal(color = 0x00ffff))
    val cubicLine     = Line(cubicGeometry, cubicMaterial)
    scene.add(cubicLine)

    // Draw keyframe markers (red spheres)
    for (i <- 0 until times.length) {
      val sphereGeometry = new SphereGeometry(0.1, 16, 8)
      val sphereMaterial = MeshPhongMaterial(color = 0xff0000)
      val sphere         = new Mesh(sphereGeometry, sphereMaterial)
      sphere.position.set(times(i), values(i), 0)
      scene.add(sphere)
    }

    // Draw a baseline grid line at y=0
    val baselinePoints = js.Array(new Vector3(tMin, 0, 0), new Vector3(tMax, 0, 0))
    val baselineGeo    = BufferGeometry().setFromPoints(baselinePoints)
    val baselineMat    = LineBasicMaterial(js.Dynamic.literal(color = 0x444444))
    val baselineLine   = Line(baselineGeo, baselineMat)
    scene.add(baselineLine)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Add grid helper for reference
    val gridHelper = GridHelper(20, 20)
    gridHelper.rotation.x = scala.math.Pi / 2
    gridHelper.position.set(5, 0, 0)
    scene.add(gridHelper)

    // Animation loop
    val animate: () => Unit = () => {
      controls.update()
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
    sampleDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    sampleDiv
}
