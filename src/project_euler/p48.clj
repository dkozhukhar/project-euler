(ns project-euler.p48
  )


;The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

;Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.


(defn pp [n]
  (rem (reduce * 1N (repeat n n)) 10000000000))


(time
 (println
   (rem
    (reduce + (map pp (range 1 1001))) 10000000000)))
;9110846700N
