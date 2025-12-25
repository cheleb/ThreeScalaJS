package dev.cheleb.scalajswebgl.samples.three.games

import THREE.*
import scala.scalajs.js
import scala.util.Random

class ExplosionEffect(scene: Scene) {
  private val particleCount = 50
  private val particles     = js.Array[Mesh]()
  private val velocities    = js.Array[Vector3]()
  private var active        = false
  private var life          = 1.0

  // Reuse geometry
  private val geometry = SphereGeometry(0.1, 8, 8)

  def trigger(position: Vector3): Unit = {
    clear()
    active = true
    life = 1.0

    for (_ <- 0 until particleCount) {
      val color    = if (Random.nextBoolean()) 0xffa500 else 0xff4500 // Orange or Red-Orange
      val material = MeshBasicMaterial(color = color)
      val particle = Mesh(geometry, material)

      // Using dynamic access to avoid member not found if types are not perfectly updated in compiler's view
      particle.position.asInstanceOf[js.Dynamic].copy(position)

      val velocity = Vector3(
        (Random.nextDouble() - 0.5) * 0.2,
        (Random.nextDouble() - 0.5) * 0.2,
        (Random.nextDouble() - 0.5) * 0.2
      )

      particles.push(particle)
      velocities.push(velocity)
      scene.add(particle)
    }
  }

  def update(): Unit = {
    if (!active) return

    life -= 0.02
    if (life <= 0) {
      clear()
      return
    }

    for (i <- 0 until particles.length) {
      val p = particles(i)
      val v = velocities(i)

      p.position.asInstanceOf[js.Dynamic].add(v)
      p.scale.asInstanceOf[js.Dynamic].multiplyScalar(0.95)
    }
  }

  def clear(): Unit = {
    active = false
    particles.foreach { p =>
      scene.remove(p)
      // Geometry is shared, don't dispose here if we want to reuse it,
      // but the original code had it. Let's not dispose shared geometry.
      p.material.foreach {
        case m: Material => m.dispose()
        case _           =>
      }
    }
    particles.length = 0
    velocities.length = 0
  }
}
