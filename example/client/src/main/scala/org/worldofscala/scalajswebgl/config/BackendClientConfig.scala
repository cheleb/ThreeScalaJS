package org.worldofscala.scalajswebgl.config

import sttp.model.Uri

final case class BackendClientConfig(
  baseUrl: Option[Uri]
)
