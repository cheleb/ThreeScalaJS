package dev.cheleb.scalajswebgl.app

import com.raquo.laminar.api.L.*
import frontroute.*

import org.scalajs.dom
import dev.cheleb.app.world.*
import dev.cheleb.scalajswebgl.samples.*
import dev.cheleb.scalajswebgl.samples.three.geometries.*
import dev.cheleb.scalajswebgl.samples.three.materials.*
import dev.cheleb.scalajswebgl.samples.three.lighting.*
import dev.cheleb.scalajswebgl.samples.three.helpers.*
import dev.cheleb.scalajswebgl.samples.three.objects.*
import dev.cheleb.scalajswebgl.samples.three.postprocessing.*
import dev.cheleb.scalajswebgl.samples.three.controls.*
import dev.cheleb.scalajswebgl.samples.three.renderers.*
import dev.cheleb.scalajswebgl.samples.three.games.*

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
          SphereSample()
        },
        path("plane") {
          PlaneSample()
        },
        path("cylinder") {
          CylinderSample()
        },
        path("cone") {
          ConeSample()
        },
        path("torus") {
          TorusSample()
        },
        path("ring") {
          RingSample()
        },
        path("circle") {
          CircleSample()
        },
        path("shape") {
          ShapeSample()
        },
        path("extrude") {
          ExtrudeSample()
        },
        path("lathe") {
          LatheSample()
        },
        path("text") {
          TextSample()
        },
        path("bufferutils") {
          BufferGeometryUtilsSample()
        },
        path("axeshelper") {
          AxesHelperSample()
        },
        path("gridhelper") {
          GridHelperSample()
        },
        path("polargridhelper") {
          PolarGridHelperSample()
        },
        path("arrowhelper") {
          ArrowHelperSample()
        },
        path("box3helper") {
          Box3HelperSample()
        },
        path("boxhelper") {
          BoxHelperSample()
        },
        path("camerahelper") {
          CameraHelperSample()
        },
        path("directionallighthelper") {
          DirectionalLightHelperSample()
        },
        path("vertexnormalshelper") {
          VertexNormalsHelperSample()
        },
        path("planehelper") {
          PlaneHelperSample()
        },
        path("pointlighthelper") {
          PointLightHelperSample()
        },
        path("skeletonhelper") {
          SkeletonHelperSample()
        },
        path("spotlighthelper") {
          SpotLightHelperSample()
        },
        path("lod") {
          LODSample()
        },
        path("skinnedmesh") {
          SkinnedMeshSample()
        },
        path("sprite") {
          SpriteSample()
        },
        path("lensflare") {
          LensFlareSample()
        },
        path("reflector") {
          ReflectorSample()
        },
        path("refractor") {
          RefractorSample()
        },
        path("water") {
          WaterSample()
        },
        path("animation") {
          dev.cheleb.scalajswebgl.samples.three.AnimationSample()
        },
        path("fog") {
          FogSample()
        },
        path("shadows") {
          ShadowSample()
        },
        path("postprocessing") {
          PostProcessingSample()
        },
        path("glitchpass") {
          GlitchPassSample()
        },
        path("bokehpass") {
          BokehPassSample()
        },
        path("ssrpass") {
          SSRPassSample()
        },
        path("ssaopass") {
          SSAOPassSample()
        },
        path("outputpass") {
          OutputPassSample()
        },
        path("advancedloaders") {
          AdvancedLoadersSample()
        },
        path("audio") {
          dev.cheleb.scalajswebgl.samples.three.AudioSample()
        },
        path("compressedtexture") {
          CompressedTextureSample()
        },
        path("depthtexture") {
          DepthTextureSample()
        },
        path("framebuffertexture") {
          FramebufferTextureSample()
        },
        path("ddsloader") {
          DDSLoaderSample()
        },
        pathPrefix("material") {
          firstMatch(
            path("meshlambert") {
              MeshLambertMaterialSample()
            },
            path("meshstandard") {
              MeshStandardMaterialSample()
            },
            path("meshphysical") {
              MeshPhysicalMaterialSample()
            },
            path("meshmatcap") {
              MeshMatcapMaterialSample()
            },
            path("meshnormal") {
              MeshNormalMaterialSample()
            },
            path("meshdepth") {
              MeshDepthMaterialSample()
            },
            path("meshdistance") {
              MeshDistanceMaterialSample()
            },
            path("linedashed") {
              LineDashedMaterialSample()
            },
            path("shadermaterial") {
              ShaderMaterialSample()
            },
            path("rawshadermaterial") {
              RawShaderMaterialSample()
            },
            path("shadowmaterial") {
              ShadowMaterialSample()
            }
          )
        },
        pathPrefix("light") {
          firstMatch(
            path("pointlight") {
              PointLightSample()
            },
            path("spotlight") {
              SpotLightSample()
            },
            path("hemispherelight") {
              HemisphereLightSample()
            },
            path("rectarealight") {
              RectAreaLightSample()
            },
            path("lightprobe") {
              LightProbeSample()
            }
          )
        },
        path("webgl2renderer") {
          WebGL2RendererSample()
        },
        path("webglmultiplerendertargets") {
          WebGLMultipleRenderTargetsSample()
        },
        path("webglcuberendertarget") {
          WebGLCubeRenderTargetSample()
        },
        path("dragcontrols") {
          DragControlsSample()
        },
        path("transformcontrols") {
          TransformControlsSample()
        },
        path("pointerlockcontrols") {
          PointerLockControlsSample()
        },
        path("flycontrols") {
          FlyControlsSample()
        },
        path("firstpersoncontrols") {
          FirstPersonControlsSample()
        },
        path("trackballcontrols") {
          TrackballControlsSample()
        },
        path("curve") {
          dev.cheleb.scalajswebgl.samples.three.CurveSample()
        },
        path("rocket") {
          RocketLandingSample()
        },
        path("tetris") {
          TetrisSample()
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
