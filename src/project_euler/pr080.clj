(ns project-euler.pr080
    (:require [clojure.math.numeric-tower :as math]
                [project-euler.utils  :as utils]))


(def d100 (reduce * (repeat 105 100N)))

(defn solv [n]
(->> n
     (* d100)
     math/exact-integer-sqrt
     first
     utils/digits
     (take 100)
     (reduce +)
     ))



(->>
(for [t (range 1 101)
      :when (not= t (* (int (Math/sqrt t)) (int (Math/sqrt t))))]
  (solv t))
 (reduce +)
 println
 time)