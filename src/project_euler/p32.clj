(ns project-euler.p32)


;Pandigital products
;Problem 32
;We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

;The product 7254 is unusual, as the identity, 39  186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

;Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

;HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.


(defn pandigital? [a b c]
 (=
  (sort (str a b c))
    '(\1 \2 \3 \4 \5 \6 \7 \8 \9)))


(time
  (println
   (apply +
      (set
      (for [t (range 1 5000)
            s (range 1 (min t (quot 10000 t)))
            :let [p (* t s)]
            :when (pandigital? t s p)]
        p
    )))))
;=>45228
