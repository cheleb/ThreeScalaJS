package org.worldofscala.app.world

import org.scalajs.dom
import org.scalajs.dom.{WebGLBuffer, WebGLProgram, WebGLRenderingContext => GL}

import scala.scalajs.js.JSConverters.*
import scala.scalajs.js.typedarray.*

import com.raquo.laminar.api.L.*
import scala.scalajs.js
import dev.worldofscala.webgl.given
object LaminarWebGLSample {
  def apply() = {
    canvasTag(onMountCallback { mc =>

      val canvas = mc.thisNode.ref
      canvas.width = 640
      canvas.height = 480

      val gl = canvas.getWebGLContext()

      // Updated vertex shader with matrices
      val vsSource = """
         attribute vec4 aVertexPosition;
         attribute vec4 aVertexColor;
         
         uniform mat4 uModelViewMatrix;
         uniform mat4 uProjectionMatrix;
         
         varying lowp vec4 vColor;
         
         void main() {
           gl_Position = uProjectionMatrix * uModelViewMatrix * aVertexPosition;
           vColor = aVertexColor;
         }
       """

      // Fragment shader program
      val fsSource = """
         varying lowp vec4 vColor;
         
         void main() {
           gl_FragColor = vColor;
         }
       """

      val shaderProgram = gl.initShaderProgram(vsSource, fsSource)

      // Get attribute and uniform locations
      val programInfo = new ProgramInfo(
        program = shaderProgram,
        attribLocations = AttribLocations(
          vertexPosition = gl.getAttribLocation(shaderProgram, "aVertexPosition"),
          vertexColor = gl.getAttribLocation(shaderProgram, "aVertexColor")
        ),
        uniformLocations = UniformLocations(
          projectionMatrix = gl.getUniformLocation(shaderProgram, "uProjectionMatrix"),
          modelViewMatrix = gl.getUniformLocation(shaderProgram, "uModelViewMatrix")
        )
      )

      // Create cube vertices (each face has a different color)
      val positions = new Float32Array(
        Array[Float](
          // Front face
          -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f,

          // Back face
          -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f,

          // Top face
          -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f,

          // Bottom face
          -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f,

          // Right face
          1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f,

          // Left face
          -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f
        ).toJSArray
      )

      // Colors for each vertex of each face
      val colors = new Float32Array(
        Array[Float](
          // Front face: white
          1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,

          // Back face: red
          1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f,

          // Top face: green
          0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f,

          // Bottom face: blue
          0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f,

          // Right face: yellow
          1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f,

          // Left face: purple
          1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f
        ).toJSArray
      )

      // Indices defining each face
      val indices = new Uint16Array(
        Array[Int](
          0, 1, 2, 0, 2, 3,       // front
          4, 5, 6, 4, 6, 7,       // back
          8, 9, 10, 8, 10, 11,    // top
          12, 13, 14, 12, 14, 15, // bottom
          16, 17, 18, 16, 18, 19, // right
          20, 21, 22, 20, 22, 23  // left
        ).toJSArray
      )

      val buffers = initBuffers(gl, positions, colors, indices)

      var rotation = 0.0
      def render(): Unit = {
        gl.clearColor(0.0f, 0.0f, 0.0f, 1.0f)
        gl.clearDepth(1.0f)
        gl.enable(GL.DEPTH_TEST)
        gl.depthFunc(GL.LEQUAL)

        gl.clear(GL.COLOR_BUFFER_BIT | GL.DEPTH_BUFFER_BIT)

        val fieldOfView      = 45.0 * Math.PI / 180.0
        val aspect           = canvas.clientWidth.toFloat / canvas.clientHeight.toFloat
        val zNear            = 0.1f
        val zFar             = 100.0f
        val projectionMatrix = Mat4.perspective(fieldOfView, aspect, zNear, zFar)

        val modelViewMatrix = Mat4.identity()
        Mat4.translate(modelViewMatrix, modelViewMatrix, js.Array(0.0, 0.0, -6.0))
        Mat4.rotate(modelViewMatrix, modelViewMatrix, rotation, js.Array(0.0, 1.0, 1.0))

        // Bind position buffer
        gl.bindBuffer(GL.ARRAY_BUFFER, buffers.position)
        gl.vertexAttribPointer(programInfo.attribLocations.vertexPosition, 3, GL.FLOAT, false, 0, 0)
        gl.enableVertexAttribArray(programInfo.attribLocations.vertexPosition)

        // Bind color buffer
        gl.bindBuffer(GL.ARRAY_BUFFER, buffers.color)
        gl.vertexAttribPointer(programInfo.attribLocations.vertexColor, 4, GL.FLOAT, false, 0, 0)
        gl.enableVertexAttribArray(programInfo.attribLocations.vertexColor)

        // Bind index buffer
        gl.bindBuffer(GL.ELEMENT_ARRAY_BUFFER, buffers.indices)

        gl.useProgram(programInfo.program)

        // Set uniforms
        gl.uniformMatrix4fv(programInfo.uniformLocations.projectionMatrix, false, projectionMatrix)
        gl.uniformMatrix4fv(programInfo.uniformLocations.modelViewMatrix, false, modelViewMatrix)

        gl.drawElements(GL.TRIANGLES, 36, GL.UNSIGNED_SHORT, 0)

        rotation += 0.01
        dom.window.requestAnimationFrame(_ => render())
      }

      render()

    })
  }

  private case class BufferSet(
    position: WebGLBuffer,
    color: WebGLBuffer,
    indices: WebGLBuffer
  )

  private case class AttribLocations(
    vertexPosition: Int,
    vertexColor: Int
  )

  private case class UniformLocations(
    projectionMatrix: org.scalajs.dom.WebGLUniformLocation,
    modelViewMatrix: org.scalajs.dom.WebGLUniformLocation
  )

  private case class ProgramInfo(
    program: WebGLProgram,
    attribLocations: AttribLocations,
    uniformLocations: UniformLocations
  )

  private def initBuffers(
    gl: GL,
    positions: Float32Array,
    colors: Float32Array,
    indices: Uint16Array
  ): BufferSet = {
    val positionBuffer = gl.createBuffer()
    gl.bindBuffer(GL.ARRAY_BUFFER, positionBuffer)
    gl.bufferData(GL.ARRAY_BUFFER, positions, GL.STATIC_DRAW)

    val colorBuffer = gl.createBuffer()
    gl.bindBuffer(GL.ARRAY_BUFFER, colorBuffer)
    gl.bufferData(GL.ARRAY_BUFFER, colors, GL.STATIC_DRAW)

    val indexBuffer = gl.createBuffer()
    gl.bindBuffer(GL.ELEMENT_ARRAY_BUFFER, indexBuffer)
    gl.bufferData(GL.ELEMENT_ARRAY_BUFFER, indices, GL.STATIC_DRAW)

    BufferSet(positionBuffer, colorBuffer, indexBuffer)
  }

  // Matrix operations helper object
  object Mat4 {
    def perspective(fovy: Double, aspect: Float, near: Float, far: Float): js.Array[Double] = {
      val out = js.Array[Double](0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
      val f   = 1.0 / Math.tan(fovy / 2)

      out(0) = f / aspect
      out(5) = f
      out(10) = (far + near) / (near - far)
      out(11) = -1
      out(14) = (2 * far * near) / (near - far)
      out
    }

    def identity(): js.Array[Double] = js.Array[Double](
      1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1
    )

    def translate(out: js.Array[Double], a: js.Array[Double], v: js.Array[Double]): js.Array[Double] = {
      val x = v(0); val y = v(1); val z = v(2)

      for (i <- 0 until 12) out(i) = a(i)

      out(12) = a(0) * x + a(4) * y + a(8) * z + a(12)
      out(13) = a(1) * x + a(5) * y + a(9) * z + a(13)
      out(14) = a(2) * x + a(6) * y + a(10) * z + a(14)
      out(15) = a(3) * x + a(7) * y + a(11) * z + a(15)

      out
    }

    def rotate(out: js.Array[Double], a: js.Array[Double], rad: Double, axis: js.Array[Double]): js.Array[Double] = {
      var x = axis(0)
      var y = axis(1)
      var z = axis(2)

      val len = Math.sqrt(x * x + y * y + z * z)

      if (len < 0.000001) return a

      x /= len
      y /= len
      z /= len

      val s = Math.sin(rad)
      val c = Math.cos(rad)
      val t = 1 - c

      val a00 = a(0); val a01 = a(1); val a02 = a(2); val a03  = a(3)
      val a10 = a(4); val a11 = a(5); val a12 = a(6); val a13  = a(7)
      val a20 = a(8); val a21 = a(9); val a22 = a(10); val a23 = a(11)

      val b00 = x * x * t + c
      val b01 = y * x * t + z * s
      val b02 = z * x * t - y * s
      val b10 = x * y * t - z * s
      val b11 = y * y * t + c
      val b12 = z * y * t + x * s
      val b20 = x * z * t + y * s
      val b21 = y * z * t - x * s
      val b22 = z * z * t + c

      out(0) = a00 * b00 + a10 * b01 + a20 * b02
      out(1) = a01 * b00 + a11 * b01 + a21 * b02
      out(2) = a02 * b00 + a12 * b01 + a22 * b02
      out(3) = a03 * b00 + a13 * b01 + a23 * b02
      out(4) = a00 * b10 + a10 * b11 + a20 * b12
      out(5) = a01 * b10 + a11 * b11 + a21 * b12
      out(6) = a02 * b10 + a12 * b11 + a22 * b12
      out(7) = a03 * b10 + a13 * b11 + a23 * b12
      out(8) = a00 * b20 + a10 * b21 + a20 * b22
      out(9) = a01 * b20 + a11 * b21 + a21 * b22
      out(10) = a02 * b20 + a12 * b21 + a22 * b22
      out(11) = a03 * b20 + a13 * b21 + a23 * b22

      if (a != out) {
        out(12) = a(12)
        out(13) = a(13)
        out(14) = a(14)
        out(15) = a(15)
      }

      out
    }
  }
}
