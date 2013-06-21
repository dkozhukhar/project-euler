(ns project-euler.pr073
    (:require
    [project-euler.primes  :as primes]
    [clojure.math.numeric-tower :as math]))


(->>
 (for [n (range 2 12001)
       d (range  (int (inc (Math/floor (/ n 3)))) (int (Math/ceil (/ n 2))))
       ;:when (> n (* 2 d))
       ;:when (< n (* 3 d))
       :when (zero? (dec(math/gcd n d)))
       ] 1)
 count
 println
 time
 )
