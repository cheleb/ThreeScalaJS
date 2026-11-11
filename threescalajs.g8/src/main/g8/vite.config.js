import { defineConfig } from "vite";
import scalaJSPlugin from "@scala-js/vite-plugin-scalajs";

export default defineConfig({
  // Resolves `scalajs:main.js` by running sbt fastLinkJS (dev) / fullLinkJS (build).
  plugins: [scalaJSPlugin()],
});
