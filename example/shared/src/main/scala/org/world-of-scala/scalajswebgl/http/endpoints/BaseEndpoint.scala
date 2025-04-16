package dev.cheleb.scalajswebgl.http.endpoints

import sttp.tapir.*
import dev.cheleb.scalajswebgl.domain.errors.HttpError

trait BaseEndpoint {
  val baseEndpoint: Endpoint[Unit, Unit, Throwable, Unit, Any] = endpoint
    .errorOut(statusCode and plainBody[String])
    .mapErrorOut[Throwable](HttpError.decode)(HttpError.encode)
    .prependIn("api")

  val baseSecuredEndpoint: Endpoint[String, Unit, Throwable, Unit, Any] =
    baseEndpoint
      .securityIn(auth.bearer[String]())

}
