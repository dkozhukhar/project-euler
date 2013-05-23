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
  (let [nn (filter  #(= 0 (rem % p))
              (take 1000  ; limit for safaty reasons
                 (iterate #(+ 9 (* 10 %)) 9N)))   ]
    (count (str (first nn)))
    ))


(test-prime-cycle 983)

(println (reduce
          (fn [[a l] b]
            (if (> l (test-prime-cycle b)) [a l] [b (test-prime-cycle b)]))
             [1 0]
          (range 1 1000) ))
;=>983


; but what cycle has it, and what cycles has other numbers with long cycles?
(test-prime-cycle 7)
(/ 999999 7)


(defn find-prime-cycle [p]
  (let [nn (filter  #(= 0 (rem % p))
              (take 1000
                 (iterate #(+ 9 (* 10 %)) 9N)))   ]
    (/ (first nn) p)
    ))


(println
  (find-prime-cycle 577))

(println
 (filter  #(< 400 (test-prime-cycle %)) (range 1 1000) ))

(println
 (map #(find-prime-cycle %)
      (filter  #(< 100 (test-prime-cycle %)) (range 1 1000) )))