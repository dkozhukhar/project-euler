(ns project-euler.p43
)

;Sub-string divisibility
;Problem 43
;The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

;Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

;d2d3d4=406 is divisible by 2
;d3d4d5=063 is divisible by 3
;d4d5d6=635 is divisible by 5
;d5d6d7=357 is divisible by 7
;d6d7d8=572 is divisible by 11
;d7d8d9=728 is divisible by 13
;d8d9d10=289 is divisible by 17
;Find the sum of all 0 to 9 pandigital numbers with this property.

(reduce +
(let [p (set '(\0 \1 \2 \3 \4 \5 \6 \7 \8 \9))]
   (for [d1 p
         d2 (disj p d1)         
         d3 (disj p d1 d2)         
         d4 (disj p d1 d2 d3)         
         :when (zero? (mod (Integer. (str d2 d3 d4)) 2))         
         d5 (disj p d1 d2 d3 d4)         
         :when (zero? (mod (Integer. (str d3 d4 d5)) 3))
         d6 (disj p d1 d2 d3 d4 d5)         
         :when (zero? (mod (Integer. (str d4 d5 d6)) 5))
         d7 (disj p d1 d2 d3 d4 d5 d6)         
         :when (zero? (mod (Integer. (str d5 d6 d7)) 7))
         d8 (disj p d1 d2 d3 d4 d5 d6 d7)         
         :when (zero? (mod (Integer. (str d6 d7 d8)) 11))
         d9 (disj p d1 d2 d3 d4 d5 d6 d7 d8)         
         :when (zero? (mod (Integer. (str d7 d8 d9)) 13))
         d10 (disj p d1 d2 d3 d4 d5 d6 d7 d8 d9)        
         :when (zero? (mod (Integer. (str d8 d9 d10)) 17))
            ]
     (BigInteger. (str d1 d2 d3 d4 d5 d6 d7 d8 d9 d10))
    )))
 
 ;16695334890
