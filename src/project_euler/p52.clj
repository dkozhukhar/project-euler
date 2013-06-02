(ns project-euler.p52
)

;It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

;Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.




(defn samedigs [n]
  (apply = (map sort (map str (map #(* n %) (range 1 7))))))

(defn pow10 [n] (reduce * (repeat n 10) ))

(time
(println
;for [d (range 5 6)]
  (for
      ;n (range (* 10 (pow10 d)) (* 17 (pow10 d)))
      [n (range 140000 150000)
       :when (samedigs n)]
  n)))
;142857
