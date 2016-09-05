(ns url-shortener.shortener)

(def ^:private url-table (atom {}))
(def char-seq (->> (range 33 127)
                (map char)))

(defn get [url-alias]
  (@url-table url-alias))

(defn save [url url-alias]
  (swap! url-table assoc url-alias url)
  url-alias)

(defn short-url [url]
  (->> (shuffle char-seq)
      (take 5)
      (apply str)))
