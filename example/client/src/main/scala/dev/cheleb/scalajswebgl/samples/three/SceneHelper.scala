package dev.cheleb.scalajswebgl.samples.three

import THREE.*
import scala.scalajs.js
import scalajs.js.JSConverters.*

object SceneHelper {

  def newPinner(r: Int, location: LatLon): GLTFResult => Group = obj => {
    val pinnerGroup = new Group()
    val pinner      = obj.scene.jsClone(true)
    val (x, y, z)   = location.xyz(r + 0.02)
    pinner.position.set(x, y, z)
    pinner.lookAt(0, 0, 0)
    pinnerGroup.add(pinner)

    pinnerGroup.add(drawLine(x * 1.1, y * 1.1, z * 1.1))

    pinnerGroup
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
