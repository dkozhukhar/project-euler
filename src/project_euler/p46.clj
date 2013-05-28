(ns project-euler.p46
   (:require [project-euler.primes  :as primes])
  )




;Goldbach's other conjecture
;Problem 46
;It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

;9 = 7 + 212
;15 = 7 + 222
;21 = 3 + 232
;25 = 7 + 232
;27 = 19 + 222
;33 = 31 + 212

;It turns out that the conjecture was false.

;What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?



; oc = prime + p2
; oc - prime = p2


(time
 (println
   (let [ps (set (primes/primes3 10000)) ;primes
         rt (set (filter odd?(range 2 10000))) ;odds
         cn  (clojure.set/difference rt ps); composite odds
         p2s (set (map #(* 2 (* % %)) (range 1 100))) ; twices of square
         ]

     (for [oc cn
           :when (empty? (clojure.set/intersection p2s
                   (set  (for [op (filter #(> oc %) ps)] (- oc op)))))] ;diff odd-primes is a 2*[]
       oc
       )
  )))
; (5993 5777)


