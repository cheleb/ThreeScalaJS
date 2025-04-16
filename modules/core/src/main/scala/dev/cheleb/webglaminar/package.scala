package dev.cheleb.webglaminar

import dev.cheleb.webgl.*
import org.scalajs.dom.HTMLCanvasElement
import com.raquo.laminar.api.L.*
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.window

/**
 * Build a canvas element with WebGL 2 context initialized with vertex and
 * fragment shaders.
 *
 * @param vertexShader
 *   The vertex shader code.
 * @param fragmentShader
 *   The fragment shader code.
 * @param modifiers
 *   The modifiers to apply to the canvas element.
 * @param welgl
 *   The WebGL initialization function.
 * @return
 */
def webglCanvas(
  vertexShader: String,
  fragmentShader: String,
  modifiers: Modifier[ReactiveHtmlElement[HTMLCanvasElement]]*
)(welgl: WebGLContexts => Unit): ReactiveHtmlElement[HTMLCanvasElement] =
  canvasTag(
    modifiers,
    onMountCallback { mc =>
      val canvas = mc.thisNode.ref
      canvas.width = (window.innerWidth * 0.80).toInt
      canvas.height = (window.innerHeight * 0.80).toInt
      val gl      = canvas.getWebGLContext()
      val program = gl.initShaderProgram(vertexShader, fragmentShader)

      gl.useProgram(program)
      welgl(WebGLContexts(gl, program))
    }
  )
