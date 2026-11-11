# threescalajs.g8

A [giter8](https://www.foundweekends.org/giter8/) template for a Three.js application in Scala 3 / Scala.js,
built with sbt and bundled with Vite, using the [ThreeScalaJS](https://github.com/cheleb/ThreeScalaJS) facades.

## Usage

```sh
sbt new cheleb/ThreeScalaJS --directory=threescalajs.g8
```

Then, in the generated folder:

```sh
npm install
npm run dev      # http://localhost:5173
npm run build    # production bundle in dist/
```

## Parameters

Current defaults live in [`src/main/g8/default.properties`](src/main/g8/default.properties).

| Property | Purpose |
| --- | --- |
| `name` | Project, folder and npm package name |
| `description` | One-line description used in the generated README |
| `organization` | sbt organization |
| `package` | Root Scala package (derived from `organization` and `name`) |
| `scala_version` | Scala version; must be at least the one `threesjs` was published with |
| `scalajs_version` | sbt-scalajs plugin version |
| `scalajs_dom_version` | scalajs-dom version |
| `threesjs_version` | `dev.cheleb %%% threesjs` version |
| `three_version` | npm `three` version; must match the facades of `threesjs_version` (CI compares it with `example/client/package.json` at tag `v<threesjs_version>`); bump both together |
| `vite_version` | Vite version |
| `vite_plugin_scalajs_version` | `@scala-js/vite-plugin-scalajs` version |

## Developing the template

```sh
sbt test   # renders the template and runs `fastLinkJS` on the result (src/test/g8/test)
sbt g8     # renders into target/g8 for manual inspection
```
