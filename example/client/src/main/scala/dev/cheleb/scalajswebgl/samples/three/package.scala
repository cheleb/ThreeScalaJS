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
  "ScalaCenter" -> LatLon(46.5188, 6.5593),
  "Lausanne"    -> LatLon(46.5192, 6.6323),
  "Geneva"      -> LatLon(46.2044, 6.1432),
  "Zurich"      -> LatLon(47.3769, 8.5417),
  "Bern"        -> LatLon(46.9480, 7.4474),
  "Basel"       -> LatLon(47.5596, 7.5886),
  "Monrpelier"  -> LatLon(43.6119, 3.8772),
  "Paris"       -> LatLon(48.8566, 2.3522),
  "London"      -> LatLon(51.5074, -0.1278),
  "Madrid"      -> LatLon(40.4168, -3.7038),
  "Barcelona"   -> LatLon(41.3851, 2.1734),
  "Rome"        -> LatLon(41.9028, 12.4964),
  "Berlin"      -> LatLon(52.5200, 13.4050)
)
