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
          demo("ThreeJS", Router.uiRoute("three", "scene")),
          demo("SphereGeometry", Router.uiRoute("three", "sphere")),
          demo("PlaneGeometry", Router.uiRoute("three", "plane")),
          demo("CylinderGeometry", Router.uiRoute("three", "cylinder")),
          demo("ConeGeometry", Router.uiRoute("three", "cone")),
          demo("TorusGeometry", Router.uiRoute("three", "torus")),
          demo("RingGeometry", Router.uiRoute("three", "ring")),
          demo("CircleGeometry", Router.uiRoute("three", "circle")),
          demo("ShapeGeometry", Router.uiRoute("three", "shape")),
          demo("ExtrudeGeometry", Router.uiRoute("three", "extrude")),
          demo("LatheGeometry", Router.uiRoute("three", "lathe")),
          demo("TextGeometry", Router.uiRoute("three", "text")),
          demo("BufferGeometryUtils", Router.uiRoute("three", "bufferutils")),
          "Materials",
          ul(
            demo("MeshLambertMaterial", Router.uiRoute("three", "material", "meshlambert")),
            demo("MeshStandardMaterial", Router.uiRoute("three", "material", "meshstandard")),
            demo("MeshPhysicalMaterial", Router.uiRoute("three", "material", "meshphysical")),
            demo("MeshMatcapMaterial", Router.uiRoute("three", "material", "meshmatcap")),
            demo("MeshNormalMaterial", Router.uiRoute("three", "material", "meshnormal")),
            demo("MeshDepthMaterial", Router.uiRoute("three", "material", "meshdepth")),
            demo("MeshDistanceMaterial", Router.uiRoute("three", "material", "meshdistance")),
            demo("LineDashedMaterial", Router.uiRoute("three", "material", "linedashed")),
            demo("ShaderMaterial", Router.uiRoute("three", "material", "shadermaterial")),
            demo("RawShaderMaterial", Router.uiRoute("three", "material", "rawshadermaterial")),
            demo("ShadowMaterial", Router.uiRoute("three", "material", "shadowmaterial"))
          )
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
