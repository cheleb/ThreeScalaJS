package dev.cheleb.scalajswebgl.app

import com.raquo.laminar.api.L.*
import frontroute.*

import org.scalajs.dom
import dev.cheleb.app.world.*
import dev.cheleb.scalajswebgl.samples.*

object Router:
  val uiBase                     = "public"
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
              (pathEnd | path("index.html")) {
                HomePage()
              },
              webglRoutes(),
              threeRoutes()
            )
          },
          noneMatched {
            div("404 Not Found")
          }
        )
      )
    )
  def linkHandler =
    onMountCallback(ctx => externalUrlBus.events.foreach(url => dom.window.location.href = url)(ctx.owner))
