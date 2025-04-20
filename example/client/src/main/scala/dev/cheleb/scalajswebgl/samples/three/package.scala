package dev.cheleb.scalajswebgl.samples.three

import java.lang.Math.{PI, cos, sin}

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

val famousPlace = Map(
  "Lausanne"      -> LatLon(46.5192, 6.6323),
  "Montpellier"   -> LatLon(43.6119, 3.8772),
  "Paris"         -> LatLon(48.8566, 2.3522),
  "London"        -> LatLon(51.5074, -0.1278),
  "Madrid"        -> LatLon(40.4168, -3.7038),
  "San Francisco" -> LatLon(37.7749, -122.4194),
  "New York"      -> LatLon(40.7128, -74.0060),
  "Tokyo"         -> LatLon(35.682839, 139.759455),
  "Warsaw"        -> LatLon(52.2297, 21.0122)
)
