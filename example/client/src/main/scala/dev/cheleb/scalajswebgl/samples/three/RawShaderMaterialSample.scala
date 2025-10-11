package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object RawShaderMaterialSample:

  def apply() =

    val rawShaderDiv = div(
      h1("RawShaderMaterial Demo"),
      p(
        "Demonstrating RawShaderMaterial - similar to ShaderMaterial but without built-in uniforms and attributes."
      ),
      div(cls := "canvas-container")
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 5

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0f0f23", 1)

    // Create a simple plane geometry
    val geometry = PlaneGeometry(4, 4, 1, 1)

    // RawShaderMaterial vertex shader - define everything from scratch
    val vertexShader =
      """
      attribute vec3 position;
      attribute vec2 uv;

      uniform mat4 modelViewMatrix;
      uniform mat4 projectionMatrix;

      varying vec2 vUv;
      varying float vTime;

      void main() {
        vUv = uv;
        gl_Position = projectionMatrix * modelViewMatrix * vec4(position, 1.0);
      }
      """

    // RawShaderMaterial fragment shader - create animated pattern
    val fragmentShader =
      """
      precision mediump float;

      uniform float time;
      uniform vec2 resolution;

      varying vec2 vUv;

      void main() {
        vec2 uv = vUv;

        // Create a simple animated pattern
        float wave = sin(uv.x * 6.0 + time * 2.0) * cos(uv.y * 4.0 + time * 1.5);
        float pattern = smoothstep(-0.3, 0.3, wave);

        // Color based on pattern
        vec3 color1 = vec3(0.1, 0.8, 1.0); // Cyan
        vec3 color2 = vec3(1.0, 0.3, 0.7); // Magenta

        vec3 finalColor = mix(color1, color2, pattern);

        // Add some pulsing effect
        float pulse = sin(time * 3.0) * 0.3 + 0.7;
        finalColor *= pulse;

        gl_FragColor = vec4(finalColor, 1.0);
      }
      """

    // Create uniforms for the raw shader
    val uniforms = js.Dynamic.literal(
      time = 0.0,
      resolution = new Vector2(window.innerWidth, window.innerHeight)
    )

    // Create the raw shader material
    val material = RawShaderMaterial(
      uniforms = uniforms,
      vertexShader = vertexShader,
      fragmentShader = fragmentShader
    )

    // Create mesh
    val mesh = Mesh(geometry, material)
    scene.add(mesh)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Update uniform
      uniforms.time = time

      // Rotate the mesh slowly
      mesh.rotation.z = time * 0.3

      renderer.render(scene, camera)
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = _ => {
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)

      // Update resolution uniform
      uniforms.resolution = new Vector2(window.innerWidth, window.innerHeight)
    }
    window.addEventListener("resize", onWindowResize)

    // Append renderer to container
    val container = rawShaderDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    rawShaderDiv
