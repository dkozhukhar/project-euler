(ns project-euler.p26
  (:require      [project-euler.primes  :as primes] )
  )

;Reciprocal cycles
;Problem 26
;A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

;1/2	= 	0.5
;1/3	= 	0.(3)
;1/4	= 	0.25
;1/5	= 	0.2
;1/6	= 	0.1(6)
;1/7	= 	0.(142857)
;1/8	= 	0.125
;1/9	= 	0.(1)
;1/10	= 	0.1
;Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

;Find the value of d  1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.



(defn test-prime-cycle [p]
  "it makes use of fact that [cycle] * d = 999....9999
  i check d to be prime, or else it is not biutuful :)"
  (if
    (or (= 2 p) (= 5 p))
    0
    (let [nn (filter  #(= 0 (rem % p))
                   (iterate #(+ 9 (* 10 %)) 9N))]
      (count (str (first nn)))
      )))



(println (reduce
          (fn [[a l] b]
            (if (> l (test-prime-cycle b)) [a l] [b (test-prime-cycle b)]))
             [1 0]
          (primes/primes3 1000) ))
;=>983



(defn find-prime-cycle [p]
  "lets see how the cycle looks like"
  (if
    (or (= 2 p) (= 5 p))
    0
    (let [nn (filter  #(= 0 (rem % p))
                   (iterate #(+ 9 (* 10 %)) 9N))  ]
      (/ (first nn) p))
    ))

(println
 (filter  #(< 400 (test-prime-cycle %)) (primes/primes3 1000) ))

(println
 (map #(find-prime-cycle %)
      (filter  #(< 100 (test-prime-cycle %)) (primes/primes3 1000) )))