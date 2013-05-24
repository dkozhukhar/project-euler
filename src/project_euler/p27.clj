(ns project-euler.p27
  (:require      [project-euler.primes  :as primes] )
  )


;Quadratic primes
;Problem 27
;Euler published the remarkable quadratic formula:

;n² + n + 41

;It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

;Using computers, the incredible formula  n²  79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, 79 and 1601, is 126479.

;Considering quadratics of the form:

;n² + an + b, where |a|  1000 and |b|  1000

;where |n| is the modulus/absolute value of n
;e.g. |11| = 11 and |4| = 4
;Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.

(defn qf [a b n]
  "calculates value for quadratic formula  n^2 + a*n + b"
  (+ (* n n) (* n a) b))

;finds primes consequtive values for quadratic formula
(for [n (range 80) :let [q (qf -79 1601 n)]]  `[~n ~(primes/prime? q) ~q])

;finds length for consequtive prime values of qf
(count (take-while primes/prime? (for [n (range 100) :let [q (qf -79 1601 n)]]  q)))

(defn mcp [a b]
     (count (take-while primes/prime? ;looks for qf-s p-c-v lengths
                        (for [n (range 100) :let [q (qf a b n)]]  q))))

(println
 (reduce (fn [[am bm prm lm] [a b]]   
          (if (< lm (mcp a b)) 
              [a b (* a b) (mcp a b)]
              [am bm prm lm]))
        [1 1 1 0]
        (for [a (range -999 1000)
              b (range -999 1000)]
             [a b])))



'(reduce (fn [[prod1 mp1] [prod2 mp2]] ;finds longest primes chain 
          (if 
           (> mp2 mp1) [prod2 mp2] [prod1 mp1]))
 (for [a (range -999 1000)
      b (range -999 1000)]
     `(~(* a b)
       ~(count (take-while primes/prime? ;looks for qf-s p-c-v lengths
                        (for [n (range 100) :let [q (qf a b n)]]  q))))))
; -59231
      


