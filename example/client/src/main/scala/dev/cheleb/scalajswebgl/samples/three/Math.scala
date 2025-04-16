package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*
import THREE.*

object Math {

  def apply() =
    div(
      h1("Math"),
      p("Math is a module that provides various mathematical functions and constants."),
      p("It includes functions for trigonometry, logarithms, and other mathematical operations."),
      p("It also includes constants like PI and E."),
      p("Math.PI: " + java.lang.Math.PI),
      p(Vector2(16, 2).x.toString()),
      p(MathUtils.generateUUID()),
      p(Color(0xffffff).toJSON())
    )

}
