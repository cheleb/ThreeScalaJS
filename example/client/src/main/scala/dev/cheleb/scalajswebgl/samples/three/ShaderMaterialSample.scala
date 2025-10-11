package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object ShaderMaterialSample:

  def apply() =

    val shaderDiv = div(
      h1("ShaderMaterial Demo"),
      p(
        "Demonstrating ShaderMaterial - a material rendered with custom GLSL shaders for advanced visual effects."
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
    val geometry = PlaneGeometry(4, 4, 32, 32)

    // Vertex shader - passes through position and UV coordinates
    val vertexShader =
      """
      varying vec2 vUv;
      varying vec3 vPosition;

      void main() {
        vUv = uv;
        vPosition = position;
        gl_Position = projectionMatrix * modelViewMatrix * vec4(position, 1.0);
      }
      """

    // Fragment shader - creates animated, colorful pattern
    val fragmentShader =
      """
      uniform float time;
      uniform vec2 resolution;
      varying vec2 vUv;
      varying vec3 vPosition;

      void main() {
        vec2 uv = vUv;

        // Create animated waves
        float wave1 = sin(uv.x * 4.0 + time) * 0.5 + 0.5;
        float wave2 = cos(uv.y * 3.0 + time * 1.2) * 0.5 + 0.5;
        float wave3 = sin(length(uv - 0.5) * 8.0 - time * 0.8) * 0.5 + 0.5;

        // Mix colors based on waves
        vec3 color1 = vec3(1.0, 0.2, 0.4); // Pink
        vec3 color2 = vec3(0.2, 0.8, 1.0); // Cyan
        vec3 color3 = vec3(1.0, 0.8, 0.2); // Yellow

        vec3 finalColor = mix(color1, color2, wave1);
        finalColor = mix(finalColor, color3, wave2 * wave3);

        // Add some sparkle effect
        float sparkle = sin(uv.x * 20.0 + time * 3.0) * sin(uv.y * 15.0 + time * 2.0);
        sparkle = smoothstep(0.8, 1.0, sparkle);

        finalColor += sparkle * vec3(1.0, 1.0, 1.0) * 0.3;

        gl_FragColor = vec4(finalColor, 1.0);
      }
      """

    // Create uniforms for the shader
    val uniforms = js.Dynamic.literal(
      time = js.Dynamic.literal(value = 0.0),
      resolution = js.Dynamic.literal(value = new Vector2(window.innerWidth, window.innerHeight))
    )

    // Create the shader material
    val material = ShaderMaterial(
      uniforms = uniforms,
      vertexShader = vertexShader,
      fragmentShader = fragmentShader,
      fog = false,
      lights = false
    )

    // Create mesh
    val mesh = Mesh(geometry, material)
    scene.add(mesh)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Update uniform
      uniforms.time.value = time

      // Rotate the mesh slowly
      mesh.rotation.z = time * 0.2

      renderer.render(scene, camera)
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = _ => {
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)

      // Update resolution uniform
      uniforms.resolution.value = new Vector2(window.innerWidth, window.innerHeight)
    }
    window.addEventListener("resize", onWindowResize)

    // Append renderer to container
    val container = shaderDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)

    shaderDiv
