(ns project-euler.pr072b
    (:require
    [project-euler.primes  :as primes]
    [clojure.math.numeric-tower :as math]))

; b for brute-force

(defn phi [multiples]
  (* (reduce * multiples)
     (reduce *
      (map
      (fn [p]  (- 1 (/ p)))
      (set multiples)
      ))
     ))


(defn multiples
  [n
   p]
  (cond
    (> p (->> n Math/sqrt int)) `(~n)
    (zero? (rem n p)) (cons p  (multiples (quot n p) p))
    :else (multiples n (inc p))
   )
  )

(defn totient [n]  ; euler's totient function, this is project euler problem btw
  (phi (multiples n 2)))


(->>
 (range 2 1000001)
 (map #(totient %))
 (reduce +)
 println
 time)
;"Elapsed time: 74699.240756 msecs"
