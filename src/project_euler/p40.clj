(ns project-euler.40
)

;Champernowne's constant
;Problem 40
;An irrational decimal fraction is created by concatenating the positive integers:

;0.123456789101112131415161718192021...

;It can be seen that the 12th digit of the fractional part is 1.

;If dn represents the nth digit of the fractional part, find the value of the following expression.

;d1  d10  d100  d1000  d10000  d100000  d1000000


;brute force
(defn champ [n]
  (read-string (str
    (nth (apply str (range 1 1000000)) (dec n)))))


(time (println
  (apply *
    (map champ
     (take 7 (iterate #(* 10 %) 1))))))
;= 210
