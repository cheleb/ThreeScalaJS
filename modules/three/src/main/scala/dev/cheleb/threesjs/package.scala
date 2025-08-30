package dev.cheleb.threesjs

import org.scalajs.dom.Event
import org.scalajs.dom.window

import THREE.PerspectiveCamera
import THREE.WebGLRenderer

def onWindowResize(camera: PerspectiveCamera, renderer: WebGLRenderer, margin: Double): Event => Unit = _ => {

  val SCREEN_WIDTH  = window.innerWidth;
  val SCREEN_HEIGHT = window.innerHeight;
  val aspect        = SCREEN_WIDTH / SCREEN_HEIGHT;

  renderer.setSize(SCREEN_WIDTH * margin, SCREEN_HEIGHT * margin);

  camera.aspect = aspect;
  camera.updateProjectionMatrix();

}
