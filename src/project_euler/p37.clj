(ns project-euler.p37
      (:require
             [project-euler.primes  :as primes]
             [project-euler.utils  :as utils]
             [clojure.math.combinatorics :as combo]
       )
)


;Truncatable primes
;Problem 37
;The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

;Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

;NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.


(defn truncatable? [n]
  (let [s (str n)]
    (every? identity
     (map primes/prime?
       (sort
        (apply concat
        (for [t (range 1 (count s))]
          (map #(read-string(apply str %)) (split-at t s))
          )))))))

(time
(println
(apply +
  (for [lvl (range 2 7)
      n (map #(read-string(apply str %))
                (combo/selections '(1 2 3 5 7 9) lvl))
      :when (truncatable? n)
      :when (primes/prime? n)]
    n))))
;=> 748317


