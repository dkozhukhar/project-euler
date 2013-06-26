(ns project-euler.pr077
   (:require
    [project-euler.primes  :as primes]))

(declare prime-way*)

(defn prime-ways [m n]
  (cond
   (zero? n) 1
   (= 1 n) 0
   (= 2 m) (if (even? n) 1 0)
   (> m n) (prime-way* n n)
   :else
      (->>
          (for [i  (take-while #(>= (min (inc m) (inc n)) %)  (primes/lazy-primes3)  )]
            (prime-way* i (- n i)))
          flatten
          (reduce +)
          )
   ))


(def prime-way* (memoize prime-ways))

(->>
  (range 1 500)
  (drop-while #(>= 5000 (prime-way* (dec %) %)))
  first
  println
  time
 )

