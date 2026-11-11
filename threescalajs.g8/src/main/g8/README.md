# $name$

$description$

A [Three.js](https://threejs.org) application written in Scala 3 with
[Scala.js](https://www.scala-js.org) and the
[ThreeScalaJS](https://github.com/cheleb/ThreeScalaJS) facades, bundled with [Vite](https://vite.dev).

## Prerequisites

- JDK 17+ and [sbt](https://www.scala-sbt.org)
- [Node.js](https://nodejs.org) 20+ (or bun)

## Develop

```sh
npm install
npm run dev
```

Open http://localhost:5173. Vite runs `sbt fastLinkJS` through `@scala-js/vite-plugin-scalajs`.

For faster turnaround, keep `sbt ~fastLinkJS` running in a second terminal and Vite will reload on every change.

## Build for production

```sh
npm run build   # runs sbt fullLinkJS, output in dist/
npm run preview
```

## Layout

- `src/main/scala/$package;format="packaged"$/Main.scala`: scene setup and the render loop
- `index.html`, `main.js`, `css/`: web entry point loaded by Vite
- `build.sbt`: Scala.js build, depends on `"dev.cheleb" %%% "threesjs" % "$threesjs_version$"`
