package dev.cheleb.scalajswebgl.samples.three

import THREE.*
import scala.scalajs.js
import scalajs.js.JSConverters.*

object SceneHelper {

  def newPinner(r: Int, location: LatLon, placeName: String = ""): GLTFResult => Group = obj => {
    val pinnerGroup = new Group()
    val pinner      = obj.scene.jsClone(true)
    val (x, y, z)   = location.xyz(r + 0.02)
    pinner.position.set(x, y, z)
    pinner.lookAt(0, 0, 0)

    // Add tooltip as a small text sprite
    if (placeName.nonEmpty) {
      val tooltipSprite = createTextSprite(placeName)
      tooltipSprite.position.set(x * 1.1, y * 1.1, z * 1.1)
      pinnerGroup.add(tooltipSprite)
    }

    pinnerGroup.add(pinner)
    pinnerGroup.add(drawLine(x * 1.1, y * 1.1, z * 1.1))

    pinnerGroup
  }

  def createTextSprite(text: String): Sprite = {
    // Create canvas for the texture - smaller dimensions for reduced size
    val canvas  = js.Dynamic.newInstance(js.Dynamic.global.OffscreenCanvas)(128, 64)
    val context = canvas.getContext("2d").asInstanceOf[js.Dynamic]

    // Style the text - smaller font size
    context.font = "Bold 12px Arial"
    context.textAlign = "center"

    // No background - removed background fill

    // Draw the text with a slight glow effect for better visibility
    // Add slight shadow for better visibility against different backgrounds
    context.shadowColor = "rgba(0, 0, 0, 0.7)"
    context.shadowBlur = 3
    context.shadowOffsetX = 1
    context.shadowOffsetY = 1

    // Draw text with white color
    context.fillStyle = "white"
    context.fillText(text, 64, 32)

    // Create a sprite with this texture
    val texture = new CanvasTexture(canvas)
    val material = new SpriteMaterial(
      js.Dynamic.literal(
        map = texture,
        sizeAttenuation = false,
        transparent = true
      )
    )

    val sprite = new Sprite(material)
    // Keep the small scale
    sprite.scale.set(0.3, 0.15, 1.0)
    sprite
  }

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
