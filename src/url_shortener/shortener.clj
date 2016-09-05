(ns url-shortener.shortener)

(def ^:private url-table (atom {}))
(def char-seq (->> (concat (range 48 58)
                           (range 65 91)
                           (range 97 123))
                   (map char)))

(defn get-url [url-alias]
  (@url-table url-alias))

(defn save [url url-alias]
  (swap! url-table assoc url-alias url)
  url-alias)

(defn short-url [url]
  (->> (shuffle char-seq)
       (take 5)
       (apply str)))
