(ns terra-server.core
  (:gen-class)
  (:require
   [manifold.stream :as s]
   [byte-streams :as byte-streams]
   [aleph.tcp :as tcp]
   [gloss.core :as gloss]
   [gloss.io :as io]
   [clojure.edn :as edn]
   ))

(defn echo-handler [s info]
  (s/map #(println (byte-streams/convert %1 String)) s)
  (s/connect s s)
  )

(defn -main
  [& args]
  (println "started")
  (tcp/start-server echo-handler {:port 4204})
  )
