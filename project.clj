(defproject terra-server "0.1.0-SNAPSHOT"
  :description "An alternative terraria server written in clojure"
  :url "https://github.com/KJ002/terra-server"
  :license {:name "EPL-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [aleph "0.5.0-rc2"]
                 [byte-streams "0.2.5-alpha2"]
                 [manifold "0.2.4"]
                 [gloss "0.2.6"]]
  :repl-options {:init-ns terra-server.core}
  :main terra-server.core)
