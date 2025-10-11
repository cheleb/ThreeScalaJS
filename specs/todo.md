## ThreeScalaJS - Unmapped Three.js Components

Based on the current implementation, here's a comprehensive list of Three.js components and features that are **not yet mapped** to Scala bindings:

### **Geometries** (Missing Many)
- [x] **SphereGeometry** - Spherical shapes
- [x] **PlaneGeometry** - Flat planes
- [x] **CylinderGeometry** - Cylindrical shapes
- [x] **ConeGeometry** - Conical shapes
- **TorusGeometry** - Donut/torus shapes
- **RingGeometry** - Ring shapes
- **CircleGeometry** - Circular shapes
- **ShapeGeometry** - Custom 2D shapes extruded to 3D
- **ExtrudeGeometry** - Extruded 2D shapes
- **LatheGeometry** - Rotationally symmetric shapes
- **TextGeometry** - 3D text rendering
- **BufferGeometry utilities** - Advanced vertex manipulation

### **Materials** (Major Gaps)
- **MeshLambertMaterial** - Diffuse lighting model
- **MeshStandardMaterial** - Physically-based rendering (PBR)
- **MeshPhysicalMaterial** - Advanced PBR with clearcoat, etc.
- **MeshMatcapMaterial** - Matcap (material capture) shading
- **MeshNormalMaterial** - Normal map visualization
- **MeshDepthMaterial** - Depth-based rendering
- **MeshDistanceMaterial** - Distance-based rendering
- **ShaderMaterial** - Custom GLSL shaders
- **RawShaderMaterial** - Unlit custom shaders
- **LineDashedMaterial** - Dashed line rendering
- **ShadowMaterial** - Shadow casting materials

### **Lights** (Missing Several)
- **PointLight** - Omnidirectional point lights
- **SpotLight** - Directional cone lights
- **HemisphereLight** - Sky-like ambient lighting
- **RectAreaLight** - Rectangular area lights
- **LightProbe** - Image-based lighting
- **AmbientLightProbe** - Ambient light probes

### **Objects** (Missing Advanced Objects)
- **LOD (Level of Detail)** - Multiple distance-based models
- **SkinnedMesh** - Skeletal animation support
- **Skeleton** - Bone structure for animation
- **Bone** - Individual bones for skeletal animation
- **Sprite** - Billboard sprites (implementation missing)
- **LensFlare** - Camera lens flare effects
- **Reflector** - Reflective surfaces
- **Refractor** - Refractive surfaces
- **Water** - Water surface simulation

### **Animation System** (Completely Missing)
- **AnimationClip** - Animation data container
- **AnimationMixer** - Animation controller
- **AnimationObjectGroup** - Group animation management
- **AnimationAction** - Individual animation instances
- **KeyframeTrack** - Animation keyframe data
- **PropertyBinding** - Property animation binding
- **PropertyMixer** - Property interpolation

### **Post-Processing** (Completely Missing)
- **EffectComposer** - Post-processing pipeline
- **ShaderPass** - Custom shader effects
- **RenderPass** - Scene rendering pass
- **BloomPass** - Bloom/glow effects
- **FilmPass** - Film grain effects
- **DotScreenPass** - Dot screen/halftone effects
- **GlitchPass** - Digital glitch effects
- **UnrealBloomPass** - Advanced bloom effects
- **BokehPass** - Depth of field effects
- **SSRPass** - Screen space reflections
- **SSAOPass** - Screen space ambient occlusion

### **Advanced Loaders** (Missing Several)
- **ObjectLoader** - Scene object loading
- **MaterialLoader** - Material definition loading
- **BufferGeometryLoader** - Geometry data loading
- **ImageBitmapLoader** - Image bitmap loading
- **FontLoader** - Font data for TextGeometry
- **FileLoader** - Generic file loading
- **AudioLoader** - Audio file loading
- **SVGLoader** - SVG file parsing

### **Helpers and Utilities** (Mostly Missing)
- **AxesHelper** - Coordinate axes visualization
- **GridHelper** - Grid plane visualization
- **PolarGridHelper** - Polar coordinate grid
- **ArrowHelper** - Arrow direction indicator
- **Box3Helper** - Box3 bounding box visualization
- **BoxHelper** - Object bounding box
- **CameraHelper** - Camera frustum visualization
- **DirectionalLightHelper** - Light direction visualization
- **FaceNormalsHelper** - Face normal visualization
- **PlaneHelper** - Plane visualization
- **PointLightHelper** - Point light visualization
- **SkeletonHelper** - Skeleton bone visualization
- **SpotLightHelper** - Spot light visualization
- **VertexNormalsHelper** - Vertex normal visualization

### **Fog Effects** (Completely Missing)
- **Fog** - Linear fog effect
- **FogExp2** - Exponential fog effect

### **Shadows** (System Missing)
- **Shadow mapping system** - Complete shadow implementation
- **Light shadow properties** - Shadow camera configuration
- **Shadow materials** - Shadow rendering materials

### **Advanced Textures** (Missing Several)
- **CompressedTexture** - Compressed texture formats
- **DepthTexture** - Depth buffer textures
- **FramebufferTexture** - Render target textures

### **Renderers** (Missing Advanced Features)
- **WebGL2Renderer** - WebGL 2.0 features
- **WebGLMultipleRenderTargets** - Multiple render targets
- **WebGLRenderTarget** - Custom render targets
- **WebGLCubeRenderTarget** - Cube map render targets

### **Audio** (Completely Missing)
- **Audio** - 3D spatial audio
- **AudioListener** - Audio listener/camera
- **AudioAnalyser** - Audio frequency analysis
- **PositionalAudio** - Position-dependent audio

### **Advanced Controls** (Missing)
- **DragControls** - Drag object manipulation
- **TransformControls** - Gizmo-based transformation
- **PointerLockControls** - Mouse lock for FPS controls
- **DeviceOrientationControls** - Mobile device orientation
- **FlyControls** - Flight simulator controls
- **FirstPersonControls** - First-person camera controls
- **TrackballControls** - Trackball camera manipulation

### **Curves and Paths** (Completely Missing)
- **Curve** - Base curve class
- **CurvePath** - Multi-curve paths
- **CatmullRomCurve3** - Smooth curve interpolation
- **CubicBezierCurve3** - Bezier curve segments
- **QuadraticBezierCurve3** - Quadratic Bezier curves
- **LineCurve3** - Straight line curves
- **EllipseCurve** - Elliptical curves

### **WebXR** (Completely Missing)
- **WebXRManager** - VR/AR functionality
- **XRController** - VR controller input

This represents a significant expansion opportunity for the ThreeScalaJS library, with the current implementation covering approximately **30-40%** of the full Three.js API surface area.