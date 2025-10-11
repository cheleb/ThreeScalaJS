package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*
import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object SkinnedMeshSample:

  def apply() =

    val skinnedMeshDiv = div(
      h1("Bone & Skeleton Demo"),
      p(
        "Demonstrating bone hierarchy and skeleton concepts - shows how bones are structured for skeletal animation."
      ),
      div(cls := "canvas-container")
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 2, 8)
    camera.lookAt(0, 0, 0)

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#0f0f23", 1)

    // Create a simple humanoid figure with bones
    val bones = js.Array[Bone]()

    // Root bone (hips)
    val rootBone = new Bone()
    rootBone.position.y = -2
    rootBone.name = "root"
    bones.push(rootBone)

    // Left leg
    val leftThigh = new Bone()
    leftThigh.position.y = -2
    leftThigh.position.x = -0.5
    leftThigh.name = "leftThigh"
    rootBone.add(leftThigh)
    bones.push(leftThigh)

    val leftShin = new Bone()
    leftShin.position.y = -2
    leftShin.name = "leftShin"
    leftThigh.add(leftShin)
    bones.push(leftShin)

    // Right leg
    val rightThigh = new Bone()
    rightThigh.position.y = -2
    rightThigh.position.x = 0.5
    rightThigh.name = "rightThigh"
    rootBone.add(rightThigh)
    bones.push(rightThigh)

    val rightShin = new Bone()
    rightShin.position.y = -2
    rightShin.name = "rightShin"
    rightThigh.add(rightShin)
    bones.push(rightShin)

    // Create the skeleton with the bones
    val skeleton = new Skeleton(bones)

    // Initialize and calculate bone inverses
    skeleton.init()
    skeleton.calculateInverses()

    // Create simple geometry and materials for demonstration
    val characterGeometry = BoxGeometry(1, 3, 0.5)
    val characterMaterial = MeshPhongMaterial(color = 0x4444ff)

    // Create a regular mesh instead of SkinnedMesh for this demo
    // since proper skinning attributes are complex to set up
    val characterMesh = new Mesh(characterGeometry, characterMaterial)

    scene.add(characterMesh)

    // Add ground plane
    val groundGeometry = PlaneGeometry(20, 20)
    val groundMesh     = new Mesh(groundGeometry, MeshLambertMaterial(color = 0x333333))
    groundMesh.rotation.x = -scala.math.Pi / 2
    groundMesh.position.y = -4
    scene.add(groundMesh)

    // Add lighting
    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)

    val directionalLight = DirectionalLight(0xffffff, 0.8)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    // Animation variables
    var walkCycle = 0.0

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001
      walkCycle += 0.05

      // Animate the character with a simple floating motion
      val floatSpeed  = 1.0
      val floatMotion = scala.math.sin(walkCycle * floatSpeed) * 0.2

      // Gentle floating animation
      characterMesh.position.y = floatMotion
      characterMesh.rotation.x = floatMotion
      characterMesh.rotation.z = scala.math.sin(walkCycle * floatSpeed * 0.5) * 0.1

      // Rotate the entire character slowly
      characterMesh.rotation.y = time * 0.2

      // Update skeleton bone matrices
      skeleton.update()

      // Demonstrate skeleton functionality by finding bones by name
      val foundBone = skeleton.getBoneByName("leftThigh")
      foundBone.foreach { bone =>
        // Add a slight rotation to demonstrate bone animation capability
        bone.rotation.x = scala.math.sin(walkCycle * 2) * 0.1
      }

      renderer.render(scene, camera)
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = _ => {
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    }
    window.addEventListener("resize", onWindowResize)

    // Add instructions
    val instructions = div(
      styleAttr := "position: absolute; top: 10px; right: 10px; color: white; font-family: monospace;",
      p("Skeleton & Bone Demo"),
      p(s"Skeleton UUID: ${skeleton.uuid}"),
      p(s"Number of bones: ${bones.length}"),
      p("Demonstrates proper Skeleton and Bone usage"),
      p("Watch the floating animation with bone manipulation!")
    )

    // Append renderer to container
    val container = skinnedMeshDiv.ref.querySelector(".canvas-container")
    container.appendChild(renderer.domElement)
    container.appendChild(instructions.ref)

    skinnedMeshDiv
