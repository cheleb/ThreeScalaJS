package dev.cheleb.scalajswebgl.app

import com.raquo.laminar.api.L.*

object HomePage:

  def apply(): HtmlElement =
    div(
      h1("Scala.js WebGL"),
      ul(
        "Adammmuray",
        ul(demo("Triangle", Router.uiRoute("demo", "webgl", "adammurray", "triangle"))),
        "WebGL",
        ul(
          demo("WebGL Sample", Router.uiRoute("demo", "webgl")),
          demo("Shaders", Router.uiRoute("demo", "webgl", "shaders")),
          demo("Triangle", Router.uiRoute("demo", "webgl", "adammurray", "triangle")),
          demo("Laminar WebGL Sample", Router.uiRoute("demo", "webgl", "detect"))
        ),
        "ThreeJS",
        ul(
          demo("Math", Router.uiRoute("demo", "three", "math")),
          demo("ThreeJS", Router.uiRoute("demo", "three", "scene")),
          demo("SphereGeometry", Router.uiRoute("demo", "three", "sphere")),
          demo("PlaneGeometry", Router.uiRoute("demo", "three", "plane")),
          demo("CylinderGeometry", Router.uiRoute("demo", "three", "cylinder")),
          demo("ConeGeometry", Router.uiRoute("demo", "three", "cone")),
          demo("TorusGeometry", Router.uiRoute("demo", "three", "torus")),
          demo("RingGeometry", Router.uiRoute("demo", "three", "ring")),
          demo("CircleGeometry", Router.uiRoute("demo", "three", "circle")),
          demo("ShapeGeometry", Router.uiRoute("demo", "three", "shape")),
          demo("ExtrudeGeometry", Router.uiRoute("demo", "three", "extrude")),
          demo("LatheGeometry", Router.uiRoute("demo", "three", "lathe")),
          demo("TextGeometry", Router.uiRoute("demo", "three", "text")),
          demo("BufferGeometryUtils", Router.uiRoute("demo", "three", "bufferutils")),
          "Materials",
          ul(
            demo("MeshLambertMaterial", Router.uiRoute("demo", "three", "material", "meshlambert")),
            demo("MeshStandardMaterial", Router.uiRoute("demo", "three", "material", "meshstandard")),
            demo("MeshPhysicalMaterial", Router.uiRoute("demo", "three", "material", "meshphysical")),
            demo("MeshMatcapMaterial", Router.uiRoute("demo", "three", "material", "meshmatcap")),
            demo("MeshNormalMaterial", Router.uiRoute("demo", "three", "material", "meshnormal")),
            demo("MeshDepthMaterial", Router.uiRoute("demo", "three", "material", "meshdepth")),
            demo("MeshDistanceMaterial", Router.uiRoute("demo", "three", "material", "meshdistance")),
            demo("LineDashedMaterial", Router.uiRoute("demo", "three", "material", "linedashed")),
            demo("ShaderMaterial", Router.uiRoute("demo", "three", "material", "shadermaterial")),
            demo("RawShaderMaterial", Router.uiRoute("demo", "three", "material", "rawshadermaterial")),
            demo("ShadowMaterial", Router.uiRoute("demo", "three", "material", "shadowmaterial"))
          ),
          "Lights",
          ul(
            demo("PointLight", Router.uiRoute("demo", "three", "light", "pointlight")),
            demo("SpotLight", Router.uiRoute("demo", "three", "light", "spotlight")),
            demo("HemisphereLight", Router.uiRoute("demo", "three", "light", "hemispherelight")),
            demo("RectAreaLight", Router.uiRoute("demo", "three", "light", "rectarealight")),
            demo("LightProbe", Router.uiRoute("demo", "three", "light", "lightprobe"))
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
