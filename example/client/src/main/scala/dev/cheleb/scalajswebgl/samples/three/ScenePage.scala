package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*

import org.scalajs.dom.window
import scala.scalajs.js
import scalajs.js.JSConverters.*

object ScenePage {

  val R = 1.0
  def apply() =

    val scalaCenterGroup = Var(Option.empty[Group])
    val scalaMesh        = Var(Option.empty[GLTFResult])
    val globeGroup       = new Group()

    def newPinner(location: LatLon): GLTFResult => Group = obj =>
      val pinnerGroup = new Group()
      val pinner      = obj.scene.jsClone(true)
      val (x, y, z)   = location.xyz(R + 0.02)
      pinner.position.set(x, y, z)
      pinner.lookAt(0, 0, 0)
      pinnerGroup.add(pinner)

      pinnerGroup.add(drawLine(x * 1.1, y * 1.1, z * 1.1))

      pinnerGroup

    val eartthDiv = div(
      h1("Scene 1"),
      label("ScalaCenter"),
      input(
        tpe := "checkbox",
        value <-- scalaCenterGroup.signal.map(_.isDefined).map {
          case false => "Show - ScalaCenter"
          case true  => "Hide ScalaSenter"
        },
        disabled <-- scalaMesh.signal.map(_.isEmpty),
        onClick.mapToChecked --> {
          case true =>
            println("add scalaCenter")
            scalaMesh.now().foreach { mesh =>
              println(s"add ${mesh.scene.id}")
              val pinner = newPinner(LatLon(46.5188, 6.5593))(mesh)
              globeGroup.add(pinner)
              scalaCenterGroup.set(Some(pinner)) // Lauzane
            }
          case false =>
            println("remove scalaCenter")
            scalaCenterGroup.now().foreach { group =>
              println(s"remove ${group.id}")
              val ll = globeGroup.remove(group)
              println("removed from group: " + ll.id)
            }
            scalaCenterGroup.set(None)
        }
      )
    )
    val scene = Scene()

    val detail        = 300
    val geometry      = new IcosahedronGeometry(R - 0.05, 10)
    val pointGeometry = new IcosahedronGeometry(R, detail);

    val material = MeshBasicMaterial(
      js.Dynamic.literal(
        color = 0x55ff55,
        wireframe = true
      )
    )
    val textureLoader = TextureLoader()
    val colorMap      = textureLoader.load("/ThreeScalaJS/demo/img/8081-earthmap10k.jpg")

    val pointMaterial = PointsMaterial(
      js.Dynamic.literal(color = 0xf0f8ff, size = 0.02, map = colorMap)
    )
    val points = Points(pointGeometry, pointMaterial)

    val earth = new Mesh(geometry, material);
    globeGroup.add(earth)
    globeGroup.add(points)

    scene.add(globeGroup)

    val camera = new PerspectiveCamera(30, window.innerWidth / window.innerHeight, 1, 100);

    camera.position.set(0, 0, 5)

    val renderer = new WebGLRenderer(
      js.Dynamic.literal(
        antialias = true,
        alpha = true
      )
    )
    renderer.setPixelRatio(window.devicePixelRatio)
    val orbitControl = OrbitControls(camera, renderer.domElement)

    renderer.setClearColor("#AAAAAA", 1)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)

    val loader = new GLTFLoader()

    loader.load(
      "/ThreeScalaJS/demo/res/scala.glb",
      obj => {
        scalaMesh.set(Some(obj)) // Lauzane
      }
    )

    val animate: () => Unit = () => {

      globeGroup.rotation.y += 0.0005;

      renderer.render(scene, camera);

      orbitControl.update()

    }
    renderer.setAnimationLoop(animate)

    val light = DirectionalLight(0xffffff, 100)

    light.position.set(5, 5, 5)
    light.lookAt(0, 0, 0)
    scene.add(light)

    eartthDiv.ref.append(renderer.domElement)

    eartthDiv

  def drawLine(
    x: Double,
    y: Double,
    z: Double
  ) = {
    val material = new LineBasicMaterial(js.Dynamic.literal(color = 0x0000ff))
    val geometry = new BufferGeometry().setFromPoints(
      points((0, 0, 0), (x, y, z))
    );
    val line = new Line(geometry, material);
    line
  }
  def points(ps: (Double, Double, Double)*) =
    ps.map(p => new Vector3(p._1, p._2, p._3)).toJSArray
}
