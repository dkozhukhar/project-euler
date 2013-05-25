(ns project-euler.p33)

;Digit canceling fractions
;Problem 33
;The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

;We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

;There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

;If the product of these four fractions is given in its lowest common terms, find the value of the denominator.


(def ds
  (for [a (range 1 10)
        b (range 1 10)
        :when (not= a b)]
    [a b]))

(println
(denominator
 (apply *
 (for [[n11 n12] ds
        [n21 n22] ds
        :when (not= n11 n12)
        :when (not= n21 n22)
        :let [n1 (+ (* 10 n11) n12)
             n2 (+ (* 10 n21) n22)]
        ;:when (< n1 n2)
        :when (= n12 n21)
        :when (= (/ n1 n2) (/ n11 n22))                ]
  (/ n1 n2)


  ))))
;=> 100