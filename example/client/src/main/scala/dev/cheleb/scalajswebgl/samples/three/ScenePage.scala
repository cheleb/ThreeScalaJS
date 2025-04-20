package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*

import org.scalajs.dom.window
import scala.scalajs.js

import scala.collection.mutable.Map as MutableMap

object ScenePage {

  val R = 1
  def apply() =

    val scalaMesh  = Var(Option.empty[GLTFResult])
    val globeGroup = new Group()
    // Map of place name to the Threejs Group (pinner)
    // This will be used to store the groups for each place
    // and allow us to add/remove them from the globe
    // when the checkbox is checked/unchecked
    // This is a mutable map, so we can add/remove groups as needed
    val placeGroups = MutableMap.empty[String, Group]

    val eartthDiv = div(
      h1("World of Scala"),
      div(
        cls := "scene-container",
        // Places sidebar
        div(
          cls := "places-sidebar",
          h3("Famous Places"),
          // Create a checkbox for each place in the famousPlaces list
          child <-- scalaMesh.signal.map {
            case Some(scalaPinner) =>
              div(
                famousPlaces.map { place =>
                  div(
                    cls := "place-item",
                    input(
                      tpe    := "checkbox",
                      idAttr := s"place-${place.name}",
                      onClick.mapToChecked --> {
                        case true =>
                          // Pass the place name to the newPinner method for tooltip display
                          val pinner = placeGroups.get(place.name) match {
                            case Some(existingPinner) =>
                              existingPinner
                            case None =>
                              val newPinner = SceneHelper.newPinner(R, place.location, place.name)(scalaPinner)
                              placeGroups += (place.name -> newPinner)
                              newPinner
                          }
                          // Update the map with the new group
                          globeGroup.add(pinner)
                        case false =>
                          placeGroups.get(place.name).foreach { group =>
                            globeGroup.remove(group)
                          }
                      }
                    ),
                    label(
                      forId := s"place-${place.name}",
                      place.name
                    )
                  )
                }
              )

            case None => "Loading..."
          }
        ),
        // Canvas container
        div(
          cls := "canvas-container"
        )
      )
    )

    val scene = Scene()

    val detail        = 300
    val geometry      = new IcosahedronGeometry(R - 0.05, 10)
    val pointGeometry = new IcosahedronGeometry(R, detail);

    val material = MeshBasicMaterial(
      color = 0x555555,
      wireframe = true
    )

    val textureLoader = TextureLoader()
    val colorMap      = textureLoader.load("/ThreeScalaJS/demo/img/8081-earthmap10k.jpg")

    val pointMaterial = PointsMaterial(
      color = 0xf0f8ff,
      size = 0.02,
      map = colorMap,
      alphaMap = colorMap
    )
    val points = Points(pointGeometry, pointMaterial)

    val earth = new Mesh(geometry, material);
    globeGroup.add(earth)
    globeGroup.add(points)

    scene.add(globeGroup)

    val camera = new PerspectiveCamera(30, window.innerWidth / window.innerHeight, 1, 100);

    camera.position.set(0, 0, 5)

    val renderer = WebGLRenderer(
      antialias = true,
      alpha = false
    )
    renderer.setPixelRatio(window.devicePixelRatio)
    val orbitControl = OrbitControls(camera, renderer.domElement)

    renderer.setClearColor("#AAAAAA", 1)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)

    val loader = new GLTFLoader()

    loader.load(
      "/ThreeScalaJS/demo/res/scala.glb",
      obj => {
        scalaMesh.set(Some(obj))
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

    // Append the renderer to the canvas container instead of eartthDiv directly
    eartthDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    eartthDiv
}
