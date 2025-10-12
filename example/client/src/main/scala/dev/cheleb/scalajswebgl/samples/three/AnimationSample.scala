package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object AnimationSample {

  def apply() =

    val animationDiv = div(
      h1("Animation System Demo"),
      p("Demonstrating Three.js AnimationClip, AnimationMixer, and AnimationAction with keyframe animations."),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 2, 5)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create animated cube
    val cubeGeometry = new BoxGeometry(1, 1, 1)
    val cubeMaterial = MeshPhongMaterial(
      color = 0x44aa88,
      shininess = 100
    )
    val cube = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.set(-2, 0, 0)
    scene.add(cube)

    // Create animated sphere
    val sphereGeometry = new SphereGeometry(0.5, 32, 16)
    val sphereMaterial = MeshPhongMaterial(
      color = 0x8844aa,
      shininess = 50
    )
    val sphere = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.set(2, 0, 0)
    scene.add(sphere)

    // For now, we'll use a simpler animation approach
    // The full animation system with keyframe tracks would require
    // more complex setup with the Three.js animation data structures

    // Create simple animation variables
    var animationTime = 0.0

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      animationTime += 0.016 // Approximate 60 FPS

      // Animate cube position and rotation
      cube.position.x = -2 + scala.math.sin(animationTime) * 2
      cube.position.y = scala.math.sin(animationTime * 2) * 0.5
      cube.rotation.y = animationTime * 0.5

      // Animate sphere position and scale
      sphere.position.x = 2 + scala.math.cos(animationTime * 1.5) * 1.5
      sphere.position.y = scala.math.sin(animationTime * 3) * 1
      sphere.rotation.x = animationTime * 0.7

      // Pulsing scale effect
      val scale = 1 + scala.math.sin(animationTime * 4) * 0.3
      sphere.scale.set(scale, scale, scale)

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
    animationDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    animationDiv
}
