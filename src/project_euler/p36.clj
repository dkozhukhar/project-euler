(ns project-euler.p36
      (:require
             [project-euler.palindromes  :as pali]
       )

)



;Double-base palindromes
;Problem 36
;The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

;Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

;(Please note that the palindromic number, in either base, may not include leading zeros.)

(time
(println
(apply +
(for [n (range 1 1000000)
      :when (pali/mirrored-string? (str n))
      :when (pali/mirrored-string? (Integer/toString n 2))]
  n))))
;=> 872187
