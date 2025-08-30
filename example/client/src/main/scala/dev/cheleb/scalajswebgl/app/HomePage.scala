package dev.cheleb.scalajswebgl.app

import com.raquo.laminar.api.L.*

object HomePage:

  def apply(): HtmlElement =
    div(
      h1("Scala.js WebGL"),
      ul(
        "Adammmuray",
        ul(demo("Triangle", Router.uiRoute("webgl", "adammurray", "triangle"))),
        "WebGL",
        ul(
          demo("WebGL Sample", Router.uiRoute("webgl")),
          demo("Shaders", Router.uiRoute("webgl", "shaders")),
          demo("Triangle", Router.uiRoute("webgl", "adammurray", "triangle")),
          demo("Laminar WebGL Sample", Router.uiRoute("webgl", "detect"))
        ),
        "ThreeJS",
        ul(
          demo("Math", Router.uiRoute("three", "math")),
          demo("ThreeJS", Router.uiRoute("three", "scene"))
        )
      )
    )

  def demo(title: String, link: String) =
    li(
      a(
        href := link,
        title
      )
    )
