(ns project-euler.p51
   (:require [project-euler.primes  :as primes]))



;Prime digit replacements
;Problem 51
;By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

;By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

;Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.

(time 
(println
   (for [a (range 10)
         b (range 10)
         c (range 10)
         ; d (range 10)
         ; d (range 10)
;         :let [p (Integer. (str a b c))
;               p? (primes/prime? p)]
         ;:when (odd? c)
         ;:when (pos? (mod (+ a b c ) 3))
         :let [pgen (Integer. (str a b c ))
               p?gen (primes/prime? pgen)]       
         :when p?gen
         :let 
           [gens
            (for [t (range 0 10)
                  :let [snum (apply str [ t t a t b c ])]
                  :when (not= (first snum) \0)

                  :let [n (read-string snum)]
                  :when (primes/prime? n)]
              n)
            lgens (count gens)
            mgen (first gens)]
         :when (>= lgens 7)
         ]
      [mgen  lgens pgen p?gen])))


