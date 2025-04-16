package dev.cheleb.scalajswebgl.config

import sttp.model.Uri

final case class BackendClientConfig(
  baseUrl: Option[Uri]
)
