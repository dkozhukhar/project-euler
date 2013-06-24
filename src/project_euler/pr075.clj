(ns project-euler.pr075
    (:require
    [project-euler.primes  :as primes]
    [clojure.math.numeric-tower :as math]))



(->>
(for [m (range 1 1500)
      n (range 1 m)
      :when (odd? (- m n))
      :when (zero? (dec (math/gcd m n)))
      :let [ a  (- (* m m) (* n n))
             b  (* 2 m n)
             c  (+ (* m m) (* n n))
             p (+ a b c)]
      k (range 1 (inc (quot 1500000 p)))
      :when (>= 1500000 (* p k))
      ]
  ;[(* a k) (* b k) (* c k)])
  (* p k))
 ;set
 ;(map #(apply + %))
 ; count
 frequencies
 (filter (fn [[a b]] (= b 1)) )
 ;(take 10)
 count
 println
 time)