package dev.cheleb.scalajswebgl.app

import be.doeraene.webcomponents.ui5.*
import be.doeraene.webcomponents.ui5.configkeys.*
import com.raquo.laminar.api.L.*

object Header:

  private val profileId = "profileId"

  def apply(): HtmlElement =
    div(
      ShellBar(
        _.slots.startButton := a(
          Icon(_.name := IconName.home, cls := "pad-10"),
          href := Router.uiRoute("demo")
        ),
        _.primaryTitle   := "ScalaJs WebGL",
        _.secondaryTitle := "ScalaJs WebGL bindings and utilities",
        _.showCoPilot    := true,
        _.slots.profile  := Avatar(
          idAttr := profileId,
          img(src := "img/avatars/ono.png")
        ),
        _.events.onProfileClick.mapTo("https://github.com/cheleb/ThreeScalaJS/") --> Router.writer
      )
    )
