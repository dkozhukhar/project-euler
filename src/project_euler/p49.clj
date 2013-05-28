(ns project-euler.p49
   (:require [project-euler.primes  :as primes])

  )



;Prime permutations
;Problem 49
;The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

;There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

;What 12-digit number do you form by concatenating the three terms in this sequence?


(defn permuted? [a b c]
  (= (sort (str a)) (sort (str b)) (sort (str c))))


(time
 (println

    (let [pp (set (filter #(> % 1000) (primes/primes3 10000)))]
      (for [p1 pp
            p2 (filter #(> p1 %) pp)
            :let [p3 (- p2 (- p1 p2))]
            :when (not (nil? (pp p3)))
            :when (permuted? p1 p2 p3)]
      [p3 p2 p1]))))
;2969 6299 9629