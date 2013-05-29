(ns project-euler.p50
   (:require [project-euler.primes  :as primes]))

;Consecutive prime sum
;Problem 50
;The prime 41, can be written as the sum of six consecutive primes:

;41 = 2 + 3 + 5 + 7 + 11 + 13
;This is the longest sum of consecutive primes that adds to a prime below one-hundred.

;The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

;Which prime, below one-million, can be written as the sum of the most consecutive primes?



(defn gs [n]
(loop [
  coll (drop n (primes/lazy-primes3))
  limit 1000000
  sum 0
  pcount 0
  psumcnt 0
  res '()]
      (cond
       (> (+ sum (first coll)) limit)            [psumcnt res]
       ;(empty? coll)                            [sum (count res) res]
       (primes/prime? (+ sum (first coll)))
          (recur 
            (drop 1 coll) 
            limit 
            (+ sum (first coll))
            (inc pcount)
            (inc pcount) ; count largest prime streak
            (+ sum (first coll))
            ) ; logs prime prime streak sums
       :else
          (recur 
              (drop 1 coll) 
              limit 
              (+ sum (first coll))
              (inc pcount)
              psumcnt
              res)
          )
      ))

(reduce (fn [[l1 p1] [l2 p2]] (if (> l2 l1) [l2 p2] [l1 p1]))
          (map gs (range 10)))

; 997651 - 543

