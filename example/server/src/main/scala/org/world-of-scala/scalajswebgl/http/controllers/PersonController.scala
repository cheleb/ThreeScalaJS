package dev.cheleb.scalajswebgl.http.controllers

import dev.cheleb.ziotapir.SecuredBaseController

import zio.*

import sttp.tapir.server.ServerEndpoint
import sttp.tapir.ztapir.*

import dev.cheleb.scalajswebgl.domain.*
import dev.cheleb.scalajswebgl.http.endpoints.PersonEndpoint
import dev.cheleb.scalajswebgl.service.PersonService
import dev.cheleb.scalajswebgl.service.JWTService

class PersonController private (personService: PersonService, jwtService: JWTService)
    extends SecuredBaseController[String, UserID](jwtService.verifyToken) {

  val create: ServerEndpoint[Any, Task] = PersonEndpoint.create
    .zServerLogic:
      personService.register

  val login: ServerEndpoint[Any, Task] = PersonEndpoint.login.zServerLogic { lp =>
    for {
      user  <- personService.login(lp.login, lp.password)
      token <- jwtService.createToken(user)
    } yield token
  }

  val profile: ServerEndpoint[Any, Task] = PersonEndpoint.profile.zServerAuthenticatedLogic { userId => withPet =>
    personService.getProfile(userId, withPet)
  }

  override val routes: List[ServerEndpoint[Any, Task]] = List(create, login, profile)
}

object PersonController {
  def makeZIO: URIO[PersonService & JWTService, PersonController] =
    for
      jwtService    <- ZIO.service[JWTService]
      personService <- ZIO.service[PersonService]
    yield new PersonController(personService, jwtService)
}
