package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.Pi

object MeshNormalMaterialSample {

  def apply() =

    val normalDiv = div(
      h1("MeshNormalMaterial Demo"),
      p(
        "Demonstrating MeshNormalMaterial - a material that visualizes surface normals using color coding. Red shows X-axis direction, Green shows Y-axis direction, and Blue shows Z-axis direction. Perfect for debugging geometry and understanding surface orientation."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 12

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create different geometries with MeshNormalMaterial to show normal visualization

    // 1. Sphere with normal material (smooth normals)
    val sphereGeometry = new SphereGeometry(1.5, 32, 16)
    val sphereMaterial = MeshNormalMaterial()
    val sphere         = new Mesh(sphereGeometry, sphereMaterial)
    sphere.position.x = -6
    sphere.position.y = 3
    scene.add(sphere)

    // 2. Cube with normal material (flat normals)
    val cubeGeometry = new BoxGeometry(2, 2, 2)
    val cubeMaterial = MeshNormalMaterial()
    val cube         = new Mesh(cubeGeometry, cubeMaterial)
    cube.position.x = -2
    cube.position.y = 3
    scene.add(cube)

    // 3. Torus with normal material
    val torusGeometry = new TorusGeometry(1, 0.4, 16, 100)
    val torusMaterial = MeshNormalMaterial()
    val torus         = new Mesh(torusGeometry, torusMaterial)
    torus.position.x = 2
    torus.position.y = 3
    scene.add(torus)

    // 4. Cone with normal material
    val coneGeometry = new ConeGeometry(1.5, 3, 32)
    val coneMaterial = MeshNormalMaterial()
    val cone         = new Mesh(coneGeometry, coneMaterial)
    cone.position.x = 6
    cone.position.y = 3
    scene.add(cone)

    // 5. Plane with normal material (bottom row)
    val planeGeometry = new PlaneGeometry(4, 4, 10, 10)
    val planeMaterial = MeshNormalMaterial()
    val plane         = new Mesh(planeGeometry, planeMaterial)
    plane.position.y = -2
    plane.rotation.x = -Pi / 2
    scene.add(plane)

    // 6. Icosahedron with normal material
    val icosahedronGeometry = new IcosahedronGeometry(1.5)
    val icosahedronMaterial = MeshNormalMaterial()
    val icosahedron         = new Mesh(icosahedronGeometry, icosahedronMaterial)
    icosahedron.position.x = -4
    icosahedron.position.y = -2
    scene.add(icosahedron)

    // 7. Octahedron with normal material
    val octahedronGeometry = new OctahedronGeometry(1.5)
    val octahedronMaterial = MeshNormalMaterial()
    val octahedron         = new Mesh(octahedronGeometry, octahedronMaterial)
    octahedron.position.x = 0
    octahedron.position.y = -2
    scene.add(octahedron)

    // 8. Tetrahedron with normal material
    val tetrahedronGeometry = new TetrahedronGeometry(1.5)
    val tetrahedronMaterial = MeshNormalMaterial()
    val tetrahedron         = new Mesh(tetrahedronGeometry, tetrahedronMaterial)
    tetrahedron.position.x = 4
    tetrahedron.position.y = -2
    scene.add(tetrahedron)

    // Add some lighting to make the scene more interesting (normals are still visible)
    val directionalLight = DirectionalLight(0xffffff, 0.5)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate objects at different speeds to show normal changes
      sphere.rotation.x = time * 0.3
      sphere.rotation.y = time * 0.5

      cube.rotation.x = time * 0.4
      cube.rotation.y = time * 0.2

      torus.rotation.x = time * 0.6
      torus.rotation.z = time * 0.3

      cone.rotation.x = time * 0.5
      cone.rotation.y = time * 0.4

      plane.rotation.z = time * 0.1

      icosahedron.rotation.x = time * 0.3
      icosahedron.rotation.y = time * 0.6

      octahedron.rotation.x = time * 0.4
      octahedron.rotation.z = time * 0.5

      tetrahedron.rotation.y = time * 0.7
      tetrahedron.rotation.z = time * 0.3

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
    normalDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    normalDiv
}
