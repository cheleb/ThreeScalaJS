package dev.cheleb.scalajswebgl.app

import com.raquo.laminar.api.L.*

object HomePage:

  def apply(): HtmlElement =
    div(
      div(
        cls := "demo",
        h2("WebGL Fundamentals"),
        ul(
          demo("WebGL Sample", Router.uiRoute("demo", "webgl")),
          demo("Shaders", Router.uiRoute("demo", "webgl", "shaders")),
          demo("Triangle", Router.uiRoute("demo", "webgl", "adammurray", "triangle")),
          demo("Laminar WebGL Sample", Router.uiRoute("demo", "webgl", "detect"))
        )
      ),
      div(
        cls := "demo",
        h2("Three.js Basics"),
        ul(
          demo("ThreeJS Scene", Router.uiRoute("demo", "three", "scene")),
          demo("Math Utils", Router.uiRoute("demo", "three", "math"))
        )
      ),
      div(
        cls := "demo",
        h2("Geometries"),
        ul(
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
          demo("BufferGeometryUtils", Router.uiRoute("demo", "three", "bufferutils"))
        )
      ),
      div(
        cls := "demo",
        h2("Materials"),
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
          demo("ShadowMaterial", Router.uiRoute("demo", "three", "material", "shadowmaterial")),
          demo("CompressedTexture", Router.uiRoute("demo", "three", "compressedtexture")),
          demo("DDSLoader", Router.uiRoute("demo", "three", "ddsloader"))
        )
      ),
      div(
        cls := "demo",
        h2("Lighting"),
        ul(
          demo("PointLight", Router.uiRoute("demo", "three", "light", "pointlight")),
          demo("SpotLight", Router.uiRoute("demo", "three", "light", "spotlight")),
          demo("HemisphereLight", Router.uiRoute("demo", "three", "light", "hemispherelight")),
          demo("RectAreaLight", Router.uiRoute("demo", "three", "light", "rectarealight")),
          demo("LightProbe", Router.uiRoute("demo", "three", "light", "lightprobe"))
        )
      ),
      div(
        cls := "demo",
        h2("Helpers and Utilities"),
        ul(
          demo("AxesHelper", Router.uiRoute("demo", "three", "axeshelper")),
          demo("GridHelper", Router.uiRoute("demo", "three", "gridhelper")),
          demo("PolarGridHelper", Router.uiRoute("demo", "three", "polargridhelper")),
          demo("ArrowHelper", Router.uiRoute("demo", "three", "arrowhelper")),
          demo("Box3Helper", Router.uiRoute("demo", "three", "box3helper")),
          demo("BoxHelper", Router.uiRoute("demo", "three", "boxhelper")),
          demo("CameraHelper", Router.uiRoute("demo", "three", "camerahelper")),
          demo("DirectionalLightHelper", Router.uiRoute("demo", "three", "directionallighthelper")),
          demo("VertexNormalsHelper", Router.uiRoute("demo", "three", "vertexnormalshelper")),
          demo("PlaneHelper", Router.uiRoute("demo", "three", "planehelper")),
          demo("PointLightHelper", Router.uiRoute("demo", "three", "pointlighthelper")),
          demo("SkeletonHelper", Router.uiRoute("demo", "three", "skeletonhelper")),
          demo("SpotLightHelper", Router.uiRoute("demo", "three", "spotlighthelper"))
        )
      ),
      div(
        cls := "demo",
        h2("Objects & Effects"),
        ul(
          demo("LOD", Router.uiRoute("demo", "three", "lod")),
          demo("SkinnedMesh", Router.uiRoute("demo", "three", "skinnedmesh")),
          demo("Sprite", Router.uiRoute("demo", "three", "sprite")),
          demo("Fog", Router.uiRoute("demo", "three", "fog")),
          demo("Shadows", Router.uiRoute("demo", "three", "shadows")),
          demo("LensFlare", Router.uiRoute("demo", "three", "lensflare")),
          demo("Reflector", Router.uiRoute("demo", "three", "reflector")),
          demo("Refractor", Router.uiRoute("demo", "three", "refractor")),
          demo("Water", Router.uiRoute("demo", "three", "water"))
        )
      ),
      div(
        cls := "demo",
        h2("Animation & Audio"),
        ul(
          demo("Animation", Router.uiRoute("demo", "three", "animation")),
          demo("Audio", Router.uiRoute("demo", "three", "audio"))
        )
      ),
      div(
        cls := "demo",
        h2("Post-Processing"),
        ul(
          demo("PostProcessing", Router.uiRoute("demo", "three", "postprocessing")),
          demo("GlitchPass", Router.uiRoute("demo", "three", "glitchpass")),
          demo("BokehPass", Router.uiRoute("demo", "three", "bokehpass")),
          demo("SSRPass", Router.uiRoute("demo", "three", "ssrpass")),
          demo("SSAOPass", Router.uiRoute("demo", "three", "ssaopass")),
          demo("OutputPass", Router.uiRoute("demo", "three", "outputpass")),
          demo("AdvancedLoaders", Router.uiRoute("demo", "three", "advancedloaders"))
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
