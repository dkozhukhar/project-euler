(ns project-euler.p30)


;Digit fifth powers
;Problem 30
;Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

;1634 = 14 + 64 + 34 + 44
;8208 = 84 + 24 + 04 + 84
;9474 = 94 + 44 + 74 + 44
;As 1 = 14 is not a sum it is not included.

;The sum of these numbers is 1634 + 8208 + 9474 = 19316.

;Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

(println
(apply +
(for [d0 (range 10)
      d1 (range 10)
      d2 (range 10)
      d3 (range 10)
      d4 (range 10)
      d5 (range 4)
      :let [n1 (+ d0 (* d1 10) (* d2 100) (* d3 1000) (* d4 10000) (* d5 100000) )]
      :let [n2 (apply + (map #(apply * (repeat 5 %)) [d0 d1 d2 d3 d4 d5 ]))]
      :when (= n1 n2)
      :when (> n1 1)
      ]
     n1)))
;=>443839
