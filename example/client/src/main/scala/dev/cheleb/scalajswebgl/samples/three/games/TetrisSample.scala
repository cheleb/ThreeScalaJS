package dev.cheleb.scalajswebgl.samples.three.games

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js
import scala.math.*
import scala.util.Random

object TetrisSample {

  case class Block(x: Int, y: Int)
  case class PieceTemplate(blocks: List[Block], color: Int)

  val templates = List(
    PieceTemplate(List(Block(0, 1), Block(1, 1), Block(2, 1), Block(3, 1)), 0x00ffff), // I
    PieceTemplate(List(Block(0, 2), Block(0, 1), Block(1, 1), Block(2, 1)), 0x0000ff), // J
    PieceTemplate(List(Block(2, 2), Block(0, 1), Block(1, 1), Block(2, 1)), 0xffa500), // L
    PieceTemplate(List(Block(1, 2), Block(2, 2), Block(1, 1), Block(2, 1)), 0xffff00), // O
    PieceTemplate(List(Block(1, 2), Block(2, 2), Block(0, 1), Block(1, 1)), 0x00ff00), // S
    PieceTemplate(List(Block(1, 2), Block(0, 1), Block(1, 1), Block(2, 1)), 0x800080), // T
    PieceTemplate(List(Block(0, 2), Block(1, 2), Block(1, 1), Block(2, 1)), 0xff0000)  // Z
  )

  def apply() =
    val container = div(
      h1("Tetris 3D"),
      p("Use Arrow keys to move and rotate. Space to drop."),
      div(
        cls := "canvas-container"
      )
    )

    val GRID_WIDTH  = 10
    val GRID_HEIGHT = 20

    // Scene setup
    val scene  = Scene()
    val camera = PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.set(0, 10, 20)
    camera.lookAt(0, 10, 0)

    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#111111", 1)

    // Lighting
    val ambientLight = AmbientLight(0xffffff, 0.5)
    scene.add(ambientLight)
    val directionalLight = DirectionalLight(0xffffff, 0.8)
    directionalLight.position.set(5, 10, 7.5)
    scene.add(directionalLight)

    // Grid Visual
    val gridHelper = GridHelper(GRID_WIDTH, GRID_WIDTH, 0x444444, 0x222222)
    gridHelper.rotation.x = Pi / 2
    gridHelper.position.set(0, GRID_HEIGHT / 2.0, -0.5)
    // scene.add(gridHelper)

    // Border
    val borderGeom = BoxGeometry(GRID_WIDTH + 0.2, GRID_HEIGHT + 0.2, 0.1)
    val borderMat  = MeshPhongMaterial(color = 0x333333)
    val border     = Mesh(borderGeom, borderMat)
    border.position.set(0, GRID_HEIGHT / 2.0, -0.6)
    scene.add(border)

    // Game State
    val grid = js.Array[Option[Mesh]]()
    for (_ <- 0 until GRID_WIDTH * GRID_HEIGHT) grid.push(None)
    var currentPieceBlocks                       = List.empty[Block]
    var currentPieceColor                        = 0x000000
    var currentPieceX                            = 0
    var currentPieceY                            = 0
    var nextPieceTemplate: Option[PieceTemplate] = None

    val pieceMeshGroup = Group()
    scene.add(pieceMeshGroup)

    val nextPieceMeshGroup = Group()
    nextPieceMeshGroup.position.set(GRID_WIDTH / 2.0 + 3, GRID_HEIGHT - 5, 0)
    scene.add(nextPieceMeshGroup)

    var score     = 0
    var lines     = 0
    var gameOver  = false
    val scoreVar  = Var(0)
    val linesVar  = Var(0)
    val statusVar = Var("")

    val blockGeom = BoxGeometry(0.9, 0.9, 0.9)

    def createBlockMesh(color: Int): Mesh =
      val mat = MeshPhongMaterial(color = color)
      Mesh(blockGeom, mat)

    def updatePieceMesh(): Unit =
      pieceMeshGroup.clear()
      currentPieceBlocks.foreach { b =>
        val mesh = createBlockMesh(currentPieceColor)
        mesh.position.set(currentPieceX + b.x - GRID_WIDTH / 2.0 + 0.5, currentPieceY + b.y, 0)
        pieceMeshGroup.add(mesh)
      }

    def updateNextPieceMesh(): Unit =
      nextPieceMeshGroup.clear()
      nextPieceTemplate.foreach { template =>
        template.blocks.foreach { b =>
          val mesh = createBlockMesh(template.color)
          mesh.position.set(b.x, b.y, 0)
          nextPieceMeshGroup.add(mesh)
        }
      }

    def spawnPiece(): Unit =
      val template = nextPieceTemplate.getOrElse(templates(Random.nextInt(templates.size)))
      nextPieceTemplate = Some(templates(Random.nextInt(templates.size)))

      currentPieceBlocks = template.blocks
      currentPieceColor = template.color
      currentPieceX = GRID_WIDTH / 2 - 2
      currentPieceY = GRID_HEIGHT - 3
      if (checkCollision(currentPieceBlocks, currentPieceX, currentPieceY)) {
        gameOver = true
        statusVar.set("Game Over!")
      }
      updatePieceMesh()
      updateNextPieceMesh()

    def checkCollision(blocks: List[Block], x: Int, y: Int): Boolean =
      blocks.exists { b =>
        val nx = x + b.x
        val ny = y + b.y
        nx < 0 || nx >= GRID_WIDTH || ny < 0 || grid(ny * GRID_WIDTH + nx).isDefined
      }

    def lockPiece(): Unit =
      currentPieceBlocks.foreach { b =>
        val nx = currentPieceX + b.x
        val ny = currentPieceY + b.y
        if (ny >= 0 && ny < GRID_HEIGHT) {
          val mesh = createBlockMesh(currentPieceColor)
          mesh.position.set(nx - GRID_WIDTH / 2.0 + 0.5, ny, 0)
          scene.add(mesh)
          grid(ny * GRID_WIDTH + nx) = Some(mesh)
        }
      }
      clearLines()
      spawnPiece()

    def clearLines(): Unit =
      var linesCleared = 0
      for (y <- (GRID_HEIGHT - 1) to 0 by -1) {
        val isFull = (0 until GRID_WIDTH).forall(x => grid(y * GRID_WIDTH + x).isDefined)
        if (isFull) {
          linesCleared += 1
          (0 until GRID_WIDTH).foreach { x =>
            grid(y * GRID_WIDTH + x).foreach(m => scene.remove(m))
            grid(y * GRID_WIDTH + x) = None
          }
          // Move lines down
          for (yy <- y until (GRID_HEIGHT - 1)) {
            for (xx <- 0 until GRID_WIDTH) {
              grid(yy * GRID_WIDTH + xx) = grid((yy + 1) * GRID_WIDTH + xx)
              grid(yy * GRID_WIDTH + xx).foreach { mesh =>
                mesh.position.y = yy.toDouble
              }
              grid((yy + 1) * GRID_WIDTH + xx) = None
            }
          }
        }
      }
      if (linesCleared > 0) {
        lines += linesCleared
        score += (linesCleared match {
          case 1 => 100
          case 2 => 300
          case 3 => 500
          case 4 => 800
          case _ => 0
        })
        scoreVar.set(score)
        linesVar.set(lines)
      }

    def rotatePiece(): Unit =
      val rotated = currentPieceBlocks.map(b => Block(b.y, -b.x))
      if (!checkCollision(rotated, currentPieceX, currentPieceY)) {
        currentPieceBlocks = rotated
        updatePieceMesh()
      }

    def movePiece(dx: Int, dy: Int): Boolean =
      if (!checkCollision(currentPieceBlocks, currentPieceX + dx, currentPieceY + dy)) {
        currentPieceX += dx
        currentPieceY += dy
        updatePieceMesh()
        true
      } else {
        false
      }

    def dropPiece(): Unit =
      while (movePiece(0, -1)) {}
      lockPiece()

    // Input
    window.addEventListener(
      "keydown",
      (e: dom.KeyboardEvent) =>
        if (!gameOver) {
          e.key match {
            case "ArrowLeft"  => movePiece(-1, 0)
            case "ArrowRight" => movePiece(1, 0)
            case "ArrowDown"  => movePiece(0, -1)
            case "ArrowUp"    => rotatePiece()
            case " "          => dropPiece()
            case _            =>
          }
        }
    )

    var lastTime    = dom.window.performance.now()
    val dropCounter = 1000.0 // 1 second
    var timer       = 0.0

    val animate: () => Unit = () => {
      val time      = dom.window.performance.now()
      val deltaTime = time - lastTime
      lastTime = time

      if (!gameOver) {
        timer += deltaTime
        if (timer > dropCounter) {
          if (!movePiece(0, -1)) {
            lockPiece()
          }
          timer = 0
        }
      }

      renderer.render(scene, camera)
    }

    renderer.setAnimationLoop(animate)

    spawnPiece()

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
        div("Next:"),
        div(styleAttr := "height: 80px;"), // Space for next piece 3D preview
        div(child.text <-- scoreVar.signal.map(s => s"Score: $s")),
        div(child.text <-- linesVar.signal.map(l => s"Lines: $l")),
        styleAttr := "position: absolute; top: 80px; right: 20px; color: white; font-size: 24px; text-align: right; background: rgba(0,0,0,0.5); padding: 10px; border-radius: 5px;"
      ),
      div(
        child.text <-- statusVar.signal,
        styleAttr := "font-weight: bold; font-size: 48px; color: #f00; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); pointer-events: none; text-shadow: 2px 2px 4px #000;"
      ),
      div(
        button(
          "Reset Game",
          onClick --> (_ => {
            grid.indices.foreach { i =>
              grid(i).foreach(m => scene.remove(m))
              grid(i) = None
            }
            score = 0
            lines = 0
            scoreVar.set(score)
            linesVar.set(lines)
            gameOver = false
            statusVar.set("")
            nextPieceTemplate = None
            spawnPiece()
          }),
          styleAttr := "position: absolute; bottom: 20px; left: 50%; transform: translateX(-50%); padding: 10px 20px; font-size: 16px; cursor: pointer; background: #222; color: #fff; border: 1px solid #fff; border-radius: 4px;"
        ),
        display <-- statusVar.signal.map(s => if (s.isEmpty) "none" else "block")
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
