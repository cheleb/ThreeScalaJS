package dev.cheleb.scalajswebgl.app

import com.raquo.laminar.api.L.*
import org.scalajs.dom
import frontroute.LinkHandler

@main def main: Unit =

  val myApp =
    div(
      Header(),
      Router(),
      Footer()
    ).amend(LinkHandler.bind) // For interbal links

  val containerNode = dom.document.getElementById("app")
  render(containerNode, myApp)
