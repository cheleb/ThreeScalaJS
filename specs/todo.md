## ThreeScalaJS - Unmapped Three.js Components

Based on the current implementation, here's a comprehensive list of Three.js components and features that are **not yet mapped** to Scala bindings:

### **Geometries** (Missing Many)
- [x] **SphereGeometry** - Spherical shapes
- [x] **PlaneGeometry** - Flat planes
- [x] **CylinderGeometry** - Cylindrical shapes
- [x] **ConeGeometry** - Conical shapes
- [x] **TorusGeometry** - Donut/torus shapes
- [x] **RingGeometry** - Ring shapes
- [x] **CircleGeometry** - Circular shapes
- [x] **ShapeGeometry** - Custom 2D shapes extruded to 3D
- [x] **ExtrudeGeometry** - Extruded 2D shapes
- [x] **LatheGeometry** - Rotationally symmetric shapes
- [x] **TextGeometry** - 3D text rendering
- [x] **BufferGeometry utilities** - Advanced vertex manipulation

### **Materials** (Major Gaps)
- [x] **MeshLambertMaterial** - Diffuse lighting model
- [x] **MeshStandardMaterial** - Physically-based rendering (PBR)
- [x] **MeshPhysicalMaterial** - Advanced PBR with clearcoat, etc.
- [x] **MeshMatcapMaterial** - Matcap (material capture) shading
- [x] **MeshNormalMaterial** - Normal map visualization
- [x] **MeshDepthMaterial** - Depth-based rendering
- [x] **MeshDistanceMaterial** - Distance-based rendering
- [x] **ShaderMaterial** - Custom GLSL shaders
- [x] **RawShaderMaterial** - Unlit custom shaders
- [x] **LineDashedMaterial** - Dashed line rendering
- [x] **ShadowMaterial** - Shadow casting materials

### **Lights** (Missing Several)
- [x] **PointLight** - Omnidirectional point lights
- [x] **SpotLight** - Directional cone lights
- [x] **HemisphereLight** - Sky-like ambient lighting
- [x] **RectAreaLight** - Rectangular area lights
- [x] **LightProbe** - Image-based lighting

### **Objects** (Missing Advanced Objects)
- [x] **LOD (Level of Detail)** - Multiple distance-based models
- [x] **SkinnedMesh** - Skeletal animation support
- [x] **Skeleton** - Bone structure for animation
- [x] **Bone** - Individual bones for skeletal animation
- [x] **Sprite** - Billboard sprites (implementation missing)
- [x] **LensFlare** - Camera lens flare effects
- [x] **Reflector** - Reflective surfaces
- [x] **Refractor** - Refractive surfaces
- [x] **Water** - Water surface simulation

### **Animation System** (✅ **COMPLETED**)
- [x] **AnimationClip** - Animation data container
- [x] **AnimationMixer** - Animation controller
- [x] **AnimationObjectGroup** - Group animation management
- [x] **AnimationAction** - Individual animation instances
- [x] **KeyframeTrack** - Animation keyframe data
- [x] **PropertyBinding** - Property animation binding
- [x] **PropertyMixer** - Property interpolation

### **Post-Processing** (✅ **COMPLETED**)
- [x] **EffectComposer** - Post-processing pipeline
- [x] **ShaderPass** - Custom shader effects
- [x] **RenderPass** - Scene rendering pass
- [x] **BloomPass** - Bloom/glow effects
- [x] **FilmPass** - Film grain effects
- [x] **DotScreenPass** - Dot screen/halftone effects
- [x] **UnrealBloomPass** - Advanced bloom effects
- [x] **GlitchPass** - Digital glitch effects
- [x] **BokehPass** - Depth of field effects
- [x] **SSRPass** - Screen space reflections
- [x] **SSAOPass** - Screen space ambient occlusion
- [x] **OutputPass** - Tone mapping and color space conversion

### **Advanced Loaders** (✅ **COMPLETED**)
- [x] **ObjectLoader** - Scene object loading
- [x] **MaterialLoader** - Material definition loading
- [x] **BufferGeometryLoader** - Geometry data loading
- [x] **ImageBitmapLoader** - Image bitmap loading
- [x] **FontLoader** - Font data for TextGeometry
- [x] **FileLoader** - Generic file loading
- [x] **AudioLoader** - Audio file loading
- [x] **SVGLoader** - SVG file parsing

### **Helpers and Utilities** (Mostly Missing)
- [x] **AxesHelper** - Coordinate axes visualization
- [x] **GridHelper** - Grid plane visualization
- [x] **PolarGridHelper** - Polar coordinate grid
- [x] **ArrowHelper** - Arrow direction indicator
- [x] **Box3Helper** - Box3 bounding box visualization
- [x] **BoxHelper** - Object bounding box
- [x] **CameraHelper** - Camera frustum visualization
- [x] **DirectionalLightHelper** - Light direction visualization
- [-] **FaceNormalsHelper** - Face normal visualization
- [x] **PlaneHelper** - Plane visualization
- [x] **PointLightHelper** - Point light visualization
- **SkeletonHelper** - Skeleton bone visualization
- **SpotLightHelper** - Spot light visualization
- [x] **VertexNormalsHelper** - Vertex normal visualization

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

### **Audio** (✅ **COMPLETED**)
- [x] **Audio** - 3D spatial audio
- [x] **AudioListener** - Audio listener/camera
- [x] **AudioAnalyser** - Audio frequency analysis
- [x] **PositionalAudio** - Position-dependent audio

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