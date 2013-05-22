(ns project-euler.p20
    (:require
             [project-euler.utils  :as utils]
  ))


;Factorial digit sum
;Problem 20
;n! means n  (n  1)  ...  3  2  1

;For example, 10! = 10  9  ...  3  2  1 = 3628800,
;and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

;Find the sum of the digits in the number 100!



(time (println
   (let [f100 (apply * (range 1N 101))]
    (apply + (map utils/char-to-int (str f100)))) ;make a string from a number then reads chars and summ em
        )); => 648
