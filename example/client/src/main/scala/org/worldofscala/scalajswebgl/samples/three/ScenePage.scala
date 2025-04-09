package org.worldofscala.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*

import org.scalajs.dom.window
import scala.scalajs.js

object ScenePage {

  val R = 1.0
  def apply() =
    val eartthDiv = div(
      h1("Scene")
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
    val colorMap      = textureLoader.load("/public/img/8081-earthmap10k.jpg")

    val pointMaterial = PointsMaterial(
      js.Dynamic.literal(color = "0xf0f0f0", size = 0.02, map = colorMap)
    )
    val points = Points(pointGeometry, pointMaterial)

    val earth = new Mesh(geometry, material);

    scene.add(earth)
    scene.add(points)

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
    renderer.render(scene, camera);

    val animate: () => Unit = () => {

      //   // globeGroup.rotation.x += 0.001;
      //   globeGroup.rotation.y += 0.0005;

      renderer.render(scene, camera);
      orbitControl.update()

    }
    renderer.setAnimationLoop(animate)

    val loader = new GLTFLoader()

    def addObj(obj: GLTFResult, location: LatLon) =
      val pinner    = obj.scene.jsClone(true)
      val (x, y, z) = location.xyz(R + 0.02)
      pinner.position.set(x, y, z)
      pinner.lookAt(0, 0, 0)
      scene.add(pinner)
      // globeGroup.add(drawLine(x * 1.2, y * 1.2, z * 1.2))

    loader.load(
      "/public/res/scala.glb",
      (obj) => {
        addObj(obj, LatLon(46.5188, 6.5593)) // Lauzane
      }
    )

    val light = DirectionalLight(0xffffff, 100)

    light.position.set(5, 5, 5)
    light.lookAt(0, 0, 0)
    scene.add(light)

    eartthDiv.ref.append(renderer.domElement)

    eartthDiv
}
