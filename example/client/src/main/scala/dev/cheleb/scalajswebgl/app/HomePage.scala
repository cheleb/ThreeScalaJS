package dev.cheleb.scalajswebgl.app

import com.raquo.laminar.api.L.*

object HomePage:

  def apply(): HtmlElement =
    div(
      h1("Scala.js WebGL"),
      ul(
        demo("WebGL Sample", Router.uiRoute("webgl")),
        demo("Shaders", Router.uiRoute("webgl", "shaders")),
        demo("Sphere", Router.uiRoute("webgl", "sphere")),
        demo("Triangle", Router.uiRoute("webgl", "adammurray", "triangle")),
        demo("Laminar WebGL Sample", Router.uiRoute("webgl", "detect")),
        demo("Three", Router.uiRoute("three", "math")),
        demo("Three", Router.uiRoute("three", "scene"))
      )
    )

  def demo(title: String, link: String) =
    li(
      a(
        href := link,
        title
      )
    )
