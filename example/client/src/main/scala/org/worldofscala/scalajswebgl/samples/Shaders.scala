package org.worldofscala.scalajswebgl.samples

import org.scalajs.dom.{WebGLRenderingContext => GL}
import dev.worldofscala.webgl.{given, Coord}
import dev.worldofscala.webglaminar.webglCanvas

object Shaders {

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
      |  fragColor = vec4(0, 1, 0, 0.8);
       |
       |}"""

  def apply() = webglCanvas(vertexShader, fragmentShader) { ctx =>
    val gl = ctx.gl2
    val vertices = Array(
      Coord(-1.0f, -1.0f, 0.0f), //
      Coord(1.0f, -1.0f, 0.0f),  //
      Coord(1.0f, 1.0f, 0.0f)
    )

    val vertexData = vertices.f32
    // Updated vertex shader with matrices
    gl.bindBuffer(GL.ARRAY_BUFFER, gl.createBuffer());
    gl.bufferData(GL.ARRAY_BUFFER, vertexData, GL.STATIC_DRAW);

    val vertexPosition = gl.getAttribLocation(ctx.program, "vertexPosition");
    gl.enableVertexAttribArray(vertexPosition);
    gl.vertexAttribPointer(vertexPosition, 3, GL.FLOAT, false, 0, 0);

    gl.drawArrays(GL.TRIANGLES, 0, vertices.length);
  }

}
