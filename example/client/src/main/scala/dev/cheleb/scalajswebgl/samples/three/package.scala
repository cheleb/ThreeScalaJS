package dev.cheleb.scalajswebgl.samples.three

import java.lang.Math.{PI, cos, sin}

import scala.scalajs.js
import THREE.Object3D
import THREE.Sprite

case class LatLon(lat: Double, lon: Double):
  override def toString(): String = s"$lat,$lon"

  /**
   * Convert lat lon to xyz
   *
   * @param d
   *   earth radius
   * @return
   */
  def xyz(d: Double) = {
    val latRad = lat * PI / 180.0;
    val lonRad = (-lon + 180) * PI / 180.0;
    (d * cos(latRad) * cos(lonRad), d * sin(latRad), d * cos(latRad) * sin(lonRad));

  }

object LatLon:
  val empty: LatLon = LatLon(0.0, 0.0)

case class Place(name: String, location: LatLon)

val famousPlaces = List(
  Place("Lausanne", LatLon(46.5192, 6.6323)),
  Place("Montpellier", LatLon(43.6119, 3.8772)),
  Place("Paris", LatLon(48.8566, 2.3522)),
  Place("London", LatLon(51.5074, -0.1278)),
  Place("Madrid", LatLon(40.4168, -3.7038)),
  Place("San Francisco", LatLon(37.7749, -122.4194)),
  Place("New York", LatLon(40.7128, -74.0060)),
  Place("Tokyo", LatLon(35.682839, 139.759455)),
  Place("Warsaw", LatLon(52.2297, 21.0122))
)

//@js.native
class PinnerData(
  val id: Int,
  val city: String,
  var tooltip: js.UndefOr[Sprite] = js.undefined
) extends js.Object:
  var pinner: js.UndefOr[Object3D] = js.undefined
