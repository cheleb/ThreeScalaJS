package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object SkeletonHelperSample {

  def apply() =

    val skeletonHelperDiv = div(
      h1("SkeletonHelper Demo"),
      p(
        "Demonstrating the SkeletonHelper for visualizing bone structures. The helper shows the skeleton hierarchy and bone positions as lines connecting the bones."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(5, 5, 5)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create bones for the skeleton
    val shoulder = new Bone()
    shoulder.position.y = -5

    val elbow = new Bone()
    elbow.position.y = 5

    val hand = new Bone()
    hand.position.y = 3

    // Build hierarchy
    shoulder.add(elbow)
    elbow.add(hand)

    // Create a simple object to hold the bones (no skinning required for helper)
    val boneContainer = new Object3D()
    boneContainer.add(shoulder)
    boneContainer.position.set(0, 0, 0)
    scene.add(boneContainer)

    // Create skeleton helper to visualize the bones
    val skeletonHelper = new SkeletonHelper(boneContainer)
    scene.add(skeletonHelper)

    // Add some additional objects for reference
    val referenceCube = new Mesh(
      new BoxGeometry(0.5, 0.5, 0.5),
      MeshLambertMaterial(color = 0xff4444)
    )
    referenceCube.position.set(3, 0, 0)
    scene.add(referenceCube)

    // Add lighting
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Animate the bones
      shoulder.rotation.x = scala.math.sin(time) * 0.3
      elbow.rotation.x = scala.math.sin(time * 0.8) * 0.5
      hand.rotation.x = scala.math.sin(time * 1.2) * 0.7

      // Rotate the bone container
      boneContainer.rotation.y = time * 0.2

      // Rotate reference cube
      referenceCube.rotation.x = time * 0.5
      referenceCube.rotation.y = time * 0.3

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
    skeletonHelperDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    skeletonHelperDiv
}
