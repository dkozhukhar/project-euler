(ns project-euler.p25
   (:require           [project-euler.math  :as math]  )

  )



;1000-digit Fibonacci number
;Problem 25
;The Fibonacci sequence is defined by the recurrence relation:

;Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
;Hence the first 12 terms will be:

;F1 = 1
;F2 = 1
;F3 = 2
;F4 = 3
;F5 = 5
;F6 = 8
;F7 = 13
;F8 = 21
;F9 = 34
;F10 = 55
;F11 = 89
;F12 = 144
;The 12th term, F12, is the first term to contain three digits.

;What is the first term in the Fibonacci sequence to contain 1000 digits?



(println
 (first
  (filter (fn [[a b c]] (= b 1000))
   (map (fn [a b] `(~a ~(count (str a)) ~b) )
    (take 10000 (math/fib 1N 1))
     (iterate inc 1N)))))

;=>4782


