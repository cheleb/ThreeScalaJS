package dev.cheleb.webglaminar

import org.scalajs.dom.WebGL2RenderingContext
import org.scalajs.dom.WebGLProgram

final case class WebGLContexts(gl2: WebGL2RenderingContext, program: WebGLProgram)
