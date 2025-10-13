package dev.cheleb.scalajswebgl.app

import com.raquo.laminar.api.L.*
import be.doeraene.webcomponents.ui5.*
import be.doeraene.webcomponents.ui5.configkeys.BarDesign

object Footer:
  def apply(): HtmlElement =
    div(
      styleAttr := "clear:both",
      Bar(
        _.design := BarDesign.Footer,
        a(href := "https://github.com/cheleb/ThreeScalaJS/", "Three.sjs"),
        "♥️" +
          " ",
        a(href := "https://laminar.dev/", "laminar")
      )
    )
