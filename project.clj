(defproject url-shortener "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :ring {:handler url-shortener.server/app
         :nrepl{:start? true}}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.1"]]
  :plugins [[lein-ring "0.9.7"]
            [cider/cider-nrepl "0.13.0-SNAPSHOT"]]
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]}})

