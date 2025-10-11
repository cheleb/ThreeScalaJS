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
    pathPrefix("webgl") {
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
    pathPrefix("three") {
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
              },
              pathEnd {
                HomePage()
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
