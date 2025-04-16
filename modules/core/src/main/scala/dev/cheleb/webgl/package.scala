package dev.cheleb.webgl

import org.scalajs.dom.HTMLCanvasElement

import org.scalajs.dom.{WebGLRenderingContext => GL, WebGL2RenderingContext => GL2, *}
import scala.scalajs.js.JSConverters.*
import scala.scalajs.js.typedarray.*

extension (htmlCanvas: HTMLCanvasElement) def getWebGLContext() = htmlCanvas.getContext("webgl2").asInstanceOf[GL2]

extension (gl: GL)
  def initShaderProgram(vsSource: String, fsSource: String): WebGLProgram = {
    val vertexShader   = loadShader(GL.VERTEX_SHADER, vsSource)
    val fragmentShader = loadShader(GL.FRAGMENT_SHADER, fsSource)

    val shaderProgram = gl.createProgram()
    gl.attachShader(shaderProgram, vertexShader)
    gl.attachShader(shaderProgram, fragmentShader)
    gl.linkProgram(shaderProgram)

    if (!gl.getProgramParameter(shaderProgram, GL.LINK_STATUS).asInstanceOf[Boolean]) {
      println(s"Unable to initialize the shader program: ${gl.getProgramInfoLog(shaderProgram)}")
      println(gl.getShaderInfoLog(vertexShader))
      println(gl.getShaderInfoLog(fragmentShader))
      return null
    }

    shaderProgram
  }

  private def loadShader(shaderType: Int, source: String): WebGLShader = {
    val shader = gl.createShader(shaderType)
    gl.shaderSource(shader, source.stripMargin)
    gl.compileShader(shader)

    if (!gl.getShaderParameter(shader, GL.COMPILE_STATUS).asInstanceOf[Boolean]) {
      println(s"An error occurred compiling the shaders: ${gl.getShaderInfoLog(shader)}")
      gl.deleteShader(shader)
      return null
    }

    shader
  }

extension (xn: Array[Coord[Float]])
  /**
   * Flatten the array of Coord into a Float32Array
   *
   * @return
   */
  def f32 = new Float32Array(xn.flatMap(c => Seq(c.x, c.y, c.z)).toJSArray)
