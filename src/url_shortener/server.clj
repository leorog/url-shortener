(ns url-shortener.server
  (:use compojure.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            [ring.middleware.json :as middleware]
            [url-shortener.shortener :as shortener]))

(defroutes api-routes

  (POST "/url" {body :body}
    {:status 201
     :headers {"Content-Type" "application/json; charset=utf-8"}
     :body (->> (body "url")
                (shortener/short-url)
                (shortener/save (body "url")))})

  (GET "/url/:url" {{url :url} :params}
    {:status 200
     :headers {"Content-Type" "text/html; charset=utf-8"}
     :body (shortener/get-url url)})

  (route/not-found "<h1>Page not found</h1>"))

(def app
  (-> (handler/api api-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))
