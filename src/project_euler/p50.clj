(ns project-euler.p50
   (:require [project-euler.primes  :as primes])

  )



;Consecutive prime sum
;Problem 50
;The prime 41, can be written as the sum of six consecutive primes:

;41 = 2 + 3 + 5 + 7 + 11 + 13
;This is the longest sum of consecutive primes that adds to a prime below one-hundred.

;The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

;Which prime, below one-million, can be written as the sum of the most consecutive primes?

(time
(println
 (count
 (map (set (primes/primes3 1000000)) (range 2 10000000)))))


(time
 (println
  (let [pp (apply sorted-set (primes/primes3 10000))
        yp (filter #(< % 1000) pp)]
     (reduce
      (fn [[a b][c d]] (if (> c a) [c d] [a b]))
      [1 0]
          (for [p yp
            :let [pp* (filter #(>= % p) pp)
                  mpl (quot 10000 p)]]
             (reduce
                (fn [[a b][c d]] (if (> c a) [c d] [a b]))
                [1 0] (for [rp (range 1 mpl)
                            :let [p* (take rp pp*)
                                  p*s (count p*)
                                  s* (reduce + p*)]
                            :when (not (nil? (pp s*)))]
                    [p*s s*]))
            ;    [:p p :pp* pp* :mpl mpl :rp rp :p* p*  :p*s p*s :s* s*]
      )))))



