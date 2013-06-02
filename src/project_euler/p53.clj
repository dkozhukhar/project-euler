(ns project-euler.p53
)


;There are exactly ten ways of selecting three from five, 12345:

;123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

;In combinatorics, we use the notation, 5C3 = 10.

;In general,

;nCr =
;n!
;r!(nr)!
;,where r  n, n! = n(n1)...321, and 0! = 1.
;It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

;How many, not necessarily distinct, values of  nCr, for 1  n  100, are greater than one-million?


(defn c2 [r n]
  (/
   (reduce * 1N (range (inc r) (inc n)))
   (reduce * 1N (range 1 (inc (- n r))))))


(time
 (println
  (count
  (for [n (range 1 101)
        r (range 0 (inc n))
        :when (> (c2 r n) 1000000)]
        (c2 r n)))))
;4075