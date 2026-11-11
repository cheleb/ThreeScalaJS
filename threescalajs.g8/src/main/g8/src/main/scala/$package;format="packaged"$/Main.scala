package $package$

import scala.scalajs.js

import org.scalajs.dom

import THREE.*

/**
 * Entry point: a lit, rotating cube that you can orbit with the mouse.
 */
object Main:

  def main(args: Array[String]): Unit =
    Option(dom.document.getElementById("app"))
      .fold(dom.console.error("#app element not found"))(start)

  private def start(container: dom.Element): Unit =
    val scene    = new Scene()
    val camera   = makeCamera()
    val renderer = makeRenderer()
    container.appendChild(renderer.domElement)

    val cube = makeCube()
    scene.add(cube)
    addLights(scene)

    val controls = new OrbitControls(camera, renderer.domElement)
    controls.enableDamping = true

    dom.window.addEventListener("resize", (_: dom.Event) => onResize(camera, renderer))
    animate(cube, controls, renderer, scene, camera)

  private def aspectRatio(): Double = dom.window.innerWidth / dom.window.innerHeight

  private def makeCamera(): PerspectiveCamera =
    val camera = new PerspectiveCamera(fov = 75, aspect = aspectRatio(), near = 0.1, far = 1000)
    camera.position.set(2, 2, 3)
    camera

  private def makeRenderer(): WebGLRenderer =
    val renderer = WebGLRenderer(antialias = true)
    renderer.setPixelRatio(dom.window.devicePixelRatio)
    renderer.setSize(dom.window.innerWidth, dom.window.innerHeight)
    renderer.setClearColor(0x101018)
    renderer

  private def makeCube(): Mesh =
    new Mesh(
      new BoxGeometry(1, 1, 1),
      new MeshStandardMaterial(js.Dynamic.literal(color = 0xdc322f, roughness = 0.4, metalness = 0.1))
    )

  private def addLights(scene: Scene): Unit =
    val sun = new DirectionalLight(0xffffff, 2.5)
    sun.position.set(5, 10, 7)
    scene.add(sun, new AmbientLight(0xffffff, 0.4))

  private def onResize(camera: PerspectiveCamera, renderer: WebGLRenderer): Unit =
    camera.aspect = aspectRatio()
    camera.updateProjectionMatrix()
    renderer.setSize(dom.window.innerWidth, dom.window.innerHeight)

  private def animate(
    cube: Mesh,
    controls: OrbitControls,
    renderer: WebGLRenderer,
    scene: Scene,
    camera: PerspectiveCamera
  ): Unit =
    renderer.setAnimationLoop { () =>
      cube.rotation.x += 0.01
      cube.rotation.y += 0.01
      controls.update()
      renderer.render(scene, camera)
    }
