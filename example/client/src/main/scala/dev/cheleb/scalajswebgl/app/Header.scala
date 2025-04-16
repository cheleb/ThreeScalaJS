package dev.cheleb.scalajswebgl.app

import be.doeraene.webcomponents.ui5.*
import be.doeraene.webcomponents.ui5.configkeys.*
import com.raquo.laminar.api.L.*

object Header:
  private val openPopoverBus = new EventBus[Boolean]
  private val profileId      = "profileId"

  def apply(): HtmlElement =
    div(
      ShellBar(
        _.slots.startButton := a(
          Icon(_.name := IconName.home, cls := "pad-10"),
          href := Router.uiRoute()
        ),
        _.primaryTitle       := "ScalaJs WebGL",
        _.secondaryTitle     := "ScalaJs WebGL bindings and utilities",
        _.notificationsCount := "2+",
        _.showNotifications  := true,
        _.showCoPilot        := true,
        _.slots.profile      := Avatar(idAttr := profileId, img(src := "img/questionmark.jpg")),
        _.events.onProfileClick.mapTo(true) --> openPopoverBus
      )
    )
