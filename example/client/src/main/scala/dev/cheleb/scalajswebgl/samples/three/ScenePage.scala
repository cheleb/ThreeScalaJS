package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scalajs.js.JSConverters.*

import scala.collection.mutable.Map as MutableMap

object ScenePage {

  val R       = 1
  def apply() =

    val scalaMesh  = Var(Option.empty[GLTFResult])
    val globeGroup = new Group()
    // Map of place name to the Threejs Group (pinner)
    // This will be used to store the groups for each place
    // and allow us to add/remove them from the globe
    // when the checkbox is checked/unchecked
    // This is a mutable map, so we can add/remove groups as needed
    val placeGroups = MutableMap.empty[String, Group]

    // Elements for raycast hovering
    val raycaster = new Raycaster()
    raycaster.params.Points.threshold = 100
    raycaster.params.Line.threshold = 100

    val mouse                                    = new Vector2()
    var currentIntersected: js.UndefOr[Object3D] = js.undefined

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

    val margin = 0.8

    val detail        = 300
    val geometry      = new IcosahedronGeometry(R - 0.05, 10)
    val pointGeometry = new IcosahedronGeometry(R, detail);

    val material = MeshPhongMaterial(
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
    println(points)
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
    renderer.setSize(window.innerWidth * margin, window.innerHeight * margin)

    val loader = new GLTFLoader()

    loader.load(
      "/ThreeScalaJS/demo/res/scala.glb",
      obj => {
        scalaMesh.set(Some(obj))
      }
    )

    // Raycasting function to detect hover on pinners
    def checkIntersection(): Unit = {
      // Update the picking ray with the camera and mouse position
      raycaster.setFromCamera(mouse, camera)

      // Get all objects in the scene (excluding the earth and points)
      val objects = placeGroups.values.toSeq.map(_.asInstanceOf[Object3D]).toJSArray

      // Calculate objects intersecting the picking ray
      if (objects.length > 0) {
        val intersects = raycaster
          .intersectObjects(objects, true)
          .filterNot(_.`object`.isInstanceOf[Sprite])

        if (intersects.length > 0) {

          val intersectedObject = intersects(0).`object`

          intersectedObject.parent.foreach { parent =>
            if (parent.userData.isInstanceOf[PinnerData]) {
              val pinnerData = parent.userData.asInstanceOf[PinnerData]

              println(s"Pinner ${pinnerData.id} Data: ${pinnerData.city}")

              if (currentIntersected != intersectedObject) {
                // Hide the previous tooltip
                currentIntersected.foreach { obj =>
                  obj.userData.asInstanceOf[PinnerData].tooltip.visible = false
                }
              }
              pinnerData.tooltip.visible = true
              currentIntersected = parent

            }
          }
        } else
          currentIntersected.foreach { obj =>
            obj.userData.asInstanceOf[PinnerData].tooltip.visible = false
          }
      }
    }

    // Mouse move handler for hover detection
    val onMouseMove: dom.MouseEvent => Unit = { event =>
      // Calculate mouse position in normalized device coordinates
      // (-1 to +1) for both components
      val rect = renderer.domElement.getBoundingClientRect()

      mouse.x = ((event.clientX - rect.left) / renderer.domElement.clientWidth) * 2 - 1
      mouse.y = -((event.clientY - rect.top) / renderer.domElement.clientHeight) * 2 + 1
      checkIntersection()

    }

    renderer.domElement.addEventListener("mousemove", onMouseMove)

    val animate: () => Unit = () => {

      // globeGroup.rotation.y += 0.0005;

      orbitControl.update()

      renderer.render(scene, camera);
    }
    renderer.setAnimationLoop(animate)

    val light = DirectionalLight(0xff00ff, 100)

    light.position.set(5, 5, 5)
    light.lookAt(0, 0, 0)
    scene.add(light)

    val ambientLight = AmbientLight(0x404040, 2)
    scene.add(ambientLight)

    // Append the renderer to the canvas container instead of eartthDiv directly
    eartthDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    def onWindowResize = {

      val SCREEN_WIDTH  = window.innerWidth;
      val SCREEN_HEIGHT = window.innerHeight;
      val aspect        = SCREEN_WIDTH / SCREEN_HEIGHT;

      renderer.setSize(SCREEN_WIDTH * margin, SCREEN_HEIGHT * margin);

      camera.aspect = aspect;
      camera.updateProjectionMatrix();

    }

    window.addEventListener("resize", _ => onWindowResize)

    eartthDiv
}
