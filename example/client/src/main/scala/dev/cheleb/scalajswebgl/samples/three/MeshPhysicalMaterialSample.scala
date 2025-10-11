package dev.cheleb.scalajswebgl.samples.three

import com.raquo.laminar.api.L.*

import THREE.*

import org.scalajs.dom
import org.scalajs.dom.window
import scala.scalajs.js

object MeshPhysicalMaterialSample {

  def apply() =

    val physicalDiv = div(
      h1("MeshPhysicalMaterial Demo"),
      p(
        "Demonstrating MeshPhysicalMaterial - an advanced PBR material with clearcoat, transmission, refraction, and other realistic material properties."
      ),
      div(
        cls := "canvas-container"
      )
    )

    // Create scene
    val scene = Scene()

    // Create camera
    val camera = new PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
    camera.position.z = 12

    // Create renderer
    val renderer = WebGLRenderer(antialias = true)
    renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    renderer.setClearColor("#1a1a2e", 1)

    // Create different objects showcasing advanced PBR properties

    // 1. Car paint with clearcoat (metallic red with glossy clearcoat)
    val carPaintSphere   = new SphereGeometry(1.2, 32, 16)
    val carPaintMaterial = MeshPhysicalMaterial(
      color = 0xff4444,
      metalness = 0.9,
      roughness = 0.1,
      clearcoat = 1.0,          // Strong clearcoat
      clearcoatRoughness = 0.1, // Smooth clearcoat
      emissive = 0x220000,
      emissiveIntensity = 0.1
    )
    val carPaintMesh = new Mesh(carPaintSphere, carPaintMaterial)
    carPaintMesh.position.set(-6, 3, 0)
    scene.add(carPaintMesh)

    // 2. Glass-like material with transmission
    val glassSphere   = new SphereGeometry(1.2, 32, 16)
    val glassMaterial = MeshPhysicalMaterial(
      color = 0x88ccff,
      metalness = 0.0,
      roughness = 0.0,
      transmission = 0.9, // Highly transmissive
      thickness = 0.5,
      ior = 1.5, // Glass IOR
      emissive = 0x002244,
      emissiveIntensity = 0.1
    )
    val glassMesh = new Mesh(glassSphere, glassMaterial)
    glassMesh.position.set(-2, 3, 0)
    scene.add(glassMesh)

    // 3. Velvet-like fabric with sheen
    val fabricSphere   = new SphereGeometry(1.2, 32, 16)
    val fabricMaterial = MeshPhysicalMaterial(
      color = 0x4444ff,
      metalness = 0.0,
      roughness = 0.8,
      sheen = 1.0, // Strong sheen effect
      sheenColor = 0x6666ff,
      sheenRoughness = 0.3,
      emissive = 0x000022,
      emissiveIntensity = 0.1
    )
    val fabricMesh = new Mesh(fabricSphere, fabricMaterial)
    fabricMesh.position.set(2, 3, 0)
    scene.add(fabricMesh)

    // 4. Gemstone-like material (high IOR, colorful)
    val gemSphere   = new SphereGeometry(1.2, 32, 16)
    val gemMaterial = MeshPhysicalMaterial(
      color = 0xff44ff,
      metalness = 0.0,
      roughness = 0.0,
      transmission = 0.8,
      thickness = 1.0,
      ior = 2.4, // Diamond-like IOR
      attenuationColor = 0xff44ff,
      attenuationDistance = 0.5,
      emissive = 0x220022,
      emissiveIntensity = 0.2
    )
    val gemMesh = new Mesh(gemSphere, gemMaterial)
    gemMesh.position.set(6, 3, 0)
    scene.add(gemMesh)

    // 5. Bottom row - more examples
    val wetSurfaceSphere   = new SphereGeometry(1.2, 32, 16)
    val wetSurfaceMaterial = MeshPhysicalMaterial(
      color = 0x44ff44,
      metalness = 0.0,
      roughness = 0.2,
      clearcoat = 0.8,          // Wet surface effect
      clearcoatRoughness = 0.0, // Perfect clearcoat
      transmission = 0.1,
      emissive = 0x002200,
      emissiveIntensity = 0.1
    )
    val wetSurfaceMesh = new Mesh(wetSurfaceSphere, wetSurfaceMaterial)
    wetSurfaceMesh.position.set(-6, -3, 0)
    scene.add(wetSurfaceMesh)

    // 6. Metallic gold with patina
    val goldSphere   = new SphereGeometry(1.2, 32, 16)
    val goldMaterial = MeshPhysicalMaterial(
      color = 0xffaa44,
      metalness = 1.0,
      roughness = 0.3, // Slightly rough gold
      clearcoat = 0.3, // Light clearcoat
      clearcoatRoughness = 0.2,
      specularIntensity = 0.8,
      specularColor = 0xffdd88,
      emissive = 0x332200,
      emissiveIntensity = 0.1
    )
    val goldMesh = new Mesh(goldSphere, goldMaterial)
    goldMesh.position.set(-2, -3, 0)
    scene.add(goldMesh)

    // 7. Reference cubes showing material properties
    val clearcoatCube     = new BoxGeometry(0.8, 0.8, 0.8)
    val clearcoatMaterial = MeshPhysicalMaterial(
      color = 0xff6666,
      metalness = 0.9,
      roughness = 0.2,
      clearcoat = 1.0,
      clearcoatRoughness = 0.1,
      emissive = 0x220000,
      emissiveIntensity = 0.2
    )
    val clearcoatCubeMesh = new Mesh(clearcoatCube, clearcoatMaterial)
    clearcoatCubeMesh.position.set(2, -3, 0)
    scene.add(clearcoatCubeMesh)

    val transmissiveCube     = new BoxGeometry(0.8, 0.8, 0.8)
    val transmissiveMaterial = MeshPhysicalMaterial(
      color = 0x66ff66,
      metalness = 0.0,
      roughness = 0.0,
      transmission = 0.7,
      thickness = 0.8,
      ior = 1.33, // Water IOR
      attenuationColor = 0x66ff66,
      emissive = 0x002200,
      emissiveIntensity = 0.1
    )
    val transmissiveCubeMesh = new Mesh(transmissiveCube, transmissiveMaterial)
    transmissiveCubeMesh.position.set(6, -3, 0)
    scene.add(transmissiveCubeMesh)

    // Add lighting to showcase advanced PBR properties
    val directionalLight = DirectionalLight(0xffffff, 1)
    directionalLight.position.set(5, 5, 5)
    scene.add(directionalLight)

    val directionalLight2 = DirectionalLight(0xffffff, 0.5)
    directionalLight2.position.set(-5, 3, 2)
    scene.add(directionalLight2)

    val ambientLight = AmbientLight(0x404040, 0.3)
    scene.add(ambientLight)

    // Animation loop
    val animate: () => Unit = () => {
      val time = js.Date.now() * 0.001

      // Rotate spheres at different speeds
      carPaintMesh.rotation.x = time * 0.3
      carPaintMesh.rotation.y = time * 0.5

      glassMesh.rotation.x = time * 0.4
      glassMesh.rotation.y = time * 0.3

      fabricMesh.rotation.y = time * 0.5
      fabricMesh.rotation.z = time * 0.2

      gemMesh.rotation.x = time * 0.2
      gemMesh.rotation.z = time * 0.6

      wetSurfaceMesh.rotation.x = time * 0.6
      wetSurfaceMesh.rotation.z = time * 0.3

      goldMesh.rotation.y = time * 0.4
      goldMesh.rotation.z = time * 0.5

      clearcoatCubeMesh.rotation.x = time * 0.3
      clearcoatCubeMesh.rotation.y = time * 0.7

      transmissiveCubeMesh.rotation.z = time * 0.4

      renderer.render(scene, camera)
    }
    renderer.setAnimationLoop(animate)

    // Handle window resize
    val onWindowResize: dom.Event => Unit = { _ =>
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix()
      renderer.setSize(window.innerWidth * 0.8, window.innerHeight * 0.8)
    }
    window.addEventListener("resize", onWindowResize)

    // Append renderer to the canvas container
    physicalDiv.ref.querySelector(".canvas-container").appendChild(renderer.domElement)

    physicalDiv
}
