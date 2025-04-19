package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*

import org.scalajs.dom.window
import scala.scalajs.js

object ScenePage {

  val R = 1
  def apply() =

    val scalaCenterGroup = Var(Option.empty[Group])
    val scalaMesh        = Var(Option.empty[GLTFResult])
    val globeGroup       = new Group()

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
              val pinner = SceneHelper.newPinner(R, LatLon(46.5188, 6.5593))(mesh)
              scalaCenterGroup.set(Some(pinner)) // Lauzane
              globeGroup.add(pinner)
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
        color = 0x555555,
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
        alpha = false
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

      orbitControl.update()

      renderer.render(scene, camera);
    }
    renderer.setAnimationLoop(animate)

    val light = DirectionalLight(0xffffff, 100)

    light.position.set(5, 5, 5)
    light.lookAt(0, 0, 0)
    scene.add(light)

    eartthDiv.ref.append(renderer.domElement)

    eartthDiv
}
