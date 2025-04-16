package dev.cheleb.app.world

//import org.scalajs.dom
import org.scalajs.dom.{WebGLRenderingContext => GL, *}

import scala.scalajs.js.JSConverters.*
import scala.scalajs.js.typedarray.*

import com.raquo.laminar.api.L.*
import scala.scalajs.js
import dev.cheleb.webgl.*

object Triangle {

  val vertexShader =
    """|#version 300 es
       |
       |in vec4 vertexPosition;
       |
       |void main() {
       |  gl_Position = vertexPosition;
       |}  
"""

  val fragmentShader =
    """|#version 300 es
       |precision highp float;
       |
       |out vec4 fragColor;
       |
       |void main() {
       |  fragColor = vec4(1, 0, 0, 1);
       |
       |}"""

  def apply() =
    canvasTag(
      width  := "100%",
      height := "100%",
      onMountCallback { mc =>

        val canvasH = mc.thisNode.ref

        canvasH.width = (window.innerWidth * 0.80).toInt
        canvasH.height = (window.innerHeight * 0.80).toInt
        val gl      = canvasH.getWebGLContext()
        val program = gl.initShaderProgram(vertexShader, fragmentShader)

        gl.useProgram(program)

        val vertices = Array(
          Array(-1.0f, -1.0f, 0.0f).toJSArray, //
          Array(1.0f, -1.0f, 0.0f).toJSArray,  //
          Array(1.0f, 1.0f, 0.0f).toJSArray
        ).toJSArray

        val vertexData = new Float32Array(vertices.flatten);
        // Updated vertex shader with matrices
        gl.bindBuffer(GL.ARRAY_BUFFER, gl.createBuffer());
        gl.bufferData(GL.ARRAY_BUFFER, vertexData, GL.STATIC_DRAW);

        val vertexPosition = gl.getAttribLocation(program, "vertexPosition");
        gl.enableVertexAttribArray(vertexPosition);
        gl.vertexAttribPointer(vertexPosition, 3, GL.FLOAT, false, 0, 0);

        def resizeCanvasToDisplaySize(canvas: HTMLCanvasElement) = {
          // Lookup the size the browser is displaying the canvas in CSS pixels.
          val displayWidth  = (window.innerWidth * 0.80).toInt
          val displayHeight = (window.innerHeight * 0.80).toInt
          // Check if the canvas is not the same size.
          val needResize = canvas.width != displayWidth ||
            canvas.height != displayHeight;

          if (needResize) {
            println(s"W ${canvas.width} - ${displayWidth}")
            println(s"W ${canvasH.width}")
            println(s"H ${canvas.height} - ${displayHeight}")
            println(s"H ${canvasH.height}")
            // Make the canvas the same size
            canvas.width = displayWidth
            canvas.height = displayHeight
          }

          needResize
        }
        def render(): Unit = {
          gl.clearColor(1.0f, 1.0f, 1.0f, 1.0f)
          gl.clearDepth(1.0f)
          gl.clear(GL.COLOR_BUFFER_BIT | GL.DEPTH_BUFFER_BIT)
          if (resizeCanvasToDisplaySize(canvasH))
            println(".")

          gl.drawArrays(GL.TRIANGLES, 0, vertices.length);

          window.requestAnimationFrame(_ => render())

        }

        render()
      }
    )
}
