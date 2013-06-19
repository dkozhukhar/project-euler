(ns project-euler.pr072
    (:require
    [project-euler.primes  :as primes]))


(->> (* 8 8)
     (+ -8)
     (* 1/2)
     ;28
     )

(quot 8 2)

(+ 0 1 2 3)

(quot 8 3)

(+ 0 1)


(defn s0 [n]
  (/ (- (* n n) n) 2))

(defn pn [p n]
  (let [qp (quot n p)]
    (* (dec qp)  qp  1/2)))

(pn 5 8)

(defn ds [n]
  (reduce +
    (for [p (take-while #(>= n %) (primes/lazy-primes3))]
      (pn p n))))

(pn 2 13)

(ds 15)


(- (s0 12) (ds 12))

(pn 2 12)
(pn 3 12)
(pn 5 12)
(pn 7 12)
(pn 11 12)

()

(->>
 (for [t (range 2 13)
      r (range 1 t)]
  (/ r t))
 set
 count)

(->>
 (for [t (range 2 13)
       r (range 1 t)
       :when (zero? (mod t r))]
  nil)
 count
 time)
