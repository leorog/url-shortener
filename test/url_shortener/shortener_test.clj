(ns url-shortener.shortener-test
  (:require  [clojure.test :refer :all]
             [url-shortener.shortener :as s]))

(deftest char-seq-test
  (testing "charseq length and values"
    (is (= \0 (first s/char-seq)))
    (is (= \z (last s/char-seq)))))

(deftest shortener-test
  (testing "given a url short it to length 5"
    (let [url-alias (s/short-url "https://nubank.com.br")]
      (is (= 5 (count url-alias))))))

(deftest save-and-get-test
  (testing "save an url and get it"
    (let [url-alias (s/save "www.nubank.com" "Abc1#k")]
      (is (= "www.nubank.com" (s/get-url url-alias))))))
