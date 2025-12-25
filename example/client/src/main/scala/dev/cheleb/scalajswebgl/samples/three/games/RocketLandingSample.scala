package dev.cheleb.scalajswebgl.samples.three.games

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.scalajs.js.JSConverters.*
import scala.math.*
import scala.util.Random

object RocketLandingSample {

  def apply() =
    val container = div(
      h1("Rocket Landing Game"),
      p("Use Arrow Up to thrust, Left/Right to rotate. Land softly on the pad!"),
      div(
        cls := "canvas-container"
      )
    )

    // Game Constants
    val GRAVITY              = -0.0005
    val THRUST               = 0.005
    val ROTATION_SPEED       = 0.05
    val MAX_LANDING_VELOCITY = -0.10

    // Scene setup
    val scene  = Scene()
    val camera = PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 5, 15)

    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#000011", 1)

    // Lighting
    val ambientLight = AmbientLight(0x404040, 0.6)
    scene.add(ambientLight)
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 10, 5)
    scene.add(directionalLight)

    // Rocket
    val rocketGroup = Group()

    // Rocket Body
    val bodyGeom = CylinderGeometry(0.2, 0.3, 1.5, 16)
    val bodyMat  = MeshPhongMaterial(color = 0xcccccc)
    val body     = Mesh(bodyGeom, bodyMat)
    rocketGroup.add(body)

    // Rocket Nose
    val noseGeom = ConeGeometry(0.2, 0.5, 16)
    val noseMat  = MeshPhongMaterial(color = 0xff0000)
    val nose     = Mesh(noseGeom, noseMat)
    nose.position.y = 1
    rocketGroup.add(nose)

    // Rocket Fins
    val finGeom = BoxGeometry(0.1, 0.4, 0.4)
    val finMat  = MeshPhongMaterial(color = 0xff0000)
    for (i <- 0 until 4) {
      val fin   = Mesh(finGeom, finMat)
      val angle = i * Pi / 2
      fin.position.x = 0.3 * cos(angle)
      fin.position.z = 0.3 * sin(angle)
      fin.position.y = -0.5
      fin.rotation.y = -angle
      rocketGroup.add(fin)
    }

    scene.add(rocketGroup)

    // Landing Pad
    val padGeom = BoxGeometry(3, 0.2, 3)
    val padMat  = MeshPhongMaterial(color = 0x00ff00)
    val pad     = Mesh(padGeom, padMat)
    pad.position.y = -5
    scene.add(pad)

    // Stars/Stars Background
    val starsGeom     = BufferGeometry()
    val starPositions = js.Array[Double]()
    for (_ <- 0 until 1000) {
      starPositions.push((Random.nextDouble() - 0.5) * 100)
      starPositions.push((Random.nextDouble() - 0.5) * 100)
      starPositions.push((Random.nextDouble() - 0.5) * 100)
    }
    starsGeom.setFromPoints(starPositions.grouped(3).toSeq.map(p => Vector3(p(0), p(1), p(2))).toJSArray)
    val starsMat = new PointsMaterial(js.Dynamic.literal(color = 0xffffff, size = 0.1))
    val stars    = Points(starsGeom, starsMat)
    scene.add(stars)

    // Game State
    var vy        = 0.0
    var vx        = 0.0
    var fuel      = 100.0
    var landed    = false
    var crashed   = false
    val explosion = new ExplosionEffect(scene)
    val trail     = new ReactorTrail(scene)

    val keys = js.Dictionary[Boolean]()
    window.addEventListener("keydown", (e: dom.KeyboardEvent) => keys(e.key) = true)
    window.addEventListener("keyup", (e: dom.KeyboardEvent) => keys(e.key) = false)

    val messageVar = Var("")

    def reset(): Unit = {
      rocketGroup.position.set(0, 8, 0)
      rocketGroup.rotation.set(0, 0, 0, rocketGroup.rotation.order)
      vx = 0.0
      vy = 0.0
      fuel = 100.0
      landed = false
      crashed = false
      messageVar.set("")
      explosion.clear()
      trail.clear()
      rocketGroup.visible = true
    }
    reset()

    val animate: () => Unit = () => {
      if (!landed && !crashed) {
        // Apply Gravity
        vy += GRAVITY

        val rotationZ = rocketGroup.rotation.z.asInstanceOf[Double]

        // Input handling
        if (keys.getOrElse("ArrowUp", false) && fuel > 0) {
          val forceX = -sin(rotationZ) * THRUST
          val forceY = cos(rotationZ) * THRUST
          vx += forceX
          vy += forceY
          fuel -= 0.2
          for (_ <- 0 until 3) trail.emit(rocketGroup.position, rotationZ)
        }
        if (keys.getOrElse("ArrowLeft", false)) {
          rocketGroup.rotation.z = rotationZ + ROTATION_SPEED
        }
        if (keys.getOrElse("ArrowRight", false)) {
          rocketGroup.rotation.z = rotationZ - ROTATION_SPEED
        }

        // Update Position
        rocketGroup.position.x = rocketGroup.position.x.asInstanceOf[Double] + vx
        rocketGroup.position.y = rocketGroup.position.y.asInstanceOf[Double] + vy

        // Collision detection with pad
        val rocketY    = rocketGroup.position.y.asInstanceOf[Double]
        val padY       = pad.position.y.asInstanceOf[Double]
        val rocketX    = rocketGroup.position.x.asInstanceOf[Double]
        val padX       = pad.position.x.asInstanceOf[Double]
        val rocketRotZ = rocketGroup.rotation.z.asInstanceOf[Double]

        if (rocketY <= padY + 0.85) {
          val distToPadX = abs(rocketX - padX)
          if (distToPadX < 1.5) {
            if (vy >= MAX_LANDING_VELOCITY && abs(rocketRotZ) < 0.2) {
              landed = true
              rocketGroup.position.y = padY + 0.85
              messageVar.set("Landed Successfully! Soft landing.")
            } else {
              crashed = true
              messageVar.set(s"Crashed! Speed: ${(-vy * 100).toInt} (Max allowed: 10)")
              explosion.trigger(rocketGroup.position)
              rocketGroup.visible = false
            }
          } else if (rocketY < -10) {
            crashed = true
            messageVar.set("Missed the pad and crashed!")
            explosion.trigger(rocketGroup.position)
            rocketGroup.visible = false
          }
        }

        // Screen exit check (Game Over)
        if (abs(rocketX) > 15 || rocketY > 15) {
          crashed = true
          messageVar.set("Rocket exited the screen - Mission Lost!")
          if (rocketY < 15) {
            explosion.trigger(rocketGroup.position)
            rocketGroup.visible = false
          }
        }
      }

      explosion.update()
      trail.update()
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

    container.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    val gameWrapper = div(
      styleAttr := "position: relative; width: fit-content; margin: auto;",
      container,
      div(
        child.text <-- messageVar.signal,
        styleAttr := "font-weight: bold; font-size: 24px; color: #fff; position: absolute; top: 20%; left: 50%; transform: translateX(-50%); pointer-events: none; text-shadow: 2px 2px 4px #000; text-align: center; width: 80%;"
      ),
      div(
        button(
          "Reset Game",
          onClick --> (_ => reset()),
          cls       := "reset-button",
          styleAttr := "position: absolute; top: 35%; left: 50%; transform: translateX(-50%); padding: 15px 30px; font-size: 18px; cursor: pointer; background: #222; color: #fff; border: 2px solid #fff; border-radius: 8px;"
        ),
        display <-- messageVar.signal.map(m => if (m.isEmpty) "none" else "block")
      )
    )

    div(
      gameWrapper,
      div(
        button(
          "Toggle Fullscreen",
          onClick --> (_ => {
            val wrapper = gameWrapper.ref
            if (dom.window.document.fullscreenElement == null) {
              wrapper.requestFullscreen()
            } else {
              dom.window.document.exitFullscreen()
            }
          }),
          cls := "fullscreen-button"
        ),
        styleAttr := "margin-top: 10px; text-align: center;"
      )
    )
}
