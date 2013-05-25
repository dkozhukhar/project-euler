(ns project-euler.p34
  (:require [project-euler.utils  :as utils])
)

;Digit factorials
;Problem 34
;145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

;Find the sum of all numbers which are equal to the sum of the factorial of their digits.

;Note: as 1! = 1 and 2! = 2 are not sums they are not included.




(defn f! [n]
  (if (zero? n) 1 (apply * (range 1 (inc n)))))

(defn f0 [n]
  (case n
    0 1
    1 1
    2 2
    3 6
    4 24
    5 120
    6 720
    7 5040
    8 40320
    9 362880))



(time
(println
 (apply +
  (for [n (range 3 3000000)
        :let [df (apply + (map f0 (utils/digits n)))]
        :when (= df n)]
    n))))
;=>40730


(println
 (map
  (fn [x]
    [x
     (* (f! 9) x)
     (apply * (repeat x 10N))
     ])
    (range 1 11))))


