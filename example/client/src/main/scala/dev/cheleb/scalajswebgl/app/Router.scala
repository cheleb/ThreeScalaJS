package dev.cheleb.scalajswebgl.app

import com.raquo.laminar.api.L.*
import frontroute.*

import org.scalajs.dom
import dev.cheleb.app.world.*
import dev.cheleb.scalajswebgl.samples.*

object Router:
  val uiBase                     = "ThreeScalaJS"
  def uiRoute(segments: String*) = segments.mkString(s"/$uiBase/", "/", "")
  private val externalUrlBus     = EventBus[String]()
  val writer                     = externalUrlBus.writer

  def webglRoutes(): Route =
    pathPrefix("demo" / "webgl") {
      firstMatch(
        path("shaders") {
          Shaders()
        },
        pathPrefix("adammurray") {
          path("triangle") {
            Triangle()
          }

        },
        firstMatch(
          pathEnd {
            WebGLSample()
          },
          path("detect") {
            LaminarWebGLSample()
          }
        )
      )
    }
  def threeRoutes(): Route =
    pathPrefix("demo" / "three") {
      firstMatch(
        path("math") {
          dev.cheleb.scalajswebgl.samples.three.Math()
        },
        path("scene") {
          dev.cheleb.scalajswebgl.samples.three.ScenePage()
        },
        path("sphere") {
          dev.cheleb.scalajswebgl.samples.three.SphereSample()
        },
        path("plane") {
          dev.cheleb.scalajswebgl.samples.three.PlaneSample()
        },
        path("cylinder") {
          dev.cheleb.scalajswebgl.samples.three.CylinderSample()
        },
        path("cone") {
          dev.cheleb.scalajswebgl.samples.three.ConeSample()
        },
        path("torus") {
          dev.cheleb.scalajswebgl.samples.three.TorusSample()
        },
        path("ring") {
          dev.cheleb.scalajswebgl.samples.three.RingSample()
        },
        path("circle") {
          dev.cheleb.scalajswebgl.samples.three.CircleSample()
        },
        path("shape") {
          dev.cheleb.scalajswebgl.samples.three.ShapeSample()
        },
        path("extrude") {
          dev.cheleb.scalajswebgl.samples.three.ExtrudeSample()
        },
        path("lathe") {
          dev.cheleb.scalajswebgl.samples.three.LatheSample()
        },
        path("text") {
          dev.cheleb.scalajswebgl.samples.three.TextSample()
        },
        path("bufferutils") {
          dev.cheleb.scalajswebgl.samples.three.BufferGeometryUtilsSample()
        },
        path("axeshelper") {
          dev.cheleb.scalajswebgl.samples.three.AxesHelperSample()
        },
        path("lod") {
          dev.cheleb.scalajswebgl.samples.three.LODSample()
        },
        path("skinnedmesh") {
          dev.cheleb.scalajswebgl.samples.three.SkinnedMeshSample()
        },
        path("sprite") {
          dev.cheleb.scalajswebgl.samples.three.SpriteSample()
        },
        path("lensflare") {
          dev.cheleb.scalajswebgl.samples.three.LensFlareSample()
        },
        path("reflector") {
          dev.cheleb.scalajswebgl.samples.three.ReflectorSample()
        },
        path("refractor") {
          dev.cheleb.scalajswebgl.samples.three.RefractorSample()
        },
        path("water") {
          dev.cheleb.scalajswebgl.samples.three.WaterSample()
        },
        path("animation") {
          dev.cheleb.scalajswebgl.samples.three.AnimationSample()
        },
        path("postprocessing") {
          dev.cheleb.scalajswebgl.samples.three.PostProcessingSample()
        },
        path("glitchpass") {
          dev.cheleb.scalajswebgl.samples.three.GlitchPassSample()
        },
        path("bokehpass") {
          dev.cheleb.scalajswebgl.samples.three.BokehPassSample()
        },
        path("ssrpass") {
          dev.cheleb.scalajswebgl.samples.three.SSRPassSample()
        },
        path("ssaopass") {
          dev.cheleb.scalajswebgl.samples.three.SSAOPassSample()
        },
        path("outputpass") {
          dev.cheleb.scalajswebgl.samples.three.OutputPassSample()
        },
        path("advancedloaders") {
          dev.cheleb.scalajswebgl.samples.three.AdvancedLoadersSample()
        },
        path("audio") {
          dev.cheleb.scalajswebgl.samples.three.AudioSample()
        },
        pathPrefix("material") {
          firstMatch(
            path("meshlambert") {
              dev.cheleb.scalajswebgl.samples.three.MeshLambertMaterialSample()
            },
            path("meshstandard") {
              dev.cheleb.scalajswebgl.samples.three.MeshStandardMaterialSample()
            },
            path("meshphysical") {
              dev.cheleb.scalajswebgl.samples.three.MeshPhysicalMaterialSample()
            },
            path("meshmatcap") {
              dev.cheleb.scalajswebgl.samples.three.MeshMatcapMaterialSample()
            },
            path("meshnormal") {
              dev.cheleb.scalajswebgl.samples.three.MeshNormalMaterialSample()
            },
            path("meshdepth") {
              dev.cheleb.scalajswebgl.samples.three.MeshDepthMaterialSample()
            },
            path("meshdistance") {
              dev.cheleb.scalajswebgl.samples.three.MeshDistanceMaterialSample()
            },
            path("linedashed") {
              dev.cheleb.scalajswebgl.samples.three.LineDashedMaterialSample()
            },
            path("shadermaterial") {
              dev.cheleb.scalajswebgl.samples.three.ShaderMaterialSample()
            },
            path("rawshadermaterial") {
              dev.cheleb.scalajswebgl.samples.three.RawShaderMaterialSample()
            },
            path("shadowmaterial") {
              dev.cheleb.scalajswebgl.samples.three.ShadowMaterialSample()
            }
          )
        },
        pathPrefix("light") {
          firstMatch(
            path("pointlight") {
              dev.cheleb.scalajswebgl.samples.three.PointLightSample()
            },
            path("spotlight") {
              dev.cheleb.scalajswebgl.samples.three.SpotLightSample()
            },
            path("hemispherelight") {
              dev.cheleb.scalajswebgl.samples.three.HemisphereLightSample()
            },
            path("rectarealight") {
              dev.cheleb.scalajswebgl.samples.three.RectAreaLightSample()
            },
            path("lightprobe") {
              dev.cheleb.scalajswebgl.samples.three.LightProbeSample()
            }
          )
        }
      )
    }

  def apply() =
    mainTag(
      linkHandler,
      routes(
        div(
          styleAttr := "max-width: fit-content;  margin-left: auto;  margin-right: auto;",
          // potentially children

          pathPrefix(uiBase) {
            firstMatch(
              webglRoutes(),
              threeRoutes(),
              pathPrefix("demo") {
                firstMatch(
                  pathEnd {
                    dev.cheleb.scalajswebgl.samples.three.ScenePage()
                  }
                )
                pathEnd {
                  HomePage()
                }
              }
            )
          },
          noneMatched {
            div("404 Not Found")
          }
        )
      )
    )
  def linkHandler =
    onMountCallback(ctx => externalUrlBus.events.foreach(url => dom.window.location.href = url)(using ctx.owner))
