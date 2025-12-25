package dev.cheleb.scalajswebgl.samples.three.games

import THREE.*
import scala.scalajs.js
import scala.util.Random
import scala.math.*

class ReactorTrail(scene: Scene) {
  private val particles  = js.Array[Mesh]()
  private val velocities = js.Array[Vector3]()
  private val lives      = js.Array[Double]()

  private val geometry = SphereGeometry(0.1, 8, 8)

  def emit(position: Vector3, rotationZ: Double): Unit = {
    // Offset position to be at the bottom of the rocket
    val offset = Vector3(
      sin(rotationZ) * 0.75,
      -cos(rotationZ) * 0.75,
      0
    )
    val emitPos = position.jsClone().add(offset)

    val color    = if (Random.nextBoolean()) 0xffff00 else 0xff8800 // Yellow or Orange
    val material = MeshBasicMaterial(color = color)
    val particle = Mesh(geometry, material)

    particle.position.copy(emitPos)

    // Velocity is mostly opposite to thrust direction with some spread
    val vMag     = 0.1 + Random.nextDouble() * 0.1
    val spread   = (Random.nextDouble() - 0.5) * 0.15
    val velocity = Vector3(
      sin(rotationZ) * vMag + cos(rotationZ) * spread,
      -cos(rotationZ) * vMag + sin(rotationZ) * spread,
      (Random.nextDouble() - 0.5) * 0.05
    )

    particles.push(particle)
    velocities.push(velocity)
    lives.push(1.0)
    scene.add(particle)
  }

  def update(): Unit = {
    var i = 0
    while (i < particles.length) {
      val p = particles(i)
      val v = velocities(i)
      lives(i) -= 0.05

      if (lives(i) <= 0) {
        scene.remove(p)
        p.material.foreach {
          case m: Material => m.dispose()
          case _           =>
        }
        particles.splice(i, 1)
        velocities.splice(i, 1)
        lives.splice(i, 1)
      } else {
        p.position.asInstanceOf[js.Dynamic].add(v)
        p.scale.asInstanceOf[js.Dynamic].multiplyScalar(0.95)
        i += 1
      }
    }
  }

  def clear(): Unit = {
    particles.foreach { p =>
      scene.remove(p)
      p.material.foreach {
        case m: Material => m.dispose()
        case _           =>
      }
    }
    particles.length = 0
    velocities.length = 0
    lives.length = 0
  }
}
