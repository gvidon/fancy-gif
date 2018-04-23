(defproject fancy-gif "0.0.1"
  :dependencies [
    [figwheel "0.3.7"]
    [org.clojure/clojure "1.8.0"]
    [org.clojure/clojurescript "1.9.908"]
    [reagent "0.7.0"]]

  :plugins [
    [lein-cljsbuild "1.1.5"]
    [lein-figwheel  "0.5.13"]]

  :hooks [leiningen.cljsbuild]

  :figwheel {
    :repl false}

  :cljsbuild {
    :builds {
      :client {
        :figwheel {
          :on-jsload "fancy-gif.core/run"}
        
        :compiler {
          :asset-path "/build/js"
          :main "fancy-gif.core"
          :optimizations :none
          :output-dir "resources/public/build/js"
          :output-to "resources/public/build/js/client.js"}

        :source-paths ["src"]}}})
