(ns project-euler.pr073
    (:require
    [project-euler.primes  :as primes]
    [clojure.math.numeric-tower :as math]))

;pure force
(->>
 (for [n (range 5 12001)
       d (range  (inc (quot n 3)) (inc (quot n 2)))
       ;:when (> n (* 2 d))
       ;:when (< n (* 3 d))
       :when (zero? (dec(math/gcd n d)))
       ] 1)
 count
 println
 time
 )
